package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo
  extends MessageMicro<DisplayInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 58, 66, 74, 80, 93, 96, 106, 114, 122, 130, 138 }, new String[] { "pattern_type", "creative_size", "animation_effect", "basic_info", "button_info", "muti_pic_text_info", "advertiser_info", "video_info", "local_info", "mini_program_type", "ecpm", "inner_adshowtype", "video_info2", "mini_program_name", "mini_program_id", "container_ad_item", "screenshot_url_list" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, null, null, null, null, null, Integer.valueOf(0), Float.valueOf(0.0F), Integer.valueOf(0), null, "", "", null, "" }, DisplayInfo.class);
  public qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo advertiser_info = new qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo();
  public final PBUInt32Field animation_effect = PBField.initUInt32(0);
  public qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo basic_info = new qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo();
  public final PBRepeatMessageField<qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo> button_info = PBField.initRepeatMessage(qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo.class);
  public final PBRepeatMessageField<qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ContainerAdItem> container_ad_item = PBField.initRepeatMessage(qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ContainerAdItem.class);
  public final PBUInt32Field creative_size = PBField.initUInt32(0);
  public final PBFloatField ecpm = PBField.initFloat(0.0F);
  public final PBUInt32Field inner_adshowtype = PBField.initUInt32(0);
  public qq_common.LocalInfo local_info = new qq_common.LocalInfo();
  public final PBStringField mini_program_id = PBField.initString("");
  public final PBStringField mini_program_name = PBField.initString("");
  public final PBUInt32Field mini_program_type = PBField.initUInt32(0);
  public qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.MutiPicTextInfo muti_pic_text_info = new qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.MutiPicTextInfo();
  public final PBUInt32Field pattern_type = PBField.initUInt32(0);
  public final PBRepeatField<String> screenshot_url_list = PBField.initRepeat(PBStringField.__repeatHelper__);
  public qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.VideoInfo video_info = new qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.VideoInfo();
  public qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.VideoInfo video_info2 = new qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.VideoInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo
 * JD-Core Version:    0.7.0.1
 */