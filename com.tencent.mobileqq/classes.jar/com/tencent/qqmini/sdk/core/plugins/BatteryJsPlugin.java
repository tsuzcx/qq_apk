package com.tencent.qqmini.sdk.core.plugins;

import android.content.Context;
import android.content.IntentFilter;
import begy;
import begz;
import beka;
import bekg;
import besl;
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
  
  public String getBatteryInfo(beka parambeka)
  {
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("level", (int)(this.batteryPct * 100.0F));
      ((JSONObject)localObject).put("isCharging", this.isCharging);
      localObject = bekg.a(parambeka.jdField_a_of_type_JavaLangString, (JSONObject)localObject).toString();
      if ("getBatteryInfo".equals(parambeka.jdField_a_of_type_JavaLangString)) {
        parambeka.jdField_a_of_type_Begy.a(parambeka.b, (String)localObject);
      }
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      besl.d("BatteryJsPlugin", localThrowable.getMessage(), localThrowable);
      if ("getBatteryInfo".equals(parambeka.jdField_a_of_type_JavaLangString))
      {
        String str = bekg.b(parambeka.jdField_a_of_type_JavaLangString, null).toString();
        parambeka.jdField_a_of_type_Begy.a(parambeka.b, str);
      }
    }
    return "";
  }
  
  public void onCreate(begz parambegz)
  {
    super.onCreate(parambegz);
    parambegz = new IntentFilter();
    parambegz.addAction("android.intent.action.BATTERY_CHANGED");
    this.mContext.registerReceiver(this.mPowerConnectionReceiver, parambegz);
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
      besl.d("BatteryJsPlugin", "unregisterReceiver exception.", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.BatteryJsPlugin
 * JD-Core Version:    0.7.0.1
 */