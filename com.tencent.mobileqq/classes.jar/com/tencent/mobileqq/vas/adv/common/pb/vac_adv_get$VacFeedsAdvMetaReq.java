package com.tencent.mobileqq.vas.adv.common.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;

public final class vac_adv_get$VacFeedsAdvMetaReq
  extends MessageMicro<VacFeedsAdvMetaReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "device_info" }, new Object[] { null }, VacFeedsAdvMetaReq.class);
  public qq_ad_get.QQAdGet.DeviceInfo device_info = new qq_ad_get.QQAdGet.DeviceInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.common.pb.vac_adv_get.VacFeedsAdvMetaReq
 * JD-Core Version:    0.7.0.1
 */