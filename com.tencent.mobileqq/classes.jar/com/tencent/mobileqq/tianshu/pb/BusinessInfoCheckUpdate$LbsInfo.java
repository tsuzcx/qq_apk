package com.tencent.mobileqq.tianshu.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class BusinessInfoCheckUpdate$LbsInfo
  extends MessageMicro<LbsInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "location", "cells", "wlan", "detail_info" }, new Object[] { null, null, null, null }, LbsInfo.class);
  public final PBRepeatMessageField<BusinessInfoCheckUpdate.LbsCellInfo> cells = PBField.initRepeatMessage(BusinessInfoCheckUpdate.LbsCellInfo.class);
  public BusinessInfoCheckUpdate.LbsDetailInfo detail_info = new BusinessInfoCheckUpdate.LbsDetailInfo();
  public BusinessInfoCheckUpdate.LbsLocationInfo location = new BusinessInfoCheckUpdate.LbsLocationInfo();
  public final PBRepeatMessageField<BusinessInfoCheckUpdate.LbsWlanInfo> wlan = PBField.initRepeatMessage(BusinessInfoCheckUpdate.LbsWlanInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.LbsInfo
 * JD-Core Version:    0.7.0.1
 */