package tencent.im.oidb.cmd0xb6e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class Oidb_0xb6e$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "is_lost", "rpt_friends_info" }, new Object[] { Integer.valueOf(0), null }, RspBody.class);
  public final PBInt32Field is_lost = PBField.initInt32(0);
  public final PBRepeatMessageField<Oidb_0xb6e.AppFriendsInfo> rpt_friends_info = PBField.initRepeatMessage(Oidb_0xb6e.AppFriendsInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb6e.Oidb_0xb6e.RspBody
 * JD-Core Version:    0.7.0.1
 */