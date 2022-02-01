package com.tencent.mobileqq.config.business.search;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class UinSearchConfProcessor$UinSearchConfigBean
{
  public static int a = 1;
  public static int b = 2;
  public int c = b;
  
  private static UinSearchConfigBean b(String paramString)
  {
    UinSearchConfigBean localUinSearchConfigBean = new UinSearchConfigBean();
    try
    {
      localUinSearchConfigBean.c = new JSONObject(paramString).optInt("action", b);
      return localUinSearchConfigBean;
    }
    catch (Throwable paramString)
    {
      QLog.e("UinSearchConfProcessor", 1, paramString, new Object[0]);
    }
    return localUinSearchConfigBean;
  }
  
  public boolean a()
  {
    return this.c == a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.search.UinSearchConfProcessor.UinSearchConfigBean
 * JD-Core Version:    0.7.0.1
 */