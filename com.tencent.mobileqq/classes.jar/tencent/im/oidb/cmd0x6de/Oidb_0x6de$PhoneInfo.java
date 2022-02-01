package tencent.im.oidb.cmd0x6de;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Oidb_0x6de$PhoneInfo
  extends MessageMicro<PhoneInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "uint32_type", "str_country_code", "str_phone", "uint32_bu_status" }, new Object[] { Integer.valueOf(0), "", "", Integer.valueOf(0) }, PhoneInfo.class);
  public final PBStringField str_country_code = PBField.initString("");
  public final PBStringField str_phone = PBField.initString("");
  public final PBUInt32Field uint32_bu_status = PBField.initUInt32(0);
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6de.Oidb_0x6de.PhoneInfo
 * JD-Core Version:    0.7.0.1
 */