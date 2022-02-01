package com.tencent.protofile.homework;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class hw_submit_homework$ReqSubmitHomework
  extends MessageMicro<ReqSubmitHomework>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50 }, new String[] { "hw_id", "gid", "status", "comment_info", "examination", "openId" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), null, null, "" }, ReqSubmitHomework.class);
  public hw_submit_homework.HwCommentInfo comment_info = new hw_submit_homework.HwCommentInfo();
  public hw_submit_homework.HwExamination examination = new hw_submit_homework.HwExamination();
  public final PBUInt64Field gid = PBField.initUInt64(0L);
  public final PBUInt64Field hw_id = PBField.initUInt64(0L);
  public final PBStringField openId = PBField.initString("");
  public final PBInt32Field status = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.protofile.homework.hw_submit_homework.ReqSubmitHomework
 * JD-Core Version:    0.7.0.1
 */