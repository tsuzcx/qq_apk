package tencent.im.group_pro_proto.oidb0xf9c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class common$Guilds
  extends MessageMicro<Guilds>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "category_id", "guilds" }, new Object[] { Integer.valueOf(0), null }, Guilds.class);
  public final PBUInt32Field category_id = PBField.initUInt32(0);
  public final PBRepeatMessageField<common.Guild> guilds = PBField.initRepeatMessage(common.Guild.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.group_pro_proto.oidb0xf9c.common.Guilds
 * JD-Core Version:    0.7.0.1
 */