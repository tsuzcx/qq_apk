package com.tencent.mobileqq.config.business;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class WVPreloadPskeyConfBean
{
  public int a = 1;
  public int b = 1;
  
  public static WVPreloadPskeyConfBean a(String paramString)
  {
    WVPreloadPskeyConfBean localWVPreloadPskeyConfBean = new WVPreloadPskeyConfBean();
    try
    {
      paramString = new JSONObject(paramString);
      localWVPreloadPskeyConfBean.a = paramString.optInt("preloadPskey", 1);
      localWVPreloadPskeyConfBean.b = paramString.optInt("enableFTSMerge", 1);
      QLog.d("WVPreloadPskeyConfProcessor", 2, "confBean = " + localWVPreloadPskeyConfBean.toString());
      return localWVPreloadPskeyConfBean;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("WVPreloadPskeyConfProcessor", 1, new Object[] { "parse e:", paramString.toString() });
    }
    return localWVPreloadPskeyConfBean;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(20);
    localStringBuilder.append("preloadPskey:").append(this.a);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.WVPreloadPskeyConfBean
 * JD-Core Version:    0.7.0.1
 */