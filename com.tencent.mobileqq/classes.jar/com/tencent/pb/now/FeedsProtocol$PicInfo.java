package com.tencent.pb.now;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FeedsProtocol$PicInfo
  extends MessageMicro<PicInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field hight = PBField.initUInt32(0);
  public final PBBytesField url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field width = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "url", "hight", "width" }, new Object[] { localByteStringMicro, localInteger, localInteger }, PicInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.now.FeedsProtocol.PicInfo
 * JD-Core Version:    0.7.0.1
 */