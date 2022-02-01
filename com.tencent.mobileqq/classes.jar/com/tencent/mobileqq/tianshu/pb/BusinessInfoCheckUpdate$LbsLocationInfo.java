package com.tencent.mobileqq.tianshu.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class BusinessInfoCheckUpdate$LbsLocationInfo
  extends MessageMicro<LbsLocationInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField additional = PBField.initString("");
  public final PBInt32Field coordinate = PBField.initInt32(0);
  public final PBInt32Field latitude = PBField.initInt32(0);
  public final PBInt32Field longitude = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "coordinate", "latitude", "longitude", "additional" }, new Object[] { localInteger, localInteger, localInteger, "" }, LbsLocationInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.LbsLocationInfo
 * JD-Core Version:    0.7.0.1
 */