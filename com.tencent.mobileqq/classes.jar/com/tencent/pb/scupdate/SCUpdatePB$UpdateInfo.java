package com.tencent.pb.scupdate;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SCUpdatePB$UpdateInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field bid = PBField.initUInt32(0);
  public final PBInt32Field code = PBField.initInt32(0);
  public final PBUInt32Field compress_mode = PBField.initUInt32(0);
  public final PBUInt32Field delta_mode = PBField.initUInt32(0);
  public final PBStringField dst_version = PBField.initString("");
  public final PBBytesField filecontent = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt64Field filesize = PBField.initInt64(0L);
  public final PBStringField scid = PBField.initString("");
  public final PBStringField src_version = PBField.initString("");
  public final PBUInt32Field storage_mode = PBField.initUInt32(0);
  public final PBStringField url = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 48, 56, 66, 72, 82, 88 }, new String[] { "bid", "scid", "dst_version", "src_version", "delta_mode", "storage_mode", "compress_mode", "url", "filesize", "filecontent", "code" }, new Object[] { Integer.valueOf(0), "", "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Long.valueOf(0L), localByteStringMicro, Integer.valueOf(0) }, UpdateInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.scupdate.SCUpdatePB.UpdateInfo
 * JD-Core Version:    0.7.0.1
 */