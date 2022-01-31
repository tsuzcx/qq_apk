package tencent.im.cs;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class head$MsgHead
  extends MessageMicro<MsgHead>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_content_head" }, new Object[] { null }, MsgHead.class);
  public head.ContentHead msg_content_head = new head.ContentHead();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.cs.head.MsgHead
 * JD-Core Version:    0.7.0.1
 */