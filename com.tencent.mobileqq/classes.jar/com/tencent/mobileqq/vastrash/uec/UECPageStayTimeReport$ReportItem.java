package com.tencent.mobileqq.vastrash.uec;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;

public class UECPageStayTimeReport$ReportItem
{
  public long a;
  public String a;
  public long b;
  public String b;
  
  public long a()
  {
    long l1 = this.jdField_a_of_type_Long;
    if (l1 != 0L)
    {
      long l2 = this.jdField_b_of_type_Long;
      if ((l2 != 0L) && (l2 - l1 > 0L)) {
        return l2 - l1;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getStayTime error, ");
    localStringBuilder.append(toString());
    QLog.e("UECPageStayTimeReport", 1, localStringBuilder.toString());
    return 0L;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
  }
  
  public void b()
  {
    this.jdField_b_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ReportItem{mPageKey='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mExtraInfo='");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mEnterTime=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", mExitTime=");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append(", Timelong=");
    localStringBuilder.append(this.jdField_b_of_type_Long - this.jdField_a_of_type_Long);
    localStringBuilder.append(", Process=");
    localStringBuilder.append(BaseApplicationImpl.processName);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vastrash.uec.UECPageStayTimeReport.ReportItem
 * JD-Core Version:    0.7.0.1
 */