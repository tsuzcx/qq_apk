package com.tencent.mobileqq.hotchat;

import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.qphone.base.util.QLog;
import oicq.wlogin_sdk.tools.MD5;
import org.json.JSONObject;

public class HotChatSCMng$ConfigData
{
  String a;
  String b;
  String c;
  
  public static ConfigData a(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return null;
      }
      try
      {
        ConfigData localConfigData = new ConfigData();
        paramString = new JSONObject(paramString);
        localConfigData.a = paramString.getString("url");
        if (localConfigData.a != null)
        {
          localConfigData.a = localConfigData.a.trim();
          localConfigData.c = MD5.toMD5(localConfigData.a);
        }
        localConfigData.b = paramString.getString("md5");
        if (localConfigData.b != null) {
          localConfigData.b = localConfigData.b.trim();
        }
        if (QLog.isDevelopLevel()) {
          NearbyUtils.a("HotchatSCMng", "parse ConfigData", new Object[] { localConfigData });
        }
        return localConfigData;
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("[url:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(",");
    localStringBuilder.append("md5:");
    localStringBuilder.append(this.b);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.hotchat.HotChatSCMng.ConfigData
 * JD-Core Version:    0.7.0.1
 */