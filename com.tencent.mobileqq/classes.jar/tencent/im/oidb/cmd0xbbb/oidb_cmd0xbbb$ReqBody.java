package tencent.im.oidb.cmd0xbbb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xbbb$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_city = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_cmd0xbbb.LocationInfo msg_location_info = new oidb_cmd0xbbb.LocationInfo();
  public oidb_cmd0xbbb.PhoneInfo msg_phone_type = new oidb_cmd0xbbb.PhoneInfo();
  public final PBStringField str_city = PBField.initString("");
  public final PBUInt32Field uint32_age = PBField.initUInt32(0);
  public final PBUInt32Field uint32_debug = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sex = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 58, 64, 74 }, new String[] { "uint32_age", "uint32_sex", "str_city", "bytes_city", "msg_phone_type", "uint32_debug", "msg_location_info" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", localByteStringMicro, null, Integer.valueOf(0), null }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbbb.oidb_cmd0xbbb.ReqBody
 * JD-Core Version:    0.7.0.1
 */