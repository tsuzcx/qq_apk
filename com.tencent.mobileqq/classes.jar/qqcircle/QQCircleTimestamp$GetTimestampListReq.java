package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class QQCircleTimestamp$GetTimestampListReq
  extends MessageMicro<GetTimestampListReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "reqList" }, new Object[] { null }, GetTimestampListReq.class);
  public final PBRepeatMessageField<QQCircleTimestamp.GetTimestampReq> reqList = PBField.initRepeatMessage(QQCircleTimestamp.GetTimestampReq.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCircleTimestamp.GetTimestampListReq
 * JD-Core Version:    0.7.0.1
 */