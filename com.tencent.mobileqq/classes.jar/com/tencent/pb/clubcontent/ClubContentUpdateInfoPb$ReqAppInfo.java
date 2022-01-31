package com.tencent.pb.clubcontent;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ClubContentUpdateInfoPb$ReqAppInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint_appid", "rpt_msg_reqiteminfo" }, new Object[] { Integer.valueOf(0), null }, ReqAppInfo.class);
  public final PBRepeatMessageField rpt_msg_reqiteminfo = PBField.initRepeatMessage(ClubContentUpdateInfoPb.ReqItemInfo.class);
  public final PBUInt32Field uint_appid = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.clubcontent.ClubContentUpdateInfoPb.ReqAppInfo
 * JD-Core Version:    0.7.0.1
 */