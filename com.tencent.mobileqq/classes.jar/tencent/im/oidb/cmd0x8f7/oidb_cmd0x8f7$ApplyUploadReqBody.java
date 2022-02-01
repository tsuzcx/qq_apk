package tencent.im.oidb.cmd0x8f7;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x8f7$ApplyUploadReqBody
  extends MessageMicro<ApplyUploadReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_file_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_sha = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_upload_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_modify_time = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 40, 48 }, new String[] { "bytes_file_name", "uint64_file_size", "bytes_sha", "bytes_md5", "uint64_modify_time", "uint32_upload_type" }, new Object[] { localByteStringMicro1, Long.valueOf(0L), localByteStringMicro2, localByteStringMicro3, Long.valueOf(0L), Integer.valueOf(0) }, ApplyUploadReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8f7.oidb_cmd0x8f7.ApplyUploadReqBody
 * JD-Core Version:    0.7.0.1
 */