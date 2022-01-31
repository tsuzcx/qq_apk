package tencent.im.msg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class im_msg$RoutingHead
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "c2c", "group" }, new Object[] { null, null }, RoutingHead.class);
  public im_msg.C2C c2c = new im_msg.C2C();
  public im_msg.Group group = new im_msg.Group();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.msg.im_msg.RoutingHead
 * JD-Core Version:    0.7.0.1
 */