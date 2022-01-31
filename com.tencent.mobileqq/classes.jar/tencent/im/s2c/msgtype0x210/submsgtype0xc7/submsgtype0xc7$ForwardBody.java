package tencent.im.s2c.msgtype0x210.submsgtype0xc7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class submsgtype0xc7$ForwardBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24002 }, new String[] { "uint32_notify_type", "uint32_op_type", "msg_hot_friend_notify" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null }, ForwardBody.class);
  public submsgtype0xc7.HotFriendNotify msg_hot_friend_notify = new submsgtype0xc7.HotFriendNotify();
  public final PBUInt32Field uint32_notify_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_op_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.ForwardBody
 * JD-Core Version:    0.7.0.1
 */