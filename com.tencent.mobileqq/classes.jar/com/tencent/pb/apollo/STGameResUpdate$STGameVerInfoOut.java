package com.tencent.pb.apollo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class STGameResUpdate$STGameVerInfoOut
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 48, 56, 64 }, new String[] { "gameId", "isPatch", "patchUrl", "zipUrl", "zipMd5", "svrResVer", "packageSize", "isPreload" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", "", Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, STGameVerInfoOut.class);
  public final PBUInt32Field gameId = PBField.initUInt32(0);
  public final PBUInt32Field isPatch = PBField.initUInt32(0);
  public final PBUInt32Field isPreload = PBField.initUInt32(0);
  public final PBUInt64Field packageSize = PBField.initUInt64(0L);
  public final PBStringField patchUrl = PBField.initString("");
  public final PBUInt32Field svrResVer = PBField.initUInt32(0);
  public final PBStringField zipMd5 = PBField.initString("");
  public final PBStringField zipUrl = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.apollo.STGameResUpdate.STGameVerInfoOut
 * JD-Core Version:    0.7.0.1
 */