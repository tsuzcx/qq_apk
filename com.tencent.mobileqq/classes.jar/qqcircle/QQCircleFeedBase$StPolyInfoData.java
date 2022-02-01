package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class QQCircleFeedBase$StPolyInfoData
  extends MessageMicro<StPolyInfoData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "info", "orderID", "lastRewardOpTime" }, new Object[] { null, "", Long.valueOf(0L) }, StPolyInfoData.class);
  public QQCircleFeedBase.StPolyLike info = new QQCircleFeedBase.StPolyLike();
  public final PBUInt64Field lastRewardOpTime = PBField.initUInt64(0L);
  public final PBStringField orderID = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.StPolyInfoData
 * JD-Core Version:    0.7.0.1
 */