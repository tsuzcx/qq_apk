package tencent.im.oidb.cmd0x6df;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Oidb_0x6df$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uint32_src", "str_country_code", "str_phone", "dev_info" }, new Object[] { Integer.valueOf(0), "", "", null }, ReqBody.class);
  public Oidb_0x6df.DevInfo dev_info = new Oidb_0x6df.DevInfo();
  public final PBStringField str_country_code = PBField.initString("");
  public final PBStringField str_phone = PBField.initString("");
  public final PBUInt32Field uint32_src = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6df.Oidb_0x6df.ReqBody
 * JD-Core Version:    0.7.0.1
 */