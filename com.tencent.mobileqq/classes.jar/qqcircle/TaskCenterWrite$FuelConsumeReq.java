package qqcircle;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class TaskCenterWrite$FuelConsumeReq
  extends MessageMicro<FuelConsumeReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBEnumField behaviorType = PBField.initEnum(0);
  public final PBBytesField busiReqData = PBField.initBytes(ByteStringMicro.EMPTY);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "extInfo", "behaviorType", "busiReqData" }, new Object[] { null, Integer.valueOf(0), localByteStringMicro }, FuelConsumeReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qqcircle.TaskCenterWrite.FuelConsumeReq
 * JD-Core Version:    0.7.0.1
 */