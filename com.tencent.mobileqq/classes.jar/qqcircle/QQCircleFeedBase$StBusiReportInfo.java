package qqcircle;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon.BytesEntry;

public final class QQCircleFeedBase$StBusiReportInfo
  extends MessageMicro<StBusiReportInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<FeedCloudCommon.BytesEntry> busiTranparent = PBField.initRepeatMessage(FeedCloudCommon.BytesEntry.class);
  public final PBInt64Field downTime = PBField.initInt64(0L);
  public final PBStringField entryTraceID = PBField.initString("");
  public QQCircleFeedBase.StRecomReportInfo recom_report = new QQCircleFeedBase.StRecomReportInfo();
  public final PBBytesField tianji_report = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField traceID = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42, 50 }, new String[] { "tianji_report", "recom_report", "downTime", "traceID", "busiTranparent", "entryTraceID" }, new Object[] { localByteStringMicro, null, Long.valueOf(0L), "", null, "" }, StBusiReportInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.StBusiReportInfo
 * JD-Core Version:    0.7.0.1
 */