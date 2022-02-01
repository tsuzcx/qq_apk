package tencent.im.DynamicFeeds;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class DynamicFeeds$SubCmd_Feeds_RespInfo
  extends MessageMicro<SubCmd_Feeds_RespInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 48, 58, 64 }, new String[] { "uiRetCode", "strError", "RespFeeds", "uiNextDayTimestamp", "strTodayTitle", "ulDelFeeds", "strReqCookie", "retFromRecsys" }, new Object[] { Integer.valueOf(0), "", null, Integer.valueOf(0), "", Long.valueOf(0L), "", Integer.valueOf(0) }, SubCmd_Feeds_RespInfo.class);
  public final PBRepeatMessageField<DynamicFeeds.FeedsItem_Resp> RespFeeds = PBField.initRepeatMessage(DynamicFeeds.FeedsItem_Resp.class);
  public final PBUInt32Field retFromRecsys = PBField.initUInt32(0);
  public final PBStringField strError = PBField.initString("");
  public final PBStringField strReqCookie = PBField.initString("");
  public final PBStringField strTodayTitle = PBField.initString("");
  public final PBUInt32Field uiNextDayTimestamp = PBField.initUInt32(0);
  public final PBUInt32Field uiRetCode = PBField.initUInt32(0);
  public final PBRepeatField<Long> ulDelFeeds = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.DynamicFeeds.DynamicFeeds.SubCmd_Feeds_RespInfo
 * JD-Core Version:    0.7.0.1
 */