package tencent.im.cs.cmd0x383;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x383$ApplyFeedMsgV2ReqBody
  extends MessageMicro<ApplyFeedMsgV2ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_first_pkg_flag = PBField.initBool(false);
  public final PBBytesField bytes_client_ip = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_imei = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_session_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_key_type = PBField.initInt32(0);
  public final PBStringField str_file_path1 = PBField.initString("");
  public final PBStringField str_file_path2 = PBField.initString("");
  public final PBStringField str_file_path3 = PBField.initString("");
  public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_client_port = PBField.initUInt32(0);
  public final PBUInt32Field uint32_file_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_msg_random1 = PBField.initUInt32(0);
  public final PBUInt32Field uint32_msg_random2 = PBField.initUInt32(0);
  public final PBUInt32Field uint32_msg_random3 = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pt_appid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_total_file_num = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 58, 88, 96, 104, 240, 248, 258, 266, 272, 282 }, new String[] { "bool_first_pkg_flag", "uint32_total_file_num", "uint32_file_num", "uint32_bus_id", "str_file_path1", "str_file_path2", "str_file_path3", "uint32_msg_random1", "uint32_msg_random2", "uint32_msg_random3", "uint32_pt_appid", "int32_key_type", "bytes_session_key", "bytes_client_ip", "uint32_client_port", "bytes_imei" }, new Object[] { Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), localByteStringMicro3 }, ApplyFeedMsgV2ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.cs.cmd0x383.cmd0x383.ApplyFeedMsgV2ReqBody
 * JD-Core Version:    0.7.0.1
 */