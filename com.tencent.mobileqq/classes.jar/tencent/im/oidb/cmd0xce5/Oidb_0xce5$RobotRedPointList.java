package tencent.im.oidb.cmd0xce5;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Oidb_0xce5$RobotRedPointList
  extends MessageMicro<RobotRedPointList>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "redpoint", "cache_time", "role" }, new Object[] { null, Long.valueOf(0L), Integer.valueOf(0) }, RobotRedPointList.class);
  public final PBUInt64Field cache_time = PBField.initUInt64(0L);
  public final PBRepeatMessageField<Oidb_0xce5.RobotRedPoint> redpoint = PBField.initRepeatMessage(Oidb_0xce5.RobotRedPoint.class);
  public final PBUInt32Field role = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xce5.Oidb_0xce5.RobotRedPointList
 * JD-Core Version:    0.7.0.1
 */