package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCircleRead$GetCircleDetailRsp
  extends MessageMicro<GetCircleDetailRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "circleList" }, new Object[] { null, null }, GetCircleDetailRsp.class);
  public final PBRepeatMessageField<QQCircleRead.CircleDetail> circleList = PBField.initRepeatMessage(QQCircleRead.CircleDetail.class);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qqcircle.QQCircleRead.GetCircleDetailRsp
 * JD-Core Version:    0.7.0.1
 */