package com.tencent.mobileqq.confess;

import amnn;
import amnp;
import awzy;
import com.tencent.qphone.base.util.QLog;

public final class ConfessMsgUtil$1
  implements Runnable
{
  public ConfessMsgUtil$1(amnn paramamnn, String paramString, amnp paramamnp, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    this.jdField_a_of_type_Amnn.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Amnp, this.jdField_a_of_type_Long, this.jdField_a_of_type_Long, this.b);
    if (QLog.isColorLevel())
    {
      long l = awzy.a();
      QLog.i("ConfessMsgUtil", 2, "decodeConfessMsgElem 1 strConfessorDesc:" + this.jdField_a_of_type_Amnp.f + " msgTime:" + this.jdField_a_of_type_Long + " msgSeq:" + this.b + " nowTime" + l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessMsgUtil.1
 * JD-Core Version:    0.7.0.1
 */