package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class QQCircleEnvHub$GetUserFullEnvRsp
  extends MessageMicro<GetUserFullEnvRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "tipsList", "userLayerInfo" }, new Object[] { null, null }, GetUserFullEnvRsp.class);
  public final PBRepeatMessageField<QQCircleEnvHub.Tips> tipsList = PBField.initRepeatMessage(QQCircleEnvHub.Tips.class);
  public QQCircleEnvHub.UserLayerInfo userLayerInfo = new QQCircleEnvHub.UserLayerInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCircleEnvHub.GetUserFullEnvRsp
 * JD-Core Version:    0.7.0.1
 */