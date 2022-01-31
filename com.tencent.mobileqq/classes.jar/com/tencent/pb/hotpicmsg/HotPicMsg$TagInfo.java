package com.tencent.pb.hotpicmsg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class HotPicMsg$TagInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_tag_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_tag_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_tag_type = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint32_tag_id", "bytes_tag_name", "uint32_tag_type" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, TagInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.hotpicmsg.HotPicMsg.TagInfo
 * JD-Core Version:    0.7.0.1
 */