package tencent.im.s2c.msgtype0x210.submsgtype0x90;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x90$DpNotifyMsgBdoy
  extends MessageMicro<DpNotifyMsgBdoy>
{
  public static final int RPT_MSG_NOTIFY_INFO_FIELD_NUMBER = 3;
  public static final int STRING_EXTEND_INFO_FIELD_NUMBER = 4;
  public static final int UINT32_PID_FIELD_NUMBER = 1;
  public static final int UINT64_DIN_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "uint32_pid", "uint64_din", "rpt_msg_notify_info", "string_extend_info" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), null, "" }, DpNotifyMsgBdoy.class);
  public final PBRepeatMessageField<SubMsgType0x90.NotifyItem> rpt_msg_notify_info = PBField.initRepeatMessage(SubMsgType0x90.NotifyItem.class);
  public final PBStringField string_extend_info = PBField.initString("");
  public final PBUInt32Field uint32_pid = PBField.initUInt32(0);
  public final PBUInt64Field uint64_din = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x90.SubMsgType0x90.DpNotifyMsgBdoy
 * JD-Core Version:    0.7.0.1
 */