package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FeedCloudWrite$StReportReq
  extends MessageMicro<StReportReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "extInfo", "reportType", "from", "reportInfo" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), null }, StReportReq.class);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBInt32Field from = PBField.initInt32(0);
  public final PBRepeatMessageField<FeedCloudMeta.StReportInfo> reportInfo = PBField.initRepeatMessage(FeedCloudMeta.StReportInfo.class);
  public final PBUInt32Field reportType = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     feedcloud.FeedCloudWrite.StReportReq
 * JD-Core Version:    0.7.0.1
 */