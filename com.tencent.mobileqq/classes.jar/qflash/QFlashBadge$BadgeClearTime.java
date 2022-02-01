package qflash;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

public final class QFlashBadge$BadgeClearTime
  extends MessageMicro<BadgeClearTime>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "typeInfo", "lastClearTime" }, new Object[] { null, Long.valueOf(0L) }, BadgeClearTime.class);
  public final PBInt64Field lastClearTime = PBField.initInt64(0L);
  public QFlashBadge.BadgeTypeInfo typeInfo = new QFlashBadge.BadgeTypeInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qflash.QFlashBadge.BadgeClearTime
 * JD-Core Version:    0.7.0.1
 */