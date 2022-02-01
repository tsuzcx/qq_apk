package com.tencent.mobileqq.confess;

import aqyp;
import aqyr;
import bcrg;
import com.tencent.qphone.base.util.QLog;

public final class ConfessMsgUtil$1
  implements Runnable
{
  public ConfessMsgUtil$1(aqyp paramaqyp, String paramString, aqyr paramaqyr, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    this.jdField_a_of_type_Aqyp.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aqyr, this.jdField_a_of_type_Long, this.jdField_a_of_type_Long, this.b);
    if (QLog.isColorLevel())
    {
      long l = bcrg.a();
      QLog.i("ConfessMsgUtil", 2, "decodeConfessMsgElem 1 strConfessorDesc:" + this.jdField_a_of_type_Aqyr.f + " msgTime:" + this.jdField_a_of_type_Long + " msgSeq:" + this.b + " nowTime" + l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessMsgUtil.1
 * JD-Core Version:    0.7.0.1
 */