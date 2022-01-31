package com.trunk.Qworkflow;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class Qworkflow$TodoChangeNotification
  extends MessageMicro
{
  public static final int ADD_NEW = 1;
  public static final int CONFIRM_READ = 4;
  public static final int DELETE = 2;
  public static final int DELETE_ALL = 3;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "enum_change_type", "rpt_change_item_list" }, new Object[] { Integer.valueOf(1), null }, TodoChangeNotification.class);
  public final PBEnumField enum_change_type = PBField.initEnum(1);
  public final PBRepeatMessageField rpt_change_item_list = PBField.initRepeatMessage(Qworkflow.TodoChangeItem.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.trunk.Qworkflow.Qworkflow.TodoChangeNotification
 * JD-Core Version:    0.7.0.1
 */