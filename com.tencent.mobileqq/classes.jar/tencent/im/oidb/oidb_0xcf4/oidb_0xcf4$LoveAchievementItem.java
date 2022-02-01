package tencent.im.oidb.oidb_0xcf4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xcf4$LoveAchievementItem
  extends MessageMicro<LoveAchievementItem>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field clockState = PBField.initUInt32(0);
  public final PBStringField str_achievement_backurl = PBField.initString("");
  public final PBUInt32Field uint32_achievement_id = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint32_achievement_id", "str_achievement_backurl", "clockState" }, new Object[] { localInteger, "", localInteger }, LoveAchievementItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.LoveAchievementItem
 * JD-Core Version:    0.7.0.1
 */