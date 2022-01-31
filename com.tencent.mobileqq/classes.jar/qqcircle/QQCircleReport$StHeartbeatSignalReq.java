package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudCommon.BytesEntry;

public final class QQCircleReport$StHeartbeatSignalReq
  extends MessageMicro<StHeartbeatSignalReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 410, 418, 426 }, new String[] { "uin", "interval_time_ms", "sig_optype", "app_info", "network_info", "byteExtinfo" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), null, null, null }, StHeartbeatSignalReq.class);
  public QQCircleBase.StAppInfo app_info = new QQCircleBase.StAppInfo();
  public final PBRepeatMessageField<FeedCloudCommon.BytesEntry> byteExtinfo = PBField.initRepeatMessage(FeedCloudCommon.BytesEntry.class);
  public final PBInt64Field interval_time_ms = PBField.initInt64(0L);
  public QQCircleBase.StNetworkInfo network_info = new QQCircleBase.StNetworkInfo();
  public final PBEnumField sig_optype = PBField.initEnum(0);
  public final PBInt64Field uin = PBField.initInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qqcircle.QQCircleReport.StHeartbeatSignalReq
 * JD-Core Version:    0.7.0.1
 */