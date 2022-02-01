package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class QQCircleFeedBase$StLikeBusiData
  extends MessageMicro<StLikeBusiData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "polyLikeInfo", "curPolyLikeInfo", "rewardstatus" }, new Object[] { null, null, Integer.valueOf(0) }, StLikeBusiData.class);
  public QQCircleFeedBase.StPolyLike curPolyLikeInfo = new QQCircleFeedBase.StPolyLike();
  public final PBRepeatMessageField<QQCircleFeedBase.StPolyLike> polyLikeInfo = PBField.initRepeatMessage(QQCircleFeedBase.StPolyLike.class);
  public final PBInt32Field rewardstatus = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.StLikeBusiData
 * JD-Core Version:    0.7.0.1
 */