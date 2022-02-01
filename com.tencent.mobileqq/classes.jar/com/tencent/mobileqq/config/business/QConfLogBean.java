package com.tencent.mobileqq.config.business;

import org.json.JSONObject;

public class QConfLogBean
{
  private long jdField_a_of_type_Long = 2000L;
  private boolean jdField_a_of_type_Boolean = true;
  private long jdField_b_of_type_Long = 60000L;
  private boolean jdField_b_of_type_Boolean = false;
  private boolean c = true;
  private boolean d = false;
  
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
          localQConfLogBean.jdField_a_of_type_Boolean = bool1;
          if (paramString.optInt("compressAndEncrypt", 0) != 1) {
            break label149;
          }
          bool1 = true;
          localQConfLogBean.jdField_b_of_type_Boolean = bool1;
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
          localQConfLogBean.jdField_a_of_type_Long = paramString.optLong("locationSdkCallbackIntervalMillis", 2000L);
          localQConfLogBean.jdField_b_of_type_Long = paramString.optLong("locationBgTimeoutMillis", 60000L);
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
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean b()
  {
    return this.d;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QConfLogBean{useNewLog=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", compressAndEncrypt=");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append(", enableConsole=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(",enableCheckPermission=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(",locationSdkCallbackIntervalMillis=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(",locationBgTimeoutMillis=");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.QConfLogBean
 * JD-Core Version:    0.7.0.1
 */