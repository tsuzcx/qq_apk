package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class FeedCloudRead$StBatchGetFeedDetailReq
  extends MessageMicro<StBatchGetFeedDetailReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBRepeatMessageField<FeedCloudMeta.StFeed> feedIndex = PBField.initRepeatMessage(FeedCloudMeta.StFeed.class);
  public final PBInt32Field from = PBField.initInt32(0);
  public final PBInt32Field source = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32 }, new String[] { "extInfo", "from", "feedIndex", "source" }, new Object[] { null, localInteger, null, localInteger }, StBatchGetFeedDetailReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     feedcloud.FeedCloudRead.StBatchGetFeedDetailReq
 * JD-Core Version:    0.7.0.1
 */