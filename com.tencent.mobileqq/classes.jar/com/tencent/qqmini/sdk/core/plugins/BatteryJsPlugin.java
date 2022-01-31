package com.tencent.qqmini.sdk.core.plugins;

import android.content.Context;
import android.content.IntentFilter;
import behp;
import behq;
import bekr;
import bekx;
import betc;
import org.json.JSONObject;

public class BatteryJsPlugin
  extends BaseJsPlugin
{
  public static final String EVENT_GET_BATTERY = "getBatteryInfo";
  public static final String EVENT_GET_BATTERY_SYNC = "getBatteryInfoSync";
  private static final String TAG = "BatteryJsPlugin";
  private float batteryPct;
  private int chargePlug = -1;
  private boolean isCharging;
  private BatteryJsPlugin.PowerConnectionReceiver mPowerConnectionReceiver = new BatteryJsPlugin.PowerConnectionReceiver(this);
  
  public String getBatteryInfo(bekr parambekr)
  {
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("level", (int)(this.batteryPct * 100.0F));
      ((JSONObject)localObject).put("isCharging", this.isCharging);
      localObject = bekx.a(parambekr.jdField_a_of_type_JavaLangString, (JSONObject)localObject).toString();
      if ("getBatteryInfo".equals(parambekr.jdField_a_of_type_JavaLangString)) {
        parambekr.jdField_a_of_type_Behp.a(parambekr.b, (String)localObject);
      }
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      betc.d("BatteryJsPlugin", localThrowable.getMessage(), localThrowable);
      if ("getBatteryInfo".equals(parambekr.jdField_a_of_type_JavaLangString))
      {
        String str = bekx.b(parambekr.jdField_a_of_type_JavaLangString, null).toString();
        parambekr.jdField_a_of_type_Behp.a(parambekr.b, str);
      }
    }
    return "";
  }
  
  public void onCreate(behq parambehq)
  {
    super.onCreate(parambehq);
    parambehq = new IntentFilter();
    parambehq.addAction("android.intent.action.BATTERY_CHANGED");
    this.mContext.registerReceiver(this.mPowerConnectionReceiver, parambehq);
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
      betc.d("BatteryJsPlugin", "unregisterReceiver exception.", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.BatteryJsPlugin
 * JD-Core Version:    0.7.0.1
 */