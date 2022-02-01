package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class FeedCloudMeta$StUserRecomInfo
  extends MessageMicro<StUserRecomInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField busiData = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<FeedCloudMeta.StFeedAbstract> feedList = PBField.initRepeatMessage(FeedCloudMeta.StFeedAbstract.class);
  public FeedCloudMeta.StUser user = new FeedCloudMeta.StUser();
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "user", "feedList", "busiData" }, new Object[] { null, null, localByteStringMicro }, StUserRecomInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     feedcloud.FeedCloudMeta.StUserRecomInfo
 * JD-Core Version:    0.7.0.1
 */