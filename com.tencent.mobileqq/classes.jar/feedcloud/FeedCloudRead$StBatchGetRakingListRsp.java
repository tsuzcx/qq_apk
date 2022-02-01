package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class FeedCloudRead$StBatchGetRakingListRsp
  extends MessageMicro<StBatchGetRakingListRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "singleRsp" }, new Object[] { null, null }, StBatchGetRakingListRsp.class);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBRepeatMessageField<FeedCloudRead.StGetRankingListRsp> singleRsp = PBField.initRepeatMessage(FeedCloudRead.StGetRankingListRsp.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     feedcloud.FeedCloudRead.StBatchGetRakingListRsp
 * JD-Core Version:    0.7.0.1
 */