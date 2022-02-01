package tencent.im.s2c.msgtype0x210.submsgtype0x4e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class Submsgtype0x4e$GroupBulletin
  extends MessageMicro<GroupBulletin>
{
  public static final int RPT_MSG_CONTENT_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_content" }, new Object[] { null }, GroupBulletin.class);
  public final PBRepeatMessageField<Submsgtype0x4e.GroupBulletin.Content> rpt_msg_content = PBField.initRepeatMessage(Submsgtype0x4e.GroupBulletin.Content.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x4e.Submsgtype0x4e.GroupBulletin
 * JD-Core Version:    0.7.0.1
 */