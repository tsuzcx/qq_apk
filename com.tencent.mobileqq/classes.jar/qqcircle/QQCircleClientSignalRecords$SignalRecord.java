package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleClientSignalRecords$SignalRecord
  extends MessageMicro<SignalRecord>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "reportTime", "sessionid", "interval_time_ms", "opt_type" }, new Object[] { Long.valueOf(0L), "", Long.valueOf(0L), Long.valueOf(0L) }, SignalRecord.class);
  public final PBInt64Field interval_time_ms = PBField.initInt64(0L);
  public final PBInt64Field opt_type = PBField.initInt64(0L);
  public final PBInt64Field reportTime = PBField.initInt64(0L);
  public final PBStringField sessionid = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qqcircle.QQCircleClientSignalRecords.SignalRecord
 * JD-Core Version:    0.7.0.1
 */