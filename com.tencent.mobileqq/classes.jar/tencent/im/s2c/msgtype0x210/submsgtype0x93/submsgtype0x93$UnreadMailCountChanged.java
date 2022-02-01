package tencent.im.s2c.msgtype0x210.submsgtype0x93;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class submsgtype0x93$UnreadMailCountChanged
  extends MessageMicro<UnreadMailCountChanged>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_umc" }, new Object[] { null }, UnreadMailCountChanged.class);
  public submsgtype0x93.UnreadMailCountInfo msg_umc = new submsgtype0x93.UnreadMailCountInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x93.submsgtype0x93.UnreadMailCountChanged
 * JD-Core Version:    0.7.0.1
 */