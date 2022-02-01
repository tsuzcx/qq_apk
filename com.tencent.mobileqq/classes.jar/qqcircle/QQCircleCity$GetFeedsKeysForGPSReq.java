package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCircleCity$GetFeedsKeysForGPSReq
  extends MessageMicro<GetFeedsKeysForGPSReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "extInfo", "gpsInfo", "attach", "num" }, new Object[] { null, null, "", Long.valueOf(0L) }, GetFeedsKeysForGPSReq.class);
  public final PBStringField attach = PBField.initString("");
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public QQCircleCity.GPS gpsInfo = new QQCircleCity.GPS();
  public final PBInt64Field num = PBField.initInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleCity.GetFeedsKeysForGPSReq
 * JD-Core Version:    0.7.0.1
 */