package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class mobileqq_mp$WebviewWhiteListRequset
  extends MessageMicro<WebviewWhiteListRequset>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "version", "qqversion", "gziped", "implat" }, new Object[] { "", "", Boolean.valueOf(false), Integer.valueOf(0) }, WebviewWhiteListRequset.class);
  public final PBBoolField gziped = PBField.initBool(false);
  public final PBUInt32Field implat = PBField.initUInt32(0);
  public final PBStringField qqversion = PBField.initString("");
  public final PBStringField version = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.mp.mobileqq_mp.WebviewWhiteListRequset
 * JD-Core Version:    0.7.0.1
 */