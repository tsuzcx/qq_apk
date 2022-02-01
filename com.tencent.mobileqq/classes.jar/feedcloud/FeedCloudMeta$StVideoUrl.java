package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FeedCloudMeta$StVideoUrl
  extends MessageMicro<StVideoUrl>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField busiData = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBoolField hasWatermark = PBField.initBool(false);
  public final PBUInt32Field levelType = PBField.initUInt32(0);
  public final PBStringField playUrl = PBField.initString("");
  public final PBUInt32Field transStatus = PBField.initUInt32(0);
  public final PBUInt32Field videoPrior = PBField.initUInt32(0);
  public final PBUInt32Field videoRate = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 50, 56 }, new String[] { "levelType", "playUrl", "videoPrior", "videoRate", "transStatus", "busiData", "hasWatermark" }, new Object[] { localInteger, "", localInteger, localInteger, localInteger, localByteStringMicro, Boolean.valueOf(false) }, StVideoUrl.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     feedcloud.FeedCloudMeta.StVideoUrl
 * JD-Core Version:    0.7.0.1
 */