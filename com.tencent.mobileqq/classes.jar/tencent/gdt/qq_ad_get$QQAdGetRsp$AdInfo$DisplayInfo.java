package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qq_ad_get$QQAdGetRsp$AdInfo$DisplayInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 58, 66 }, new String[] { "pattern_type", "creative_size", "animation_effect", "basic_info", "button_info", "muti_pic_text_info", "advertiser_info", "video_info" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, null, null, null, null }, DisplayInfo.class);
  public qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo advertiser_info = new qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo();
  public final PBUInt32Field animation_effect = PBField.initUInt32(0);
  public qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo basic_info = new qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo();
  public final PBRepeatMessageField button_info = PBField.initRepeatMessage(qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.ButtonInfo.class);
  public final PBUInt32Field creative_size = PBField.initUInt32(0);
  public qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.MutiPicTextInfo muti_pic_text_info = new qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.MutiPicTextInfo();
  public final PBUInt32Field pattern_type = PBField.initUInt32(0);
  public qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.VideoInfo video_info = new qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.VideoInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo
 * JD-Core Version:    0.7.0.1
 */