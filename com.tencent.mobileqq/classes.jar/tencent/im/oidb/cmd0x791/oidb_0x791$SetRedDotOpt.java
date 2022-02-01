package tencent.im.oidb.cmd0x791;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x791$SetRedDotOpt
  extends MessageMicro<SetRedDotOpt>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_clear = PBField.initBool(false);
  public final PBBoolField bool_display_reddot = PBField.initBool(false);
  public final PBBoolField bool_keep_unchanged = PBField.initBool(false);
  public final PBBoolField bool_push_to_client = PBField.initBool(false);
  public final PBInt32Field int32_number = PBField.initInt32(0);
  public final PBRepeatField<Long> rpt_uint64_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBBytesField str_custom_buffer = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField str_face_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_cmd_uin_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_expire_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_last_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_reason = PBField.initUInt32(0);
  public final PBUInt32Field uint32_report_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_total_number = PBField.initUInt32(0);
  public final PBUInt64Field uint64_cmd_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 66, 74, 80, 88, 96, 104, 112, 120 }, new String[] { "uint64_cmd_uin", "rpt_uint64_uin", "bool_clear", "bool_display_reddot", "int32_number", "uint32_reason", "bool_push_to_client", "str_face_url", "str_custom_buffer", "uint32_expire_time", "uint32_last_time", "uint32_total_number", "uint32_cmd_uin_type", "uint32_report_type", "bool_keep_unchanged" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Boolean.valueOf(false), Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false) }, SetRedDotOpt.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0x791.oidb_0x791.SetRedDotOpt
 * JD-Core Version:    0.7.0.1
 */