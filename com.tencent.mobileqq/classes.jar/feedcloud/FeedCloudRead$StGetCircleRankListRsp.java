package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class FeedCloudRead$StGetCircleRankListRsp
  extends MessageMicro<StGetCircleRankListRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "extInfo", "rankList", "startTime", "endTime" }, new Object[] { null, null, Long.valueOf(0L), Long.valueOf(0L) }, StGetCircleRankListRsp.class);
  public final PBInt64Field endTime = PBField.initInt64(0L);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBRepeatMessageField<FeedCloudMeta.StCircleRankItem> rankList = PBField.initRepeatMessage(FeedCloudMeta.StCircleRankItem.class);
  public final PBInt64Field startTime = PBField.initInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     feedcloud.FeedCloudRead.StGetCircleRankListRsp
 * JD-Core Version:    0.7.0.1
 */