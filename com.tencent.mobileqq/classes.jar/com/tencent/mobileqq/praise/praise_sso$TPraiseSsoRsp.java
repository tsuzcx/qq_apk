package com.tencent.mobileqq.praise;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class praise_sso$TPraiseSsoRsp
  extends MessageMicro<TPraiseSsoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "i32_ret", "st_cmd0x1_rsp" }, new Object[] { Integer.valueOf(0), null }, TPraiseSsoRsp.class);
  public final PBInt32Field i32_ret = PBField.initInt32(0);
  public praise_sso.TSsoCmd0x1Rsp st_cmd0x1_rsp = new praise_sso.TSsoCmd0x1Rsp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.praise.praise_sso.TPraiseSsoRsp
 * JD-Core Version:    0.7.0.1
 */