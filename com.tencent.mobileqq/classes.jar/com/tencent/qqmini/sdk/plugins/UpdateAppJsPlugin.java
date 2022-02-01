package com.tencent.qqmini.sdk.plugins;

import android.app.Activity;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

@JsPlugin
public class UpdateAppJsPlugin
  extends BaseJsPlugin
{
  public static final String API_UPDATE_QQ_APP = "updateQQApp";
  public static final String TAG = "UpdateAppJsPlugin";
  private Activity mActivity;
  private MiniAppProxy mMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
  
  public void onCreate(IMiniAppContext paramIMiniAppContext)
  {
    super.onCreate(paramIMiniAppContext);
    this.mActivity = paramIMiniAppContext.getAttachedActivity();
  }
  
  @JsEvent({"updateQQApp"})
  public void updateQQApp(RequestEvent paramRequestEvent)
  {
    if (this.mActivity == null)
    {
      QMLog.e("UpdateAppJsPlugin", "mActivity is null ?!!");
      return;
    }
    try
    {
      this.mMiniAppProxy.getAppUpdate(this.mActivity, new UpdateAppJsPlugin.1(this, paramRequestEvent));
      return;
    }
    catch (Exception paramRequestEvent)
    {
      QMLog.e("UpdateAppJsPlugin", "Failed to updateQQApp");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.UpdateAppJsPlugin
 * JD-Core Version:    0.7.0.1
 */