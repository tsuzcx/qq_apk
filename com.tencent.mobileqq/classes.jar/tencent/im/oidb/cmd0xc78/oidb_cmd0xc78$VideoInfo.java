package tencent.im.oidb.cmd0xc78;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xc78$VideoInfo
  extends MessageMicro<VideoInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "md5", "sha1", "play_duration" }, new Object[] { "", "", Integer.valueOf(0) }, VideoInfo.class);
  public final PBStringField md5 = PBField.initString("");
  public final PBUInt32Field play_duration = PBField.initUInt32(0);
  public final PBStringField sha1 = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xc78.oidb_cmd0xc78.VideoInfo
 * JD-Core Version:    0.7.0.1
 */