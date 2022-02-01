package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCircleCity$GetFeedsKeysForGPSRsp
  extends MessageMicro<GetFeedsKeysForGPSRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42 }, new String[] { "extInfo", "hasMore", "attach", "list", "geo" }, new Object[] { null, Integer.valueOf(0), "", "", null }, GetFeedsKeysForGPSRsp.class);
  public final PBStringField attach = PBField.initString("");
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public QQCircleCity.GeoInfo geo = new QQCircleCity.GeoInfo();
  public final PBInt32Field hasMore = PBField.initInt32(0);
  public final PBRepeatField<String> list = PBField.initRepeat(PBStringField.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     qqcircle.QQCircleCity.GetFeedsKeysForGPSRsp
 * JD-Core Version:    0.7.0.1
 */