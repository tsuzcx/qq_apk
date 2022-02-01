package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class QQCircleFeedBase$StCommCountStore
  extends MessageMicro<StCommCountStore>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "polyInfos" }, new Object[] { null }, StCommCountStore.class);
  public final PBRepeatMessageField<QQCircleFeedBase.StPolyInfoData> polyInfos = PBField.initRepeatMessage(QQCircleFeedBase.StPolyInfoData.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.StCommCountStore
 * JD-Core Version:    0.7.0.1
 */