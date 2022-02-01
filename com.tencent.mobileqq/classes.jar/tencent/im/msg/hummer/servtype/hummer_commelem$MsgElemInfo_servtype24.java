package tencent.im.msg.hummer.servtype;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class hummer_commelem$MsgElemInfo_servtype24
  extends MessageMicro<MsgElemInfo_servtype24>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "limit_chat_enter", "limit_chat_exit" }, new Object[] { null, null }, MsgElemInfo_servtype24.class);
  public hummer_commelem.MsgElemInfo_servtype24.LimitChatEnter limit_chat_enter = new hummer_commelem.MsgElemInfo_servtype24.LimitChatEnter();
  public hummer_commelem.MsgElemInfo_servtype24.LimitChatExit limit_chat_exit = new hummer_commelem.MsgElemInfo_servtype24.LimitChatExit();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype24
 * JD-Core Version:    0.7.0.1
 */