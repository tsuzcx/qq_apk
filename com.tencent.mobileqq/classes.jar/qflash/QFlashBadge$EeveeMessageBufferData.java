package qflash;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QFlashBadge$EeveeMessageBufferData
  extends MessageMicro<EeveeMessageBufferData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "qFlashBadgeInfoList" }, new Object[] { null, null }, EeveeMessageBufferData.class);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBRepeatMessageField<QFlashBadge.QFlashBadgeInfo> qFlashBadgeInfoList = PBField.initRepeatMessage(QFlashBadge.QFlashBadgeInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qflash.QFlashBadge.EeveeMessageBufferData
 * JD-Core Version:    0.7.0.1
 */