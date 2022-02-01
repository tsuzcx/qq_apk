package tencent.im.oidb.cmd0x8f6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_cmd0x8f6$GetUnreadMailCountRsp
  extends MessageMicro<GetUnreadMailCountRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_unread" }, new Object[] { null }, GetUnreadMailCountRsp.class);
  public oidb_cmd0x8f6.UnreadMailCountInfo msg_unread = new oidb_cmd0x8f6.UnreadMailCountInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8f6.oidb_cmd0x8f6.GetUnreadMailCountRsp
 * JD-Core Version:    0.7.0.1
 */