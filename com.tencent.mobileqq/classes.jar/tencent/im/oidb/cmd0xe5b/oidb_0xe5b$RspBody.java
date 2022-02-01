package tencent.im.oidb.cmd0xe5b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xe5b$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_achievement_totalcount", "rpt_life_ach_item", "str_achievement_openid" }, new Object[] { Integer.valueOf(0), null, "" }, RspBody.class);
  public final PBRepeatMessageField<oidb_0xe5b.LifeAchievementItem> rpt_life_ach_item = PBField.initRepeatMessage(oidb_0xe5b.LifeAchievementItem.class);
  public final PBStringField str_achievement_openid = PBField.initString("");
  public final PBUInt32Field uint32_achievement_totalcount = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe5b.oidb_0xe5b.RspBody
 * JD-Core Version:    0.7.0.1
 */