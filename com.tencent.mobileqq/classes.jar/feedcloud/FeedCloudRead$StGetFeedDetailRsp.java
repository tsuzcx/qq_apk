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

public final class FeedCloudRead$StGetFeedDetailRsp
  extends MessageMicro<StGetFeedDetailRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField adAttchInfo = PBField.initString("");
  public final PBBytesField busiRspData = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField detailUrl = PBField.initString("");
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public FeedCloudMeta.StFeed feed = new FeedCloudMeta.StFeed();
  public final PBUInt32Field isFinish = PBField.initUInt32(0);
  public final PBBoolField isFirstLogin = PBField.initBool(false);
  public FeedCloudMeta.StShare share = new FeedCloudMeta.StShare();
  public final PBRepeatMessageField<FeedCloudMeta.StFeed> vecRcmdFeed = PBField.initRepeatMessage(FeedCloudMeta.StFeed.class);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48, 58, 66, 72 }, new String[] { "extInfo", "detailUrl", "feed", "vecRcmdFeed", "share", "isFinish", "adAttchInfo", "busiRspData", "isFirstLogin" }, new Object[] { null, "", null, null, null, Integer.valueOf(0), "", localByteStringMicro, Boolean.valueOf(false) }, StGetFeedDetailRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     feedcloud.FeedCloudRead.StGetFeedDetailRsp
 * JD-Core Version:    0.7.0.1
 */