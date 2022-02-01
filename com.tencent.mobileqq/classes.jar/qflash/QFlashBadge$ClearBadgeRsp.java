package qflash;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QFlashBadge$ClearBadgeRsp
  extends MessageMicro<ClearBadgeRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "clearRspInfo" }, new Object[] { null, null }, ClearBadgeRsp.class);
  public final PBRepeatMessageField<QFlashBadge.ClearBadgeRspInfo> clearRspInfo = PBField.initRepeatMessage(QFlashBadge.ClearBadgeRspInfo.class);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qflash.QFlashBadge.ClearBadgeRsp
 * JD-Core Version:    0.7.0.1
 */