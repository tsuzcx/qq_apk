package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class FeedCloudTagsvr$GetFeedsKeysRsp
  extends MessageMicro<GetFeedsKeysRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42, 50, 58 }, new String[] { "extInfo", "hasMore", "FeedTotal", "uinTotal", "feedsKeyList", "tag", "attachInfo" }, new Object[] { null, Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), "", null, "" }, GetFeedsKeysRsp.class);
  public final PBInt64Field FeedTotal = PBField.initInt64(0L);
  public final PBStringField attachInfo = PBField.initString("");
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBRepeatField<String> feedsKeyList = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBInt32Field hasMore = PBField.initInt32(0);
  public FeedCloudTagsvr.TagInfo tag = new FeedCloudTagsvr.TagInfo();
  public final PBInt64Field uinTotal = PBField.initInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     feedcloud.FeedCloudTagsvr.GetFeedsKeysRsp
 * JD-Core Version:    0.7.0.1
 */