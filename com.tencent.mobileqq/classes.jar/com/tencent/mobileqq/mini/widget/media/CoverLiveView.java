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

public class CoverLiveView
  extends CoverView
  implements CoverView.OnPageChangeListener
{
  private boolean isPageBackground;
  private MiniAppLivePlayer livePlayer;
  
  public CoverLiveView(@NonNull Context paramContext)
  {
    super(paramContext);
    this.livePlayer = new MiniAppLivePlayer(paramContext);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    addView(this.livePlayer, paramContext);
  }
  
  private boolean isWrongParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((!isFullScreen()) && (this.livePlayer.isFullScreenSize(paramLayoutParams.width, paramLayoutParams.height)))
    {
      long l = System.currentTimeMillis() - this.livePlayer.lastSmallScreenTime;
      if (l < 1000L)
      {
        Log.w("CoverView", "setLayoutParams: wrong set size " + l, new Throwable());
        return true;
      }
    }
    return false;
  }
  
  public void initLivePlayerSettings(JSONObject paramJSONObject)
  {
    this.livePlayer.initLivePlayerSettings(paramJSONObject);
  }
  
  public boolean isFullScreen()
  {
    return this.livePlayer.isFullScreen();
  }
  
  public void onAddColorNote() {}
  
  public void onPageBackground()
  {
    if (!this.isPageBackground) {
      this.isPageBackground = this.livePlayer.enterBackground();
    }
  }
  
  public void onPageForeground()
  {
    if (this.isPageBackground) {
      if (this.livePlayer.enterForeground()) {
        break label25;
      }
    }
    label25:
    for (boolean bool = true;; bool = false)
    {
      this.isPageBackground = bool;
      return;
    }
  }
  
  public void onPageWebViewDestory()
  {
    this.livePlayer.release();
  }
  
  public void onPageWebViewPause()
  {
    if (!this.isPageBackground) {
      this.isPageBackground = this.livePlayer.enterBackground();
    }
  }
  
  public void onPageWebViewResume()
  {
    if (this.isPageBackground) {
      if (this.livePlayer.enterForeground()) {
        break label25;
      }
    }
    label25:
    for (boolean bool = true;; bool = false)
    {
      this.isPageBackground = bool;
      return;
    }
  }
  
  public void operateLivePlayer(String paramString, int paramInt, JSONObject paramJSONObject)
  {
    this.livePlayer.operateLivePlayer(paramString, paramInt, paramJSONObject);
  }
  
  public void release()
  {
    this.livePlayer.release();
  }
  
  public void setAtyRef(WeakReference<Activity> paramWeakReference)
  {
    this.livePlayer.setAtyRef(paramWeakReference);
  }
  
  public void setData(String paramString)
  {
    this.livePlayer.data = paramString;
  }
  
  public void setLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if (isWrongParams(paramLayoutParams)) {
      return;
    }
    super.setLayoutParams(paramLayoutParams);
  }
  
  public void setLivePlayerId(int paramInt)
  {
    this.livePlayer.livePlayerId = paramInt;
  }
  
  public void setPageWebviewId(int paramInt)
  {
    this.livePlayer.webviewId = paramInt;
  }
  
  public void setServiceWebview(JsRuntime paramJsRuntime)
  {
    this.livePlayer.serviceWebview = paramJsRuntime;
  }
  
  public void setWebviewContainer(WebviewContainer paramWebviewContainer)
  {
    this.livePlayer.webviewContainer = paramWebviewContainer;
  }
  
  public void smallScreen()
  {
    this.livePlayer.smallScreen();
  }
  
  public void updateLivePlayerSettings(JSONObject paramJSONObject)
  {
    this.livePlayer.updateLivePlayerSetting(paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.CoverLiveView
 * JD-Core Version:    0.7.0.1
 */