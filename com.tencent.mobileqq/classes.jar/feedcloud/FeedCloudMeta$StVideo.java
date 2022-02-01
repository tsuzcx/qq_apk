package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FeedCloudMeta$StVideo
  extends MessageMicro<StVideo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field approvalStatus = PBField.initUInt32(0);
  public final PBBytesField busiData = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field duration = PBField.initUInt32(0);
  public final PBStringField fileId = PBField.initString("");
  public final PBUInt32Field fileSize = PBField.initUInt32(0);
  public final PBUInt32Field height = PBField.initUInt32(0);
  public final PBUInt32Field mediaQualityRank = PBField.initUInt32(0);
  public final PBFloatField mediaQualityScore = PBField.initFloat(0.0F);
  public final PBStringField playUrl = PBField.initString("");
  public final PBUInt32Field transStatus = PBField.initUInt32(0);
  public final PBRepeatMessageField<FeedCloudMeta.StVideoUrl> vecVideoUrl = PBField.initRepeatMessage(FeedCloudMeta.StVideoUrl.class);
  public final PBUInt32Field videoPrior = PBField.initUInt32(0);
  public final PBUInt32Field videoRate = PBField.initUInt32(0);
  public final PBUInt32Field videoSource = PBField.initUInt32(0);
  public final PBUInt32Field width = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 50, 56, 64, 72, 82, 90, 96, 104, 112, 125 }, new String[] { "fileId", "fileSize", "duration", "width", "height", "playUrl", "transStatus", "videoPrior", "videoRate", "vecVideoUrl", "busiData", "approvalStatus", "videoSource", "mediaQualityRank", "mediaQualityScore" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Float.valueOf(0.0F) }, StVideo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     feedcloud.FeedCloudMeta.StVideo
 * JD-Core Version:    0.7.0.1
 */