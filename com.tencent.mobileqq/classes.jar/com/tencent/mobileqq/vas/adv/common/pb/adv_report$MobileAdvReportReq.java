package com.tencent.mobileqq.vas.adv.common.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;

public final class adv_report$MobileAdvReportReq
  extends MessageMicro<MobileAdvReportReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field action_type = PBField.initInt32(0);
  public final PBInt32Field action_value = PBField.initInt32(0);
  public final PBInt32Field adv_pos = PBField.initInt32(0);
  public qq_ad_get.QQAdGet.DeviceInfo device_info = new qq_ad_get.QQAdGet.DeviceInfo();
  public final PBUInt32Field feed_index = PBField.initUInt32(0);
  public final PBUInt64Field qq = PBField.initUInt64(0L);
  public final PBStringField recomm_cookie = PBField.initString("");
  public adv_report.RewardReportInfo reward_report_info = new adv_report.RewardReportInfo();
  public adv_report.SubscribeInfo subscribe_info = new adv_report.SubscribeInfo();
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 40, 48, 56, 66, 74 }, new String[] { "qq", "device_info", "adv_pos", "recomm_cookie", "action_type", "action_value", "feed_index", "reward_report_info", "subscribe_info" }, new Object[] { Long.valueOf(0L), null, localInteger, "", localInteger, localInteger, localInteger, null, null }, MobileAdvReportReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.common.pb.adv_report.MobileAdvReportReq
 * JD-Core Version:    0.7.0.1
 */