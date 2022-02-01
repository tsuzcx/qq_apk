package com.tencent.mobileqq.soload.biz.entity;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.soload.util.SoDataUtil;
import com.tencent.qphone.base.util.QLog;

public class SoLocalInfo
{
  public long a;
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  
  public SoLocalInfo()
  {
    this.jdField_a_of_type_Long = -1L;
  }
  
  public SoLocalInfo(String paramString1, String paramString2, String paramString3, long paramLong, String paramString4, String paramString5, String paramString6)
  {
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.jdField_a_of_type_Long = paramLong;
    this.d = paramString4;
    this.e = paramString5;
    this.f = paramString6;
  }
  
  private static long a(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        long l = Long.parseLong(paramString);
        return l;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("SoLoadWidget.SoLocalInfo", 1, paramString, new Object[0]);
    }
    return -1L;
  }
  
  public static SoLocalInfo a(String paramString)
  {
    SoLocalInfo localSoLocalInfo = new SoLocalInfo();
    try
    {
      paramString = Uri.parse(paramString);
      localSoLocalInfo.jdField_a_of_type_JavaLangString = paramString.getQueryParameter("ver");
      localSoLocalInfo.b = paramString.getQueryParameter("name");
      localSoLocalInfo.c = paramString.getQueryParameter("path");
      localSoLocalInfo.jdField_a_of_type_Long = a(paramString.getQueryParameter("crc"));
      localSoLocalInfo.d = paramString.getQueryParameter("url");
      localSoLocalInfo.e = paramString.getQueryParameter("rUrl");
      localSoLocalInfo.f = paramString.getQueryParameter("rPath");
      return localSoLocalInfo;
    }
    catch (Throwable paramString)
    {
      QLog.e("SoLoadWidget.SoLocalInfo", 1, paramString, new Object[0]);
    }
    return localSoLocalInfo;
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("?").append("ver=").append(this.jdField_a_of_type_JavaLangString).append("&name=").append(this.b).append("&path=").append(SoDataUtil.a(this.c)).append("&crc=").append(this.jdField_a_of_type_Long).append("&url=").append(SoDataUtil.a(this.d)).append("&rUrl=").append(SoDataUtil.a(this.e)).append("&rPath=").append(SoDataUtil.a(this.f));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.soload.biz.entity.SoLocalInfo
 * JD-Core Version:    0.7.0.1
 */