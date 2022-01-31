package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon.BytesEntry;
import feedcloud.FeedCloudCommon.Entry;

public final class QQCircleReport$SingleDcData
  extends MessageMicro<SingleDcData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "dcid", "report_data", "extinfo", "byteExtinfo" }, new Object[] { Integer.valueOf(0), null, null, null }, SingleDcData.class);
  public final PBRepeatMessageField<FeedCloudCommon.BytesEntry> byteExtinfo = PBField.initRepeatMessage(FeedCloudCommon.BytesEntry.class);
  public final PBUInt32Field dcid = PBField.initUInt32(0);
  public final PBRepeatMessageField<FeedCloudCommon.Entry> extinfo = PBField.initRepeatMessage(FeedCloudCommon.Entry.class);
  public final PBRepeatMessageField<FeedCloudCommon.Entry> report_data = PBField.initRepeatMessage(FeedCloudCommon.Entry.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qqcircle.QQCircleReport.SingleDcData
 * JD-Core Version:    0.7.0.1
 */