package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FeedCloudMeta$StImage
  extends MessageMicro<StImage>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField busiData = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field height = PBField.initUInt32(0);
  public final PBStringField imageMD5 = PBField.initString("");
  public final PBStringField layerPicUrl = PBField.initString("");
  public final PBStringField picId = PBField.initString("");
  public final PBStringField picUrl = PBField.initString("");
  public final PBRepeatMessageField<FeedCloudMeta.StImageUrl> vecImageUrl = PBField.initRepeatMessage(FeedCloudMeta.StImageUrl.class);
  public final PBUInt32Field width = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 58, 66 }, new String[] { "width", "height", "picUrl", "vecImageUrl", "picId", "busiData", "imageMD5", "layerPicUrl" }, new Object[] { localInteger, localInteger, "", null, "", localByteStringMicro, "", "" }, StImage.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     feedcloud.FeedCloudMeta.StImage
 * JD-Core Version:    0.7.0.1
 */