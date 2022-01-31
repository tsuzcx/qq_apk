package com.tencent.protofile.homework;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class hw_submit_homework$HwExamAnswer
  extends MessageMicro<HwExamAnswer>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "questionid", "answer", "result", "score" }, new Object[] { "", "", Integer.valueOf(0), Integer.valueOf(0) }, HwExamAnswer.class);
  public final PBStringField answer = PBField.initString("");
  public final PBStringField questionid = PBField.initString("");
  public final PBInt32Field result = PBField.initInt32(0);
  public final PBUInt32Field score = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.protofile.homework.hw_submit_homework.HwExamAnswer
 * JD-Core Version:    0.7.0.1
 */