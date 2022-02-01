package com.tencent.mobileqq.config.business;

import org.json.JSONObject;

public class QConfLogBean
{
  private boolean a = true;
  private boolean b = false;
  private boolean c = true;
  private boolean d = false;
  private long e = 2000L;
  private long f = 60000L;
  
  public static QConfLogBean a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        QConfLogBean localQConfLogBean = new QConfLogBean();
        paramString = new JSONObject(paramString);
        boolean bool2 = true;
        if (paramString.optInt("useNewLog", 1) == 1)
        {
          bool1 = true;
          localQConfLogBean.a = bool1;
          if (paramString.optInt("compressAndEncrypt", 0) != 1) {
            break label149;
          }
          bool1 = true;
          localQConfLogBean.b = bool1;
          if (paramString.optInt("enableConsole", 1) != 1) {
            break label154;
          }
          bool1 = true;
          localQConfLogBean.c = bool1;
          if (paramString.optInt("enableCheckPermission", 1) != 1) {
            break label159;
          }
          bool1 = bool2;
          localQConfLogBean.d = bool1;
          localQConfLogBean.e = paramString.optLong("locationSdkCallbackIntervalMillis", 2000L);
          localQConfLogBean.f = paramString.optLong("locationBgTimeoutMillis", 60000L);
          return localQConfLogBean;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      boolean bool1 = false;
      continue;
      label149:
      bool1 = false;
      continue;
      label154:
      bool1 = false;
      continue;
      label159:
      bool1 = false;
    }
  }
  
  public boolean a()
  {
    return this.a;
  }
  
  public boolean b()
  {
    return this.d;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QConfLogBean{useNewLog=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", compressAndEncrypt=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", enableConsole=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(",enableCheckPermission=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(",locationSdkCallbackIntervalMillis=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(",locationBgTimeoutMillis=");
    localStringBuilder.append(this.f);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.QConfLogBean
 * JD-Core Version:    0.7.0.1
 */