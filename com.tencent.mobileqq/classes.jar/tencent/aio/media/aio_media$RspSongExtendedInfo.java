package tencent.aio.media;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class aio_media$RspSongExtendedInfo
  extends MessageMicro<RspSongExtendedInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_result", "rpt_msg_song_list" }, new Object[] { null, null }, RspSongExtendedInfo.class);
  public aio_media.ResultInfo msg_result = new aio_media.ResultInfo();
  public final PBRepeatMessageField<aio_media.Song> rpt_msg_song_list = PBField.initRepeatMessage(aio_media.Song.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.aio.media.aio_media.RspSongExtendedInfo
 * JD-Core Version:    0.7.0.1
 */