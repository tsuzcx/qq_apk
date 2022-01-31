package com.tencent.pb.scupdate;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class SCUpdatePB$SCPreload
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "plver", "item_list" }, new Object[] { Long.valueOf(0L), null }, SCPreload.class);
  public final PBRepeatMessageField item_list = PBField.initRepeatMessage(SCUpdatePB.ItemVersion.class);
  public final PBInt64Field plver = PBField.initInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.scupdate.SCUpdatePB.SCPreload
 * JD-Core Version:    0.7.0.1
 */