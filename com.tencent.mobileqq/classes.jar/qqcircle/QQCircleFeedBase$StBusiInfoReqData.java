package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudMeta.StGPSV2;

public final class QQCircleFeedBase$StBusiInfoReqData
  extends MessageMicro<StBusiInfoReqData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "gpsInfo", "busiMap", "rewardInfo" }, new Object[] { null, null, Long.valueOf(0L) }, StBusiInfoReqData.class);
  public final PBRepeatMessageField<FeedCloudCommon.Entry> busiMap = PBField.initRepeatMessage(FeedCloudCommon.Entry.class);
  public FeedCloudMeta.StGPSV2 gpsInfo = new FeedCloudMeta.StGPSV2();
  public final PBRepeatField<Long> rewardInfo = PBField.initRepeat(PBInt64Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.StBusiInfoReqData
 * JD-Core Version:    0.7.0.1
 */