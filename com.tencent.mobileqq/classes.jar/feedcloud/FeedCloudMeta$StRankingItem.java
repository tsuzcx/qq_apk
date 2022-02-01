package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;

public final class FeedCloudMeta$StRankingItem
  extends MessageMicro<StRankingItem>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField busiData = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field grade = PBField.initInt32(0);
  public final PBInt32Field inTopicList = PBField.initInt32(0);
  public final PBInt32Field rankNo = PBField.initInt32(0);
  public FeedCloudMeta.StRelationInfo relation = new FeedCloudMeta.StRelationInfo();
  public final PBInt64Field score = PBField.initInt64(0L);
  public FeedCloudMeta.StUser user = new FeedCloudMeta.StUser();
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 48, 56 }, new String[] { "user", "relation", "score", "grade", "busiData", "rankNo", "inTopicList" }, new Object[] { null, null, Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, StRankingItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     feedcloud.FeedCloudMeta.StRankingItem
 * JD-Core Version:    0.7.0.1
 */