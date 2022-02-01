package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FeedCloudMeta$StDittoFeed
  extends MessageMicro<StDittoFeed>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField dittoData = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField dittoDataNew = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field dittoId = PBField.initUInt32(0);
  public final PBUInt32Field dittoPatternId = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "dittoId", "dittoPatternId", "dittoData", "dittoDataNew" }, new Object[] { localInteger, localInteger, localByteStringMicro1, localByteStringMicro2 }, StDittoFeed.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     feedcloud.FeedCloudMeta.StDittoFeed
 * JD-Core Version:    0.7.0.1
 */