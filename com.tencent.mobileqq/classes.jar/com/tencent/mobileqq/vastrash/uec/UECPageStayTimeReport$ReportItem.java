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
    if ((this.jdField_a_of_type_Long == 0L) || (this.jdField_b_of_type_Long == 0L) || (this.jdField_b_of_type_Long - this.jdField_a_of_type_Long <= 0L))
    {
      QLog.e("UECPageStayTimeReport", 1, "getStayTime error, " + toString());
      return 0L;
    }
    return this.jdField_b_of_type_Long - this.jdField_a_of_type_Long;
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
    return "ReportItem{mPageKey='" + this.jdField_a_of_type_JavaLangString + '\'' + ", mExtraInfo='" + this.jdField_b_of_type_JavaLangString + '\'' + ", mEnterTime=" + this.jdField_a_of_type_Long + ", mExitTime=" + this.jdField_b_of_type_Long + ", Timelong=" + (this.jdField_b_of_type_Long - this.jdField_a_of_type_Long) + ", Process=" + BaseApplicationImpl.processName + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vastrash.uec.UECPageStayTimeReport.ReportItem
 * JD-Core Version:    0.7.0.1
 */