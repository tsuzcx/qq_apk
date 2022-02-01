package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FeedCloudMeta$StPushList
  extends MessageMicro<StPushList>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField busiData = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field count = PBField.initUInt32(0);
  public final PBUInt32Field hasClickCount = PBField.initUInt32(0);
  public final PBStringField id = PBField.initString("");
  public final PBStringField jumpUrl = PBField.initString("");
  public FeedCloudMeta.StUser postUser = new FeedCloudMeta.StUser();
  public final PBUInt32Field status = PBField.initUInt32(0);
  public final PBUInt32Field totalClickCount = PBField.initUInt32(0);
  public final PBRepeatMessageField<FeedCloudMeta.StUser> vecUser = PBField.initRepeatMessage(FeedCloudMeta.StUser.class);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42, 50, 56, 64, 74 }, new String[] { "id", "count", "status", "vecUser", "busiData", "postUser", "hasClickCount", "totalClickCount", "jumpUrl" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), null, localByteStringMicro, null, Integer.valueOf(0), Integer.valueOf(0), "" }, StPushList.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     feedcloud.FeedCloudMeta.StPushList
 * JD-Core Version:    0.7.0.1
 */