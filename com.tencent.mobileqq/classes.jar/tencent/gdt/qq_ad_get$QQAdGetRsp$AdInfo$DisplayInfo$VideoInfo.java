package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$VideoInfo
  extends MessageMicro<VideoInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32 }, new String[] { "video_url", "media_duration", "tencent_video_id", "video_file_size" }, new Object[] { "", Integer.valueOf(0), "", Integer.valueOf(0) }, VideoInfo.class);
  public final PBUInt32Field media_duration = PBField.initUInt32(0);
  public final PBStringField tencent_video_id = PBField.initString("");
  public final PBUInt32Field video_file_size = PBField.initUInt32(0);
  public final PBStringField video_url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.VideoInfo
 * JD-Core Version:    0.7.0.1
 */