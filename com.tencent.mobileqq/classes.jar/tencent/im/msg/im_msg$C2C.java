package tencent.im.msg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class im_msg$C2C
  extends MessageMicro<C2C>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "sender", "receiver", "c2c_relation" }, new Object[] { null, null, null }, C2C.class);
  public im_msg.C2CRelation c2c_relation = new im_msg.C2CRelation();
  public im_common.User receiver = new im_common.User();
  public im_common.User sender = new im_common.User();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.msg.im_msg.C2C
 * JD-Core Version:    0.7.0.1
 */