package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class FeedCloudMeta$StUserRecomInfo
  extends MessageMicro<StUserRecomInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "user", "feedList" }, new Object[] { null, null }, StUserRecomInfo.class);
  public final PBRepeatMessageField<FeedCloudMeta.StFeedAbstract> feedList = PBField.initRepeatMessage(FeedCloudMeta.StFeedAbstract.class);
  public FeedCloudMeta.StUser user = new FeedCloudMeta.StUser();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     feedcloud.FeedCloudMeta.StUserRecomInfo
 * JD-Core Version:    0.7.0.1
 */