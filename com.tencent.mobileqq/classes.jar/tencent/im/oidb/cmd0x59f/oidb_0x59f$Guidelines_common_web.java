package tencent.im.oidb.cmd0x59f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x59f$Guidelines_common_web
  extends MessageMicro<Guidelines_common_web>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 48, 56, 64 }, new String[] { "str_web_url", "uint32_groups_recomm_flag", "uint32_set_gender", "uint32_set_birthday", "uint32_set_head", "uint32_set_school", "uint32_set_region", "uint32_set_company" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, Guidelines_common_web.class);
  public final PBStringField str_web_url = PBField.initString("");
  public final PBUInt32Field uint32_groups_recomm_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_set_birthday = PBField.initUInt32(0);
  public final PBUInt32Field uint32_set_company = PBField.initUInt32(0);
  public final PBUInt32Field uint32_set_gender = PBField.initUInt32(0);
  public final PBUInt32Field uint32_set_head = PBField.initUInt32(0);
  public final PBUInt32Field uint32_set_region = PBField.initUInt32(0);
  public final PBUInt32Field uint32_set_school = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x59f.oidb_0x59f.Guidelines_common_web
 * JD-Core Version:    0.7.0.1
 */