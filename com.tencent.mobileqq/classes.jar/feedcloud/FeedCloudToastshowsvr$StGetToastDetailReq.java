package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class FeedCloudToastshowsvr$StGetToastDetailReq
  extends MessageMicro<StGetToastDetailReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField busiReqData = PBField.initBytes(ByteStringMicro.EMPTY);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBStringField toastId = PBField.initString("");
  public final PBStringField userId = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "extInfo", "userId", "toastId", "busiReqData" }, new Object[] { null, "", "", localByteStringMicro }, StGetToastDetailReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     feedcloud.FeedCloudToastshowsvr.StGetToastDetailReq
 * JD-Core Version:    0.7.0.1
 */