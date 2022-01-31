package tencent.aio.media;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class aio_media$TypeVideo
  extends MessageMicro<TypeVideo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_cover = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_jump = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_video_jump_value = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField enum_video_jump_type = PBField.initEnum(1);
  public final PBEnumField enum_video_type = PBField.initEnum(1);
  public final PBBytesField match_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_polling = PBField.initUInt32(0);
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_id = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 50, 56, 64, 74, 82 }, new String[] { "uint32_type", "uint64_id", "bytes_jump", "bytes_cover", "uint32_polling", "bytes_name", "enum_video_type", "enum_video_jump_type", "bytes_video_jump_value", "match_id" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), localByteStringMicro3, Integer.valueOf(1), Integer.valueOf(1), localByteStringMicro4, localByteStringMicro5 }, TypeVideo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.aio.media.aio_media.TypeVideo
 * JD-Core Version:    0.7.0.1
 */