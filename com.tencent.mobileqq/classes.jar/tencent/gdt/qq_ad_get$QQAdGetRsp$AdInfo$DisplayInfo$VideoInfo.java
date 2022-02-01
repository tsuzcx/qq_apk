package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo$VideoInfo
  extends MessageMicro<VideoInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField bottom_card_url = PBField.initString("");
  public final PBStringField endcard = PBField.initString("");
  public final PBUInt32Field endcard_direction = PBField.initUInt32(0);
  public final PBUInt32Field endcard_load_time = PBField.initUInt32(0);
  public final PBUInt32Field media_duration = PBField.initUInt32(0);
  public final PBBoolField no_auto_play = PBField.initBool(false);
  public final PBStringField tencent_video_id = PBField.initString("");
  public final PBUInt32Field video_file_size = PBField.initUInt32(0);
  public final PBStringField video_url = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40, 50, 56, 64, 74 }, new String[] { "video_url", "media_duration", "tencent_video_id", "video_file_size", "no_auto_play", "endcard", "endcard_load_time", "endcard_direction", "bottom_card_url" }, new Object[] { "", localInteger, "", localInteger, Boolean.valueOf(false), "", localInteger, localInteger, "" }, VideoInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.VideoInfo
 * JD-Core Version:    0.7.0.1
 */