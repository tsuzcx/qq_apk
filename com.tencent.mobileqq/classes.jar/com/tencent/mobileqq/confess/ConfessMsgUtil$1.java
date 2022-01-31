package com.tencent.mobileqq.confess;

import aoiu;
import aoiw;
import ayzl;
import com.tencent.qphone.base.util.QLog;

public final class ConfessMsgUtil$1
  implements Runnable
{
  public ConfessMsgUtil$1(aoiu paramaoiu, String paramString, aoiw paramaoiw, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    this.jdField_a_of_type_Aoiu.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aoiw, this.jdField_a_of_type_Long, this.jdField_a_of_type_Long, this.b);
    if (QLog.isColorLevel())
    {
      long l = ayzl.a();
      QLog.i("ConfessMsgUtil", 2, "decodeConfessMsgElem 1 strConfessorDesc:" + this.jdField_a_of_type_Aoiw.f + " msgTime:" + this.jdField_a_of_type_Long + " msgSeq:" + this.b + " nowTime" + l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessMsgUtil.1
 * JD-Core Version:    0.7.0.1
 */