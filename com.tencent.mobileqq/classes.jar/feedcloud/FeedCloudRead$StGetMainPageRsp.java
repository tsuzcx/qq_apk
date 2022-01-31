package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FeedCloudRead$StGetMainPageRsp
  extends MessageMicro<StGetMainPageRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField busiRspData = PBField.initBytes(ByteStringMicro.EMPTY);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBUInt32Field fansCount = PBField.initUInt32(0);
  public final PBStringField feedAttchInfo = PBField.initString("");
  public final PBUInt32Field feedCount = PBField.initUInt32(0);
  public final PBUInt32Field followCount = PBField.initUInt32(0);
  public final PBUInt32Field isFinish = PBField.initUInt32(0);
  public FeedCloudMeta.StShare share = new FeedCloudMeta.StShare();
  public FeedCloudMeta.StUser user = new FeedCloudMeta.StUser();
  public final PBRepeatMessageField<FeedCloudMeta.StFeed> vecFeed = PBField.initRepeatMessage(FeedCloudMeta.StFeed.class);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 50, 56, 66, 74, 82 }, new String[] { "extInfo", "user", "feedCount", "fansCount", "followCount", "vecFeed", "isFinish", "share", "feedAttchInfo", "busiRspData" }, new Object[] { null, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), null, "", localByteStringMicro }, StGetMainPageRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     feedcloud.FeedCloudRead.StGetMainPageRsp
 * JD-Core Version:    0.7.0.1
 */