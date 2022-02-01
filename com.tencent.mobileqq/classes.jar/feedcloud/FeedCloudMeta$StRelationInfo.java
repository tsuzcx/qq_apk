package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FeedCloudMeta$StRelationInfo
  extends MessageMicro<StRelationInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField busiData = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField id = PBField.initString("");
  public final PBUInt32Field relation = PBField.initUInt32(0);
  public final PBUInt32Field relationState = PBField.initUInt32(0);
  public final PBUInt32Field score = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40 }, new String[] { "id", "relation", "busiData", "relationState", "score" }, new Object[] { "", Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, StRelationInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     feedcloud.FeedCloudMeta.StRelationInfo
 * JD-Core Version:    0.7.0.1
 */