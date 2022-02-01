package com.tencent.qqmini.miniapp.widget.media;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.widget.CoverView;
import com.tencent.qqmini.sdk.widget.CoverView.OnPageChangeListener;
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
        paramLayoutParams = new StringBuilder();
        paramLayoutParams.append("setLayoutParams: wrong set size ");
        paramLayoutParams.append(l);
        Log.w("CoverView", paramLayoutParams.toString(), new Throwable());
        return true;
      }
    }
    return false;
  }
  
  public void initLivePlayerSettings(RequestEvent paramRequestEvent, JSONObject paramJSONObject)
  {
    this.livePlayer.initLivePlayerSettings(paramRequestEvent, paramJSONObject);
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
      this.isPageBackground = (this.livePlayer.enterForeground() ^ true);
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
      this.isPageBackground = (this.livePlayer.enterForeground() ^ true);
    }
  }
  
  public void operateLivePlayer(String paramString, RequestEvent paramRequestEvent, JSONObject paramJSONObject)
  {
    this.livePlayer.operateLivePlayer(paramString, paramRequestEvent, paramJSONObject);
  }
  
  public void release()
  {
    this.livePlayer.release();
  }
  
  public void setAtyRef(WeakReference<Activity> paramWeakReference)
  {
    this.livePlayer.setAtyRef(paramWeakReference);
  }
  
  public void setBaseRuntime(BaseRuntime paramBaseRuntime)
  {
    this.livePlayer.baseRuntime = paramBaseRuntime;
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
  
  public void setMiniAppContext(IMiniAppContext paramIMiniAppContext)
  {
    this.livePlayer.miniAppContextRef = new WeakReference(paramIMiniAppContext);
  }
  
  public void setPageWebviewId(int paramInt)
  {
    this.livePlayer.webviewId = paramInt;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.media.CoverLiveView
 * JD-Core Version:    0.7.0.1
 */