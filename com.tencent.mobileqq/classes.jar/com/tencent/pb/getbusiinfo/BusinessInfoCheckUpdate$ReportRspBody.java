package com.tencent.pb.getbusiinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class BusinessInfoCheckUpdate$ReportRspBody
  extends MessageMicro<ReportRspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42 }, new String[] { "code", "errmsg", "uin", "appid", "buffer" }, new Object[] { Integer.valueOf(0), "", Long.valueOf(0L), Integer.valueOf(0), "" }, ReportRspBody.class);
  public final PBUInt32Field appid = PBField.initUInt32(0);
  public final PBStringField buffer = PBField.initString("");
  public final PBInt32Field code = PBField.initInt32(0);
  public final PBStringField errmsg = PBField.initString("");
  public final PBUInt64Field uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.ReportRspBody
 * JD-Core Version:    0.7.0.1
 */