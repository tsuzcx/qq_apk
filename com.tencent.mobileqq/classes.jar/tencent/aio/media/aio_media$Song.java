package tencent.aio.media;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class aio_media$Song
  extends MessageMicro<Song>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_cover = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_lyric = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_sub_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField enum_song_source = PBField.initEnum(1);
  public final PBRepeatField<ByteStringMicro> rpt_bytes_download_url = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBRepeatField<ByteStringMicro> rpt_bytes_singer = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBStringField str_song_id = PBField.initString("");
  public final PBUInt32Field uint32_duration = PBField.initUInt32(0);
  public final PBUInt64Field uint64_sharer_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 64, 72, 80 }, new String[] { "str_song_id", "bytes_name", "bytes_sub_title", "rpt_bytes_singer", "rpt_bytes_download_url", "bytes_lyric", "bytes_cover", "uint32_duration", "enum_song_source", "uint64_sharer_uin" }, new Object[] { "", localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(0L) }, Song.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.aio.media.aio_media.Song
 * JD-Core Version:    0.7.0.1
 */