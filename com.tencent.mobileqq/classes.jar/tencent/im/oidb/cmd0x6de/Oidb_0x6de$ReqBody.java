package tencent.im.oidb.cmd0x6de;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Oidb_0x6de$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public Oidb_0x6de.DevInfo dev_info = new Oidb_0x6de.DevInfo();
  public final PBStringField str_country_code = PBField.initString("");
  public final PBStringField str_phone = PBField.initString("");
  public final PBUInt32Field uint32_phone_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_src = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42 }, new String[] { "uint32_src", "uint32_phone_type", "str_country_code", "str_phone", "dev_info" }, new Object[] { localInteger, localInteger, "", "", null }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6de.Oidb_0x6de.ReqBody
 * JD-Core Version:    0.7.0.1
 */