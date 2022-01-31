package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class QQCircleFeedBase$StLikeBusiData
  extends MessageMicro<StLikeBusiData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "polyLikeInfo", "curPolyLikeInfo" }, new Object[] { null, null }, StLikeBusiData.class);
  public QQCircleFeedBase.StPolyLike curPolyLikeInfo = new QQCircleFeedBase.StPolyLike();
  public final PBRepeatMessageField<QQCircleFeedBase.StPolyLike> polyLikeInfo = PBField.initRepeatMessage(QQCircleFeedBase.StPolyLike.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.StLikeBusiData
 * JD-Core Version:    0.7.0.1
 */