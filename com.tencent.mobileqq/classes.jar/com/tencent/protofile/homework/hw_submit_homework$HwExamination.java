package com.tencent.protofile.homework;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class hw_submit_homework$HwExamination
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 82, 90, 402 }, new String[] { "total_count", "correct_count", "error_count", "undone_count", "total_score", "elapsed_time", "avg_elapsed_time", "difficult", "answer_status", "answer_analyse", "difficult_desc", "answer" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", null }, HwExamination.class);
  public final PBRepeatMessageField answer = PBField.initRepeatMessage(hw_submit_homework.HwExamAnswer.class);
  public final PBStringField answer_analyse = PBField.initString("");
  public final PBUInt32Field answer_status = PBField.initUInt32(0);
  public final PBUInt32Field avg_elapsed_time = PBField.initUInt32(0);
  public final PBUInt32Field correct_count = PBField.initUInt32(0);
  public final PBUInt32Field difficult = PBField.initUInt32(0);
  public final PBStringField difficult_desc = PBField.initString("");
  public final PBUInt32Field elapsed_time = PBField.initUInt32(0);
  public final PBUInt32Field error_count = PBField.initUInt32(0);
  public final PBUInt32Field total_count = PBField.initUInt32(0);
  public final PBUInt32Field total_score = PBField.initUInt32(0);
  public final PBUInt32Field undone_count = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.protofile.homework.hw_submit_homework.HwExamination
 * JD-Core Version:    0.7.0.1
 */