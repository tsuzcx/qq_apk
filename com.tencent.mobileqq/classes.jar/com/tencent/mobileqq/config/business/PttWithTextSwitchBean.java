package com.tencent.mobileqq.config.business;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class PttWithTextSwitchBean
{
  private int a = 0;
  private long b = 3000L;
  
  public static PttWithTextSwitchBean a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      PttWithTextSwitchBean localPttWithTextSwitchBean = new PttWithTextSwitchBean();
      paramString = new JSONObject(paramString);
      localPttWithTextSwitchBean.a = paramString.optInt("pttWithTextSwitch", -1);
      localPttWithTextSwitchBean.b = paramString.optLong("aioSttSpliceTimeout", 45000L);
      return localPttWithTextSwitchBean;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PttWithTextSwitchBean", 1, new Object[] { "parse e:", paramString.toString() });
      }
    }
    return null;
  }
  
  public boolean a()
  {
    return this.a == 1;
  }
  
  public long b()
  {
    return this.b;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("open:");
    localStringBuilder.append(this.a);
    localStringBuilder.append("  |  aioSttSpliceTimeout:");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.PttWithTextSwitchBean
 * JD-Core Version:    0.7.0.1
 */