package tencent.im.oidb.cmd0x8dd;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_0x8dd$LocationInfo
  extends MessageMicro<LocationInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50 }, new String[] { "str_province", "str_city", "str_district", "str_town", "str_road", "str_premises" }, new Object[] { "", "", "", "", "", "" }, LocationInfo.class);
  public final PBStringField str_city = PBField.initString("");
  public final PBStringField str_district = PBField.initString("");
  public final PBStringField str_premises = PBField.initString("");
  public final PBStringField str_province = PBField.initString("");
  public final PBStringField str_road = PBField.initString("");
  public final PBStringField str_town = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8dd.oidb_0x8dd.LocationInfo
 * JD-Core Version:    0.7.0.1
 */