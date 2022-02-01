package qflash;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QFlashBadge$ClearBadgeReq
  extends MessageMicro<ClearBadgeReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "clearReqInfo" }, new Object[] { null, null }, ClearBadgeReq.class);
  public final PBRepeatMessageField<QFlashBadge.ClearBadgeReqInfo> clearReqInfo = PBField.initRepeatMessage(QFlashBadge.ClearBadgeReqInfo.class);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qflash.QFlashBadge.ClearBadgeReq
 * JD-Core Version:    0.7.0.1
 */