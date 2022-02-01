package com.tencent.protofile.homework;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class hw_submit_homework$RspSubmitHomework
  extends MessageMicro<RspSubmitHomework>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "errinfo", "status" }, new Object[] { null, Integer.valueOf(0) }, RspSubmitHomework.class);
  public hw_submit_homework.ErrorInfo errinfo = new hw_submit_homework.ErrorInfo();
  public final PBInt32Field status = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.protofile.homework.hw_submit_homework.RspSubmitHomework
 * JD-Core Version:    0.7.0.1
 */