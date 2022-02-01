package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class FeedCloudTagsvr$GetFeedsKeysByTagIDReq
  extends MessageMicro<GetFeedsKeysByTagIDReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42 }, new String[] { "extInfo", "id", "feedsTime", "num", "attachInfo" }, new Object[] { null, "", Long.valueOf(0L), Long.valueOf(0L), "" }, GetFeedsKeysByTagIDReq.class);
  public final PBStringField attachInfo = PBField.initString("");
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBInt64Field feedsTime = PBField.initInt64(0L);
  public final PBStringField id = PBField.initString("");
  public final PBInt64Field num = PBField.initInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     feedcloud.FeedCloudTagsvr.GetFeedsKeysByTagIDReq
 * JD-Core Version:    0.7.0.1
 */