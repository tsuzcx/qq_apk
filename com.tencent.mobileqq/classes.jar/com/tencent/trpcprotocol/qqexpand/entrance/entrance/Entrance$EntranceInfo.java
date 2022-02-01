package com.tencent.trpcprotocol.qqexpand.entrance.entrance;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Entrance$EntranceInfo
  extends MessageMicro<EntranceInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50 }, new String[] { "id", "title", "subtitle", "icon_url", "backgroud_url", "jump_url" }, new Object[] { Integer.valueOf(0), "", "", "", "", "" }, EntranceInfo.class);
  public final PBStringField backgroud_url = PBField.initString("");
  public final PBStringField icon_url = PBField.initString("");
  public final PBUInt32Field id = PBField.initUInt32(0);
  public final PBStringField jump_url = PBField.initString("");
  public final PBStringField subtitle = PBField.initString("");
  public final PBStringField title = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.qqexpand.entrance.entrance.Entrance.EntranceInfo
 * JD-Core Version:    0.7.0.1
 */