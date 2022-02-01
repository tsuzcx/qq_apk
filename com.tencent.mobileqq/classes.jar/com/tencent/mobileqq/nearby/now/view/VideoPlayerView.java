package com.tencent.mobileqq.nearby.now.view;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.IntRange;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.base.preload.DownloadTask;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.protocol.INowShortVideoProtoManager;
import com.tencent.mobileqq.nearby.now.utils.INowVideoReporter;
import com.tencent.mobileqq.nearby.now.utils.QualityReporter;
import com.tencent.mobileqq.nearby.now.view.logic.IVideoInfoListener;
import com.tencent.mobileqq.nearby.now.view.player.IVideoView;
import com.tencent.mobileqq.nearby.now.view.player.impl.VideoViewTVKImpl;
import com.tencent.mobileqq.nearby.now.view.player.impl.VideoViewTextureImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import java.io.File;

public class VideoPlayerView
  implements IVideoPlayerView
{
  public static final int EXO_PLAYER = 1;
  public static final int LOCAL_PLAYER = 2;
  public static final int NOWN_PLAYER = 0;
  private static final String TAG = "VideoPlayerView";
  public static boolean shouldForceCreate;
  private final int NULL_PATH_ERROR_CODE = 1024;
  private final int PROGRESS_MSG = 2025;
  private final int UNKNOWN_ERROR_ERROR_CODE = -2147483648;
  private final int UPDATE_COVER = 2026;
  private ImageView doodleView;
  private boolean hasError = false;
  private boolean isLocalFile = true;
  protected boolean isPlaying = false;
  protected ImageView ivCover;
  protected QQAppInterface mApp;
  protected Context mContext;
  private String mCurrentPath;
  private long mEndPlayTime;
  long mFileSize = 0L;
  protected Handler mHandler;
  private long mInterval = -1L;
  long mLastPos;
  public String mLastUrl = "";
  long mOffset = 0L;
  private boolean mPaused = false;
  protected IVideoView mPlayer;
  public int mPlayerType = 0;
  PlayResultListener mReultListener;
  private RelativeLayout mRootView;
  IVideoPlayerView.ShowLoadingWhenLoadingCoverListener mShowLoadingWhenLoadingCoverListener;
  private long mStartPlayTime;
  private boolean mStartPlayed;
  private VideoData mVideoData;
  protected IVideoInfoListener mVideoInfoListener;
  INowShortVideoProtoManager nowShortVideoProtoManager;
  private int retryCount = 0;
  
  public VideoPlayerView(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.mContext = paramContext;
    this.mPlayer = createVideoView();
    this.mApp = paramQQAppInterface;
    this.nowShortVideoProtoManager = ((INowShortVideoProtoManager)QRoute.api(INowShortVideoProtoManager.class)).init(this.mApp);
  }
  
  public static TVK_ICacheMgr createCacheMgr()
  {
    if (!TVK_SDKMgr.isInstalled(BaseApplicationImpl.getContext())) {
      initTVKSDK(BaseApplicationImpl.getContext());
    }
    if (TVK_SDKMgr.isInstalled(BaseApplicationImpl.getContext())) {
      return TVK_SDKMgr.getProxyFactory().getCacheMgr(BaseApplicationImpl.getContext());
    }
    return null;
  }
  
  public static String getFileName(String paramString)
  {
    return MD5.toMD5(paramString);
  }
  
  public static void initTVKSDK(Context paramContext)
  {
    TVK_SDKMgr.setOnLogListener(new VideoPlayerView.TVKSDKOnLogListener(null));
    TVK_SDKMgr.initSdk(paramContext.getApplicationContext(), "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
  }
  
  public static void preloadVideo(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VideoPlayerView", 2, "startPreloadVideo");
    }
    TVK_ICacheMgr localTVK_ICacheMgr = createCacheMgr();
    if (localTVK_ICacheMgr == null) {
      QLog.w("VideoPlayerView", 1, "preloadVideo failed , cacheMgr==null!");
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(AppConstants.SDCARD_PATH);
    ((StringBuilder)localObject1).append(".now_video/");
    ((StringBuilder)localObject1).append("vid_");
    ((StringBuilder)localObject1).append(getFileName(paramString));
    ((StringBuilder)localObject1).append(".mp4");
    localObject1 = ((StringBuilder)localObject1).toString();
    if (new File((String)localObject1).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.i("VideoPlayerView", 2, "file.exists ! use local file");
      }
      return;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("vid_");
    ((StringBuilder)localObject2).append(getFileName(paramString));
    localObject2 = DownloadTask.b(((StringBuilder)localObject2).toString(), 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(".tmp");
    localObject1 = VideoViewTVKImpl.a((String)localObject2, localStringBuilder.toString(), 0L);
    ((TVK_PlayerVideoInfo)localObject1).setConfigMap("cache_duration", "5");
    paramString = InnerDns.replaceDomainWithIp(paramString.replace("https://", "http://"), 1012);
    localTVK_ICacheMgr.setPreloadCallback(new VideoPlayerView.1());
    localTVK_ICacheMgr.preLoadVideoByUrl(BaseApplicationImpl.getContext(), paramString, null, (TVK_PlayerVideoInfo)localObject1);
  }
  
  public static String setFileCompleted(File paramFile)
  {
    if (paramFile.exists())
    {
      String str = paramFile.getParentFile().getAbsolutePath();
      Object localObject2 = paramFile.getName();
      Object localObject1 = localObject2;
      if (((String)localObject2).endsWith(".tmp")) {
        localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 4);
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(str);
      ((StringBuilder)localObject2).append("/");
      ((StringBuilder)localObject2).append((String)localObject1);
      localObject1 = ((StringBuilder)localObject2).toString();
      paramFile.renameTo(new File((String)localObject1));
      return localObject1;
    }
    return "";
  }
  
  public IVideoView createVideoView()
  {
    if (!TVK_SDKMgr.isInstalled(this.mContext)) {
      initTVKSDK(this.mContext);
    }
    if (TVK_SDKMgr.isInstalled(this.mContext)) {
      return new VideoViewTVKImpl(this.mContext);
    }
    QLog.w("VideoPlayerView", 1, "use VideoViewTextureImpl!");
    return new VideoViewTextureImpl(this.mContext);
  }
  
  public long getCurrentPosition()
  {
    return this.mPlayer.d();
  }
  
  public long getDownloadOffset()
  {
    if (this.mVideoData == null) {
      return 0L;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AppConstants.SDCARD_PATH);
    ((StringBuilder)localObject).append(".now_video/");
    ((StringBuilder)localObject).append("vid_");
    ((StringBuilder)localObject).append(getFileName(this.mVideoData.d));
    ((StringBuilder)localObject).append(".mp4");
    localObject = ((StringBuilder)localObject).toString();
    if (new File((String)localObject).exists()) {
      return ((String)localObject).length();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AppConstants.SDCARD_PATH);
    ((StringBuilder)localObject).append(".now_video/");
    ((StringBuilder)localObject).append("vid_");
    ((StringBuilder)localObject).append(getFileName(this.mVideoData.d));
    ((StringBuilder)localObject).append(".mp4.tmp");
    localObject = new File(((StringBuilder)localObject).toString());
    if (((File)localObject).exists()) {
      return ((File)localObject).length();
    }
    return 0L;
  }
  
  public long getDuration()
  {
    return this.mPlayer.g();
  }
  
  public long getFileSize()
  {
    return this.mFileSize;
  }
  
  public int getPlayerType()
  {
    return this.mPlayerType;
  }
  
  public String getmLastUrl()
  {
    return this.mLastUrl;
  }
  
  public int getmPlayerType()
  {
    return this.mPlayerType;
  }
  
  public void hideDownloadProgress() {}
  
  public void initWidgetView(RelativeLayout paramRelativeLayout)
  {
    this.mRootView = paramRelativeLayout;
    this.ivCover = ((ImageView)this.mRootView.findViewById(2131436334));
    this.doodleView = ((ImageView)this.mRootView.findViewById(2131432065));
    paramRelativeLayout = this.mHandler;
    if (paramRelativeLayout != null)
    {
      paramRelativeLayout.removeMessages(2025);
      this.mHandler.removeMessages(2026);
    }
    this.mHandler = new VideoPlayerView.2(this, this.mContext.getMainLooper());
  }
  
  public boolean isPlaying()
  {
    return this.mPlayer.i();
  }
  
  public boolean isVideoCached()
  {
    if (this.mVideoData == null) {
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append(".now_video/");
    localStringBuilder.append("vid_");
    localStringBuilder.append(getFileName(this.mVideoData.d));
    localStringBuilder.append(".mp4");
    if (new File(localStringBuilder.toString()).exists()) {
      return true;
    }
    long l = this.mOffset;
    return (l >= this.mFileSize) && (l != 0L);
  }
  
  public void pause()
  {
    if (QLog.isColorLevel()) {
      QLog.i("VideoPlayerView", 2, "pause");
    }
    this.mPlayer.e();
    this.mPaused = true;
    this.mLastPos = getCurrentPosition();
  }
  
  public void play(RelativeLayout paramRelativeLayout, VideoData paramVideoData, Object paramObject)
  {
    this.mVideoData = paramVideoData;
    initWidgetView(paramRelativeLayout);
    play(paramVideoData);
  }
  
  public void play(VideoData paramVideoData)
  {
    String str = paramVideoData.d;
    this.mFileSize = 0L;
    this.mOffset = 0L;
    boolean bool2 = isVideoCached();
    this.mLastUrl = str;
    this.mCurrentPath = str;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("play(String videoPath)! path is: ");
      ((StringBuilder)localObject1).append(str);
      ((StringBuilder)localObject1).append("play stack is: ");
      ((StringBuilder)localObject1).append(Log.getStackTraceString(new Throwable()));
      QLog.i("VideoPlayerView", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = this.mPlayer;
    if (localObject1 != null) {
      ((IVideoView)localObject1).b();
    }
    localObject1 = this.mPlayer;
    if ((localObject1 != null) && (((IVideoView)localObject1).a() != null) && (this.mPlayer.a().getParent() != null)) {
      ((ViewGroup)this.mPlayer.a().getParent()).removeView(this.mPlayer.a());
    }
    this.mPlayer = createVideoView();
    localObject1 = this.mPlayer;
    if ((localObject1 instanceof VideoViewTVKImpl))
    {
      localObject1 = (VideoViewTVKImpl)localObject1;
      boolean bool1;
      if (paramVideoData.H < paramVideoData.I) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      ((VideoViewTVKImpl)localObject1).a(bool1);
    }
    localObject1 = this.mPlayer;
    if (localObject1 == null)
    {
      QLog.e("VideoPlayerView", 1, "mPlayer == null!");
      return;
    }
    if ((localObject1 != null) && (((IVideoView)localObject1).a() != null) && (this.mPlayer.a().getParent() != null)) {
      ((ViewGroup)this.mPlayer.a().getParent()).removeView(this.mPlayer.a());
    }
    localObject1 = this.mPlayer;
    if (localObject1 != null) {
      this.mRootView.addView(((IVideoView)localObject1).a(), 0, new RelativeLayout.LayoutParams(-1, -1));
    }
    this.mRootView.requestLayout();
    this.mPlayerType = 1;
    ((INowVideoReporter)QRoute.api(INowVideoReporter.class)).setRePlayCount(0);
    ((INowVideoReporter)QRoute.api(INowVideoReporter.class)).setPlayTimeBegin(System.currentTimeMillis());
    ((INowVideoReporter)QRoute.api(INowVideoReporter.class)).setFeedId(paramVideoData.c);
    ((INowVideoReporter)QRoute.api(INowVideoReporter.class)).setAnchorUin(String.valueOf(paramVideoData.i));
    localObject1 = this.mVideoInfoListener;
    if (localObject1 != null) {
      ((IVideoPlayerView.VideoInfoListener)localObject1).onDoingStartPlayback();
    }
    try
    {
      this.ivCover.setVisibility(0);
      this.doodleView.setVisibility(0);
      this.mPlayer.a(new VideoPlayerView.3(this));
      this.mPlayer.a(new VideoPlayerView.4(this));
      this.mPlayer.a(new VideoPlayerView.5(this));
      this.mPlayer.a(new VideoPlayerView.6(this, paramVideoData));
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(AppConstants.SDCARD_PATH);
      ((StringBuilder)localObject1).append(".now_video/");
      ((StringBuilder)localObject1).append("vid_");
      ((StringBuilder)localObject1).append(getFileName(str));
      ((StringBuilder)localObject1).append(".mp4");
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject2 = new File((String)localObject1);
      Object localObject3;
      if (((File)localObject2).exists())
      {
        if (QLog.isColorLevel()) {
          QLog.i("VideoPlayerView", 2, "file.exists ! use local file");
        }
        this.mFileSize = ((File)localObject2).length();
        this.mOffset = this.mFileSize;
        localObject2 = this.mPlayer;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("vid_");
        ((StringBuilder)localObject3).append(getFileName(str));
        ((IVideoView)localObject2).a(((StringBuilder)localObject3).toString(), (String)localObject1, str, paramVideoData.z);
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(".tmp");
        localObject2 = new File(((StringBuilder)localObject2).toString());
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("use remote file,tmp's exsit=");
          ((StringBuilder)localObject3).append(((File)localObject2).exists());
          QLog.i("VideoPlayerView", 2, ((StringBuilder)localObject3).toString());
        }
        localObject2 = this.mPlayer;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("vid_");
        ((StringBuilder)localObject3).append(getFileName(str));
        localObject3 = ((StringBuilder)localObject3).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append(".tmp");
        ((IVideoView)localObject2).a((String)localObject3, localStringBuilder.toString(), str, paramVideoData.z);
      }
      this.mPlayer.a(new VideoPlayerView.7(this, paramVideoData, bool2));
      if (QLog.isColorLevel()) {
        QLog.i("VideoPlayerView", 2, "player start!");
      }
      this.mPaused = false;
      return;
    }
    catch (Exception paramVideoData)
    {
      Log.e("VideoPlayerView", paramVideoData.toString());
    }
  }
  
  public boolean restart()
  {
    ((INowVideoReporter)QRoute.api(INowVideoReporter.class)).setRePlayCount(((INowVideoReporter)QRoute.api(INowVideoReporter.class)).getRePlayCount() + 1);
    if (QLog.isColorLevel()) {
      QLog.i("VideoPlayerView", 2, "restart");
    }
    String str = this.mVideoData.c;
    int i;
    if (isVideoCached()) {
      i = 1;
    } else {
      i = 2;
    }
    QualityReporter.a(str, i, "0", "0");
    QualityReporter.a(2);
    QualityReporter.d();
    this.mPlayer.f();
    return true;
  }
  
  public void resume()
  {
    if (this.mPaused)
    {
      if (QLog.isColorLevel()) {
        QLog.i("VideoPlayerView", 2, "resume");
      }
      this.mPlayer.c();
      this.mPlayer.a(this.mLastPos);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("VideoPlayerView", 2, "!not paused no resume!");
    }
  }
  
  public void seekTo(@IntRange(from=0L) long paramLong)
  {
    this.mPlayer.a(paramLong);
    this.mStartPlayed = true;
  }
  
  public void setCoverVisibility(int paramInt)
  {
    this.ivCover.setVisibility(paramInt);
    this.doodleView.setVisibility(paramInt);
  }
  
  public void setOnVideoInfoListener(IVideoInfoListener paramIVideoInfoListener)
  {
    this.mVideoInfoListener = paramIVideoInfoListener;
  }
  
  public void setProgressCallbackInterval(long paramLong)
  {
    IVideoView localIVideoView = this.mPlayer;
    this.mInterval = paramLong;
  }
  
  public void setShowLoadingWhenLoadingCoverListener(IVideoPlayerView.ShowLoadingWhenLoadingCoverListener paramShowLoadingWhenLoadingCoverListener)
  {
    this.mShowLoadingWhenLoadingCoverListener = paramShowLoadingWhenLoadingCoverListener;
  }
  
  public void setVideoPlayViewVisibility(int paramInt)
  {
    IVideoView localIVideoView = this.mPlayer;
    if ((localIVideoView != null) && (localIVideoView.a() != null)) {
      this.mPlayer.a().setVisibility(paramInt);
    }
  }
  
  public void setmLastUrl(String paramString)
  {
    this.mLastUrl = paramString;
  }
  
  public void setmPlayerType(int paramInt)
  {
    this.mPlayerType = paramInt;
  }
  
  public void stopPlayback(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("stopPlayback, clearSurface=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.i("VideoPlayerView", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.mVideoInfoListener;
    if (localObject != null) {
      ((IVideoPlayerView.VideoInfoListener)localObject).onDoingStopPlayback();
    }
    if (this.mStartPlayed)
    {
      this.mEndPlayTime = System.currentTimeMillis();
      long l = this.mEndPlayTime;
      l = this.mStartPlayTime;
      this.mPlayer.g();
      this.mStartPlayed = false;
    }
    this.mPlayer.b();
    this.mPaused = false;
  }
  
  public void suspend()
  {
    if (QLog.isColorLevel()) {
      QLog.i("VideoPlayerView", 2, "stop");
    }
    Object localObject = this.mHandler;
    if (localObject != null)
    {
      ((Handler)localObject).removeMessages(2025);
      this.mHandler.removeMessages(2026);
    }
    if (this.mStartPlayed) {
      this.mStartPlayed = false;
    }
    localObject = this.mPlayer;
    if ((localObject != null) && (((IVideoView)localObject).a() != null) && (this.mPlayer.a().getParent() != null)) {
      ((ViewGroup)this.mPlayer.a().getParent()).removeView(this.mPlayer.a());
    }
    this.mPlayer.b();
    this.mReultListener = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.VideoPlayerView
 * JD-Core Version:    0.7.0.1
 */