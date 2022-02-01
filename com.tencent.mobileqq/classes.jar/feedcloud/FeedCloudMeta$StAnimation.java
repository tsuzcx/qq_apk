package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FeedCloudMeta$StAnimation
  extends MessageMicro<StAnimation>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField animationUrl = PBField.initString("");
  public final PBBytesField busiData = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field height = PBField.initUInt32(0);
  public final PBUInt32Field width = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "width", "height", "animationUrl", "busiData" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", localByteStringMicro }, StAnimation.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     feedcloud.FeedCloudMeta.StAnimation
 * JD-Core Version:    0.7.0.1
 */