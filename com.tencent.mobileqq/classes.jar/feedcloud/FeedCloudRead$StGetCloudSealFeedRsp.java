package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class FeedCloudRead$StGetCloudSealFeedRsp
  extends MessageMicro<StGetCloudSealFeedRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField attachInfo = PBField.initString("");
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBBytesField sealClientInfo = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<FeedCloudMeta.StFeed> sealFeeds = PBField.initRepeatMessage(FeedCloudMeta.StFeed.class);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "extInfo", "sealFeeds", "attachInfo", "sealClientInfo" }, new Object[] { null, null, "", localByteStringMicro }, StGetCloudSealFeedRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     feedcloud.FeedCloudRead.StGetCloudSealFeedRsp
 * JD-Core Version:    0.7.0.1
 */