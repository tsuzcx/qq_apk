package qflash;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class QFlashBadge$BadgeJumpInfo
  extends MessageMicro<BadgeJumpInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "jumpTypeValue", "jumpLink" }, new Object[] { Integer.valueOf(0), "" }, BadgeJumpInfo.class);
  public final PBStringField jumpLink = PBField.initString("");
  public final PBEnumField jumpTypeValue = PBField.initEnum(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qflash.QFlashBadge.BadgeJumpInfo
 * JD-Core Version:    0.7.0.1
 */