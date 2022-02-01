package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class FeedCloudRead$StClearCountReq
  extends MessageMicro<StClearCountReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "extInfo", "userId", "clearCountInfos" }, new Object[] { null, "", null }, StClearCountReq.class);
  public final PBRepeatMessageField<FeedCloudRead.StClearCountInfo> clearCountInfos = PBField.initRepeatMessage(FeedCloudRead.StClearCountInfo.class);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBStringField userId = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     feedcloud.FeedCloudRead.StClearCountReq
 * JD-Core Version:    0.7.0.1
 */