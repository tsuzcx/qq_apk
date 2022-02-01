package com.tencent.protofile.cmd67;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd67$UserInfo
  extends MessageMicro<UserInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 37 }, new String[] { "uint64_uin", "str_matched_contacts", "uint32_chat_type", "float_weight" }, new Object[] { Long.valueOf(0L), "", Integer.valueOf(0), Float.valueOf(0.0F) }, UserInfo.class);
  public final PBFloatField float_weight = PBField.initFloat(0.0F);
  public final PBStringField str_matched_contacts = PBField.initString("");
  public final PBUInt32Field uint32_chat_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.protofile.cmd67.cmd67.UserInfo
 * JD-Core Version:    0.7.0.1
 */