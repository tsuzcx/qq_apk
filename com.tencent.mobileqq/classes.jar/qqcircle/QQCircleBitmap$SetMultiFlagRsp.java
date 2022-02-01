package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCircleBitmap$SetMultiFlagRsp
  extends MessageMicro<SetMultiFlagRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "results" }, new Object[] { null, null }, SetMultiFlagRsp.class);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public QQCircleBitmap.SingleResult results = new QQCircleBitmap.SingleResult();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCircleBitmap.SetMultiFlagRsp
 * JD-Core Version:    0.7.0.1
 */