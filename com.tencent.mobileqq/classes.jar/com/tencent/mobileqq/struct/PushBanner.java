package com.tencent.mobileqq.struct;

import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.QLog;

public class PushBanner
{
  public JumpAction a;
  @unique
  public String a;
  public short a;
  public String b = "";
  public String c;
  public String d = "";
  public String e = "";
  public String f = "";
  public String g = "";
  public String h = "";
  public String i = "";
  public String j = "";
  public String k = "";
  public String l;
  public String m;
  public String n;
  
  public PushBanner(long paramLong, String paramString, short paramShort)
  {
    this.jdField_a_of_type_JavaLangString = String.valueOf(paramLong);
    this.c = paramString;
    if (paramShort == 0)
    {
      this.jdField_a_of_type_Short = 10;
      return;
    }
    this.jdField_a_of_type_Short = paramShort;
  }
  
  public boolean a(String paramString)
  {
    try
    {
      String[] arrayOfString = paramString.split("&");
      if (arrayOfString.length == 7)
      {
        this.e = arrayOfString[0].substring(14);
        this.f = arrayOfString[1].substring(8);
        this.g = arrayOfString[2].substring(5);
        this.h = arrayOfString[3].substring(9);
        this.i = arrayOfString[4].substring(17);
        this.j = PkgTools.decodeCgi(arrayOfString[5].substring(9));
        if ((this.j != null) && (this.j.length() > 0))
        {
          int i1 = this.j.lastIndexOf("channel_id");
          if (i1 != -1)
          {
            paramString = this.j.substring(i1);
            i1 = paramString.charAt(10);
            String str;
            if (i1 == 37)
            {
              str = paramString.substring(paramString.indexOf('%') + 3);
              paramString = str;
              if (str.indexOf('%') > 0) {
                paramString = str.substring(0, str.indexOf('%'));
              }
              this.b = paramString;
            }
            else if (i1 == 61)
            {
              str = paramString.substring(paramString.indexOf('=') + 1);
              paramString = str;
              if (str.indexOf('&') > 0) {
                paramString = str.substring(0, str.indexOf('&'));
              }
              this.b = paramString;
            }
          }
        }
        this.k = arrayOfString[6].substring(13);
        if ("PLUGIN".equalsIgnoreCase(this.i)) {
          return true;
        }
      }
      else
      {
        throw new IllegalArgumentException("PushBanner Params Count must be:7");
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PushBanner", 2, "loadParams Exception:", paramString);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.struct.PushBanner
 * JD-Core Version:    0.7.0.1
 */