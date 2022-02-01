package com.tencent.trpcprotocol.qqexpand.entrance.entrance;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class Entrance$EntranceManager
  extends MessageMicro<EntranceManager>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "can_show", "entrances" }, new Object[] { Boolean.valueOf(false), null }, EntranceManager.class);
  public final PBBoolField can_show = PBField.initBool(false);
  public final PBRepeatMessageField<Entrance.EntranceInfo> entrances = PBField.initRepeatMessage(Entrance.EntranceInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.qqexpand.entrance.entrance.Entrance.EntranceManager
 * JD-Core Version:    0.7.0.1
 */