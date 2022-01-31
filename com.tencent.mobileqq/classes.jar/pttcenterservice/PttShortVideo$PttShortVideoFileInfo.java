package pttcenterservice;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class PttShortVideo$PttShortVideoFileInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_decrypt_thumb_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_decrypt_video_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_thumb_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField str_file_name = PBField.initString("");
  public final PBUInt32Field uint32_file_format = PBField.initUInt32(0);
  public final PBUInt32Field uint32_file_res_length = PBField.initUInt32(0);
  public final PBUInt32Field uint32_file_res_width = PBField.initUInt32(0);
  public final PBUInt32Field uint32_file_time = PBField.initUInt32(0);
  public final PBUInt64Field uint64_decrypt_file_size = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_decrypt_thumb_size = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_thumb_file_size = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 48, 56, 64, 72, 82, 88, 98, 104 }, new String[] { "str_file_name", "bytes_file_md5", "bytes_thumb_file_md5", "uint64_file_size", "uint32_file_res_length", "uint32_file_res_width", "uint32_file_format", "uint32_file_time", "uint64_thumb_file_size", "bytes_decrypt_video_md5", "uint64_decrypt_file_size", "bytes_decrypt_thumb_md5", "uint64_decrypt_thumb_size" }, new Object[] { "", localByteStringMicro1, localByteStringMicro2, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro3, Long.valueOf(0L), localByteStringMicro4, Long.valueOf(0L) }, PttShortVideoFileInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     pttcenterservice.PttShortVideo.PttShortVideoFileInfo
 * JD-Core Version:    0.7.0.1
 */