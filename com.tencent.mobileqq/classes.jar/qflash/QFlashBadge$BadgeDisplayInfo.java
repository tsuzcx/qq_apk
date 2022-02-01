package qflash;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QFlashBadge$BadgeDisplayInfo
  extends MessageMicro<BadgeDisplayInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42 }, new String[] { "showBadge", "wording", "number", "avatarInfoList", "jumpInfo" }, new Object[] { Boolean.valueOf(false), "", Integer.valueOf(0), null, null }, BadgeDisplayInfo.class);
  public final PBRepeatMessageField<QFlashBadge.BadgeAvatarInfo> avatarInfoList = PBField.initRepeatMessage(QFlashBadge.BadgeAvatarInfo.class);
  public QFlashBadge.BadgeJumpInfo jumpInfo = new QFlashBadge.BadgeJumpInfo();
  public final PBUInt32Field number = PBField.initUInt32(0);
  public final PBBoolField showBadge = PBField.initBool(false);
  public final PBStringField wording = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qflash.QFlashBadge.BadgeDisplayInfo
 * JD-Core Version:    0.7.0.1
 */