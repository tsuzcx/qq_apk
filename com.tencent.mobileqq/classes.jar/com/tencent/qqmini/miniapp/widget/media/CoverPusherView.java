package com.tencent.qqmini.miniapp.widget.media;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.widget.CoverView;
import com.tencent.qqmini.sdk.widget.CoverView.OnPageChangeListener;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class CoverPusherView
  extends CoverView
  implements CoverView.OnPageChangeListener
{
  private MiniAppLivePusher livePusher;
  
  public CoverPusherView(@NonNull IMiniAppContext paramIMiniAppContext)
  {
    super(paramIMiniAppContext.getContext());
    this.livePusher = new MiniAppLivePusher(paramIMiniAppContext);
    paramIMiniAppContext = new FrameLayout.LayoutParams(-1, -1);
    addView(this.livePusher, paramIMiniAppContext);
  }
  
  public void initLivePusherSettings(RequestEvent paramRequestEvent, JSONObject paramJSONObject)
  {
    this.livePusher.initLivePusherSettings(paramRequestEvent, paramJSONObject);
  }
  
  public void onAddColorNote() {}
  
  public void onPageBackground()
  {
    QMLog.e("CoverView", "CoverPusherView onPageBackground");
    this.livePusher.enterBackground();
  }
  
  public void onPageForeground()
  {
    QMLog.e("CoverView", "CoverPusherView onPageForeground");
    this.livePusher.enterForeground();
  }
  
  public void onPageWebViewDestory()
  {
    this.livePusher.release();
  }
  
  public void onPageWebViewPause()
  {
    this.livePusher.enterBackground();
  }
  
  public void onPageWebViewResume()
  {
    this.livePusher.enterForeground();
  }
  
  public void operateLivePusher(String paramString, RequestEvent paramRequestEvent, JSONObject paramJSONObject)
  {
    this.livePusher.operateLivePusher(paramString, paramRequestEvent, paramJSONObject);
  }
  
  public void release()
  {
    this.livePusher.release();
  }
  
  public void setAtyRef(WeakReference<Activity> paramWeakReference)
  {
    this.livePusher.setAtyRef(paramWeakReference);
  }
  
  public void setData(String paramString)
  {
    this.livePusher.data = paramString;
  }
  
  public void setLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    super.setLayoutParams(paramLayoutParams);
  }
  
  public void setLivePusherId(int paramInt)
  {
    this.livePusher.livePusherId = paramInt;
  }
  
  public void setMiniAppContext(IMiniAppContext paramIMiniAppContext)
  {
    this.livePusher.miniAppContextRef = new WeakReference(paramIMiniAppContext);
  }
  
  public void setPageWebviewId(int paramInt)
  {
    this.livePusher.webviewId = paramInt;
  }
  
  public void updateLivePusherSettings(JSONObject paramJSONObject)
  {
    this.livePusher.updateLivePusherSetting(paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.media.CoverPusherView
 * JD-Core Version:    0.7.0.1
 */