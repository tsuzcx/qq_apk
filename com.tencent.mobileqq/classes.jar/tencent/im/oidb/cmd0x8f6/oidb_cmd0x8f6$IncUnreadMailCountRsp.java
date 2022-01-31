package tencent.im.oidb.cmd0x8f6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_cmd0x8f6$IncUnreadMailCountRsp
  extends MessageMicro<IncUnreadMailCountRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_unread" }, new Object[] { null }, IncUnreadMailCountRsp.class);
  public final PBRepeatMessageField<oidb_cmd0x8f6.UnreadMailCountInfo> rpt_msg_unread = PBField.initRepeatMessage(oidb_cmd0x8f6.UnreadMailCountInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8f6.oidb_cmd0x8f6.IncUnreadMailCountRsp
 * JD-Core Version:    0.7.0.1
 */