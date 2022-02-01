package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class QQCircleFeedBase$StLayerAttachInfo
  extends MessageMicro<StLayerAttachInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "feedList" }, new Object[] { null }, StLayerAttachInfo.class);
  public final PBRepeatMessageField<QQCircleFeedBase.StSimpleFeed> feedList = PBField.initRepeatMessage(QQCircleFeedBase.StSimpleFeed.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.StLayerAttachInfo
 * JD-Core Version:    0.7.0.1
 */