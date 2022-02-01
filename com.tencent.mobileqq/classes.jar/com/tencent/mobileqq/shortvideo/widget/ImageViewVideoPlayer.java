package com.tencent.mobileqq.shortvideo.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.aelight.camera.api.ICameraCompatible;
import com.tencent.aelight.camera.constants.CameraCompatibleConstants;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.image.VideoDrawable;
import com.tencent.image.VideoDrawable.OnPlayRepeatListener;
import com.tencent.image.VideoDrawable.OnPlayerOneFrameListener;
import com.tencent.image.VideoDrawable.VideoDrawableParams;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Arrays;

public class ImageViewVideoPlayer
  extends LinearLayout
  implements URLDrawableDownListener, VideoDrawable.OnPlayRepeatListener, VideoDrawable.OnPlayerOneFrameListener
{
  public static final int AIO_VIDEO_FRAME_LIMIT_NUM = 3;
  private static final int G_CUT_FRAMES_PLAY = 3;
  public static final int IMV_PLAYER_STATE_INIT = 2;
  public static final int IMV_PLAYER_STATE_START = 3;
  public static final int IMV_PLAYER_STATE_STOP = 4;
  public static final int IMV_PLAYER_STATE_UNINIT = 1;
  public static final int QQSTORY_VIDEO_FRAME_LIMIT_NUM = 3;
  public static final int QZONE_VIDEO_FRAME_LIMIT_NUM = 3;
  public static final int RESULT_ERROR_NO_AUDIO_FILE = -2;
  public static final int RESULT_ERROR_NO_SOURCE = -1;
  public static final int RESULT_ERROR_NO_VIDEO_FILE = -3;
  public static final int RESULT_ERROR_PARAM_INVALID = -4;
  private static final String TAG = "ImageViewVideoPlayer";
  public static final int VIDEO_FRAME_LIMIT_NUM = 11;
  private static ColorDrawable sLoading = new ColorDrawable(-14342358);
  private String mAFile = null;
  private int mCurrentPlayedFrame = 0;
  private boolean mEnableCyclePlay = false;
  public ImageViewVideoPlayer.IMPFrameListener mFrameListener = null;
  private boolean mHaveEnded = false;
  public Bitmap mLastFramePicture = null;
  public BitmapDrawable mLoadingBitmap = null;
  private boolean mNeedPlayAudio = false;
  private boolean mNeedProgress = true;
  public URLImageView mPlayer;
  public ImageViewVideoPlayer.IMPlayerEndListener mPlayerEndListener = null;
  public int mPlayerState = 1;
  private PlayerProgressBar mProgressBar;
  public boolean mRequireAudioFocus = true;
  public boolean mSecurityChecked = false;
  private int mTotalFrame = 0;
  private URLDrawable mUrlDrawable = null;
  private String mVFile = null;
  public VideoDrawable mVideoDrawable = null;
  
  public ImageViewVideoPlayer(Context paramContext)
  {
    super(paramContext);
    initUI(paramContext);
  }
  
  public ImageViewVideoPlayer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initUI(paramContext);
  }
  
  private void checkAndGetVideoDrawable()
  {
    Object localObject = this.mUrlDrawable;
    if (localObject != null)
    {
      StringBuilder localStringBuilder;
      try
      {
        localObject = ((URLDrawable)localObject).getCurrDrawable();
      }
      catch (NullPointerException localNullPointerException)
      {
        if (QLog.isColorLevel()) {
          QLog.i("ImageViewVideoPlayer", 2, "checkAndGetVideoDrawable mUrlDrawable==null", localNullPointerException);
        }
        localStringBuilder = null;
      }
      if ((localStringBuilder != null) && ((localStringBuilder instanceof VideoDrawable)))
      {
        this.mVideoDrawable = ((VideoDrawable)this.mUrlDrawable.getCurrDrawable());
        boolean bool2 = this.mVideoDrawable.isAudioPlaying();
        boolean bool1;
        if ((!((ICameraCompatible)QRoute.api(ICameraCompatible.class)).isFoundProduct(CameraCompatibleConstants.c)) && (!((ICameraCompatible)QRoute.api(ICameraCompatible.class)).isFoundProductFeature(CameraCompatibleConstants.d))) {
          bool1 = false;
        } else {
          bool1 = true;
        }
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("initPlayer: audioPlaying= ");
          localStringBuilder.append(bool2);
          localStringBuilder.append(" black=");
          localStringBuilder.append(bool1);
          QLog.i("ImageViewVideoPlayer", 2, localStringBuilder.toString());
        }
        if (bool1) {
          this.mVideoDrawable.disableGlobalPause();
        }
      }
    }
  }
  
  private void endFramePlay()
  {
    if (!this.mHaveEnded)
    {
      this.mHaveEnded = true;
      this.mLastFramePicture = getCurrentBitmap();
      stopPlayer();
      releasePlayer();
      getHandler().postAtFrontOfQueue(new ImageViewVideoPlayer.3(this));
    }
  }
  
  private void initUI(Context paramContext)
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    this.mPlayer = new URLImageView(paramContext);
    super.addView(this.mPlayer, localLayoutParams);
    this.mProgressBar = new PlayerProgressBar(paramContext);
    super.addView(this.mProgressBar, localLayoutParams);
    super.setVisibility(8);
    this.mPlayerState = 1;
  }
  
  public boolean checkVideoSourceValidate(RMVideoStateMgr paramRMVideoStateMgr)
  {
    return paramRMVideoStateMgr.b(11);
  }
  
  public Bitmap getCurrentBitmap()
  {
    VideoDrawable localVideoDrawable = this.mVideoDrawable;
    if (localVideoDrawable != null) {
      return localVideoDrawable.getCurrentBitmap();
    }
    return null;
  }
  
  public int getVFileAndAFile(String paramString)
  {
    if (paramString == null) {
      return -4;
    }
    File localFile = new File(paramString);
    if ((localFile.exists()) && (localFile.isDirectory()))
    {
      paramString = localFile.list();
      if (paramString == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ImageViewVideoPlayer", 2, "getVFileAndAFile(), files = null");
        }
        return -1;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(localFile.getAbsolutePath());
      ((StringBuilder)localObject).append(File.separator);
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getVFileAndAFile(), sourceDirFile =");
        localStringBuilder.append(localFile.getAbsolutePath());
        localStringBuilder.append(",files = ");
        localStringBuilder.append(Arrays.toString(paramString));
        localStringBuilder.append(", file count = ");
        localStringBuilder.append(localFile.listFiles().length);
        QLog.d("ImageViewVideoPlayer", 2, localStringBuilder.toString());
      }
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        localFile = paramString[i];
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("getVFileAndAFile(), current file = ");
          localStringBuilder.append(localFile);
          QLog.d("ImageViewVideoPlayer", 2, localStringBuilder.toString());
        }
        if (localFile.endsWith(".af"))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject);
          localStringBuilder.append(localFile);
          this.mAFile = localStringBuilder.toString();
        }
        if (localFile.endsWith(".vf"))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject);
          localStringBuilder.append(localFile);
          if (FileUtils.a(localStringBuilder.toString()) > 0L)
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append((String)localObject);
            localStringBuilder.append(localFile);
            this.mVFile = localStringBuilder.toString();
          }
        }
        i += 1;
      }
      paramString = this.mVFile;
      if ((paramString != null) && (!"".equals(paramString)))
      {
        paramString = this.mAFile;
        if ((paramString != null) && (!"".equals(paramString)))
        {
          this.mNeedPlayAudio = false;
          if (FileUtils.a(this.mAFile) > 0L)
          {
            if (QLog.isColorLevel())
            {
              paramString = new StringBuilder();
              paramString.append("getVFileAndAFile(), mNeedPlayAudio = ");
              paramString.append(this.mNeedPlayAudio);
              QLog.d("ImageViewVideoPlayer", 2, paramString.toString());
            }
            this.mNeedPlayAudio = true;
          }
          return 0;
        }
        return -2;
      }
      return -3;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ImageViewVideoPlayer", 2, "getVFileAndAFile(), videoDir not exist");
    }
    return -1;
  }
  
  public String getmAFile()
  {
    return this.mAFile;
  }
  
  public boolean initEditPlayer(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3)
  {
    this.mSecurityChecked = true;
    this.mAFile = paramString2;
    this.mVFile = paramString3;
    return initPlayer(paramInt1, paramInt2, paramInt3, paramString1, false);
  }
  
  public boolean initPlayer(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    return initPlayer(paramInt1, paramInt2, paramInt3, paramString, true);
  }
  
  public boolean initPlayer(int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
  {
    if ((!this.mSecurityChecked) && (getVFileAndAFile(paramString) != 0)) {
      return false;
    }
    this.mVideoDrawable = null;
    this.mSecurityChecked = false;
    this.mLastFramePicture = null;
    this.mTotalFrame = (paramInt3 - 3);
    if (this.mNeedProgress)
    {
      paramString = this.mProgressBar;
      paramString.a = paramInt1;
      paramString.b = paramInt2;
      paramString.c = paramInt3;
      paramString.setCurrentProgress(0, false);
    }
    paramString = URLDrawable.URLDrawableOptions.obtain();
    paramString.mFailedDrawable = null;
    paramString.mLoadingDrawable = sLoading;
    Object localObject = this.mLoadingBitmap;
    if (localObject != null) {
      paramString.mLoadingDrawable = ((Drawable)localObject);
    }
    localObject = new VideoDrawable.VideoDrawableParams();
    ((VideoDrawable.VideoDrawableParams)localObject).mVideoRoundCorner = 0;
    ((VideoDrawable.VideoDrawableParams)localObject).mRequestedFPS = -1;
    ((VideoDrawable.VideoDrawableParams)localObject).mEnableAntiAlias = true;
    ((VideoDrawable.VideoDrawableParams)localObject).mEnableFilter = true;
    ((VideoDrawable.VideoDrawableParams)localObject).mPlayAudioFrame = this.mNeedPlayAudio;
    ((VideoDrawable.VideoDrawableParams)localObject).mPlayVideoFrame = true;
    ((VideoDrawable.VideoDrawableParams)localObject).mDecodeType = 1;
    ((VideoDrawable.VideoDrawableParams)localObject).mAfPath = this.mAFile;
    ((VideoDrawable.VideoDrawableParams)localObject).mVfPath = this.mVFile;
    ((VideoDrawable.VideoDrawableParams)localObject).mTotalTime = paramInt2;
    ((VideoDrawable.VideoDrawableParams)localObject).mVideoFrames = paramInt3;
    paramString.mExtraInfo = localObject;
    if ((!this.mEnableCyclePlay) || (!paramBoolean)) {
      paramString.mUseMemoryCache = false;
    }
    this.mUrlDrawable = URLDrawable.getDrawable(new File(this.mVFile), paramString);
    this.mPlayer.setURLDrawableDownListener(this);
    checkAndGetVideoDrawable();
    paramString = this.mVideoDrawable;
    if (paramString != null)
    {
      paramString.setOnPlayRepeatListener(this);
      this.mVideoDrawable.setOnPlayerOneFrameListener(this);
      if (!this.mEnableCyclePlay) {
        this.mVideoDrawable.resetAndPlayAudioOnce();
      }
    }
    this.mPlayerState = 2;
    this.mHaveEnded = false;
    return true;
  }
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    checkAndGetVideoDrawable();
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    checkAndGetVideoDrawable();
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    checkAndGetVideoDrawable();
    paramView = this.mVideoDrawable;
    if (paramView != null)
    {
      paramView.setOnPlayRepeatListener(this);
      this.mVideoDrawable.setOnPlayerOneFrameListener(this);
      if (!this.mRequireAudioFocus) {
        this.mVideoDrawable.disableRequireAudioFocus();
      }
    }
  }
  
  public void onPlayRepeat(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPlayRepeat: repeatTimes= ");
      localStringBuilder.append(paramInt);
      QLog.i("ImageViewVideoPlayer", 2, localStringBuilder.toString());
    }
    if (!this.mEnableCyclePlay)
    {
      if (this.mNeedProgress) {
        this.mProgressBar.setCurrentProgress(this.mCurrentPlayedFrame, true);
      }
      endFramePlay();
      return;
    }
    this.mCurrentPlayedFrame = 0;
    getHandler().postAtFrontOfQueue(new ImageViewVideoPlayer.2(this, paramInt));
  }
  
  public void oneFrameDrawed()
  {
    int i = this.mCurrentPlayedFrame;
    boolean bool = true;
    this.mCurrentPlayedFrame = (i + 1);
    if (this.mCurrentPlayedFrame < this.mTotalFrame) {
      bool = false;
    }
    if (this.mNeedProgress) {
      this.mProgressBar.setCurrentProgress(this.mCurrentPlayedFrame, bool);
    }
    if ((bool) && (!this.mEnableCyclePlay)) {
      endFramePlay();
    }
    ImageViewVideoPlayer.IMPFrameListener localIMPFrameListener = this.mFrameListener;
    if (localIMPFrameListener != null) {
      localIMPFrameListener.onCurrentFrame(this.mCurrentPlayedFrame);
    }
  }
  
  public void releasePlayer()
  {
    VideoDrawable localVideoDrawable = this.mVideoDrawable;
    if (localVideoDrawable != null)
    {
      localVideoDrawable.enableGlobalPause();
      this.mVideoDrawable.removeOnPlayRepeatListener(this);
      this.mVideoDrawable.setOnPlayRepeatListener(null);
    }
    this.mUrlDrawable = null;
    this.mTotalFrame = 0;
    this.mCurrentPlayedFrame = 0;
    this.mPlayerState = 1;
  }
  
  public void resetPlay()
  {
    VideoDrawable localVideoDrawable = this.mVideoDrawable;
    if (localVideoDrawable != null) {
      localVideoDrawable.resetPlay();
    }
  }
  
  public void setCyclePlay(boolean paramBoolean)
  {
    this.mEnableCyclePlay = paramBoolean;
  }
  
  public void setIMPFrameListener(ImageViewVideoPlayer.IMPFrameListener paramIMPFrameListener)
  {
    this.mFrameListener = paramIMPFrameListener;
  }
  
  public void setIMPlayerEndListener(ImageViewVideoPlayer.IMPlayerEndListener paramIMPlayerEndListener)
  {
    this.mPlayerEndListener = paramIMPlayerEndListener;
  }
  
  public void setNeedPlayAudio(boolean paramBoolean)
  {
    this.mNeedPlayAudio = paramBoolean;
  }
  
  public void startPlayer()
  {
    super.setVisibility(0);
    URLImageView localURLImageView = this.mPlayer;
    if (localURLImageView != null) {
      localURLImageView.setImageDrawable(this.mUrlDrawable);
    }
    this.mPlayerState = 3;
  }
  
  public void stopPlayer()
  {
    if (this.mUrlDrawable != null)
    {
      localObject = this.mVideoDrawable;
      if (localObject != null) {
        ((VideoDrawable)localObject).stopAudio();
      }
    }
    Object localObject = super.getHandler();
    if (localObject != null) {
      ((Handler)localObject).postAtFrontOfQueue(new ImageViewVideoPlayer.1(this));
    }
    this.mPlayerState = 4;
  }
  
  public void updateUISize(int paramInt1, float paramFloat, boolean paramBoolean, int paramInt2)
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(paramInt1, (int)(paramInt1 * paramFloat));
    this.mPlayer.setLayoutParams(localLayoutParams);
    this.mNeedProgress = paramBoolean;
    if (this.mNeedProgress)
    {
      localLayoutParams = new LinearLayout.LayoutParams(paramInt1, paramInt2);
      this.mProgressBar.setLayoutParams(localLayoutParams);
      return;
    }
    this.mProgressBar.setVisibility(8);
  }
  
  public void updateUISize(int paramInt1, int paramInt2, float paramFloat, boolean paramBoolean, int paramInt3)
  {
    int i = (int)(paramInt1 * paramFloat);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateUISize width");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("height");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("screenHeight=");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.i("ImageViewVideoPlayer", 2, ((StringBuilder)localObject).toString());
    }
    if (i >= paramInt2) {
      paramInt2 = i;
    }
    Object localObject = new LinearLayout.LayoutParams(paramInt1, paramInt2);
    this.mPlayer.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.mNeedProgress = paramBoolean;
    if (this.mNeedProgress)
    {
      localObject = new LinearLayout.LayoutParams(paramInt1, paramInt3);
      this.mProgressBar.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
    }
    this.mProgressBar.setVisibility(8);
  }
  
  public void updateUISize(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(paramInt1, paramInt2);
    this.mPlayer.setLayoutParams(localLayoutParams);
    this.mNeedProgress = paramBoolean;
    if (this.mNeedProgress)
    {
      localLayoutParams = new LinearLayout.LayoutParams(paramInt1, paramInt3);
      this.mProgressBar.setLayoutParams(localLayoutParams);
      return;
    }
    this.mProgressBar.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer
 * JD-Core Version:    0.7.0.1
 */