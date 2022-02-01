package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCirclePay$StPayQueryReq
  extends MessageMicro<StPayQueryReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "extInfo", "rewardInfo" }, new Object[] { null, Long.valueOf(0L) }, StPayQueryReq.class);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBRepeatField<Long> rewardInfo = PBField.initRepeat(PBInt64Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCirclePay.StPayQueryReq
 * JD-Core Version:    0.7.0.1
 */