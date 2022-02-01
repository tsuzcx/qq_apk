package com.tencent.mobileqq.vas.adv.common.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class AdvPush$UserInfo
  extends MessageMicro<UserInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42 }, new String[] { "uin", "app", "os", "version", "qua" }, new Object[] { Long.valueOf(0L), "", "", "", "" }, UserInfo.class);
  public final PBStringField app = PBField.initString("");
  public final PBStringField os = PBField.initString("");
  public final PBStringField qua = PBField.initString("");
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  public final PBStringField version = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.common.pb.AdvPush.UserInfo
 * JD-Core Version:    0.7.0.1
 */