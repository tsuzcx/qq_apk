package com.tencent.pb.teamwork;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class TimDocSSOMsg$GetSharedPadListReqBody
  extends MessageMicro<GetSharedPadListReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public TimDocSSOMsg.LoginInfo msg_login_info = new TimDocSSOMsg.LoginInfo();
  public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_needmore = PBField.initUInt32(0);
  public final PBUInt32Field uint32_offset = PBField.initUInt32(0);
  public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50 }, new String[] { "uint32_appid", "uint32_timestamp", "uint32_offset", "uint32_count", "uint32_needmore", "msg_login_info" }, new Object[] { localInteger, localInteger, localInteger, localInteger, localInteger, null }, GetSharedPadListReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.teamwork.TimDocSSOMsg.GetSharedPadListReqBody
 * JD-Core Version:    0.7.0.1
 */