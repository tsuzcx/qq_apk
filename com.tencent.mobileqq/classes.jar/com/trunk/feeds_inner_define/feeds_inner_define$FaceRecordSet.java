package com.trunk.feeds_inner_define;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class feeds_inner_define$FaceRecordSet
  extends MessageMicro<FaceRecordSet>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_face_records" }, new Object[] { null }, FaceRecordSet.class);
  public final PBRepeatMessageField<feeds_inner_define.FaceRecordSet.FaceRecord> rpt_face_records = PBField.initRepeatMessage(feeds_inner_define.FaceRecordSet.FaceRecord.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.trunk.feeds_inner_define.feeds_inner_define.FaceRecordSet
 * JD-Core Version:    0.7.0.1
 */