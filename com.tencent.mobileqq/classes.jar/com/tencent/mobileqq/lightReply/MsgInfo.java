package com.tencent.mobileqq.lightReply;

import com.tencent.qphone.base.util.QLog;

public class MsgInfo
{
  public int a;
  public long a;
  public String a;
  public String b;
  
  public MsgInfo(String paramString1, long paramLong, String paramString2, String paramString3)
  {
    try
    {
      this.jdField_a_of_type_Long = Long.valueOf(paramString1).longValue();
      i = (int)paramLong;
    }
    catch (Exception paramString1)
    {
      try
      {
        do
        {
          int i;
          this.jdField_a_of_type_Int = i;
          this.jdField_a_of_type_JavaLangString = paramString2;
          this.b = paramString3;
          return;
          paramString1 = paramString1;
        } while (!QLog.isColorLevel());
        QLog.d("MsgInfo", 2, QLog.getStackTraceString(paramString1));
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MsgInfo", 2, QLog.getStackTraceString(paramString1));
          }
        }
      }
    }
  }
  
  public String toString()
  {
    return "MsgInfo: uin = " + this.jdField_a_of_type_Long + ", seq = " + this.jdField_a_of_type_Int + ", uuid = " + this.jdField_a_of_type_JavaLangString + ", content = " + this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.lightReply.MsgInfo
 * JD-Core Version:    0.7.0.1
 */