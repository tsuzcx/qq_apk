package com.tencent.qqmini.sdk.core.plugins;

import android.content.Context;
import android.content.IntentFilter;
import bglu;
import bglv;
import bgok;
import bgop;
import bgpk;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

public class NetworkJsPlugin
  extends BaseJsPlugin
{
  public static final String EVENT_NETWORK_STATE_CHANGE = "onNetworkStatusChange";
  private static final String TAG = "NetworkJsPlugin";
  private String mLastNetworkType = "none";
  private NetworkJsPlugin.ConnectionChangeReceiver mReceiver;
  private boolean mRegister;
  
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
    switch (bgpk.a(this.mContext))
    {
    default: 
      return "unkown";
    case 0: 
      return "none";
    case 2: 
      return "2g";
    case 3: 
      return "3g";
    case 4: 
      return "4g";
    }
    return "wifi";
  }
  
  public String getNetworkType(bgok parambgok)
  {
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("networkType", getCurrentTypeDesc());
      localObject = bgop.a(parambgok.jdField_a_of_type_JavaLangString, (JSONObject)localObject).toString();
      parambgok.jdField_a_of_type_Bglu.a(parambgok.b, (String)localObject);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("NetworkJsPlugin", localThrowable.getMessage(), localThrowable);
      String str = bgop.b(parambgok.jdField_a_of_type_JavaLangString, null).toString();
      parambgok.jdField_a_of_type_Bglu.a(parambgok.b, str);
    }
    return "";
  }
  
  public void onCreate(bglv parambglv)
  {
    super.onCreate(parambglv);
    if ((this.mContext != null) && (!this.mRegister))
    {
      this.mReceiver = new NetworkJsPlugin.ConnectionChangeReceiver(this);
      this.mContext.registerReceiver(this.mReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
      this.mRegister = true;
    }
  }
  
  public void onDestroy()
  {
    if ((this.mRegister) && (this.mReceiver != null)) {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.NetworkJsPlugin
 * JD-Core Version:    0.7.0.1
 */