package tencent.im.oidb.cmd0xfc2;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xfc2$FileInfo
  extends MessageMicro<FileInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_sha = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt64Field int64_save_time = PBField.initInt64(0L);
  public final PBInt64Field int64_upload_time = PBField.initInt64(0L);
  public final PBStringField str_fileid = PBField.initString("");
  public final PBStringField str_name = PBField.initString("");
  public final PBUInt32Field uint32_danger_level = PBField.initUInt32(0);
  public final PBUInt64Field uint64_size = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42, 48, 56, 64 }, new String[] { "str_fileid", "str_name", "uint64_size", "bytes_sha", "bytes_md5", "uint32_danger_level", "int64_upload_time", "int64_save_time" }, new Object[] { "", "", localLong, localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), localLong, localLong }, FileInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xfc2.oidb_0xfc2.FileInfo
 * JD-Core Version:    0.7.0.1
 */