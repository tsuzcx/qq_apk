package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FeedCloudRead$StGetMainPageRsp
  extends MessageMicro<StGetMainPageRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField busiRspData = PBField.initBytes(ByteStringMicro.EMPTY);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBUInt32Field fansCount = PBField.initUInt32(0);
  public final PBUInt32Field fansValueStyle = PBField.initUInt32(0);
  public final PBStringField feedAttchInfo = PBField.initString("");
  public final PBUInt32Field feedCount = PBField.initUInt32(0);
  public final PBUInt32Field followCount = PBField.initUInt32(0);
  public FeedCloudMeta.StFollowRecomInfo followRecomInfo = new FeedCloudMeta.StFollowRecomInfo();
  public FeedCloudMeta.StGuidePublishBubble guidePublishBubble = new FeedCloudMeta.StGuidePublishBubble();
  public final PBUInt32Field isFinish = PBField.initUInt32(0);
  public final PBBoolField isFirstLogin = PBField.initBool(false);
  public final PBUInt32Field isPenguinUser = PBField.initUInt32(0);
  public final PBUInt32Field likedFeedCount = PBField.initUInt32(0);
  public final PBUInt32Field likedNum = PBField.initUInt32(0);
  public FeedCloudMeta.StExternalMedalWallInfo medalWall = new FeedCloudMeta.StExternalMedalWallInfo();
  public final PBStringField pmBeginShow = PBField.initString("");
  public final PBUInt32Field pushRocketCount = PBField.initUInt32(0);
  public FeedCloudMeta.StShare share = new FeedCloudMeta.StShare();
  public FeedCloudMeta.StUser user = new FeedCloudMeta.StUser();
  public final PBRepeatMessageField<FeedCloudMeta.StFeed> vecFeed = PBField.initRepeatMessage(FeedCloudMeta.StFeed.class);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 50, 56, 66, 74, 82, 90, 96, 106, 112, 120, 130, 138, 144, 152, 160 }, new String[] { "extInfo", "user", "feedCount", "fansCount", "followCount", "vecFeed", "isFinish", "share", "feedAttchInfo", "busiRspData", "pmBeginShow", "fansValueStyle", "guidePublishBubble", "isFirstLogin", "pushRocketCount", "followRecomInfo", "medalWall", "likedNum", "likedFeedCount", "isPenguinUser" }, new Object[] { null, null, localInteger, localInteger, localInteger, null, localInteger, null, "", localByteStringMicro, "", localInteger, null, Boolean.valueOf(false), localInteger, null, null, localInteger, localInteger, localInteger }, StGetMainPageRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     feedcloud.FeedCloudRead.StGetMainPageRsp
 * JD-Core Version:    0.7.0.1
 */