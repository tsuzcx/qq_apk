package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FeedCloudWrite$StDoFollowReq
  extends MessageMicro<StDoFollowReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public FeedCloudMeta.StFeed feed = new FeedCloudMeta.StFeed();
  public final PBInt32Field followMethod = PBField.initInt32(0);
  public final PBUInt32Field followType = PBField.initUInt32(0);
  public final PBInt32Field from = PBField.initInt32(0);
  public FeedCloudMeta.StUser user = new FeedCloudMeta.StUser();
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40, 50 }, new String[] { "extInfo", "followType", "user", "from", "followMethod", "feed" }, new Object[] { null, localInteger, null, localInteger, localInteger, null }, StDoFollowReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     feedcloud.FeedCloudWrite.StDoFollowReq
 * JD-Core Version:    0.7.0.1
 */