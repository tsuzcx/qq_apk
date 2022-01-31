package tencent.im.oidb.cmd0x6d6;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x6d6$UploadFileRspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_file_exist = PBField.initBool(false);
  public final PBBytesField bytes_check_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_file_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_ret_code = PBField.initInt32(0);
  public final PBStringField str_client_wording = PBField.initString("");
  public final PBStringField str_file_id = PBField.initString("");
  public final PBStringField str_ret_msg = PBField.initString("");
  public final PBStringField str_server_dns = PBField.initString("");
  public final PBStringField str_upload_ip = PBField.initString("");
  public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 48, 58, 66, 74, 80 }, new String[] { "int32_ret_code", "str_ret_msg", "str_client_wording", "str_upload_ip", "str_server_dns", "uint32_bus_id", "str_file_id", "bytes_file_key", "bytes_check_key", "bool_file_exist" }, new Object[] { Integer.valueOf(0), "", "", "", "", Integer.valueOf(0), "", localByteStringMicro1, localByteStringMicro2, Boolean.valueOf(false) }, UploadFileRspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6d6.oidb_0x6d6.UploadFileRspBody
 * JD-Core Version:    0.7.0.1
 */