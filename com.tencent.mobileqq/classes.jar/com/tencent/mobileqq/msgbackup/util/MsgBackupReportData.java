package com.tencent.mobileqq.msgbackup.util;

import android.support.annotation.NonNull;
import java.util.ArrayList;

public class MsgBackupReportData
{
  public double a;
  public int a;
  public long a;
  public ArrayList<MsgBackupReportData.FileError> a;
  public boolean a;
  public int b;
  public long b;
  public boolean b;
  public int c;
  public long c;
  public int d;
  public long d;
  public long e;
  public long f;
  public long g;
  public long h;
  public long i;
  public long j;
  public long k;
  public long l;
  public long m;
  public long n;
  public long o;
  public long p;
  public long q;
  public long r;
  
  public MsgBackupReportData()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Double = 0.0D;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
    this.e = 0L;
    this.f = 0L;
    this.g = 0L;
    this.h = 0L;
    this.i = 0L;
    this.j = 0L;
    this.k = 0L;
    this.l = 0L;
    this.m = 0L;
    this.n = 0L;
    this.o = 0L;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_d_of_type_Int = 0;
    this.p = 0L;
    this.q = 0L;
    this.r = 0L;
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[bizType = ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("\n platForm = ");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append("\n requestStatus = ");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append("\n errorCode = ");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append("\n totalCost = ");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("\n averageSpeed = ");
    localStringBuilder.append(this.jdField_a_of_type_Double);
    localStringBuilder.append("\n totalSessionCount = ");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append("\n finishedSessionCount = ");
    localStringBuilder.append(this.jdField_c_of_type_Long);
    localStringBuilder.append("\n resSessionContains = ");
    localStringBuilder.append(this.jdField_d_of_type_Long);
    localStringBuilder.append("\n resTotalSize = ");
    localStringBuilder.append(this.e);
    localStringBuilder.append("\n dbTotalSize = ");
    localStringBuilder.append(this.f);
    localStringBuilder.append("\n resRequestCount = ");
    localStringBuilder.append(this.g);
    localStringBuilder.append("\n resRequestFailedCount = ");
    localStringBuilder.append(this.h);
    localStringBuilder.append("\n resRequestCancelCount = ");
    localStringBuilder.append(this.i);
    localStringBuilder.append("\n resTrivialCount = ");
    localStringBuilder.append(this.j);
    localStringBuilder.append("\n resTrivialFailedCount = ");
    localStringBuilder.append(this.k);
    localStringBuilder.append("\n resTrivialCancelCount = ");
    localStringBuilder.append(this.l);
    localStringBuilder.append("\n dbRequestCount = ");
    localStringBuilder.append(this.m);
    localStringBuilder.append("\n dbRequestFailedCount = ");
    localStringBuilder.append(this.n);
    localStringBuilder.append("\n dbRequestCancelCount = ");
    localStringBuilder.append(this.o);
    localStringBuilder.append("\n connectType = ");
    localStringBuilder.append(this.jdField_d_of_type_Int);
    localStringBuilder.append("\n connectElipse = ");
    localStringBuilder.append(this.p);
    localStringBuilder.append("\n sessionReadyAllTimes = ");
    localStringBuilder.append(this.q);
    localStringBuilder.append("\n fileFailedCount = ");
    localStringBuilder.append(this.r);
    localStringBuilder.append("\n fileErrorList = ");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilArrayList);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.util.MsgBackupReportData
 * JD-Core Version:    0.7.0.1
 */