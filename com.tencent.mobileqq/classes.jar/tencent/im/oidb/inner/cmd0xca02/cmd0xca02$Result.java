package tencent.im.oidb.inner.cmd0xca02;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0xca02$Result
  extends MessageMicro<Result>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_can_remove = PBField.initBool(false);
  public final PBBoolField bool_red_point = PBField.initBool(false);
  public cmd0xca02.AppInfo msg_app_info = new cmd0xca02.AppInfo();
  public final PBBytesField string_hash_val = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField string_icon = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField string_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField string_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_add_timestamp = PBField.initUInt32(0);
  public final PBUInt32Field uint32_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_identify_visibilty = PBField.initUInt32(31);
  public final PBUInt32Field uint32_res = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 56, 64, 74, 80, 88 }, new String[] { "uint32_id", "uint32_res", "string_hash_val", "string_icon", "string_name", "string_url", "bool_red_point", "bool_can_remove", "msg_app_info", "uint32_add_timestamp", "uint32_identify_visibilty" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, Boolean.valueOf(false), Boolean.valueOf(false), null, Integer.valueOf(0), Integer.valueOf(31) }, Result.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.inner.cmd0xca02.cmd0xca02.Result
 * JD-Core Version:    0.7.0.1
 */