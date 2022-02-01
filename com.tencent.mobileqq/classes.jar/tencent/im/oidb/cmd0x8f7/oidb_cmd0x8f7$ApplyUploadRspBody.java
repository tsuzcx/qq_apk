package tencent.im.oidb.cmd0x8f7;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0x8f7$ApplyUploadRspBody
  extends MessageMicro<ApplyUploadRspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_file_exist = PBField.initBool(false);
  public final PBBytesField bytes_check_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_conflict_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_random_sha = PBField.initBytes(ByteStringMicro.copyFromUtf8(""));
  public final PBBytesField bytes_server_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_expired_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_server_port = PBField.initUInt32(0);
  public final PBUInt32Field uint32_uploadip = PBField.initUInt32(0);
  public final PBUInt32Field uint32_version = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.copyFromUtf8("");
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 50, 58, 64, 72, 80 }, new String[] { "bool_file_exist", "bytes_uuid", "bytes_check_key", "bytes_server_name", "uint32_server_port", "bytes_random_sha", "bytes_conflict_key", "uint32_expired_time", "uint32_version", "uint32_uploadip" }, new Object[] { Boolean.valueOf(false), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), localByteStringMicro4, localByteStringMicro5, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ApplyUploadRspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8f7.oidb_cmd0x8f7.ApplyUploadRspBody
 * JD-Core Version:    0.7.0.1
 */