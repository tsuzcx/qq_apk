package tencent.im.oidb.cmd0x5d2;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x5d2$RspGetInfo
  extends MessageMicro<RspGetInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40 }, new String[] { "group_info", "login_info", "time", "frd_info", "frd_delete" }, new Object[] { null, null, Integer.valueOf(0), null, Long.valueOf(0L) }, RspGetInfo.class);
  public final PBRepeatField<Long> frd_delete = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBRepeatMessageField<oidb_0x5d2.FriendInfo> frd_info = PBField.initRepeatMessage(oidb_0x5d2.FriendInfo.class);
  public final PBRepeatMessageField<oidb_0x5d2.GroupInfo> group_info = PBField.initRepeatMessage(oidb_0x5d2.GroupInfo.class);
  public final PBRepeatMessageField<oidb_0x5d2.LoginInfo> login_info = PBField.initRepeatMessage(oidb_0x5d2.LoginInfo.class);
  public final PBUInt32Field time = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5d2.oidb_0x5d2.RspGetInfo
 * JD-Core Version:    0.7.0.1
 */