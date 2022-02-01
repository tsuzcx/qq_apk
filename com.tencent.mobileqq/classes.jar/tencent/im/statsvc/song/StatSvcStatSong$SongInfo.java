package tencent.im.statsvc.song;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class StatSvcStatSong$SongInfo
  extends MessageMicro<SongInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_singer_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_song_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_song_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_pause_remaining_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_song_play_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_song_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_source_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_end_time = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 18, 26, 32, 42, 48, 56, 64, 72 }, new String[] { "bytes_song_id", "bytes_song_name", "uint32_song_type", "bytes_singer_name", "uint64_end_time", "uint32_source_type", "uint32_pause_remaining_time", "uint32_song_play_time" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localInteger, localByteStringMicro3, Long.valueOf(0L), localInteger, localInteger, localInteger }, SongInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.statsvc.song.StatSvcStatSong.SongInfo
 * JD-Core Version:    0.7.0.1
 */