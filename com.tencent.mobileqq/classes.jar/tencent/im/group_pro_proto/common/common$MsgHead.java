package tencent.im.group_pro_proto.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class common$MsgHead
  extends MessageMicro<MsgHead>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "routing_head", "content_head" }, new Object[] { null, null }, MsgHead.class);
  public common.ContentHead content_head = new common.ContentHead();
  public common.RoutingHead routing_head = new common.RoutingHead();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.group_pro_proto.common.common.MsgHead
 * JD-Core Version:    0.7.0.1
 */