package tencent.im.oidb.qqmusic;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class MusicSongInfoMatch$CMsgRequest
  extends MessageMicro<CMsgRequest>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42 }, new String[] { "uin", "ct", "cv", "reqtype", "urlparams" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), null }, CMsgRequest.class);
  public final PBUInt64Field ct = PBField.initUInt64(0L);
  public final PBUInt64Field cv = PBField.initUInt64(0L);
  public final PBUInt32Field reqtype = PBField.initUInt32(0);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  public final PBRepeatMessageField<MusicSongInfoMatch.ParamPair> urlparams = PBField.initRepeatMessage(MusicSongInfoMatch.ParamPair.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.qqmusic.MusicSongInfoMatch.CMsgRequest
 * JD-Core Version:    0.7.0.1
 */