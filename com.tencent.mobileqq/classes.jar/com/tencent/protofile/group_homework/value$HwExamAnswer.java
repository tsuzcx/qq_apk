package com.tencent.protofile.group_homework;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class value$HwExamAnswer
  extends MessageMicro<HwExamAnswer>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField answer = PBField.initString("");
  public final PBStringField questionid = PBField.initString("");
  public final PBInt32Field result = PBField.initInt32(0);
  public final PBUInt32Field score = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "questionid", "answer", "result", "score" }, new Object[] { "", "", localInteger, localInteger }, HwExamAnswer.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.protofile.group_homework.value.HwExamAnswer
 * JD-Core Version:    0.7.0.1
 */