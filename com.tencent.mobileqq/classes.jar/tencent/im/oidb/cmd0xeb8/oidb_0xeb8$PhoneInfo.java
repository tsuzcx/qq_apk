package tencent.im.oidb.cmd0xeb8;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xeb8$PhoneInfo
  extends MessageMicro<PhoneInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_vas_phone = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField str_country_code = PBField.initString("");
  public final PBStringField str_phone = PBField.initString("");
  public final PBUInt32Field uint32_phone_status = PBField.initUInt32(0);
  public final PBUInt32Field uint32_phone_type = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42 }, new String[] { "uint32_phone_type", "str_country_code", "str_phone", "uint32_phone_status", "bytes_vas_phone" }, new Object[] { Integer.valueOf(0), "", "", Integer.valueOf(0), localByteStringMicro }, PhoneInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xeb8.oidb_0xeb8.PhoneInfo
 * JD-Core Version:    0.7.0.1
 */