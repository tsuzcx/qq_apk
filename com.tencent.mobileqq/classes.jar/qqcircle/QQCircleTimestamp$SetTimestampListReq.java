package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class QQCircleTimestamp$SetTimestampListReq
  extends MessageMicro<SetTimestampListReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "reqList" }, new Object[] { null }, SetTimestampListReq.class);
  public final PBRepeatMessageField<QQCircleTimestamp.SetTimestampReq> reqList = PBField.initRepeatMessage(QQCircleTimestamp.SetTimestampReq.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleTimestamp.SetTimestampListReq
 * JD-Core Version:    0.7.0.1
 */