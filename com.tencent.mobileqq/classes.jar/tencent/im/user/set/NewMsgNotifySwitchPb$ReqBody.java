package tencent.im.user.set;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class NewMsgNotifySwitchPb$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_notify_switch", "uint32_bind_uin_notify_switch" }, new Object[] { Integer.valueOf(0), Integer.valueOf(1) }, ReqBody.class);
  public final PBUInt32Field uint32_bind_uin_notify_switch = PBField.initUInt32(1);
  public final PBUInt32Field uint32_notify_switch = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.user.set.NewMsgNotifySwitchPb.ReqBody
 * JD-Core Version:    0.7.0.1
 */