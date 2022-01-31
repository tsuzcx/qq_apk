package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class FeedCloudMeta$StNotice
  extends MessageMicro<StNotice>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField busiData = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field createTime = PBField.initUInt64(0L);
  public FeedCloudMeta.StFeed feed = new FeedCloudMeta.StFeed();
  public final PBStringField feedId = PBField.initString("");
  public final PBStringField message = PBField.initString("");
  public final PBUInt32Field noticeType = PBField.initUInt32(0);
  public FeedCloudMeta.StOperation operation = new FeedCloudMeta.StOperation();
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42, 50, 58 }, new String[] { "feedId", "noticeType", "createTime", "operation", "feed", "busiData", "message" }, new Object[] { "", Integer.valueOf(0), Long.valueOf(0L), null, null, localByteStringMicro, "" }, StNotice.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     feedcloud.FeedCloudMeta.StNotice
 * JD-Core Version:    0.7.0.1
 */