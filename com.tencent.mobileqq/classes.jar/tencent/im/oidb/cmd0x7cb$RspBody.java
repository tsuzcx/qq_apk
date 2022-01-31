package tencent.im.oidb;

import appoint.define.appoint_define.LocaleInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x7cb$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 104 }, new String[] { "uint32_time_stamp", "uint32_time_gap", "rpt_comment_configs", "str_attend_tips_to_A", "str_first_msg_tips", "rpt_cancle_config", "msg_date_request", "rpt_msg_hot_locale", "rpt_msg_topic_list", "str_travel_msg_tips", "str_travel_profile_tips", "str_travel_atten_tips", "uint32_topic_default" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, "", "", null, null, null, null, "", "", "", Integer.valueOf(0) }, RspBody.class);
  public cmd0x7cb.DateRequest msg_date_request = new cmd0x7cb.DateRequest();
  public final PBRepeatMessageField<cmd0x7cb.ConfigItem> rpt_cancle_config = PBField.initRepeatMessage(cmd0x7cb.ConfigItem.class);
  public final PBRepeatMessageField<cmd0x7cb.CommentConfig> rpt_comment_configs = PBField.initRepeatMessage(cmd0x7cb.CommentConfig.class);
  public final PBRepeatMessageField<appoint_define.LocaleInfo> rpt_msg_hot_locale = PBField.initRepeatMessage(appoint_define.LocaleInfo.class);
  public final PBRepeatMessageField<cmd0x7cb.TopicConfig> rpt_msg_topic_list = PBField.initRepeatMessage(cmd0x7cb.TopicConfig.class);
  public final PBStringField str_attend_tips_to_A = PBField.initString("");
  public final PBStringField str_first_msg_tips = PBField.initString("");
  public final PBStringField str_travel_atten_tips = PBField.initString("");
  public final PBStringField str_travel_msg_tips = PBField.initString("");
  public final PBStringField str_travel_profile_tips = PBField.initString("");
  public final PBUInt32Field uint32_time_gap = PBField.initUInt32(0);
  public final PBUInt32Field uint32_time_stamp = PBField.initUInt32(0);
  public final PBUInt32Field uint32_topic_default = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7cb.RspBody
 * JD-Core Version:    0.7.0.1
 */