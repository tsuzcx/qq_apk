package tencent.im.oidb.cmd0x59f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x59f$BindContactInfo
  extends MessageMicro<BindContactInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_inactive = PBField.initBool(false);
  public final PBStringField str_mobile = PBField.initString("");
  public final PBStringField str_nation_code = PBField.initString("");
  public final PBUInt32Field uint32_bind_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_bind_type = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40 }, new String[] { "str_mobile", "str_nation_code", "uint32_bind_time", "bool_inactive", "uint32_bind_type" }, new Object[] { "", "", localInteger, Boolean.valueOf(false), localInteger }, BindContactInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x59f.oidb_0x59f.BindContactInfo
 * JD-Core Version:    0.7.0.1
 */