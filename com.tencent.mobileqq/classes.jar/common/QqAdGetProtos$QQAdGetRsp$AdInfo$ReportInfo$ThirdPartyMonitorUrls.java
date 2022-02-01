package common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QqAdGetProtos$QQAdGetRsp$AdInfo$ReportInfo$ThirdPartyMonitorUrls
  extends MessageMicro<ThirdPartyMonitorUrls>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48, 58 }, new String[] { "api_exposure_monitor_url", "sdk_exposure_monitor_url", "api_click_monitor_url", "sdk_click_monitor_url", "video_play_monitor_url", "video_play_duration", "active_view_tracking_url" }, new Object[] { "", "", "", "", "", Integer.valueOf(0), "" }, ThirdPartyMonitorUrls.class);
  public final PBRepeatField<String> active_view_tracking_url = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBRepeatField<String> api_click_monitor_url = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBRepeatField<String> api_exposure_monitor_url = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBRepeatField<String> sdk_click_monitor_url = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBRepeatField<String> sdk_exposure_monitor_url = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBUInt32Field video_play_duration = PBField.initUInt32(0);
  public final PBRepeatField<String> video_play_monitor_url = PBField.initRepeat(PBStringField.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     common.QqAdGetProtos.QQAdGetRsp.AdInfo.ReportInfo.ThirdPartyMonitorUrls
 * JD-Core Version:    0.7.0.1
 */