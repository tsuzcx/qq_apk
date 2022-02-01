package tencent.im.DynamicFeeds;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class DynamicFeeds$SubCmd_Feeds_ReqInfo
  extends MessageMicro<SubCmd_Feeds_ReqInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 40, 50 }, new String[] { "uiReqEvent", "ReqResIDs", "uiLoadDayTimestamp", "HistoryFeedIDs", "ulFinishDayBitmap", "strReqCookie" }, new Object[] { Integer.valueOf(0), null, Integer.valueOf(0), null, Long.valueOf(0L), "" }, SubCmd_Feeds_ReqInfo.class);
  public final PBRepeatMessageField<DynamicFeeds.FeedsItem_History> HistoryFeedIDs = PBField.initRepeatMessage(DynamicFeeds.FeedsItem_History.class);
  public final PBRepeatMessageField<DynamicFeeds.FeedsItem_Req> ReqResIDs = PBField.initRepeatMessage(DynamicFeeds.FeedsItem_Req.class);
  public final PBStringField strReqCookie = PBField.initString("");
  public final PBUInt32Field uiLoadDayTimestamp = PBField.initUInt32(0);
  public final PBUInt32Field uiReqEvent = PBField.initUInt32(0);
  public final PBUInt64Field ulFinishDayBitmap = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.DynamicFeeds.DynamicFeeds.SubCmd_Feeds_ReqInfo
 * JD-Core Version:    0.7.0.1
 */