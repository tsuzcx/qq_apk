package com.trunk.feeds_inner_define;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class feeds_inner_define$FaceRecordSet$FaceRecord
  extends MessageMicro<FaceRecord>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_author_uin", "int32_face_type" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, FaceRecord.class);
  public final PBInt32Field int32_face_type = PBField.initInt32(0);
  public final PBUInt64Field uint64_author_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.trunk.feeds_inner_define.feeds_inner_define.FaceRecordSet.FaceRecord
 * JD-Core Version:    0.7.0.1
 */