package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FeedCloudMeta$StLightInteractInfo
  extends MessageMicro<StLightInteractInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField busiData = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field count = PBField.initUInt32(0);
  public FeedCloudMeta.StRelationInfo relation = new FeedCloudMeta.StRelationInfo();
  public FeedCloudMeta.StUser user = new FeedCloudMeta.StUser();
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "user", "relation", "count", "busiData" }, new Object[] { null, null, Integer.valueOf(0), localByteStringMicro }, StLightInteractInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     feedcloud.FeedCloudMeta.StLightInteractInfo
 * JD-Core Version:    0.7.0.1
 */