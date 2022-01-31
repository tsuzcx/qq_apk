package tencent.im.msg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class im_msg$Group
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "sender", "receiver", "group_info" }, new Object[] { null, null, null }, Group.class);
  public im_common.GroupInfo group_info = new im_common.GroupInfo();
  public im_common.User receiver = new im_common.User();
  public im_common.User sender = new im_common.User();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.msg.im_msg.Group
 * JD-Core Version:    0.7.0.1
 */