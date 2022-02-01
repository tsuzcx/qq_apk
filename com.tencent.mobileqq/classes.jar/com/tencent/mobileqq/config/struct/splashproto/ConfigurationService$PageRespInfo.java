package com.tencent.mobileqq.config.struct.splashproto;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ConfigurationService$PageRespInfo
  extends MessageMicro<PageRespInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field compress = PBField.initUInt32(0);
  public final PBBytesField cookies = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField md5 = PBField.initString("");
  public final PBInt32Field next_offset = PBField.initInt32(-1);
  public final PBUInt32Field page_size = PBField.initUInt32(0);
  public final PBUInt32Field report = PBField.initUInt32(0);
  public final PBUInt32Field task_id = PBField.initUInt32(0);
  public final PBUInt32Field total_size = PBField.initUInt32(0);
  public final PBUInt32Field version = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50, 56, 64, 74 }, new String[] { "task_id", "version", "compress", "total_size", "page_size", "md5", "report", "next_offset", "cookies" }, new Object[] { localInteger, localInteger, localInteger, localInteger, localInteger, "", localInteger, Integer.valueOf(-1), localByteStringMicro }, PageRespInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.PageRespInfo
 * JD-Core Version:    0.7.0.1
 */