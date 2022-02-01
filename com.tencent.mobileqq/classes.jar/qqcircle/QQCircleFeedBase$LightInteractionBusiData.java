package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleFeedBase$LightInteractionBusiData
  extends MessageMicro<LightInteractionBusiData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "polyInfo", "polyInfos", "splitItemText" }, new Object[] { null, null, "" }, LightInteractionBusiData.class);
  public QQCircleFeedBase.StPolyLike polyInfo = new QQCircleFeedBase.StPolyLike();
  public final PBRepeatMessageField<QQCircleFeedBase.StPolyLike> polyInfos = PBField.initRepeatMessage(QQCircleFeedBase.StPolyLike.class);
  public final PBStringField splitItemText = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.LightInteractionBusiData
 * JD-Core Version:    0.7.0.1
 */