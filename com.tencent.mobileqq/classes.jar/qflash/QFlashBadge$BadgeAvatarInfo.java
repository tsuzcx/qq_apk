package qflash;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class QFlashBadge$BadgeAvatarInfo
  extends MessageMicro<BadgeAvatarInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "uID", "uRL" }, new Object[] { "", "" }, BadgeAvatarInfo.class);
  public final PBStringField uID = PBField.initString("");
  public final PBStringField uRL = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qflash.QFlashBadge.BadgeAvatarInfo
 * JD-Core Version:    0.7.0.1
 */