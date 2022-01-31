package com.tencent.pb.getbusiinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class BusinessInfoCheckUpdate$LbsSubnation
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66, 74, 82 }, new String[] { "name", "code", "nation", "province", "city", "district", "town", "village", "street", "street_no" }, new Object[] { "", "", "", "", "", "", "", "", "", "" }, LbsSubnation.class);
  public final PBStringField city = PBField.initString("");
  public final PBStringField code = PBField.initString("");
  public final PBStringField district = PBField.initString("");
  public final PBStringField name = PBField.initString("");
  public final PBStringField nation = PBField.initString("");
  public final PBStringField province = PBField.initString("");
  public final PBStringField street = PBField.initString("");
  public final PBStringField street_no = PBField.initString("");
  public final PBStringField town = PBField.initString("");
  public final PBStringField village = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.LbsSubnation
 * JD-Core Version:    0.7.0.1
 */