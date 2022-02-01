package tencent.im.oidb.cmd0xbbc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.channel_button.channel_button.Channel;
import tencent.im.oidb.channel_button.channel_button.Section;

public final class oidb_cmd0xbbc$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42 }, new String[] { "rpt_me_channel", "rpt_recomm_channel", "rpt_msg_section", "uint32_set_type", "msg_phone_type" }, new Object[] { null, null, null, Integer.valueOf(0), null }, ReqBody.class);
  public oidb_cmd0xbbc.PhoneInfo msg_phone_type = new oidb_cmd0xbbc.PhoneInfo();
  public final PBRepeatMessageField<channel_button.Channel> rpt_me_channel = PBField.initRepeatMessage(channel_button.Channel.class);
  public final PBRepeatMessageField<channel_button.Section> rpt_msg_section = PBField.initRepeatMessage(channel_button.Section.class);
  public final PBRepeatMessageField<channel_button.Channel> rpt_recomm_channel = PBField.initRepeatMessage(channel_button.Channel.class);
  public final PBUInt32Field uint32_set_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbbc.oidb_cmd0xbbc.ReqBody
 * JD-Core Version:    0.7.0.1
 */