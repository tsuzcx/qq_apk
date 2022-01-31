package tencent.im.cs.cmd0x346;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x346$ApplyUploadHitRspV2
  extends MessageMicro<ApplyUploadHitRspV2>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_upload_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_ret_code = PBField.initInt32(0);
  public final PBStringField str_ret_msg = PBField.initString("");
  public final PBStringField str_upload_dns = PBField.initString("");
  public final PBStringField str_upload_domain = PBField.initString("");
  public final PBStringField str_upload_https_domain = PBField.initString("");
  public final PBStringField str_upload_ip = PBField.initString("");
  public final PBUInt32Field uint32_upload_https_port = PBField.initUInt32(443);
  public final PBUInt32Field uint32_upload_port = PBField.initUInt32(0);
  public final PBUInt64Field uint64_total_space = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_used_space = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 162, 242, 320, 402, 482, 562, 640, 720, 800, 882, 962 }, new String[] { "int32_ret_code", "str_ret_msg", "str_upload_ip", "uint32_upload_port", "str_upload_domain", "bytes_uuid", "bytes_upload_key", "uint64_total_space", "uint64_used_space", "uint32_upload_https_port", "str_upload_https_domain", "str_upload_dns" }, new Object[] { Integer.valueOf(0), "", "", Integer.valueOf(0), "", localByteStringMicro1, localByteStringMicro2, Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(443), "", "" }, ApplyUploadHitRspV2.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadHitRspV2
 * JD-Core Version:    0.7.0.1
 */