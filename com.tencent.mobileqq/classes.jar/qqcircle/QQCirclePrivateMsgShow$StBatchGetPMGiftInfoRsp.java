package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCirclePrivateMsgShow$StBatchGetPMGiftInfoRsp
  extends MessageMicro<StBatchGetPMGiftInfoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "userGiftInfos" }, new Object[] { null, null }, StBatchGetPMGiftInfoRsp.class);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBRepeatMessageField<QQCirclePrivateMsgShow.UserPMGiftInfo> userGiftInfos = PBField.initRepeatMessage(QQCirclePrivateMsgShow.UserPMGiftInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCirclePrivateMsgShow.StBatchGetPMGiftInfoRsp
 * JD-Core Version:    0.7.0.1
 */