package com.tencent.pb.profilecard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class VaProfileGate$QQValueInfoItem
  extends MessageMicro<QQValueInfoItem>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field level = PBField.initInt32(0);
  public final PBStringField material_id = PBField.initString("");
  public final PBInt32Field on_off = PBField.initInt32(0);
  public final PBRepeatMessageField<VaProfileGate.QQValueExtInfo> qqvalue_ext_info = PBField.initRepeatMessage(VaProfileGate.QQValueExtInfo.class);
  public final PBInt32Field score = PBField.initInt32(0);
  public final PBInt32Field trend = PBField.initInt32(0);
  public final PBStringField url = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 42, 48, 58, 66 }, new String[] { "score", "level", "trend", "url", "on_off", "material_id", "qqvalue_ext_info" }, new Object[] { localInteger, localInteger, localInteger, "", localInteger, "", null }, QQValueInfoItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.profilecard.VaProfileGate.QQValueInfoItem
 * JD-Core Version:    0.7.0.1
 */