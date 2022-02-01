package com.tencent.pb.clubcontent;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ClubContentUpdateInfoPb$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field int_protocolver = PBField.initInt32(0);
  public final PBRepeatMessageField<ClubContentUpdateInfoPb.ReqAppInfo> rpt_msg_reqappinfo = PBField.initRepeatMessage(ClubContentUpdateInfoPb.ReqAppInfo.class);
  public final PBStringField str_clientver = PBField.initString("");
  public final PBUInt32Field uint_clientplatid = PBField.initUInt32(0);
  public final PBUInt64Field uint_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42 }, new String[] { "int_protocolver", "uint_clientplatid", "str_clientver", "uint_uin", "rpt_msg_reqappinfo" }, new Object[] { localInteger, localInteger, "", Long.valueOf(0L), null }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.ReqBody
 * JD-Core Version:    0.7.0.1
 */