package tencent.im.group_pro_proto.oidb0xf9c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class discovery$Reply
  extends MessageMicro<Reply>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "categories", "guilds" }, new Object[] { null, null }, Reply.class);
  public final PBRepeatMessageField<common.Category> categories = PBField.initRepeatMessage(common.Category.class);
  public common.Guilds guilds = new common.Guilds();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.group_pro_proto.oidb0xf9c.discovery.Reply
 * JD-Core Version:    0.7.0.1
 */