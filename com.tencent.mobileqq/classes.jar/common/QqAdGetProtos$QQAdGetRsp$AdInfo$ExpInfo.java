package common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class QqAdGetProtos$QQAdGetRsp$AdInfo$ExpInfo
  extends MessageMicro<ExpInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field interstitial_ad_style = PBField.initInt32(0);
  public final PBInt32Field qq_game_video_ad_style = PBField.initInt32(0);
  public final PBInt32Field reward_video_download_type = PBField.initInt32(0);
  public final PBInt32Field video_countdown = PBField.initInt32(0);
  public final PBInt32Field video_countdown_style = PBField.initInt32(0);
  public final PBInt32Field video_volume = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48 }, new String[] { "qq_game_video_ad_style", "reward_video_download_type", "video_countdown", "video_volume", "video_countdown_style", "interstitial_ad_style" }, new Object[] { localInteger, localInteger, localInteger, localInteger, localInteger, localInteger }, ExpInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     common.QqAdGetProtos.QQAdGetRsp.AdInfo.ExpInfo
 * JD-Core Version:    0.7.0.1
 */