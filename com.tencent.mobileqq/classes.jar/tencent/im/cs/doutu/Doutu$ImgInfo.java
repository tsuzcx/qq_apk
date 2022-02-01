package tencent.im.cs.doutu;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Doutu$ImgInfo
  extends MessageMicro<ImgInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_pic_down_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_pic_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_source_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_thumb_down_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_thumb_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_pic_height = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pic_width = PBField.initUInt32(0);
  public final PBUInt32Field uint32_thumb_height = PBField.initUInt32(0);
  public final PBUInt32Field uint32_thumb_width = PBField.initUInt32(0);
  public final PBUInt64Field uint64_pic_size = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_thumb_size = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42, 50, 56, 64, 72, 82, 90 }, new String[] { "bytes_pic_md5", "uint64_pic_size", "uint32_pic_width", "uint32_pic_height", "bytes_pic_down_url", "bytes_thumb_file_md5", "uint64_thumb_size", "uint32_thumb_width", "uint32_thumb_height", "bytes_thumb_down_url", "bytes_source_name" }, new Object[] { localByteStringMicro1, localLong, localInteger, localInteger, localByteStringMicro2, localByteStringMicro3, localLong, localInteger, localInteger, localByteStringMicro4, localByteStringMicro5 }, ImgInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.cs.doutu.Doutu.ImgInfo
 * JD-Core Version:    0.7.0.1
 */