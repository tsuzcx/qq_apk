package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class TaskCenterReader$FuelListRecord
  extends MessageMicro<FuelListRecord>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40 }, new String[] { "behaviorType", "opName", "optTime", "fuelValue", "leftFuel" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, FuelListRecord.class);
  public final PBEnumField behaviorType = PBField.initEnum(0);
  public final PBInt32Field fuelValue = PBField.initInt32(0);
  public final PBInt32Field leftFuel = PBField.initInt32(0);
  public final PBStringField opName = PBField.initString("");
  public final PBUInt32Field optTime = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qqcircle.TaskCenterReader.FuelListRecord
 * JD-Core Version:    0.7.0.1
 */