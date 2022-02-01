package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class FeedCloudWrite$StDoBuyReq
  extends MessageMicro<StDoBuyReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field amount = PBField.initInt32(0);
  public final PBBytesField busiReqData = PBField.initBytes(ByteStringMicro.EMPTY);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBStringField giftID = PBField.initString("");
  public final PBInt32Field giftType = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42 }, new String[] { "extInfo", "giftID", "amount", "giftType", "busiReqData" }, new Object[] { null, "", localInteger, localInteger, localByteStringMicro }, StDoBuyReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     feedcloud.FeedCloudWrite.StDoBuyReq
 * JD-Core Version:    0.7.0.1
 */