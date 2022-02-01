package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class FeedCloudMeta$StFollowRecomInfo
  extends MessageMicro<StFollowRecomInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 34, 50, 58 }, new String[] { "followText", "followUsers", "commFriendText", "commGroupText" }, new Object[] { "", null, "", "" }, StFollowRecomInfo.class);
  public final PBStringField commFriendText = PBField.initString("");
  public final PBStringField commGroupText = PBField.initString("");
  public final PBStringField followText = PBField.initString("");
  public final PBRepeatMessageField<FeedCloudMeta.StFollowUser> followUsers = PBField.initRepeatMessage(FeedCloudMeta.StFollowUser.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     feedcloud.FeedCloudMeta.StFollowRecomInfo
 * JD-Core Version:    0.7.0.1
 */