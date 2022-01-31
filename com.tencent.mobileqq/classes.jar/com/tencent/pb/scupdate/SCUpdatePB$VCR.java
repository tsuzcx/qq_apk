package com.tencent.pb.scupdate;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SCUpdatePB$VCR
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42 }, new String[] { "seq", "bid", "scid", "optype", "version" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "", Integer.valueOf(0), "" }, VCR.class);
  public final PBUInt32Field bid = PBField.initUInt32(0);
  public final PBUInt32Field optype = PBField.initUInt32(0);
  public final PBStringField scid = PBField.initString("");
  public final PBInt64Field seq = PBField.initInt64(0L);
  public final PBStringField version = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.scupdate.SCUpdatePB.VCR
 * JD-Core Version:    0.7.0.1
 */