package com.tencent.mobileqq.vas.adv.common.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class AdvPush$AdvPushReq
  extends MessageMicro<AdvPushReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "user_info", "busi_type_args_list", "gdt_args" }, new Object[] { null, null, "" }, AdvPushReq.class);
  public final PBRepeatMessageField<AdvPush.BusiTypeArgs> busi_type_args_list = PBField.initRepeatMessage(AdvPush.BusiTypeArgs.class);
  public final PBStringField gdt_args = PBField.initString("");
  public AdvPush.UserInfo user_info = new AdvPush.UserInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.common.pb.AdvPush.AdvPushReq
 * JD-Core Version:    0.7.0.1
 */