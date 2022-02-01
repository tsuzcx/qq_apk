package qflash;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QFlashBadge$QFlashBadgeInfo
  extends MessageMicro<QFlashBadgeInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public QFlashBadge.QFlashBadgeContentInfo contentInfo = new QFlashBadge.QFlashBadgeContentInfo();
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBInt64Field lastClearTimestamp = PBField.initInt64(0L);
  public final PBInt64Field pushTimestamp = PBField.initInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "extInfo", "contentInfo", "lastClearTimestamp", "pushTimestamp" }, new Object[] { null, null, localLong, localLong }, QFlashBadgeInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qflash.QFlashBadge.QFlashBadgeInfo
 * JD-Core Version:    0.7.0.1
 */