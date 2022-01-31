package com.tencent.qqmini.sdk.core.plugins;

import android.content.Context;
import android.content.IntentFilter;
import bdcy;
import bdcz;
import bdfz;
import bdgg;
import bdnw;
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
  
  public String getBatteryInfo(bdfz parambdfz)
  {
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("level", (int)(this.batteryPct * 100.0F));
      ((JSONObject)localObject).put("isCharging", this.isCharging);
      localObject = bdgg.a(parambdfz.jdField_a_of_type_JavaLangString, (JSONObject)localObject).toString();
      if ("getBatteryInfo".equals(parambdfz.jdField_a_of_type_JavaLangString)) {
        parambdfz.jdField_a_of_type_Bdcy.a(parambdfz.b, (String)localObject);
      }
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      bdnw.d("BatteryJsPlugin", localThrowable.getMessage(), localThrowable);
      if ("getBatteryInfo".equals(parambdfz.jdField_a_of_type_JavaLangString))
      {
        String str = bdgg.b(parambdfz.jdField_a_of_type_JavaLangString, null).toString();
        parambdfz.jdField_a_of_type_Bdcy.a(parambdfz.b, str);
      }
    }
    return "";
  }
  
  public void onCreate(bdcz parambdcz)
  {
    super.onCreate(parambdcz);
    parambdcz = new IntentFilter();
    parambdcz.addAction("android.intent.action.BATTERY_CHANGED");
    this.mContext.registerReceiver(this.mPowerConnectionReceiver, parambdcz);
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
      bdnw.d("BatteryJsPlugin", "unregisterReceiver exception.", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.BatteryJsPlugin
 * JD-Core Version:    0.7.0.1
 */