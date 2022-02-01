package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class QQCircleClientSignalRecords$SignalFlow
  extends MessageMicro<SignalFlow>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "records" }, new Object[] { null }, SignalFlow.class);
  public final PBRepeatMessageField<QQCircleClientSignalRecords.SignalRecord> records = PBField.initRepeatMessage(QQCircleClientSignalRecords.SignalRecord.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCircleClientSignalRecords.SignalFlow
 * JD-Core Version:    0.7.0.1
 */