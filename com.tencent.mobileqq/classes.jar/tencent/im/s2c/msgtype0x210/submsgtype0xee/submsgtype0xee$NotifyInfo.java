package tencent.im.s2c.msgtype0x210.submsgtype0xee;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

public final class submsgtype0xee$NotifyInfo
  extends MessageMicro<NotifyInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42, 90, 98, 106, 114, 170 }, new String[] { "msg_style_sheet", "enum_apppush_type", "msg_ordinary_push_info", "msg_social_push_info", "msg_ugc_push_info", "msg_context_info", "msg_account_info", "msg_statistics_info", "msg_control_info", "msg_extra_info" }, new Object[] { null, Integer.valueOf(0), null, null, null, null, null, null, null, null }, NotifyInfo.class);
  public final PBEnumField enum_apppush_type = PBField.initEnum(0);
  public submsgtype0xee.AccountInfo msg_account_info = new submsgtype0xee.AccountInfo();
  public submsgtype0xee.ContextInfo msg_context_info = new submsgtype0xee.ContextInfo();
  public submsgtype0xee.ControlInfo msg_control_info = new submsgtype0xee.ControlInfo();
  public submsgtype0xee.ExtraInfo msg_extra_info = new submsgtype0xee.ExtraInfo();
  public submsgtype0xee.OrdinaryPushInfo msg_ordinary_push_info = new submsgtype0xee.OrdinaryPushInfo();
  public submsgtype0xee.SocialPushInfo msg_social_push_info = new submsgtype0xee.SocialPushInfo();
  public submsgtype0xee.StatisticsInfo msg_statistics_info = new submsgtype0xee.StatisticsInfo();
  public submsgtype0xee.StyleSheet msg_style_sheet = new submsgtype0xee.StyleSheet();
  public submsgtype0xee.UGCPushInfo msg_ugc_push_info = new submsgtype0xee.UGCPushInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xee.submsgtype0xee.NotifyInfo
 * JD-Core Version:    0.7.0.1
 */