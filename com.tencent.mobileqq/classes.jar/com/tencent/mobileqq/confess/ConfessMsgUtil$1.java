package com.tencent.mobileqq.confess;

import aqjm;
import aqjo;
import bbyp;
import com.tencent.qphone.base.util.QLog;

public final class ConfessMsgUtil$1
  implements Runnable
{
  public ConfessMsgUtil$1(aqjm paramaqjm, String paramString, aqjo paramaqjo, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    this.jdField_a_of_type_Aqjm.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aqjo, this.jdField_a_of_type_Long, this.jdField_a_of_type_Long, this.b);
    if (QLog.isColorLevel())
    {
      long l = bbyp.a();
      QLog.i("ConfessMsgUtil", 2, "decodeConfessMsgElem 1 strConfessorDesc:" + this.jdField_a_of_type_Aqjo.f + " msgTime:" + this.jdField_a_of_type_Long + " msgSeq:" + this.b + " nowTime" + l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessMsgUtil.1
 * JD-Core Version:    0.7.0.1
 */