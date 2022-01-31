package tencent.im.s2c.msgtype0x210.submsgtype0x26;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class submsgtype0x26$MsgBody$SubCmd0x3UpdateDiscussAppInfo
  extends MessageMicro<SubCmd0x3UpdateDiscussAppInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "msg_app_id", "uint64_conf_uin", "msg_app_tip_notify" }, new Object[] { null, Long.valueOf(0L), null }, SubCmd0x3UpdateDiscussAppInfo.class);
  public submsgtype0x26.AppID msg_app_id = new submsgtype0x26.AppID();
  public submsgtype0x26.AppTipNotify msg_app_tip_notify = new submsgtype0x26.AppTipNotify();
  public final PBUInt64Field uint64_conf_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.MsgBody.SubCmd0x3UpdateDiscussAppInfo
 * JD-Core Version:    0.7.0.1
 */