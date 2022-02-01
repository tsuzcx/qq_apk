package com.tencent.pb.now;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ilive_feeds_read$ReadMediaDetailRsp
  extends MessageMicro<ReadMediaDetailRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field err_code = PBField.initUInt32(0);
  public final PBBytesField err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field is_end = PBField.initUInt32(0);
  public final PBRepeatMessageField<FeedsProtocol.MediaInfo> media_list = PBField.initRepeatMessage(FeedsProtocol.MediaInfo.class);
  public final PBUInt32Field total = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40 }, new String[] { "media_list", "err_code", "err_msg", "is_end", "total" }, new Object[] { null, localInteger, localByteStringMicro, localInteger, localInteger }, ReadMediaDetailRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.now.ilive_feeds_read.ReadMediaDetailRsp
 * JD-Core Version:    0.7.0.1
 */