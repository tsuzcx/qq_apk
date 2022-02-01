package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FeedCloudMeta$StTagInfo
  extends MessageMicro<StTagInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48, 56, 66, 72, 80, 90, 96, 104, 794 }, new String[] { "tagId", "tagName", "tagDec", "userList", "feedList", "tagTotalUser", "tagTotalFeed", "tagWording", "tagType", "followState", "shareInfo", "isTop", "isSelected", "tagReport" }, new Object[] { "", "", "", null, null, Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), "" }, StTagInfo.class);
  public final PBRepeatMessageField<FeedCloudMeta.StFeedAbstract> feedList = PBField.initRepeatMessage(FeedCloudMeta.StFeedAbstract.class);
  public final PBUInt32Field followState = PBField.initUInt32(0);
  public final PBUInt32Field isSelected = PBField.initUInt32(0);
  public final PBUInt32Field isTop = PBField.initUInt32(0);
  public FeedCloudMeta.StShare shareInfo = new FeedCloudMeta.StShare();
  public final PBStringField tagDec = PBField.initString("");
  public final PBStringField tagId = PBField.initString("");
  public final PBStringField tagName = PBField.initString("");
  public final PBStringField tagReport = PBField.initString("");
  public final PBUInt32Field tagTotalFeed = PBField.initUInt32(0);
  public final PBUInt32Field tagTotalUser = PBField.initUInt32(0);
  public final PBUInt32Field tagType = PBField.initUInt32(0);
  public final PBStringField tagWording = PBField.initString("");
  public final PBRepeatMessageField<FeedCloudMeta.StUser> userList = PBField.initRepeatMessage(FeedCloudMeta.StUser.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     feedcloud.FeedCloudMeta.StTagInfo
 * JD-Core Version:    0.7.0.1
 */