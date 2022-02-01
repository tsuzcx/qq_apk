package tencent.im.oidb.cmd0xce5;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Oidb_0xce5$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "group_id", "robot_info" }, new Object[] { Long.valueOf(0L), null }, ReqBody.class);
  public final PBUInt64Field group_id = PBField.initUInt64(0L);
  public final PBRepeatMessageField<Oidb_0xce5.RobotInfo> robot_info = PBField.initRepeatMessage(Oidb_0xce5.RobotInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xce5.Oidb_0xce5.ReqBody
 * JD-Core Version:    0.7.0.1
 */