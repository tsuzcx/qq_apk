package tencent.im.cs.cmd0x383;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x383$ApplyUploadRspBody
  extends MessageMicro<ApplyUploadRspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_file_exist = PBField.initBool(false);
  public final PBBoolField bool_safe_check_flag = PBField.initBool(false);
  public final PBBytesField bytes_check_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_file_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField str_file_path = PBField.initString("");
  public final PBStringField str_server_dns = PBField.initString("");
  public final PBStringField str_upload_ip = PBField.initString("");
  public final PBUInt32Field uint32_im_fail_reason = PBField.initUInt32(0);
  public final PBUInt32Field uint32_safe_check_res = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48, 88, 96, 104 }, new String[] { "str_upload_ip", "str_server_dns", "str_file_path", "bytes_file_key", "bytes_check_key", "bool_file_exist", "bool_safe_check_flag", "uint32_safe_check_res", "uint32_im_fail_reason" }, new Object[] { "", "", "", localByteStringMicro1, localByteStringMicro2, Boolean.valueOf(false), Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0) }, ApplyUploadRspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.cs.cmd0x383.cmd0x383.ApplyUploadRspBody
 * JD-Core Version:    0.7.0.1
 */