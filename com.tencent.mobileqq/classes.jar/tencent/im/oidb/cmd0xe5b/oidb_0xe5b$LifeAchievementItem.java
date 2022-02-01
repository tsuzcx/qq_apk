package tencent.im.oidb.cmd0xe5b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xe5b$LifeAchievementItem
  extends MessageMicro<LifeAchievementItem>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_has_praised = PBField.initBool(false);
  public final PBBytesField bytes_achievement_content = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField str_achievement_icon = PBField.initString("");
  public final PBStringField str_achievement_title = PBField.initString("");
  public final PBUInt32Field uint32_achievement_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_praise_num = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 50 }, new String[] { "uint32_achievement_id", "str_achievement_title", "str_achievement_icon", "bool_has_praised", "uint32_praise_num", "bytes_achievement_content" }, new Object[] { localInteger, "", "", Boolean.valueOf(false), localInteger, localByteStringMicro }, LifeAchievementItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe5b.oidb_0xe5b.LifeAchievementItem
 * JD-Core Version:    0.7.0.1
 */