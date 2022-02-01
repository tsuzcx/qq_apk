package com.tencent.mobileqq.config.struct.splashproto;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ConfigurationService$PageReqInfo
  extends MessageMicro<PageReqInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField cookies = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field offset = PBField.initInt32(0);
  public final PBUInt32Field task_id = PBField.initUInt32(0);
  public final PBUInt32Field version = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "task_id", "offset", "version", "cookies" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, PageReqInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.PageReqInfo
 * JD-Core Version:    0.7.0.1
 */