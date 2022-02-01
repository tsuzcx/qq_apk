package com.tencent.mobileqq.tianshu.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class BusinessInfoCheckUpdate$LbsSubnation
  extends MessageMicro<LbsSubnation>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 114, 122, 130 }, new String[] { "name", "code", "nation", "province", "city", "district", "town", "village", "street", "street_no", "ad_area_level_1", "ad_area_level_2", "ad_area_level_3", "locality", "sublocality", "colloquial_area" }, new Object[] { "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "" }, LbsSubnation.class);
  public final PBStringField ad_area_level_1 = PBField.initString("");
  public final PBStringField ad_area_level_2 = PBField.initString("");
  public final PBStringField ad_area_level_3 = PBField.initString("");
  public final PBStringField city = PBField.initString("");
  public final PBStringField code = PBField.initString("");
  public final PBStringField colloquial_area = PBField.initString("");
  public final PBStringField district = PBField.initString("");
  public final PBStringField locality = PBField.initString("");
  public final PBStringField name = PBField.initString("");
  public final PBStringField nation = PBField.initString("");
  public final PBStringField province = PBField.initString("");
  public final PBStringField street = PBField.initString("");
  public final PBStringField street_no = PBField.initString("");
  public final PBStringField sublocality = PBField.initString("");
  public final PBStringField town = PBField.initString("");
  public final PBStringField village = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.LbsSubnation
 * JD-Core Version:    0.7.0.1
 */