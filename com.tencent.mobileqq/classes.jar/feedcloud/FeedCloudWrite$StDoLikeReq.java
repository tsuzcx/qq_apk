package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FeedCloudWrite$StDoLikeReq
  extends MessageMicro<StDoLikeReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField busiReqData = PBField.initBytes(ByteStringMicro.EMPTY);
  public FeedCloudMeta.StComment comment = new FeedCloudMeta.StComment();
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public FeedCloudMeta.StFeed feed = new FeedCloudMeta.StFeed();
  public FeedCloudMeta.StLike like = new FeedCloudMeta.StLike();
  public final PBUInt32Field likeType = PBField.initUInt32(0);
  public FeedCloudMeta.StReply reply = new FeedCloudMeta.StReply();
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42, 50, 58 }, new String[] { "extInfo", "likeType", "like", "feed", "busiReqData", "comment", "reply" }, new Object[] { null, Integer.valueOf(0), null, null, localByteStringMicro, null, null }, StDoLikeReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     feedcloud.FeedCloudWrite.StDoLikeReq
 * JD-Core Version:    0.7.0.1
 */