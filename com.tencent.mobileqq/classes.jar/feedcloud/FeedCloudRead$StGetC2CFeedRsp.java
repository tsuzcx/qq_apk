package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FeedCloudRead$StGetC2CFeedRsp
  extends MessageMicro<StGetC2CFeedRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField attchInfo = PBField.initString("");
  public final PBBytesField busiRspData = PBField.initBytes(ByteStringMicro.EMPTY);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public FeedCloudMeta.StShare share = new FeedCloudMeta.StShare();
  public final PBUInt32Field timeInterval = PBField.initUInt32(0);
  public final PBRepeatMessageField<FeedCloudMeta.StFeed> vecFeed = PBField.initRepeatMessage(FeedCloudMeta.StFeed.class);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42, 50 }, new String[] { "extInfo", "vecFeed", "timeInterval", "busiRspData", "attchInfo", "share" }, new Object[] { null, null, Integer.valueOf(0), localByteStringMicro, "", null }, StGetC2CFeedRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     feedcloud.FeedCloudRead.StGetC2CFeedRsp
 * JD-Core Version:    0.7.0.1
 */