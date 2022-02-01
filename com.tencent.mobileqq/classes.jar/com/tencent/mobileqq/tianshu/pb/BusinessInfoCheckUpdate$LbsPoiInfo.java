package com.tencent.mobileqq.tianshu.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class BusinessInfoCheckUpdate$LbsPoiInfo
  extends MessageMicro<LbsPoiInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField addr = PBField.initString("");
  public final PBStringField catalog = PBField.initString("");
  public final PBStringField catalogid = PBField.initString("");
  public final PBStringField city = PBField.initString("");
  public final PBStringField cityid = PBField.initString("");
  public final PBStringField dianping_id = PBField.initString("");
  public final PBStringField dist = PBField.initString("");
  public final PBStringField hotvalue = PBField.initString("");
  public final PBInt32Field is_business_area = PBField.initInt32(0);
  public final PBStringField latitude = PBField.initString("");
  public final PBStringField longitude = PBField.initString("");
  public final PBStringField name = PBField.initString("");
  public final PBStringField province = PBField.initString("");
  public final PBStringField region = PBField.initString("");
  public final PBInt32Field shopping_mall = PBField.initInt32(0);
  public final PBStringField uid = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 104, 114, 122, 128 }, new String[] { "name", "addr", "catalog", "latitude", "longitude", "dist", "uid", "catalogid", "city", "cityid", "dianping_id", "hotvalue", "is_business_area", "province", "region", "shopping_mall" }, new Object[] { "", "", "", "", "", "", "", "", "", "", "", "", localInteger, "", "", localInteger }, LbsPoiInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.LbsPoiInfo
 * JD-Core Version:    0.7.0.1
 */