package tencent.im.group_pro_proto.oidb0xffa;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb0xffa$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "ark_message", "guild_info", "leave_message" }, new Object[] { null, null, "" }, ReqBody.class);
  public oidb0xffa.ArkMessage ark_message = new oidb0xffa.ArkMessage();
  public final PBRepeatMessageField<oidb0xffa.GuildInfo> guild_info = PBField.initRepeatMessage(oidb0xffa.GuildInfo.class);
  public final PBStringField leave_message = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.group_pro_proto.oidb0xffa.oidb0xffa.ReqBody
 * JD-Core Version:    0.7.0.1
 */