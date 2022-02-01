package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FeedCloudWrite$StDoLikeReq
  extends MessageMicro<StDoLikeReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField busiReqData = PBField.initBytes(ByteStringMicro.EMPTY);
  public FeedCloudMeta.StComment comment = new FeedCloudMeta.StComment();
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public FeedCloudMeta.StFeed feed = new FeedCloudMeta.StFeed();
  public final PBInt32Field from = PBField.initInt32(0);
  public FeedCloudMeta.StLike like = new FeedCloudMeta.StLike();
  public final PBUInt32Field likeType = PBField.initUInt32(0);
  public FeedCloudMeta.StReply reply = new FeedCloudMeta.StReply();
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42, 50, 58, 64 }, new String[] { "extInfo", "likeType", "like", "feed", "busiReqData", "comment", "reply", "from" }, new Object[] { null, localInteger, null, null, localByteStringMicro, null, null, localInteger }, StDoLikeReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     feedcloud.FeedCloudWrite.StDoLikeReq
 * JD-Core Version:    0.7.0.1
 */