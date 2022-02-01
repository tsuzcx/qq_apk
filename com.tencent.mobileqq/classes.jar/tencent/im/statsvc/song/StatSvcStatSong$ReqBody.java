package tencent.im.statsvc.song;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class StatSvcStatSong$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_need_convert = PBField.initBool(false);
  public final PBBoolField bool_pause_flag = PBField.initBool(false);
  public final PBBytesField bytes_singer_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_song_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_song_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_remaining_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_song_play_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_song_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_source_type = PBField.initUInt32(0);
  
  static
  {
    Boolean localBoolean = Boolean.valueOf(false);
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 48, 56, 64, 72 }, new String[] { "bool_need_convert", "bytes_song_id", "bytes_song_name", "uint32_song_type", "bytes_singer_name", "uint32_remaining_time", "uint32_source_type", "bool_pause_flag", "uint32_song_play_time" }, new Object[] { localBoolean, localByteStringMicro1, localByteStringMicro2, localInteger, localByteStringMicro3, localInteger, localInteger, localBoolean, localInteger }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.statsvc.song.StatSvcStatSong.ReqBody
 * JD-Core Version:    0.7.0.1
 */