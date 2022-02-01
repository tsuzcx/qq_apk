package com.tencent.pb.qlsBusiness;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class sso_svrr$QLSSsoBSvrHeader
  extends MessageMicro<QLSSsoBSvrHeader>
{
  public static final int SUBCMD_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "subcmd" }, new Object[] { Integer.valueOf(0) }, QLSSsoBSvrHeader.class);
  public final PBUInt32Field subcmd = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.qlsBusiness.sso_svrr.QLSSsoBSvrHeader
 * JD-Core Version:    0.7.0.1
 */