package tencent.im.group_pro_proto.oidb0xffa;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

public final class oidb0xffa$ArkMessage
  extends MessageMicro<ArkMessage>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "ark_message_type", "moba_premades_team_message" }, new Object[] { Integer.valueOf(0), null }, ArkMessage.class);
  public final PBEnumField ark_message_type = PBField.initEnum(0);
  public oidb0xffa.MobaPremadesTeamMessage moba_premades_team_message = new oidb0xffa.MobaPremadesTeamMessage();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.group_pro_proto.oidb0xffa.oidb0xffa.ArkMessage
 * JD-Core Version:    0.7.0.1
 */