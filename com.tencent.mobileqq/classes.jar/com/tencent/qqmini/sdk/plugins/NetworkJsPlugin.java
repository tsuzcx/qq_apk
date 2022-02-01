package com.tencent.qqmini.sdk.plugins;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.utils.NetworkUtil;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

@JsPlugin(lazyLoad=false)
public class NetworkJsPlugin
  extends BaseJsPlugin
{
  public static final String EVENT_NETWORK_STATE_CHANGE = "onNetworkStatusChange";
  private static final String TAG = "NetworkJsPlugin";
  private String mLastNetworkType = "none";
  private NetworkJsPlugin.ConnectionChangeReceiver mReceiver;
  private boolean mRegister = false;
  
  private void callBackStatusChange(JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (paramJSONObject.has("networkType")) && (!this.mLastNetworkType.equals(paramJSONObject.optString("networkType"))))
    {
      this.mLastNetworkType = paramJSONObject.optString("networkType");
      sendSubscribeEvent("onNetworkStatusChange", paramJSONObject.toString());
    }
  }
  
  private String getCurrentTypeDesc()
  {
    int i = NetworkUtil.getActiveNetworkType(this.mContext);
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4) {
              return "unkown";
            }
            return "4g";
          }
          return "3g";
        }
        return "2g";
      }
      return "wifi";
    }
    return "none";
  }
  
  @JsEvent({"getNetworkType"})
  public String getNetworkType(RequestEvent paramRequestEvent)
  {
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("networkType", getCurrentTypeDesc());
      localObject = ApiUtil.wrapCallbackOk(paramRequestEvent.event, (JSONObject)localObject).toString();
      paramRequestEvent.jsService.evaluateCallbackJs(paramRequestEvent.callbackId, (String)localObject);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("NetworkJsPlugin", localThrowable.getMessage(), localThrowable);
      String str = ApiUtil.wrapCallbackFail(paramRequestEvent.event, null).toString();
      paramRequestEvent.jsService.evaluateCallbackJs(paramRequestEvent.callbackId, str);
    }
    return "";
  }
  
  public void onCreate(IMiniAppContext paramIMiniAppContext)
  {
    super.onCreate(paramIMiniAppContext);
    if ((this.mContext != null) && (!this.mRegister))
    {
      this.mReceiver = new NetworkJsPlugin.ConnectionChangeReceiver(this);
      this.mContext.registerReceiver(this.mReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
      this.mRegister = true;
    }
  }
  
  public void onDestroy()
  {
    if ((this.mRegister) && (this.mReceiver != null)) {
      try
      {
        this.mContext.unregisterReceiver(this.mReceiver);
        this.mReceiver = null;
        this.mRegister = false;
        return;
      }
      catch (Throwable localThrowable)
      {
        QMLog.e("NetworkJsPlugin", "fail unregisterReceiver", localThrowable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.NetworkJsPlugin
 * JD-Core Version:    0.7.0.1
 */