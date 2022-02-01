package qflash;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class QFlashBadge$QFlashBadgeContentInfo
  extends MessageMicro<QFlashBadgeContentInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public QFlashBadge.BadgeDisplayInfo displayInfo = new QFlashBadge.BadgeDisplayInfo();
  public final PBBytesField traceInfo = PBField.initBytes(ByteStringMicro.EMPTY);
  public QFlashBadge.BadgeTypeInfo typeInfo = new QFlashBadge.BadgeTypeInfo();
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "typeInfo", "displayInfo", "traceInfo" }, new Object[] { null, null, localByteStringMicro }, QFlashBadgeContentInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qflash.QFlashBadge.QFlashBadgeContentInfo
 * JD-Core Version:    0.7.0.1
 */