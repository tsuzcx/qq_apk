package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class FeedCloudRead$StGetCircleRankListRsp
  extends MessageMicro<StGetCircleRankListRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt64Field endTime = PBField.initInt64(0L);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBRepeatMessageField<FeedCloudMeta.StCircleRankItem> rankList = PBField.initRepeatMessage(FeedCloudMeta.StCircleRankItem.class);
  public final PBInt64Field startTime = PBField.initInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "extInfo", "rankList", "startTime", "endTime" }, new Object[] { null, null, localLong, localLong }, StGetCircleRankListRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     feedcloud.FeedCloudRead.StGetCircleRankListRsp
 * JD-Core Version:    0.7.0.1
 */