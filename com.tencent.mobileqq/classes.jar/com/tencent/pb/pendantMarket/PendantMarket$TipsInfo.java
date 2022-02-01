package com.tencent.pb.pendantMarket;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class PendantMarket$TipsInfo
  extends MessageMicro<TipsInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 58, 66, 72, 82 }, new String[] { "valid", "ret", "type", "title_wording", "wording", "right_btn_wording", "left_btn_wording", "vip_type", "vip_month", "url" }, new Object[] { Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0), "", "", "", "", "", Integer.valueOf(0), "" }, TipsInfo.class);
  public final PBStringField left_btn_wording = PBField.initString("");
  public final PBInt32Field ret = PBField.initInt32(0);
  public final PBStringField right_btn_wording = PBField.initString("");
  public final PBStringField title_wording = PBField.initString("");
  public final PBUInt32Field type = PBField.initUInt32(0);
  public final PBStringField url = PBField.initString("");
  public final PBBoolField valid = PBField.initBool(false);
  public final PBUInt32Field vip_month = PBField.initUInt32(0);
  public final PBStringField vip_type = PBField.initString("");
  public final PBStringField wording = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.pendantMarket.PendantMarket.TipsInfo
 * JD-Core Version:    0.7.0.1
 */