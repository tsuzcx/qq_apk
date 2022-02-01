package com.tencent.mobileqq.config.business;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class MSFConfigBean
{
  private boolean a = false;
  private boolean b = false;
  private boolean c = true;
  private boolean d = true;
  private boolean e = false;
  private boolean f = false;
  
  public static MSFConfigBean a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        MSFConfigBean localMSFConfigBean = new MSFConfigBean();
        paramString = new JSONObject(paramString);
        localMSFConfigBean.a = paramString.optBoolean("isIPCDivideToTransportEnable", false);
        localMSFConfigBean.b = paramString.optBoolean("isSleepThreadWhenIPCBlockEnable", false);
        localMSFConfigBean.c = paramString.optBoolean("isSendQuickHBByDeepSleepEnable", true);
        localMSFConfigBean.d = paramString.optBoolean("isSendQuickHBByScreenOnEnable", true);
        localMSFConfigBean.e = paramString.optBoolean("isBinderConnectOptEnable", false);
        localMSFConfigBean.f = paramString.optBoolean("isChangeHuaweiDSCheck", false);
        return localMSFConfigBean;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("MSFConfigProcessor", 1, new Object[] { "parse e:", paramString.toString() });
    return null;
  }
  
  public static String a(MSFConfigBean paramMSFConfigBean)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramMSFConfigBean != null) {}
    try
    {
      localJSONObject.put("isIPCDivideToTransportEnable", paramMSFConfigBean.a);
      localJSONObject.put("isSleepThreadWhenIPCBlockEnable", paramMSFConfigBean.b);
      localJSONObject.put("isSendQuickHBByDeepSleepEnable", paramMSFConfigBean.c);
      localJSONObject.put("isBinderConnectOptEnable", paramMSFConfigBean.e);
      localJSONObject.put("isSendQuickHBByScreenOnEnable", paramMSFConfigBean.d);
      localJSONObject.put("isChangeHuaweiDSCheck", paramMSFConfigBean.f);
      return localJSONObject.toString();
    }
    catch (JSONException paramMSFConfigBean)
    {
      for (;;)
      {
        paramMSFConfigBean.printStackTrace();
      }
    }
  }
  
  public String toString()
  {
    return "MSFConfigBean{isIPCDivideToTransportEnable=" + this.a + ", isSleepThreadWhenIPCBlockEnable=" + this.b + ", isSendQuickHBByDeepSleepEnable=" + this.c + ", isSendQuickHBByScreenOnEnable=" + this.d + ", isBinderConnectOptEnable=" + this.e + ", isChangeHuaweiDSCheck=" + this.f + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.MSFConfigBean
 * JD-Core Version:    0.7.0.1
 */