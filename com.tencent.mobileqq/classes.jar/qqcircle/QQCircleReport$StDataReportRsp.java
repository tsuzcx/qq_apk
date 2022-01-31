package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import feedcloud.FeedCloudCommon.Result;

public final class QQCircleReport$StDataReportRsp
  extends MessageMicro<StDataReportRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "result" }, new Object[] { null }, StDataReportRsp.class);
  public FeedCloudCommon.Result result = new FeedCloudCommon.Result();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qqcircle.QQCircleReport.StDataReportRsp
 * JD-Core Version:    0.7.0.1
 */