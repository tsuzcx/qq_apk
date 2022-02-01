package qqcircle;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import feedcloud.FeedCloudCommon.Result;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class TaskCenterWrite$FuelConsumeRsp
  extends MessageMicro<FuelConsumeRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField busiRspData = PBField.initBytes(ByteStringMicro.EMPTY);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public FeedCloudCommon.Result ret = new FeedCloudCommon.Result();
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "extInfo", "ret", "busiRspData" }, new Object[] { null, null, localByteStringMicro }, FuelConsumeRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.TaskCenterWrite.FuelConsumeRsp
 * JD-Core Version:    0.7.0.1
 */