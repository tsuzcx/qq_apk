package tencent.im.s2c.msgtype0x210.submsgtype0x6f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SubMsgType0x6f$QimFriendNotifyToQQ
  extends MessageMicro<QimFriendNotifyToQQ>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uint32_notify_type", "msg_add_notify_to_qq", "msg_upgrade_notify", "msg_add_not_login_frd_notify_to_qq" }, new Object[] { Integer.valueOf(0), null, null, null }, QimFriendNotifyToQQ.class);
  public SubMsgType0x6f.AddQimNotLoginFrdNotifyToQQ msg_add_not_login_frd_notify_to_qq = new SubMsgType0x6f.AddQimNotLoginFrdNotifyToQQ();
  public SubMsgType0x6f.AddQimFriendNotifyToQQ msg_add_notify_to_qq = new SubMsgType0x6f.AddQimFriendNotifyToQQ();
  public SubMsgType0x6f.UpgradeQimFriendNotify msg_upgrade_notify = new SubMsgType0x6f.UpgradeQimFriendNotify();
  public final PBUInt32Field uint32_notify_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.QimFriendNotifyToQQ
 * JD-Core Version:    0.7.0.1
 */