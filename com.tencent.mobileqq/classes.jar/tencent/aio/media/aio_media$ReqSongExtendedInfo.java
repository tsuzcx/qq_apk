package tencent.aio.media;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class aio_media$ReqSongExtendedInfo
  extends MessageMicro<ReqSongExtendedInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "enum_aio_type", "uint64_id", "rpt_msg_song_list" }, new Object[] { Integer.valueOf(1), Long.valueOf(0L), null }, ReqSongExtendedInfo.class);
  public final PBEnumField enum_aio_type = PBField.initEnum(1);
  public final PBRepeatMessageField<aio_media.SongExtendedReqParam> rpt_msg_song_list = PBField.initRepeatMessage(aio_media.SongExtendedReqParam.class);
  public final PBUInt64Field uint64_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.aio.media.aio_media.ReqSongExtendedInfo
 * JD-Core Version:    0.7.0.1
 */