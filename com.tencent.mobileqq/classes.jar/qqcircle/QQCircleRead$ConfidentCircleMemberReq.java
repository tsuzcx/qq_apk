package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCircleRead$ConfidentCircleMemberReq
  extends MessageMicro<ConfidentCircleMemberReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "circleInfo" }, new Object[] { null, null }, ConfidentCircleMemberReq.class);
  public QQCircleBase.UserCircleInfo circleInfo = new QQCircleBase.UserCircleInfo();
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleRead.ConfidentCircleMemberReq
 * JD-Core Version:    0.7.0.1
 */