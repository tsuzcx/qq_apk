package com.tencent.protofile.group_homework;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class value$HwFeedback$FbContent
  extends MessageMicro<FbContent>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "main", "comment", "examination" }, new Object[] { null, null, null }, FbContent.class);
  public final PBRepeatMessageField<value.HwCommentInfo> comment = PBField.initRepeatMessage(value.HwCommentInfo.class);
  public value.HwExamination examination = new value.HwExamination();
  public final PBRepeatMessageField<value.HwCommentInfo> main = PBField.initRepeatMessage(value.HwCommentInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.protofile.group_homework.value.HwFeedback.FbContent
 * JD-Core Version:    0.7.0.1
 */