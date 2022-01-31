package tencent.aio.media;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class aio_media$TypeMusic
  extends MessageMicro<TypeMusic>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 48 }, new String[] { "rpt_msg_song_list", "uint32_progress_seek", "int32_progress_seek", "enum_play_mode", "bool_allow_member_start", "bool_allow_member_add" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Boolean.valueOf(true), Boolean.valueOf(false) }, TypeMusic.class);
  public final PBBoolField bool_allow_member_add = PBField.initBool(false);
  public final PBBoolField bool_allow_member_start = PBField.initBool(true);
  public final PBEnumField enum_play_mode = PBField.initEnum(1);
  public final PBInt32Field int32_progress_seek = PBField.initInt32(0);
  public final PBRepeatMessageField<aio_media.Song> rpt_msg_song_list = PBField.initRepeatMessage(aio_media.Song.class);
  public final PBUInt32Field uint32_progress_seek = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.aio.media.aio_media.TypeMusic
 * JD-Core Version:    0.7.0.1
 */