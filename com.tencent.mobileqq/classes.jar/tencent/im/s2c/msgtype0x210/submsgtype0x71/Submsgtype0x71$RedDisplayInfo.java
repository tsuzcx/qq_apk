package tencent.im.s2c.msgtype0x210.submsgtype0x71;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class Submsgtype0x71$RedDisplayInfo
  extends MessageMicro<RedDisplayInfo>
{
  public static final int MSG_TAB_DISPLAY_INFO_FIELD_NUMBER = 2;
  public static final int RPT_MSG_RED_TYPE_INFO_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "rpt_msg_red_type_info", "msg_tab_display_info" }, new Object[] { null, null }, RedDisplayInfo.class);
  public Submsgtype0x71.RedTypeInfo msg_tab_display_info = new Submsgtype0x71.RedTypeInfo();
  public final PBRepeatMessageField<Submsgtype0x71.RedTypeInfo> rpt_msg_red_type_info = PBField.initRepeatMessage(Submsgtype0x71.RedTypeInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x71.Submsgtype0x71.RedDisplayInfo
 * JD-Core Version:    0.7.0.1
 */