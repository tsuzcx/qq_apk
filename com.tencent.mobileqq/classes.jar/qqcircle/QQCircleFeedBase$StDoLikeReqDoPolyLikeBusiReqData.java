package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class QQCircleFeedBase$StDoLikeReqDoPolyLikeBusiReqData
  extends MessageMicro<StDoLikeReqDoPolyLikeBusiReqData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "polyLikeInfo", "curPolyLikeInfo" }, new Object[] { null, null }, StDoLikeReqDoPolyLikeBusiReqData.class);
  public QQCircleFeedBase.StPolyLike curPolyLikeInfo = new QQCircleFeedBase.StPolyLike();
  public QQCircleFeedBase.StPolyLike polyLikeInfo = new QQCircleFeedBase.StPolyLike();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.StDoLikeReqDoPolyLikeBusiReqData
 * JD-Core Version:    0.7.0.1
 */