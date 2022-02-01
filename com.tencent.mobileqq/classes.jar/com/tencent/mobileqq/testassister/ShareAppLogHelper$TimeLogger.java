package com.tencent.mobileqq.testassister;

import com.tencent.qphone.base.util.QLog;

class ShareAppLogHelper$TimeLogger
{
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  
  public ShareAppLogHelper$TimeLogger(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      long l = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("ShareAppLogHelper.TimeLogger", 4, new Object[] { this.jdField_a_of_type_JavaLangString, " costTime: ", Long.valueOf(l - this.jdField_a_of_type_Long) });
      }
    }
    else
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.testassister.ShareAppLogHelper.TimeLogger
 * JD-Core Version:    0.7.0.1
 */