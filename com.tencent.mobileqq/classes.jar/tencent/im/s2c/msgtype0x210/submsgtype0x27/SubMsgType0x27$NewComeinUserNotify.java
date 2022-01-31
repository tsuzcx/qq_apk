package tencent.im.s2c.msgtype0x210.submsgtype0x27;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SubMsgType0x27$NewComeinUserNotify
  extends MessageMicro<NewComeinUserNotify>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50 }, new String[] { "uint32_msg_type", "bool_strong_notify", "uint32_push_time", "msg_new_comein_user", "msg_new_group", "msg_new_group_user" }, new Object[] { Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(0), null, null, null }, NewComeinUserNotify.class);
  public final PBBoolField bool_strong_notify = PBField.initBool(false);
  public SubMsgType0x27.NewComeinUser msg_new_comein_user = new SubMsgType0x27.NewComeinUser();
  public SubMsgType0x27.NewGroup msg_new_group = new SubMsgType0x27.NewGroup();
  public SubMsgType0x27.NewGroupUser msg_new_group_user = new SubMsgType0x27.NewGroupUser();
  public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_push_time = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.NewComeinUserNotify
 * JD-Core Version:    0.7.0.1
 */