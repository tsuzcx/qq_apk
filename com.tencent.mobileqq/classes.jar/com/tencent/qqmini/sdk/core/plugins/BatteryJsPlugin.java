package com.tencent.qqmini.sdk.core.plugins;

import android.content.Context;
import android.content.IntentFilter;
import bglu;
import bglv;
import bgok;
import bgop;
import com.tencent.qqmini.sdk.log.QMLog;
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
  
  public String getBatteryInfo(bgok parambgok)
  {
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("level", (int)(this.batteryPct * 100.0F));
      ((JSONObject)localObject).put("isCharging", this.isCharging);
      localObject = bgop.a(parambgok.jdField_a_of_type_JavaLangString, (JSONObject)localObject).toString();
      if ("getBatteryInfo".equals(parambgok.jdField_a_of_type_JavaLangString)) {
        parambgok.jdField_a_of_type_Bglu.a(parambgok.b, (String)localObject);
      }
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("BatteryJsPlugin", localThrowable.getMessage(), localThrowable);
      if ("getBatteryInfo".equals(parambgok.jdField_a_of_type_JavaLangString))
      {
        String str = bgop.b(parambgok.jdField_a_of_type_JavaLangString, null).toString();
        parambgok.jdField_a_of_type_Bglu.a(parambgok.b, str);
      }
    }
    return "";
  }
  
  public void onCreate(bglv parambglv)
  {
    super.onCreate(parambglv);
    parambglv = new IntentFilter();
    parambglv.addAction("android.intent.action.BATTERY_CHANGED");
    this.mContext.registerReceiver(this.mPowerConnectionReceiver, parambglv);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.BatteryJsPlugin
 * JD-Core Version:    0.7.0.1
 */