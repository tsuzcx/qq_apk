package com.tencent.mobileqq.troop.homework.arithmetic.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class MathHWNetWorkPB$YoutuPicInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField new_data = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField new_url = PBField.initString("");
  public final PBStringField old_url = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "old_url", "new_url", "new_data" }, new Object[] { "", "", localByteStringMicro }, YoutuPicInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.arithmetic.pb.MathHWNetWorkPB.YoutuPicInfo
 * JD-Core Version:    0.7.0.1
 */