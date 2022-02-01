package qflash;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class QFlashBadge$QFlashBadgeTraceInfo
  extends MessageMicro<QFlashBadgeTraceInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34 }, new String[] { "traceID", "badgeType", "reason", "sealTransfer" }, new Object[] { "", Integer.valueOf(0), "", "" }, QFlashBadgeTraceInfo.class);
  public final PBInt32Field badgeType = PBField.initInt32(0);
  public final PBStringField reason = PBField.initString("");
  public final PBStringField sealTransfer = PBField.initString("");
  public final PBStringField traceID = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qflash.QFlashBadge.QFlashBadgeTraceInfo
 * JD-Core Version:    0.7.0.1
 */