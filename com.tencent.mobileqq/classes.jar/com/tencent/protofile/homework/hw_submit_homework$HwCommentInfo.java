package com.tencent.protofile.homework;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class hw_submit_homework$HwCommentInfo
  extends MessageMicro<HwCommentInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field createts = PBField.initUInt64(0L);
  public final PBStringField id = PBField.initString("");
  public final PBUInt64Field modifyts = PBField.initUInt64(0L);
  public final PBBytesField text = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 32, 40, 48 }, new String[] { "id", "text", "createts", "modifyts", "uin" }, new Object[] { "", localByteStringMicro, Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, HwCommentInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.protofile.homework.hw_submit_homework.HwCommentInfo
 * JD-Core Version:    0.7.0.1
 */