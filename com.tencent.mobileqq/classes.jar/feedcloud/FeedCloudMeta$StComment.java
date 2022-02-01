package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class FeedCloudMeta$StComment
  extends MessageMicro<StComment>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatField<String> atUinList = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBBytesField busiData = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField content = PBField.initString("");
  public final PBUInt64Field createTime = PBField.initUInt64(0L);
  public final PBUInt64Field createTimeNs = PBField.initUInt64(0L);
  public final PBStringField id = PBField.initString("");
  public FeedCloudMeta.StLike likeInfo = new FeedCloudMeta.StLike();
  public FeedCloudMeta.StUser postUser = new FeedCloudMeta.StUser();
  public final PBUInt32Field replyCount = PBField.initUInt32(0);
  public final PBRepeatMessageField<FeedCloudCommon.Entry> storeExtInfo = PBField.initRepeatMessage(FeedCloudCommon.Entry.class);
  public final PBStringField thirdId = PBField.initString("");
  public final PBUInt32Field typeFlag = PBField.initUInt32(0);
  public final PBUInt32Field typeFlag2 = PBField.initUInt32(0);
  public final PBRepeatMessageField<FeedCloudMeta.StReply> vecReply = PBField.initRepeatMessage(FeedCloudMeta.StReply.class);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40, 50, 58, 66, 72, 82, 88, 96, 106, 114 }, new String[] { "id", "postUser", "createTime", "content", "replyCount", "vecReply", "busiData", "likeInfo", "typeFlag", "atUinList", "typeFlag2", "createTimeNs", "storeExtInfo", "thirdId" }, new Object[] { "", null, Long.valueOf(0L), "", localInteger, null, localByteStringMicro, null, localInteger, "", localInteger, Long.valueOf(0L), null, "" }, StComment.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     feedcloud.FeedCloudMeta.StComment
 * JD-Core Version:    0.7.0.1
 */