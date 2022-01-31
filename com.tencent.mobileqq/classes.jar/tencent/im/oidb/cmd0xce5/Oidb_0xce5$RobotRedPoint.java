package tencent.im.oidb.cmd0xce5;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Oidb_0xce5$RobotRedPoint
  extends MessageMicro<RobotRedPoint>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "robot_uin", "end_ts", "role" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0) }, RobotRedPoint.class);
  public final PBUInt64Field end_ts = PBField.initUInt64(0L);
  public final PBUInt64Field robot_uin = PBField.initUInt64(0L);
  public final PBUInt32Field role = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xce5.Oidb_0xce5.RobotRedPoint
 * JD-Core Version:    0.7.0.1
 */