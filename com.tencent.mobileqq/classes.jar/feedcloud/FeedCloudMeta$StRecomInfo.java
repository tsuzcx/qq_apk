package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class FeedCloudMeta$StRecomInfo
  extends MessageMicro<StRecomInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField recomAttachInfo = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField recomReason = PBField.initString("");
  public final PBStringField recomTrace = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "recomReason", "recomAttachInfo", "recomTrace" }, new Object[] { "", localByteStringMicro, "" }, StRecomInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     feedcloud.FeedCloudMeta.StRecomInfo
 * JD-Core Version:    0.7.0.1
 */