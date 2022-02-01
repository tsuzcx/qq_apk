package com.tencent.mobileqq.statistics;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.QLog;

class ScoreReportController$ReportData
{
  public long a;
  public String a;
  public long b;
  public String b;
  public long c;
  public String c;
  public long d;
  public String d;
  public long e;
  public String e;
  public long f;
  public String f;
  public long g;
  public long h;
  public long i = 0L;
  public long j = 4L;
  public long k = a();
  public long l = Build.VERSION.SDK_INT;
  public long m;
  public long n = 0L;
  public long o = 0L;
  public long p = 0L;
  public long q = 0L;
  
  public ScoreReportController$ReportData()
  {
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "8.7.0";
    this.jdField_c_of_type_JavaLangString = Build.MODEL;
  }
  
  public int a()
  {
    boolean bool = AppNetConnInfo.isWifiConn();
    int i1 = 3;
    if (bool)
    {
      i1 = 2;
    }
    else
    {
      if (AppNetConnInfo.isMobileConn())
      {
        int i2 = AppNetConnInfo.getMobileInfo();
        if (i2 == 1) {
          break label55;
        }
        if (i2 != 2)
        {
          if (i2 == 3)
          {
            i1 = 5;
            break label55;
          }
        }
        else
        {
          i1 = 4;
          break label55;
        }
      }
      i1 = 0;
    }
    label55:
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getNetType: ");
      localStringBuilder.append(i1);
      QLog.d("ScoreReportController", 2, localStringBuilder.toString());
    }
    return i1;
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder(256);
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append('|');
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append('|');
    localStringBuilder.append(this.jdField_c_of_type_Long);
    localStringBuilder.append('|');
    localStringBuilder.append(this.jdField_d_of_type_Long);
    localStringBuilder.append('|');
    localStringBuilder.append(this.jdField_e_of_type_Long);
    localStringBuilder.append('|');
    localStringBuilder.append(this.jdField_f_of_type_Long);
    localStringBuilder.append('|');
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('|');
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append('|');
    localStringBuilder.append(this.g);
    localStringBuilder.append('|');
    localStringBuilder.append(this.h);
    localStringBuilder.append('|');
    localStringBuilder.append(this.i);
    localStringBuilder.append('|');
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append('|');
    localStringBuilder.append(this.j);
    localStringBuilder.append('|');
    localStringBuilder.append(this.k);
    localStringBuilder.append('|');
    localStringBuilder.append(this.l);
    localStringBuilder.append('|');
    localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
    localStringBuilder.append('|');
    localStringBuilder.append(this.jdField_e_of_type_JavaLangString);
    localStringBuilder.append('|');
    localStringBuilder.append(this.m);
    localStringBuilder.append('|');
    localStringBuilder.append(this.n);
    localStringBuilder.append('|');
    localStringBuilder.append(this.o);
    localStringBuilder.append('|');
    localStringBuilder.append(this.p);
    localStringBuilder.append('|');
    localStringBuilder.append(this.q);
    localStringBuilder.append('|');
    localStringBuilder.append(this.jdField_f_of_type_JavaLangString);
    localStringBuilder.append('|');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.ScoreReportController.ReportData
 * JD-Core Version:    0.7.0.1
 */