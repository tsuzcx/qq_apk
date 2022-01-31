package com.tencent.pb.mqqcomic;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class MqqComicHeadPb$ComicRspHead
  extends MessageMicro<ComicRspHead>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField cmd = PBField.initString("");
  public final PBBytesField debugMsg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField etag = PBField.initString("");
  public final PBInt32Field maxCacheSec = PBField.initInt32(0);
  public final PBInt32Field reportRate = PBField.initInt32(0);
  public final PBInt32Field retCode = PBField.initInt32(0);
  public final PBBytesField retMsg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt64Field uin = PBField.initInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 50, 56, 64 }, new String[] { "retCode", "retMsg", "debugMsg", "maxCacheSec", "etag", "cmd", "uin", "reportRate" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), "", "", Long.valueOf(0L), Integer.valueOf(0) }, ComicRspHead.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pb.mqqcomic.MqqComicHeadPb.ComicRspHead
 * JD-Core Version:    0.7.0.1
 */