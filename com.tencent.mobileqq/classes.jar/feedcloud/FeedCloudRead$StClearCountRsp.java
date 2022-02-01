package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class FeedCloudRead$StClearCountRsp
  extends MessageMicro<StClearCountRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "extInfo", "result", "clearCountRspInfos" }, new Object[] { null, null, null }, StClearCountRsp.class);
  public final PBRepeatMessageField<FeedCloudRead.StClearCountRspInfo> clearCountRspInfos = PBField.initRepeatMessage(FeedCloudRead.StClearCountRspInfo.class);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public FeedCloudCommon.Result result = new FeedCloudCommon.Result();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     feedcloud.FeedCloudRead.StClearCountRsp
 * JD-Core Version:    0.7.0.1
 */