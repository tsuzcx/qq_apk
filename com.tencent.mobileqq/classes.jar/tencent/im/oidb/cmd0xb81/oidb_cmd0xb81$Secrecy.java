package tencent.im.oidb.cmd0xb81;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xb81$Secrecy
  extends MessageMicro<Secrecy>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_enable_age = PBField.initUInt32(0);
  public final PBUInt32Field uint32_enable_constellation = PBField.initUInt32(0);
  public final PBUInt32Field uint32_enable_edu = PBField.initUInt32(0);
  public final PBUInt32Field uint32_enable_gender = PBField.initUInt32(0);
  public final PBUInt32Field uint32_enable_region = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "uint32_enable_age", "uint32_enable_region", "uint32_enable_constellation", "uint32_enable_edu", "uint32_enable_gender" }, new Object[] { localInteger, localInteger, localInteger, localInteger, localInteger }, Secrecy.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.Secrecy
 * JD-Core Version:    0.7.0.1
 */