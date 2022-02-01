package com.tencent.qqmini.sdk.plugins;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

@JsPlugin
public class BatteryJsPlugin
  extends BaseJsPlugin
{
  public static final String EVENT_GET_BATTERY = "getBatteryInfo";
  public static final String EVENT_GET_BATTERY_SYNC = "getBatteryInfoSync";
  private static final String TAG = "BatteryJsPlugin";
  private float batteryPct = 0.0F;
  private int chargePlug = -1;
  private boolean isCharging = false;
  private BatteryJsPlugin.PowerConnectionReceiver mPowerConnectionReceiver = new BatteryJsPlugin.PowerConnectionReceiver(this);
  
  @JsEvent({"getBatteryInfo", "getBatteryInfoSync"})
  public String getBatteryInfo(RequestEvent paramRequestEvent)
  {
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("level", (int)(this.batteryPct * 100.0F));
      ((JSONObject)localObject).put("isCharging", this.isCharging);
      localObject = ApiUtil.wrapCallbackOk(paramRequestEvent.event, (JSONObject)localObject).toString();
      if ("getBatteryInfo".equals(paramRequestEvent.event)) {
        paramRequestEvent.jsService.evaluateCallbackJs(paramRequestEvent.callbackId, (String)localObject);
      }
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("BatteryJsPlugin", localThrowable.getMessage(), localThrowable);
      if ("getBatteryInfo".equals(paramRequestEvent.event))
      {
        String str = ApiUtil.wrapCallbackFail(paramRequestEvent.event, null).toString();
        paramRequestEvent.jsService.evaluateCallbackJs(paramRequestEvent.callbackId, str);
      }
    }
    return "";
  }
  
  public void onCreate(IMiniAppContext paramIMiniAppContext)
  {
    super.onCreate(paramIMiniAppContext);
    paramIMiniAppContext = new IntentFilter();
    paramIMiniAppContext.addAction("android.intent.action.BATTERY_CHANGED");
    this.mContext.registerReceiver(this.mPowerConnectionReceiver, paramIMiniAppContext);
  }
  
  public void onDestroy()
  {
    try
    {
      this.mContext.unregisterReceiver(this.mPowerConnectionReceiver);
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("BatteryJsPlugin", "unregisterReceiver exception.", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.BatteryJsPlugin
 * JD-Core Version:    0.7.0.1
 */