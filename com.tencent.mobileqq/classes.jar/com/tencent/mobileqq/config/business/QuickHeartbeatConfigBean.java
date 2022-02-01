package com.tencent.mobileqq.config.business;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class QuickHeartbeatConfigBean
{
  public boolean a = false;
  
  public static QuickHeartbeatConfigBean a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      QuickHeartbeatConfigBean localQuickHeartbeatConfigBean = new QuickHeartbeatConfigBean();
      localQuickHeartbeatConfigBean.a = new JSONObject(paramString).optBoolean("isSendQuickHBBackToForeground", false);
      return localQuickHeartbeatConfigBean;
    }
    catch (Exception paramString)
    {
      QLog.e("QuickHeartbeatConfigProcessor", 1, new Object[] { "parse e:", paramString.toString() });
    }
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QuickHeartbeatConfigBean{isSendQuickHBBackToForeground=");
    localStringBuilder.append(this.a);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.QuickHeartbeatConfigBean
 * JD-Core Version:    0.7.0.1
 */