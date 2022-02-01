package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class FeedCloudMeta$StFeed
  extends MessageMicro<StFeed>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField adBuffer = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField busiData = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField busiReport = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<FeedCloudCommon.BytesEntry> busiTranparent = PBField.initRepeatMessage(FeedCloudCommon.BytesEntry.class);
  public final PBUInt32Field commentCount = PBField.initUInt32(0);
  public final PBStringField content = PBField.initString("");
  public FeedCloudMeta.StImage cover = new FeedCloudMeta.StImage();
  public final PBUInt64Field createTime = PBField.initUInt64(0L);
  public FeedCloudMeta.StDittoFeed dittoFeed = new FeedCloudMeta.StDittoFeed();
  public final PBUInt32Field feedType = PBField.initUInt32(0);
  public final PBStringField id = PBField.initString("");
  public final PBRepeatMessageField<FeedCloudMeta.StImage> images = PBField.initRepeatMessage(FeedCloudMeta.StImage.class);
  public final PBBoolField isRecomFd = PBField.initBool(false);
  public FeedCloudMeta.StLike likeInfo = new FeedCloudMeta.StLike();
  public final PBRepeatField<Integer> opMask = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBRepeatField<Integer> opMask2 = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBBoolField orgFeedDeleted = PBField.initBool(false);
  public FeedCloudMeta.StPoiInfoV2 poiInfo = new FeedCloudMeta.StPoiInfoV2();
  public FeedCloudMeta.StUser poster = new FeedCloudMeta.StUser();
  public FeedCloudMeta.StRecomForward recomForward = new FeedCloudMeta.StRecomForward();
  public FeedCloudMeta.StRecomInfo recomInfo = new FeedCloudMeta.StRecomInfo();
  public final PBBytesField reportInfoForClient = PBField.initBytes(ByteStringMicro.EMPTY);
  public FeedCloudMeta.StShare share = new FeedCloudMeta.StShare();
  public final PBUInt32Field status = PBField.initUInt32(0);
  public final PBStringField subtitle = PBField.initString("");
  public final PBUInt32Field syncStatus = PBField.initUInt32(0);
  public final PBRepeatMessageField<FeedCloudMeta.StTagInfo> tagInfos = PBField.initRepeatMessage(FeedCloudMeta.StTagInfo.class);
  public final PBStringField title = PBField.initString("");
  public final PBUInt32Field type = PBField.initUInt32(0);
  public final PBRepeatMessageField<FeedCloudMeta.StComment> vecComment = PBField.initRepeatMessage(FeedCloudMeta.StComment.class);
  public FeedCloudMeta.StVideo video = new FeedCloudMeta.StVideo();
  public FeedCloudMeta.StVisitor visitorInfo = new FeedCloudMeta.StVisitor();
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 64, 72, 82, 88, 98, 106, 114, 122, 128, 138, 146, 154, 160, 170, 178, 184, 194, 202, 208, 218, 224, 234, 240, 250, 256 }, new String[] { "id", "title", "subtitle", "poster", "cover", "video", "content", "type", "createTime", "likeInfo", "commentCount", "vecComment", "share", "visitorInfo", "images", "status", "poiInfo", "adBuffer", "busiData", "isRecomFd", "recomForward", "tagInfos", "syncStatus", "busiReport", "dittoFeed", "feedType", "busiTranparent", "orgFeedDeleted", "recomInfo", "opMask", "reportInfoForClient", "opMask2" }, new Object[] { "", "", "", null, null, null, "", Integer.valueOf(0), Long.valueOf(0L), null, Integer.valueOf(0), null, null, null, null, Integer.valueOf(0), null, localByteStringMicro1, localByteStringMicro2, Boolean.valueOf(false), null, null, Integer.valueOf(0), localByteStringMicro3, null, Integer.valueOf(0), null, Boolean.valueOf(false), null, Integer.valueOf(0), localByteStringMicro4, Integer.valueOf(0) }, StFeed.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     feedcloud.FeedCloudMeta.StFeed
 * JD-Core Version:    0.7.0.1
 */