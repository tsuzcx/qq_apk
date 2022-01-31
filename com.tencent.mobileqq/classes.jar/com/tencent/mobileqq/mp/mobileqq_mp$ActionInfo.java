package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class mobileqq_mp$ActionInfo
  extends MessageMicro<ActionInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "actionData", "i_actionData", "a_actionData", "appid" }, new Object[] { "", "", "", Integer.valueOf(0) }, ActionInfo.class);
  public final PBStringField a_actionData = PBField.initString("");
  public final PBStringField actionData = PBField.initString("");
  public final PBUInt32Field appid = PBField.initUInt32(0);
  public final PBStringField i_actionData = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.mp.mobileqq_mp.ActionInfo
 * JD-Core Version:    0.7.0.1
 */