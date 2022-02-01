package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class FeedCloudMeta$StOperation
  extends MessageMicro<StOperation>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField busiData = PBField.initBytes(ByteStringMicro.EMPTY);
  public FeedCloudMeta.StComment comment = new FeedCloudMeta.StComment();
  public FeedCloudMeta.StLike like = new FeedCloudMeta.StLike();
  public final PBUInt64Field opTime = PBField.initUInt64(0L);
  public final PBUInt32Field opType = PBField.initUInt32(0);
  public FeedCloudMeta.StUser opUser = new FeedCloudMeta.StUser();
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42, 50 }, new String[] { "opType", "opUser", "opTime", "comment", "like", "busiData" }, new Object[] { Integer.valueOf(0), null, Long.valueOf(0L), null, null, localByteStringMicro }, StOperation.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     feedcloud.FeedCloudMeta.StOperation
 * JD-Core Version:    0.7.0.1
 */