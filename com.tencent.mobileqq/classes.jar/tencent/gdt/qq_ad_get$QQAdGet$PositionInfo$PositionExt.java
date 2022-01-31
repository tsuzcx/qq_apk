package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qq_ad_get$QQAdGet$PositionInfo$PositionExt
  extends MessageMicro<PositionExt>
{
  public static final int FETCH_TYPE_PREFETCH = 1;
  public static final int FETCH_TYPE_REAL_TIME = 0;
  public static final int FETCH_TYPE_SPECIFY_AD = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42, 66, 74 }, new String[] { "share_info", "deep_link_version", "get_ad_type", "specified_ads", "sub_position_id", "cps_req_info", "video_req_info" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), null, "", null, null }, PositionExt.class);
  public final PBRepeatMessageField<qq_ad_get.QQAdGet.PositionInfo.PositionExt.CpsReqInfo> cps_req_info = PBField.initRepeatMessage(qq_ad_get.QQAdGet.PositionInfo.PositionExt.CpsReqInfo.class);
  public final PBUInt32Field deep_link_version = PBField.initUInt32(0);
  public final PBEnumField get_ad_type = PBField.initEnum(0);
  public qq_ad_get.QQAdGet.PositionInfo.PositionExt.ShareInfo share_info = new qq_ad_get.QQAdGet.PositionInfo.PositionExt.ShareInfo();
  public final PBRepeatMessageField<qq_ad_get.QQAdGet.PositionInfo.PositionExt.SpecifiedAdsItem> specified_ads = PBField.initRepeatMessage(qq_ad_get.QQAdGet.PositionInfo.PositionExt.SpecifiedAdsItem.class);
  public final PBStringField sub_position_id = PBField.initString("");
  public qq_ad_get.QQAdGet.PositionInfo.PositionExt.VideoReqInfo video_req_info = new qq_ad_get.QQAdGet.PositionInfo.PositionExt.VideoReqInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.gdt.qq_ad_get.QQAdGet.PositionInfo.PositionExt
 * JD-Core Version:    0.7.0.1
 */