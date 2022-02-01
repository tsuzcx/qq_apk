package com.tencent.mobileqq.praise;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class praise_sso$TPraiseSsoReq
  extends MessageMicro<TPraiseSsoReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field i32_cmd = PBField.initInt32(0);
  public final PBInt32Field i32_implat = PBField.initInt32(0);
  public praise_sso.TSsoCmd0x1Req st_cmd0x1_req = new praise_sso.TSsoCmd0x1Req();
  public final PBStringField str_qq_ver = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "i32_cmd", "i32_implat", "str_qq_ver", "st_cmd0x1_req" }, new Object[] { localInteger, localInteger, "", null }, TPraiseSsoReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.praise.praise_sso.TPraiseSsoReq
 * JD-Core Version:    0.7.0.1
 */