package com.tencent.mobileqq.mini.widget.media;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.mini.widget.CoverView;
import com.tencent.mobileqq.mini.widget.CoverView.OnPageChangeListener;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class CoverVideoView
  extends CoverView
  implements CoverView.OnPageChangeListener
{
  private boolean isPageBackground;
  private MiniAppVideoPlayer videoPlayer;
  
  public CoverVideoView(@NonNull Context paramContext)
  {
    super(paramContext);
    this.videoPlayer = new MiniAppVideoPlayer(paramContext);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    addView(this.videoPlayer, paramContext);
  }
  
  public void changeState()
  {
    this.videoPlayer.changeState();
  }
  
  public void fullScreen()
  {
    this.videoPlayer.fullScreen();
  }
  
  public MiniAppVideoPlayer.VideoPlayerStatusObserver getVideoPlayerStatusObserver()
  {
    return this.videoPlayer.videoPlayerStatusObserver;
  }
  
  public void initVideoPlayerSettings(JSONObject paramJSONObject)
  {
    this.videoPlayer.initVideoPlayerSettings(paramJSONObject);
  }
  
  public boolean isFullScreen()
  {
    return this.videoPlayer.isFullScreen();
  }
  
  public boolean isPlaying()
  {
    return this.videoPlayer.isPlaying();
  }
  
  public boolean isWrongParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((!isFullScreen()) && (this.videoPlayer.isFullScreenSize(paramLayoutParams.width, paramLayoutParams.height)))
    {
      long l = System.currentTimeMillis() - this.videoPlayer.lastSmallScreenTime;
      if (l < 1000L)
      {
        Log.w("CoverView", "setLayoutParams: wrong set size " + l, new Throwable());
        return true;
      }
    }
    return false;
  }
  
  public void onAddColorNote()
  {
    if (this.videoPlayer != null)
    {
      stop();
      this.isPageBackground = true;
    }
  }
  
  public void onPageBackground()
  {
    if ((this.videoPlayer != null) && (this.videoPlayer.autoPauseIfOpenNative) && (!this.isPageBackground)) {
      this.isPageBackground = pauseWithUi();
    }
  }
  
  public void onPageForeground()
  {
    if (this.isPageBackground)
    {
      changeState();
      this.isPageBackground = false;
    }
  }
  
  public void onPageWebViewDestory() {}
  
  public void onPageWebViewPause() {}
  
  public void onPageWebViewResume() {}
  
  public boolean pauseWithUi()
  {
    if (this.videoPlayer.isPlaying())
    {
      this.videoPlayer.changeState();
      return true;
    }
    return false;
  }
  
  public void play()
  {
    this.videoPlayer.play();
  }
  
  public void playDanmu(String paramString, int paramInt)
  {
    this.videoPlayer.playDanmu(paramString, paramInt);
  }
  
  public boolean playWithUi()
  {
    if (!this.videoPlayer.isPlaying())
    {
      this.videoPlayer.changeState();
      return true;
    }
    return false;
  }
  
  public void release()
  {
    this.videoPlayer.release();
  }
  
  public boolean seekTo(int paramInt)
  {
    return this.videoPlayer.seekTo(paramInt);
  }
  
  public void setAtyRef(WeakReference<Activity> paramWeakReference)
  {
    this.videoPlayer.setAtyRef(paramWeakReference);
  }
  
  public void setData(String paramString)
  {
    this.videoPlayer.data = paramString;
  }
  
  public void setLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    super.setLayoutParams(paramLayoutParams);
  }
  
  public void setPageWebviewId(int paramInt)
  {
    this.videoPlayer.webviewId = paramInt;
  }
  
  public void setServiceWebview(JsRuntime paramJsRuntime)
  {
    this.videoPlayer.serviceWebview = paramJsRuntime;
  }
  
  public void setVideoPath(String paramString)
  {
    this.videoPlayer.setVideoPath(paramString);
  }
  
  public void setVideoPlayerId(int paramInt)
  {
    this.videoPlayer.videoId = paramInt;
  }
  
  public void setWebviewContainer(WebviewContainer paramWebviewContainer)
  {
    this.videoPlayer.webviewContainer = paramWebviewContainer;
  }
  
  public void smallScreen()
  {
    this.videoPlayer.smallScreen();
  }
  
  public void stop()
  {
    this.videoPlayer.stop();
  }
  
  public void updateVideoPlayerSettings(JSONObject paramJSONObject)
  {
    this.videoPlayer.updateVideoPlayerSetting(paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.CoverVideoView
 * JD-Core Version:    0.7.0.1
 */