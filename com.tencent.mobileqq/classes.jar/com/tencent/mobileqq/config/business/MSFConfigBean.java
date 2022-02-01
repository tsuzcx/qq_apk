package com.tencent.mobileqq.config.business;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class MSFConfigBean
{
  public boolean a = false;
  private boolean b = false;
  private boolean c = false;
  private boolean d = true;
  private boolean e = true;
  private boolean f = false;
  private boolean g = false;
  private int h = 120;
  
  public static MSFConfigBean a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      MSFConfigBean localMSFConfigBean = new MSFConfigBean();
      paramString = new JSONObject(paramString);
      localMSFConfigBean.b = paramString.optBoolean("isIPCDivideToTransportEnable", false);
      localMSFConfigBean.c = paramString.optBoolean("isSleepThreadWhenIPCBlockEnable", false);
      localMSFConfigBean.d = paramString.optBoolean("isSendQuickHBByDeepSleepEnable", true);
      localMSFConfigBean.e = paramString.optBoolean("isSendQuickHBByScreenOnEnable", true);
      localMSFConfigBean.f = paramString.optBoolean("isBinderConnectOptEnable", false);
      localMSFConfigBean.g = paramString.optBoolean("isChangeHuaweiDSCheck", false);
      localMSFConfigBean.a = paramString.optBoolean("isNeedLoadMsgFromDeepSleep", false);
      localMSFConfigBean.h = paramString.optInt("deepSleepDetectInterval", 120);
      return localMSFConfigBean;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MSFConfigProcessor", 1, new Object[] { "parse e:", paramString.toString() });
      }
    }
    return null;
  }
  
  public static String a(MSFConfigBean paramMSFConfigBean)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramMSFConfigBean != null) {
      try
      {
        localJSONObject.put("isIPCDivideToTransportEnable", paramMSFConfigBean.b);
        localJSONObject.put("isSleepThreadWhenIPCBlockEnable", paramMSFConfigBean.c);
        localJSONObject.put("isSendQuickHBByDeepSleepEnable", paramMSFConfigBean.d);
        localJSONObject.put("isBinderConnectOptEnable", paramMSFConfigBean.f);
        localJSONObject.put("isSendQuickHBByScreenOnEnable", paramMSFConfigBean.e);
        localJSONObject.put("isChangeHuaweiDSCheck", paramMSFConfigBean.g);
        localJSONObject.put("isNeedLoadMsgFromDeepSleep", paramMSFConfigBean.a);
        localJSONObject.put("deepSleepDetectInterval", paramMSFConfigBean.h);
      }
      catch (JSONException paramMSFConfigBean)
      {
        paramMSFConfigBean.printStackTrace();
      }
    }
    return localJSONObject.toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MSFConfigBean{isIPCDivideToTransportEnable=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", isSleepThreadWhenIPCBlockEnable=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", isSendQuickHBByDeepSleepEnable=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", isSendQuickHBByScreenOnEnable=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", isBinderConnectOptEnable=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", isChangeHuaweiDSCheck=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", isNeedLoadMsgFromDeepSleep=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", deepSleepDetectInterval=");
    localStringBuilder.append(this.h);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.MSFConfigBean
 * JD-Core Version:    0.7.0.1
 */