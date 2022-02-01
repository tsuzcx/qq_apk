package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCirclePrivateMsgShow$StBatchGetPMGiftInfoReq
  extends MessageMicro<StBatchGetPMGiftInfoReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "uids" }, new Object[] { null, "" }, StBatchGetPMGiftInfoReq.class);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBRepeatField<String> uids = PBField.initRepeat(PBStringField.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     qqcircle.QQCirclePrivateMsgShow.StBatchGetPMGiftInfoReq
 * JD-Core Version:    0.7.0.1
 */