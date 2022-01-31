package com.tencent.pb.teamwork;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class TimDocSSOMsg$SetPadRightInfoReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_localpadid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_pad_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public TimDocSSOMsg.LoginInfo msg_login_info = new TimDocSSOMsg.LoginInfo();
  public final PBRepeatMessageField rpt_msg_uin_right_info = PBField.initRepeatMessage(TimDocSSOMsg.UinRightInfo.class);
  public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_domainid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pad_right = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 48, 58 }, new String[] { "uint32_appid", "bytes_pad_url", "msg_login_info", "uint32_pad_right", "rpt_msg_uin_right_info", "uint32_domainid", "bytes_localpadid" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, null, Integer.valueOf(0), null, Integer.valueOf(0), localByteStringMicro2 }, SetPadRightInfoReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.teamwork.TimDocSSOMsg.SetPadRightInfoReqBody
 * JD-Core Version:    0.7.0.1
 */