package tencent.im.oidb.cmd0x8dd;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x8dd$Detail
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42, 50, 58, 66, 74, 82 }, new String[] { "str_nation", "str_name", "uint32_code", "str_province", "str_city", "str_district", "str_town", "str_village", "str_street", "str_street_no" }, new Object[] { "", "", Integer.valueOf(0), "", "", "", "", "", "", "" }, Detail.class);
  public final PBStringField str_city = PBField.initString("");
  public final PBStringField str_district = PBField.initString("");
  public final PBStringField str_name = PBField.initString("");
  public final PBStringField str_nation = PBField.initString("");
  public final PBStringField str_province = PBField.initString("");
  public final PBStringField str_street = PBField.initString("");
  public final PBStringField str_street_no = PBField.initString("");
  public final PBStringField str_town = PBField.initString("");
  public final PBStringField str_village = PBField.initString("");
  public final PBUInt32Field uint32_code = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8dd.oidb_0x8dd.Detail
 * JD-Core Version:    0.7.0.1
 */