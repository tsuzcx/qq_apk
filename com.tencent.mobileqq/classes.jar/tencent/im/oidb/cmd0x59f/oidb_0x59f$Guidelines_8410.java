package tencent.im.oidb.cmd0x59f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x59f$Guidelines_8410
  extends MessageMicro<Guidelines_8410>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField str_jump_url = PBField.initString("");
  public final PBStringField str_res_url = PBField.initString("");
  public final PBStringField str_res_url_night = PBField.initString("");
  public final PBStringField str_res_url_night_pad = PBField.initString("");
  public final PBStringField str_res_url_pad = PBField.initString("");
  public final PBUInt32Field uint32_banner_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_banner_status = PBField.initUInt32(0);
  public final PBUInt32Field uint32_jump_type = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 58, 64 }, new String[] { "uint32_banner_id", "uint32_banner_status", "str_res_url", "str_res_url_night", "str_res_url_pad", "str_res_url_night_pad", "str_jump_url", "uint32_jump_type" }, new Object[] { localInteger, localInteger, "", "", "", "", "", localInteger }, Guidelines_8410.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x59f.oidb_0x59f.Guidelines_8410
 * JD-Core Version:    0.7.0.1
 */