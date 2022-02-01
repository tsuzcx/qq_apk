package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;

public final class TaskCenterReader$EeveeMyFuel
  extends MessageMicro<EeveeMyFuel>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "pushTime", "myFuelValue" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, EeveeMyFuel.class);
  public final PBInt32Field myFuelValue = PBField.initInt32(0);
  public final PBInt64Field pushTime = PBField.initInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.TaskCenterReader.EeveeMyFuel
 * JD-Core Version:    0.7.0.1
 */