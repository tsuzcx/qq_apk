package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class TaskCenterReader$FuelInfo
  extends MessageMicro<FuelInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field fuelValue = PBField.initUInt32(0);
  public final PBUInt32Field myFuel = PBField.initUInt32(0);
  public final PBStringField userId = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "userId", "myFuel", "fuelValue" }, new Object[] { "", localInteger, localInteger }, FuelInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.TaskCenterReader.FuelInfo
 * JD-Core Version:    0.7.0.1
 */