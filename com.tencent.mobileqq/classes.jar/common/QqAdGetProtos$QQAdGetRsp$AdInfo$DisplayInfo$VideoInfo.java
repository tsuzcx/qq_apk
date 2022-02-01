package common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QqAdGetProtos$QQAdGetRsp$AdInfo$DisplayInfo$VideoInfo
  extends MessageMicro<VideoInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40 }, new String[] { "video_url", "media_duration", "tencent_video_id", "video_file_size", "no_auto_play" }, new Object[] { "", Integer.valueOf(0), "", Integer.valueOf(0), Boolean.valueOf(false) }, VideoInfo.class);
  public final PBUInt32Field media_duration = PBField.initUInt32(0);
  public final PBBoolField no_auto_play = PBField.initBool(false);
  public final PBStringField tencent_video_id = PBField.initString("");
  public final PBUInt32Field video_file_size = PBField.initUInt32(0);
  public final PBStringField video_url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     common.QqAdGetProtos.QQAdGetRsp.AdInfo.DisplayInfo.VideoInfo
 * JD-Core Version:    0.7.0.1
 */