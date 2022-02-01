package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FeedCloudRead$StGetRankingListRsp
  extends MessageMicro<StGetRankingListRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField busiRspData = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field endTime = PBField.initUInt32(0);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public FeedCloudMeta.StRankingItem hostUinRank = new FeedCloudMeta.StRankingItem();
  public final PBInt32Field isActiveRank = PBField.initInt32(0);
  public final PBRepeatMessageField<FeedCloudMeta.StRankingItem> items = PBField.initRepeatMessage(FeedCloudMeta.StRankingItem.class);
  public final PBUInt32Field startTime = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 50, 56 }, new String[] { "extInfo", "items", "startTime", "endTime", "busiRspData", "hostUinRank", "isActiveRank" }, new Object[] { null, null, localInteger, localInteger, localByteStringMicro, null, localInteger }, StGetRankingListRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     feedcloud.FeedCloudRead.StGetRankingListRsp
 * JD-Core Version:    0.7.0.1
 */