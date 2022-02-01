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
  public final PBBytesField clientSealData = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField recomAttachInfo = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField recomReason = PBField.initString("");
  public final PBStringField recomTrace = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "recomReason", "recomAttachInfo", "recomTrace", "clientSealData" }, new Object[] { "", localByteStringMicro1, "", localByteStringMicro2 }, StRecomInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     feedcloud.FeedCloudMeta.StRecomInfo
 * JD-Core Version:    0.7.0.1
 */