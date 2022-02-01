package tencent.aio.media;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class aio_media$TypeKSing
  extends MessageMicro<TypeKSing>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_cover = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_jump = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_song = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_singer = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 48, 58 }, new String[] { "uint32_type", "uint64_id", "bytes_jump", "bytes_cover", "bytes_name", "uint64_singer", "bytes_song" }, new Object[] { Integer.valueOf(0), localLong, localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localLong, localByteStringMicro4 }, TypeKSing.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.aio.media.aio_media.TypeKSing
 * JD-Core Version:    0.7.0.1
 */