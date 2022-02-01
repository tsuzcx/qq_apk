package com.tencent.mobileqq.praise;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class praise_sso$TSsoCmd0x1Rsp
  extends MessageMicro<TSsoCmd0x1Rsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "i32_itemId", "str_url" }, new Object[] { Integer.valueOf(0), "" }, TSsoCmd0x1Rsp.class);
  public final PBInt32Field i32_itemId = PBField.initInt32(0);
  public final PBStringField str_url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.praise.praise_sso.TSsoCmd0x1Rsp
 * JD-Core Version:    0.7.0.1
 */