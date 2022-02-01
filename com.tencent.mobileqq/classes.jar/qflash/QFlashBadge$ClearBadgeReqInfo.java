package qflash;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

public final class QFlashBadge$ClearBadgeReqInfo
  extends MessageMicro<ClearBadgeReqInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "typeInfo", "clearType", "rewriteClearTime" }, new Object[] { null, Integer.valueOf(0), Long.valueOf(0L) }, ClearBadgeReqInfo.class);
  public final PBEnumField clearType = PBField.initEnum(0);
  public final PBInt64Field rewriteClearTime = PBField.initInt64(0L);
  public QFlashBadge.BadgeTypeInfo typeInfo = new QFlashBadge.BadgeTypeInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qflash.QFlashBadge.ClearBadgeReqInfo
 * JD-Core Version:    0.7.0.1
 */