package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class mobileqq_mp$CRMSendLBSInfoRequest
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 17, 25, 34 }, new String[] { "uin", "latitude", "longitude", "cityinfo" }, new Object[] { Long.valueOf(0L), Double.valueOf(0.0D), Double.valueOf(0.0D), "" }, CRMSendLBSInfoRequest.class);
  public final PBStringField cityinfo = PBField.initString("");
  public final PBDoubleField latitude = PBField.initDouble(0.0D);
  public final PBDoubleField longitude = PBField.initDouble(0.0D);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.mp.mobileqq_mp.CRMSendLBSInfoRequest
 * JD-Core Version:    0.7.0.1
 */