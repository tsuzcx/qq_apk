package com.tencent.mobileqq.shortvideo.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import bdaw;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.image.VideoDrawable;
import com.tencent.image.VideoDrawable.OnPlayRepeatListener;
import com.tencent.image.VideoDrawable.OnPlayerOneFrameListener;
import com.tencent.image.VideoDrawable.VideoDrawableParams;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Arrays;
import zeb;

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
  private String mAFile;
  private int mCurrentPlayedFrame;
  private boolean mEnableCyclePlay;
  public ImageViewVideoPlayer.IMPFrameListener mFrameListener;
  private boolean mHaveEnded;
  public Bitmap mLastFramePicture;
  public BitmapDrawable mLoadingBitmap;
  private boolean mNeedPlayAudio;
  private boolean mNeedProgress = true;
  public URLImageView mPlayer;
  public ImageViewVideoPlayer.IMPlayerEndListener mPlayerEndListener;
  public int mPlayerState = 1;
  private PlayerProgressBar mProgressBar;
  public boolean mRequireAudioFocus = true;
  public boolean mSecurityChecked;
  private int mTotalFrame;
  private URLDrawable mUrlDrawable;
  private String mVFile;
  public VideoDrawable mVideoDrawable;
  
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
    if (this.mUrlDrawable != null) {}
    try
    {
      Drawable localDrawable = this.mUrlDrawable.getCurrDrawable();
      if ((localDrawable != null) && ((localDrawable instanceof VideoDrawable)))
      {
        this.mVideoDrawable = ((VideoDrawable)this.mUrlDrawable.getCurrDrawable());
        boolean bool2 = this.mVideoDrawable.isAudioPlaying();
        if ((!bdaw.d(bdaw.c)) && (!bdaw.a(bdaw.d))) {
          break label141;
        }
        bool1 = true;
        if (QLog.isColorLevel()) {
          QLog.i("ImageViewVideoPlayer", 2, "initPlayer: audioPlaying= " + bool2 + " black=" + bool1);
        }
        if (bool1) {
          this.mVideoDrawable.disableGlobalPause();
        }
      }
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("ImageViewVideoPlayer", 2, "checkAndGetVideoDrawable mUrlDrawable==null", localNullPointerException);
        }
        Object localObject = null;
        continue;
        label141:
        boolean bool1 = false;
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
    return paramRMVideoStateMgr.c(11);
  }
  
  public Bitmap getCurrentBitmap()
  {
    if (this.mVideoDrawable != null) {
      return this.mVideoDrawable.getCurrentBitmap();
    }
    return null;
  }
  
  public int getVFileAndAFile(String paramString)
  {
    int i = -1;
    if (paramString == null) {
      i = -4;
    }
    File localFile;
    do
    {
      do
      {
        return i;
        localFile = new File(paramString);
        if ((localFile.exists()) && (localFile.isDirectory())) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ImageViewVideoPlayer", 2, "getVFileAndAFile(), videoDir not exist");
      return -1;
      paramString = localFile.list();
      if (paramString != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ImageViewVideoPlayer", 2, "getVFileAndAFile(), files = null");
    return -1;
    String str = localFile.getAbsolutePath() + File.separator;
    if (QLog.isColorLevel()) {
      QLog.d("ImageViewVideoPlayer", 2, "getVFileAndAFile(), sourceDirFile =" + localFile.getAbsolutePath() + ",files = " + Arrays.toString(paramString) + ",filse count = " + localFile.listFiles().length);
    }
    int j = paramString.length;
    i = 0;
    while (i < j)
    {
      localFile = paramString[i];
      if (QLog.isColorLevel()) {
        QLog.d("ImageViewVideoPlayer", 2, "getVFileAndAFile(), current file = " + localFile);
      }
      if (localFile.endsWith(".af")) {
        this.mAFile = (str + localFile);
      }
      if ((localFile.endsWith(".vf")) && (zeb.a(str + localFile) > 0L)) {
        this.mVFile = (str + localFile);
      }
      i += 1;
    }
    if ((this.mVFile == null) || ("".equals(this.mVFile))) {
      return -3;
    }
    if ((this.mAFile == null) || ("".equals(this.mAFile))) {
      return -2;
    }
    this.mNeedPlayAudio = false;
    if (zeb.a(this.mAFile) > 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImageViewVideoPlayer", 2, "getVFileAndAFile(), mNeedPlayAudio = " + this.mNeedPlayAudio);
      }
      this.mNeedPlayAudio = true;
    }
    return 0;
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
      this.mProgressBar.a = paramInt1;
      this.mProgressBar.b = paramInt2;
      this.mProgressBar.c = paramInt3;
      this.mProgressBar.setCurrentProgress(0, false);
    }
    paramString = URLDrawable.URLDrawableOptions.obtain();
    paramString.mFailedDrawable = null;
    paramString.mLoadingDrawable = sLoading;
    if (this.mLoadingBitmap != null) {
      paramString.mLoadingDrawable = this.mLoadingBitmap;
    }
    VideoDrawable.VideoDrawableParams localVideoDrawableParams = new VideoDrawable.VideoDrawableParams();
    localVideoDrawableParams.mVideoRoundCorner = 0;
    localVideoDrawableParams.mRequestedFPS = -1;
    localVideoDrawableParams.mEnableAntiAlias = true;
    localVideoDrawableParams.mEnableFilter = true;
    localVideoDrawableParams.mPlayAudioFrame = this.mNeedPlayAudio;
    localVideoDrawableParams.mPlayVideoFrame = true;
    localVideoDrawableParams.mDecodeType = 1;
    localVideoDrawableParams.mAfPath = this.mAFile;
    localVideoDrawableParams.mVfPath = this.mVFile;
    localVideoDrawableParams.mTotalTime = paramInt2;
    localVideoDrawableParams.mVideoFrames = paramInt3;
    paramString.mExtraInfo = localVideoDrawableParams;
    if ((!this.mEnableCyclePlay) || (!paramBoolean)) {
      paramString.mUseMemoryCache = false;
    }
    this.mUrlDrawable = URLDrawable.getDrawable(new File(this.mVFile), paramString);
    this.mPlayer.setURLDrawableDownListener(this);
    checkAndGetVideoDrawable();
    if (this.mVideoDrawable != null)
    {
      this.mVideoDrawable.setOnPlayRepeatListener(this);
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
    if (this.mVideoDrawable != null)
    {
      this.mVideoDrawable.setOnPlayRepeatListener(this);
      this.mVideoDrawable.setOnPlayerOneFrameListener(this);
      if (!this.mRequireAudioFocus) {
        this.mVideoDrawable.disableRequireAudioFocus();
      }
    }
  }
  
  public void onPlayRepeat(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ImageViewVideoPlayer", 2, "onPlayRepeat: repeatTimes= " + paramInt);
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
    this.mCurrentPlayedFrame += 1;
    if (this.mCurrentPlayedFrame >= this.mTotalFrame) {}
    for (boolean bool = true;; bool = false)
    {
      if (this.mNeedProgress) {
        this.mProgressBar.setCurrentProgress(this.mCurrentPlayedFrame, bool);
      }
      if ((bool) && (!this.mEnableCyclePlay)) {
        endFramePlay();
      }
      if (this.mFrameListener != null) {
        this.mFrameListener.onCurrentFrame(this.mCurrentPlayedFrame);
      }
      return;
    }
  }
  
  public void releasePlayer()
  {
    if (this.mVideoDrawable != null)
    {
      this.mVideoDrawable.enableGlobalPause();
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
    if (this.mVideoDrawable != null) {
      this.mVideoDrawable.resetPlay();
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
    if (this.mPlayer != null) {
      this.mPlayer.setImageDrawable(this.mUrlDrawable);
    }
    this.mPlayerState = 3;
  }
  
  public void stopPlayer()
  {
    if ((this.mUrlDrawable != null) && (this.mVideoDrawable != null)) {
      this.mVideoDrawable.stopAudio();
    }
    Handler localHandler = super.getHandler();
    if (localHandler != null) {
      localHandler.postAtFrontOfQueue(new ImageViewVideoPlayer.1(this));
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
    if (QLog.isColorLevel()) {
      QLog.i("ImageViewVideoPlayer", 2, "updateUISize width" + paramInt1 + "height" + i + "screenHeight=" + paramInt2);
    }
    if (i < paramInt2) {}
    for (;;)
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
      return;
      paramInt2 = i;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer
 * JD-Core Version:    0.7.0.1
 */