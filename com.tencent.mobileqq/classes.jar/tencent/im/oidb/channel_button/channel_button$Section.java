package tencent.im.oidb.channel_button;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class channel_button$Section
  extends MessageMicro<Section>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34 }, new String[] { "str_section_name", "uint64_section_id", "str_note_text", "rpt_msg_channel" }, new Object[] { "", Long.valueOf(0L), "", null }, Section.class);
  public final PBRepeatMessageField<channel_button.Channel> rpt_msg_channel = PBField.initRepeatMessage(channel_button.Channel.class);
  public final PBStringField str_note_text = PBField.initString("");
  public final PBStringField str_section_name = PBField.initString("");
  public final PBUInt64Field uint64_section_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.channel_button.channel_button.Section
 * JD-Core Version:    0.7.0.1
 */