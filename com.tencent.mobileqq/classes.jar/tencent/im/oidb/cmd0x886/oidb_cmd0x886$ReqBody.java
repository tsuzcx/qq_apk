package tencent.im.oidb.cmd0x886;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x886$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField enum_ad_display = PBField.initEnum(2);
  public oidb_cmd0x886.AdInfo msg_ad_info = new oidb_cmd0x886.AdInfo();
  public oidb_cmd0x886.PhoneInfo msg_phone_info = new oidb_cmd0x886.PhoneInfo();
  public final PBUInt64Field uint64_client_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 48 }, new String[] { "uint64_uin", "msg_phone_info", "msg_ad_info", "bytes_uuid", "uint64_client_time", "enum_ad_display" }, new Object[] { Long.valueOf(0L), null, null, localByteStringMicro, Long.valueOf(0L), Integer.valueOf(2) }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x886.oidb_cmd0x886.ReqBody
 * JD-Core Version:    0.7.0.1
 */