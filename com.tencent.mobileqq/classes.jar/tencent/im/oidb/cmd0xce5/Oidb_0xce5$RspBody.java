package tencent.im.oidb.cmd0xce5;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Oidb_0xce5$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field max_robot_num = PBField.initUInt32(0);
  public final PBRepeatMessageField<Oidb_0xce5.RobotInfo> robot_info = PBField.initRepeatMessage(Oidb_0xce5.RobotInfo.class);
  public Oidb_0xce5.RobotRedPointList robot_redpoint_list = new Oidb_0xce5.RobotRedPointList();
  public final PBUInt32Field role = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 42 }, new String[] { "robot_info", "role", "max_robot_num", "robot_redpoint_list" }, new Object[] { null, localInteger, localInteger, null }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xce5.Oidb_0xce5.RspBody
 * JD-Core Version:    0.7.0.1
 */