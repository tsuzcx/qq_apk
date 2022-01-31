package tencent.im.s2c.msgtype0x210.submsgtype0x69;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Submsgtype0x69
  extends MessageMicro<Submsgtype0x69>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_display_reddot = PBField.initBool(false);
  public final PBBoolField bool_test_env = PBField.initBool(false);
  public final PBBytesField bytes_custom_buffer = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_face_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_cmd_uin_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_expire_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_last_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_number = PBField.initUInt32(0);
  public final PBUInt32Field uint32_reason = PBField.initUInt32(0);
  public final PBUInt32Field uint32_report_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_cmd_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 58, 66, 72, 80, 88, 96 }, new String[] { "uint32_appid", "bool_display_reddot", "uint32_number", "uint32_reason", "uint32_last_time", "uint64_cmd_uin", "bytes_face_url", "bytes_custom_buffer", "uint32_expire_time", "uint32_cmd_uin_type", "uint32_report_type", "bool_test_env" }, new Object[] { Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false) }, Submsgtype0x69.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x69.Submsgtype0x69
 * JD-Core Version:    0.7.0.1
 */