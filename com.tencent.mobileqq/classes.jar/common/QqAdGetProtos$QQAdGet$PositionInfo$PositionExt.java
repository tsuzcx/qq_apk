package common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QqAdGetProtos$QQAdGet$PositionInfo$PositionExt
  extends MessageMicro<PositionExt>
{
  public static final int FETCH_TYPE_PREFETCH = 1;
  public static final int FETCH_TYPE_REAL_TIME = 0;
  public static final int FETCH_TYPE_SPECIFY_AD = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatField<Integer> black_category_list = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBRepeatMessageField<QqAdGetProtos.QQAdGet.PositionInfo.PositionExt.CpsReqInfo> cps_req_info = PBField.initRepeatMessage(QqAdGetProtos.QQAdGet.PositionInfo.PositionExt.CpsReqInfo.class);
  public final PBRepeatField<Integer> debug_adindexid_list = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBUInt32Field deep_link_version = PBField.initUInt32(0);
  public final PBEnumField get_ad_type = PBField.initEnum(0);
  public QqAdGetProtos.QQAdGet.PositionInfo.PositionExt.ShareInfo share_info = new QqAdGetProtos.QQAdGet.PositionInfo.PositionExt.ShareInfo();
  public final PBRepeatMessageField<QqAdGetProtos.QQAdGet.PositionInfo.PositionExt.SpecifiedAdsItem> specified_ads = PBField.initRepeatMessage(QqAdGetProtos.QQAdGet.PositionInfo.PositionExt.SpecifiedAdsItem.class);
  public final PBStringField sub_position_id = PBField.initString("");
  public QqAdGetProtos.QQAdGet.PositionInfo.PositionExt.VideoReqInfo video_req_info = new QqAdGetProtos.QQAdGet.PositionInfo.PositionExt.VideoReqInfo();
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42, 48, 56, 66, 74 }, new String[] { "share_info", "deep_link_version", "get_ad_type", "specified_ads", "sub_position_id", "black_category_list", "debug_adindexid_list", "cps_req_info", "video_req_info" }, new Object[] { null, localInteger, localInteger, null, "", localInteger, localInteger, null, null }, PositionExt.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     common.QqAdGetProtos.QQAdGet.PositionInfo.PositionExt
 * JD-Core Version:    0.7.0.1
 */