package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class QQCircleFeedBase$LightInteractionBusiData
  extends MessageMicro<LightInteractionBusiData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "polyInfo", "polyInfos" }, new Object[] { null, null }, LightInteractionBusiData.class);
  public QQCircleFeedBase.StPolyLike polyInfo = new QQCircleFeedBase.StPolyLike();
  public final PBRepeatMessageField<QQCircleFeedBase.StPolyLike> polyInfos = PBField.initRepeatMessage(QQCircleFeedBase.StPolyLike.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.LightInteractionBusiData
 * JD-Core Version:    0.7.0.1
 */