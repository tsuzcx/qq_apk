package com.tencent.pb.getbusiinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class BusinessInfoCheckUpdate$LbsDetailInfo
  extends MessageMicro<LbsDetailInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "subnation", "poilist" }, new Object[] { null, null }, LbsDetailInfo.class);
  public final PBRepeatMessageField<BusinessInfoCheckUpdate.LbsPoiInfo> poilist = PBField.initRepeatMessage(BusinessInfoCheckUpdate.LbsPoiInfo.class);
  public BusinessInfoCheckUpdate.LbsSubnation subnation = new BusinessInfoCheckUpdate.LbsSubnation();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.LbsDetailInfo
 * JD-Core Version:    0.7.0.1
 */