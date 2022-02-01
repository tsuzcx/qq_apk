package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class TaskCenterReader$ReceiveFuelRecord
  extends MessageMicro<ReceiveFuelRecord>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "uid", "fuelValue" }, new Object[] { "", Long.valueOf(0L) }, ReceiveFuelRecord.class);
  public final PBInt64Field fuelValue = PBField.initInt64(0L);
  public final PBStringField uid = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qqcircle.TaskCenterReader.ReceiveFuelRecord
 * JD-Core Version:    0.7.0.1
 */