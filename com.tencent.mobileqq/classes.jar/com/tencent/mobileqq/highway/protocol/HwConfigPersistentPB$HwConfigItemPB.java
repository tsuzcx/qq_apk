package com.tencent.mobileqq.highway.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class HwConfigPersistentPB$HwConfigItemPB
  extends MessageMicro<HwConfigItemPB>
{
  public static final int RPT_END_POINT_LIST_FIELD_NUMBER = 2;
  public static final int STRING_KEY_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "string_key", "rpt_end_point_list" }, new Object[] { "", null }, HwConfigItemPB.class);
  public final PBRepeatMessageField<HwConfigPersistentPB.HwEndPointPB> rpt_end_point_list = PBField.initRepeatMessage(HwConfigPersistentPB.HwEndPointPB.class);
  public final PBStringField string_key = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.highway.protocol.HwConfigPersistentPB.HwConfigItemPB
 * JD-Core Version:    0.7.0.1
 */