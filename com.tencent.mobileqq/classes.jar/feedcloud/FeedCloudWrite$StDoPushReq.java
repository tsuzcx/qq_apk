package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class FeedCloudWrite$StDoPushReq
  extends MessageMicro<StDoPushReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField busiReqData = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field comboCount = PBField.initInt32(0);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public FeedCloudMeta.StFeed feed = new FeedCloudMeta.StFeed();
  public final PBInt32Field from = PBField.initInt32(0);
  public FeedCloudMeta.StPushList push = new FeedCloudMeta.StPushList();
  public final PBInt32Field pushType = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40, 50, 56 }, new String[] { "extInfo", "feed", "comboCount", "push", "from", "busiReqData", "pushType" }, new Object[] { null, null, localInteger, null, localInteger, localByteStringMicro, localInteger }, StDoPushReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     feedcloud.FeedCloudWrite.StDoPushReq
 * JD-Core Version:    0.7.0.1
 */