package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCirclePay$StPayRewardRsp
  extends MessageMicro<StPayRewardRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "payComm" }, new Object[] { null, null }, StPayRewardRsp.class);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public QQCirclePay.StPayComm payComm = new QQCirclePay.StPayComm();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCirclePay.StPayRewardRsp
 * JD-Core Version:    0.7.0.1
 */