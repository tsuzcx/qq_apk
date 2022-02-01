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
    boolean bool2 = true;
    if (paramString == null) {
      return null;
    }
    try
    {
      QConfLogBean localQConfLogBean = new QConfLogBean();
      paramString = new JSONObject(paramString);
      if (paramString.optInt("useNewLog", 1) == 1)
      {
        bool1 = true;
        localQConfLogBean.jdField_a_of_type_Boolean = bool1;
        if (paramString.optInt("compressAndEncrypt", 0) != 1) {
          break label130;
        }
        bool1 = true;
        label56:
        localQConfLogBean.jdField_b_of_type_Boolean = bool1;
        if (paramString.optInt("enableConsole", 1) != 1) {
          break label135;
        }
        bool1 = true;
        label74:
        localQConfLogBean.c = bool1;
        if (paramString.optInt("enableCheckPermission", 1) != 1) {
          break label140;
        }
      }
      label130:
      label135:
      label140:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        localQConfLogBean.d = bool1;
        localQConfLogBean.jdField_a_of_type_Long = paramString.optLong("locationSdkCallbackIntervalMillis", 2000L);
        localQConfLogBean.jdField_b_of_type_Long = paramString.optLong("locationBgTimeoutMillis", 60000L);
        return localQConfLogBean;
        bool1 = false;
        break;
        bool1 = false;
        break label56;
        bool1 = false;
        break label74;
      }
      return null;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
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
    return "QConfLogBean{useNewLog=" + this.jdField_a_of_type_Boolean + ", compressAndEncrypt=" + this.jdField_b_of_type_Boolean + ", enableConsole=" + this.c + ",enableCheckPermission=" + this.d + ",locationSdkCallbackIntervalMillis=" + this.jdField_a_of_type_Long + ",locationBgTimeoutMillis=" + this.jdField_b_of_type_Long + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.QConfLogBean
 * JD-Core Version:    0.7.0.1
 */