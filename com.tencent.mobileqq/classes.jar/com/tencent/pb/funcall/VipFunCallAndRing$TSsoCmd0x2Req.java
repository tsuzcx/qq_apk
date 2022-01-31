package com.tencent.pb.funcall;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class VipFunCallAndRing$TSsoCmd0x2Req
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "u64_friend_uin", "str_friend_phone" }, new Object[] { Long.valueOf(0L), "" }, TSsoCmd0x2Req.class);
  public final PBStringField str_friend_phone = PBField.initString("");
  public final PBUInt64Field u64_friend_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.funcall.VipFunCallAndRing.TSsoCmd0x2Req
 * JD-Core Version:    0.7.0.1
 */