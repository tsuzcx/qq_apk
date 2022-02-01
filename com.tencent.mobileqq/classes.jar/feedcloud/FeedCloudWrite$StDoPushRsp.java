package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FeedCloudWrite$StDoPushRsp
  extends MessageMicro<StDoPushRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField busiRspData = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field cancelPushStatus = PBField.initUInt32(0);
  public final PBUInt32Field consumeFuel = PBField.initUInt32(0);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBUInt32Field myFuel = PBField.initUInt32(0);
  public final PBInt32Field pushedCnt = PBField.initInt32(0);
  public final PBUInt32Field returnFuel = PBField.initUInt32(0);
  public final PBUInt32Field totalCnt = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 40, 48, 56, 64 }, new String[] { "extInfo", "consumeFuel", "myFuel", "busiRspData", "returnFuel", "totalCnt", "cancelPushStatus", "pushedCnt" }, new Object[] { null, localInteger, localInteger, localByteStringMicro, localInteger, localInteger, localInteger, localInteger }, StDoPushRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     feedcloud.FeedCloudWrite.StDoPushRsp
 * JD-Core Version:    0.7.0.1
 */