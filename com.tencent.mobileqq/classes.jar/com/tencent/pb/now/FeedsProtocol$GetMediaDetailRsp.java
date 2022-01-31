package com.tencent.pb.now;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FeedsProtocol$GetMediaDetailRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field err_code = PBField.initUInt32(0);
  public final PBBytesField err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field is_end = PBField.initUInt32(0);
  public final PBRepeatMessageField media_list = PBField.initRepeatMessage(FeedsProtocol.MediaInfo.class);
  public final PBUInt32Field total = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40 }, new String[] { "media_list", "err_code", "err_msg", "is_end", "total" }, new Object[] { null, Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, GetMediaDetailRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.now.FeedsProtocol.GetMediaDetailRsp
 * JD-Core Version:    0.7.0.1
 */