package tencent.im.oidb.cmd0xb86;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_cmd0xb86$ExamineUserInfo
  extends MessageMicro<ExamineUserInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "msg_nick", "msg_head", "msg_desc" }, new Object[] { null, null, null }, ExamineUserInfo.class);
  public oidb_cmd0xb86.ExamineDesc msg_desc = new oidb_cmd0xb86.ExamineDesc();
  public oidb_cmd0xb86.ExamineHead msg_head = new oidb_cmd0xb86.ExamineHead();
  public oidb_cmd0xb86.ExamineNick msg_nick = new oidb_cmd0xb86.ExamineNick();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb86.oidb_cmd0xb86.ExamineUserInfo
 * JD-Core Version:    0.7.0.1
 */