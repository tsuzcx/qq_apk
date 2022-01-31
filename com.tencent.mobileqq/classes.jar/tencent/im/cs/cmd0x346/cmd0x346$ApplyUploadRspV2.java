package tencent.im.cs.cmd0x346;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x346$ApplyUploadRspV2
  extends MessageMicro<ApplyUploadRspV2>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_file_exist = PBField.initBool(false);
  public final PBBytesField bytes_sha = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_upload_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_ret_code = PBField.initInt32(0);
  public final PBRepeatField<String> rpt_str_uploadip_list = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBStringField str_ret_msg = PBField.initString("");
  public final PBStringField str_upload_dns = PBField.initString("");
  public final PBStringField str_upload_domain = PBField.initString("");
  public final PBStringField str_upload_https_domain = PBField.initString("");
  public final PBStringField str_upload_ip = PBField.initString("");
  public final PBStringField str_upload_lanip = PBField.initString("");
  public final PBUInt32Field uint32_httpsvr_api_ver = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pack_size = PBField.initUInt32(0);
  public final PBUInt32Field uint32_upload_https_port = PBField.initUInt32(443);
  public final PBUInt32Field uint32_upload_port = PBField.initUInt32(0);
  public final PBUInt64Field uint64_total_space = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uploaded_size = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_used_space = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 162, 240, 320, 400, 482, 562, 640, 722, 802, 880, 960, 1042, 1120, 1130, 1136, 1146, 1202, 1282 }, new String[] { "int32_ret_code", "str_ret_msg", "uint64_total_space", "uint64_used_space", "uint64_uploaded_size", "str_upload_ip", "str_upload_domain", "uint32_upload_port", "bytes_uuid", "bytes_upload_key", "bool_file_exist", "uint32_pack_size", "rpt_str_uploadip_list", "uint32_httpsvr_api_ver", "bytes_sha", "uint32_upload_https_port", "str_upload_https_domain", "str_upload_dns", "str_upload_lanip" }, new Object[] { Integer.valueOf(0), "", Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), "", "", Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Boolean.valueOf(false), Integer.valueOf(0), "", Integer.valueOf(0), localByteStringMicro3, Integer.valueOf(443), "", "", "" }, ApplyUploadRspV2.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadRspV2
 * JD-Core Version:    0.7.0.1
 */