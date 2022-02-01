package com.tencent.qqmini.sdk.widget.media;

import android.app.Activity;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.widget.CoverView;
import com.tencent.qqmini.sdk.widget.CoverView.OnPageChangeListener;
import java.util.Observer;
import org.json.JSONObject;

public class CoverVideoView
  extends CoverView
  implements CoverView.OnPageChangeListener
{
  private MiniAppVideoController videoController;
  private FrameLayout videoLayout;
  
  public CoverVideoView(Activity paramActivity)
  {
    super(paramActivity);
    this.videoController = new MiniAppVideoController(paramActivity);
    this.videoLayout = this.videoController.getUI();
    if (this.videoLayout != null)
    {
      paramActivity = new FrameLayout.LayoutParams(-1, -1);
      addView(this.videoLayout, paramActivity);
    }
  }
  
  public void fullScreen()
  {
    if (!this.videoController.isFullScreen()) {
      this.videoController.fullScreen();
    }
  }
  
  public Observer getVideoPlayerStatusObserver()
  {
    return this.videoController.getVideoPlayerStatusObserver();
  }
  
  public void initVideoPlayerSettings(JSONObject paramJSONObject)
  {
    this.videoController.initVideoPlayerSettings(paramJSONObject);
  }
  
  public boolean isFullScreen()
  {
    return this.videoController.isFullScreen();
  }
  
  public boolean isPlaying()
  {
    return this.videoController.isPlaying();
  }
  
  public void onAddColorNote()
  {
    if (this.videoController != null) {
      this.videoController.stop();
    }
  }
  
  public void onPageBackground()
  {
    if (this.videoController != null) {
      this.videoController.onPageBackground();
    }
  }
  
  public void onPageForeground()
  {
    if (this.videoController != null) {
      this.videoController.onPageForeground();
    }
  }
  
  public void onPageWebViewDestory()
  {
    if (this.videoController != null) {
      this.videoController.release();
    }
  }
  
  public void onPageWebViewPause() {}
  
  public void onPageWebViewResume() {}
  
  public boolean pauseWithUi()
  {
    return this.videoController.pauseWithUi();
  }
  
  public void play()
  {
    this.videoController.play();
  }
  
  public void playDanmu(String paramString, int paramInt)
  {
    this.videoController.playDanmu(paramString, paramInt);
  }
  
  public boolean playWithUi()
  {
    return this.videoController.playWithUi();
  }
  
  public void release()
  {
    this.videoController.release();
  }
  
  public boolean seekTo(int paramInt)
  {
    return this.videoController.seekTo(paramInt);
  }
  
  public void setData(String paramString)
  {
    this.videoController.setData(paramString);
  }
  
  public void setLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    super.setLayoutParams(paramLayoutParams);
  }
  
  public void setMiniAppContext(IMiniAppContext paramIMiniAppContext)
  {
    this.videoController.setMiniAppContext(paramIMiniAppContext);
  }
  
  public void setPageWebView(IJsService paramIJsService)
  {
    this.videoController.setPageWebview(paramIJsService);
  }
  
  public void setPageWebViewId(int paramInt)
  {
    this.videoController.setPageWebViewId(paramInt);
  }
  
  public void setVideoPath(String paramString)
  {
    this.videoController.setVideoPath(paramString);
  }
  
  public void setVideoPlayerId(int paramInt)
  {
    this.videoController.setVideoPlayerId(paramInt);
  }
  
  public void smallScreen()
  {
    if (this.videoController.isFullScreen()) {
      this.videoController.smallScreen();
    }
  }
  
  public void stop()
  {
    this.videoController.stop();
  }
  
  public void updateVideoPlayerSettings(JSONObject paramJSONObject)
  {
    this.videoController.updateConfig(paramJSONObject);
    this.videoController.updateVideoPlayerSettings(paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.media.CoverVideoView
 * JD-Core Version:    0.7.0.1
 */