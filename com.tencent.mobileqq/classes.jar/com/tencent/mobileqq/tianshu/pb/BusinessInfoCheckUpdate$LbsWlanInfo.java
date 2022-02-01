package com.tencent.mobileqq.tianshu.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class BusinessInfoCheckUpdate$LbsWlanInfo
  extends MessageMicro<LbsWlanInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "mac", "ssid", "rssi" }, new Object[] { "", "", Integer.valueOf(0) }, LbsWlanInfo.class);
  public final PBStringField mac = PBField.initString("");
  public final PBInt32Field rssi = PBField.initInt32(0);
  public final PBStringField ssid = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.LbsWlanInfo
 * JD-Core Version:    0.7.0.1
 */