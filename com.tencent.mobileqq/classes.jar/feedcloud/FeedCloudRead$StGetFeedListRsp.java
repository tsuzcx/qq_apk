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

public final class FeedCloudRead$StGetFeedListRsp
  extends MessageMicro<StGetFeedListRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField adAttchInfo = PBField.initString("");
  public final PBBytesField busiRspData = PBField.initBytes(ByteStringMicro.EMPTY);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBStringField feedAttchInfo = PBField.initString("");
  public final PBUInt32Field isFinish = PBField.initUInt32(0);
  public final PBBoolField isFirstLogin = PBField.initBool(false);
  public FeedCloudMeta.StUser user = new FeedCloudMeta.StUser();
  public final PBRepeatMessageField<FeedCloudMeta.StFeed> vecFeed = PBField.initRepeatMessage(FeedCloudMeta.StFeed.class);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42, 50, 58, 64 }, new String[] { "extInfo", "vecFeed", "isFinish", "user", "adAttchInfo", "feedAttchInfo", "busiRspData", "isFirstLogin" }, new Object[] { null, null, Integer.valueOf(0), null, "", "", localByteStringMicro, Boolean.valueOf(false) }, StGetFeedListRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     feedcloud.FeedCloudRead.StGetFeedListRsp
 * JD-Core Version:    0.7.0.1
 */