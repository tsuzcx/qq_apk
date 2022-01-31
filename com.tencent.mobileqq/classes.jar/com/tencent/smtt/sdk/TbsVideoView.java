package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;
import com.tencent.smtt.export.external.DexLoader;

class TbsVideoView
  extends FrameLayout
  implements MediaPlayer.OnErrorListener
{
  static final int ACTIVITY_ONDESTROY = 4;
  static final int ACTIVITY_ONPAUSE = 3;
  static final int ACTIVITY_ONRESUME = 2;
  static final int ACTIVITY_ONSTOP = 1;
  static final int CALL_MODE_BLACK = 1;
  static final int CALL_MODE_WITHE = 2;
  public static final String KEY_EXTRA_DATA = "extraData";
  static final String KEY_MODE = "callMode";
  public static final String KEY_VIDEO_URL = "videoUrl";
  public static final String TBS_INTERNAL_PLAY_ACTION = "com.tencent.smtt.tbs.video.PLAY";
  private Context mContext = null;
  private VideoView mSysVideoView;
  private Object mTbsPlayer;
  private String mUrl;
  private VideoWizard mWizard;
  
  public TbsVideoView(Context paramContext)
  {
    super(paramContext.getApplicationContext());
    this.mContext = paramContext;
  }
  
  private void openVideo(Bundle paramBundle, Object paramObject)
  {
    initPlayer();
    boolean bool = false;
    if (isTbsPlayerReady())
    {
      paramBundle.putInt("callMode", paramBundle.getInt("callMode"));
      bool = this.mWizard.play(this.mTbsPlayer, paramBundle, this, paramObject);
    }
    if (!bool)
    {
      if (this.mSysVideoView != null) {
        this.mSysVideoView.stopPlayback();
      }
      if (this.mSysVideoView == null) {
        this.mSysVideoView = new VideoView(getContext());
      }
      this.mUrl = paramBundle.getString("videoUrl");
      this.mSysVideoView.setVideoURI(Uri.parse(this.mUrl));
      this.mSysVideoView.setOnErrorListener(this);
      paramBundle = new Intent("com.tencent.smtt.tbs.video.PLAY");
      paramBundle.addFlags(268435456);
      paramObject = getContext().getApplicationContext();
      paramBundle.setPackage(paramObject.getPackageName());
      paramObject.startActivity(paramBundle);
    }
  }
  
  void initPlayer()
  {
    DexLoader localDexLoader = null;
    setBackgroundColor(-16777216);
    if (this.mWizard == null)
    {
      SDKEngine.getInstance(true).init(getContext().getApplicationContext(), false, false, null);
      TbsWizard localTbsWizard = SDKEngine.getInstance(true).wizard();
      if (localTbsWizard != null) {
        localDexLoader = localTbsWizard.dexLoader();
      }
      if ((localDexLoader != null) && (QbSdk.canLoadVideo(getContext()))) {
        this.mWizard = new VideoWizard(localDexLoader);
      }
    }
    if ((this.mWizard != null) && (this.mTbsPlayer == null)) {
      this.mTbsPlayer = this.mWizard.getTbsPlayer(getContext().getApplicationContext());
    }
  }
  
  public boolean isTbsPlayerReady()
  {
    return (this.mWizard != null) && (this.mTbsPlayer != null);
  }
  
  void onActivity(Activity paramActivity, int paramInt)
  {
    if ((paramInt == 3) && (!isTbsPlayerReady()) && (this.mSysVideoView != null)) {
      this.mSysVideoView.pause();
    }
    if (paramInt == 4)
    {
      this.mContext = null;
      if ((!isTbsPlayerReady()) && (this.mSysVideoView != null))
      {
        this.mSysVideoView.stopPlayback();
        this.mSysVideoView = null;
      }
    }
    if ((paramInt == 2) && (!isTbsPlayerReady()))
    {
      this.mContext = paramActivity;
      resume(paramActivity);
    }
    if (isTbsPlayerReady()) {
      this.mWizard.onActivity(this.mTbsPlayer, paramActivity, paramInt);
    }
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    try
    {
      if ((this.mContext instanceof Activity))
      {
        paramMediaPlayer = (Activity)this.mContext;
        if (!paramMediaPlayer.isFinishing()) {
          paramMediaPlayer.finish();
        }
      }
      paramMediaPlayer = getContext();
      if (paramMediaPlayer != null)
      {
        Toast.makeText(paramMediaPlayer, "播放失败，请选择其它播放器播放", 1).show();
        paramMediaPlayer = paramMediaPlayer.getApplicationContext();
        Intent localIntent = new Intent("android.intent.action.VIEW");
        localIntent.addFlags(268435456);
        localIntent.setDataAndType(Uri.parse(this.mUrl), "video/*");
        paramMediaPlayer.startActivity(localIntent);
      }
      return true;
    }
    catch (Throwable paramMediaPlayer) {}
    return false;
  }
  
  public void onUserStateChanged()
  {
    if (isTbsPlayerReady()) {
      this.mWizard.onUserStateChanged(this.mTbsPlayer);
    }
  }
  
  void play(Bundle paramBundle, Object paramObject)
  {
    openVideo(paramBundle, paramObject);
  }
  
  public void resume(Activity paramActivity)
  {
    if (isTbsPlayerReady()) {}
    do
    {
      do
      {
        return;
      } while (this.mSysVideoView == null);
      if (this.mSysVideoView.getParent() == null)
      {
        Window localWindow = paramActivity.getWindow();
        FrameLayout localFrameLayout = (FrameLayout)localWindow.getDecorView();
        localWindow.addFlags(1024);
        localWindow.addFlags(128);
        localFrameLayout.setBackgroundColor(-16777216);
        paramActivity = new MediaController(paramActivity);
        paramActivity.setMediaPlayer(this.mSysVideoView);
        this.mSysVideoView.setMediaController(paramActivity);
        paramActivity = new FrameLayout.LayoutParams(-1, -1);
        paramActivity.gravity = 17;
        localFrameLayout.addView(this.mSysVideoView, paramActivity);
      }
    } while (Build.VERSION.SDK_INT < 8);
    this.mSysVideoView.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsVideoView
 * JD-Core Version:    0.7.0.1
 */