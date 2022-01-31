package com.tencent.mobileqq.mini.widget.media;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.mini.widget.CoverView;
import com.tencent.mobileqq.mini.widget.CoverView.OnPageChangeListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class CoverPusherView
  extends CoverView
  implements CoverView.OnPageChangeListener
{
  private MiniAppLivePusher livePusher;
  
  public CoverPusherView(@NonNull Context paramContext)
  {
    super(paramContext);
    this.livePusher = new MiniAppLivePusher(paramContext);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    addView(this.livePusher, paramContext);
  }
  
  public void initLivePusherSettings(JSONObject paramJSONObject)
  {
    this.livePusher.initLivePusherSettings(paramJSONObject);
  }
  
  public void onAddColorNote() {}
  
  public void onPageBackground()
  {
    QLog.e("CoverView", 1, "CoverPusherView onPageBackground");
    this.livePusher.enterBackground();
  }
  
  public void onPageForeground()
  {
    QLog.e("CoverView", 1, "CoverPusherView onPageForeground");
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
  
  public void operateLivePusher(String paramString, int paramInt, JSONObject paramJSONObject)
  {
    this.livePusher.operateLivePusher(paramString, paramInt, paramJSONObject);
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
  
  public void setPageWebviewId(int paramInt)
  {
    this.livePusher.webviewId = paramInt;
  }
  
  public void setServiceWebview(JsRuntime paramJsRuntime)
  {
    this.livePusher.serviceWebview = paramJsRuntime;
  }
  
  public void updateLivePusherSettings(JSONObject paramJSONObject)
  {
    this.livePusher.updateLivePusherSetting(paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.CoverPusherView
 * JD-Core Version:    0.7.0.1
 */