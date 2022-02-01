package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class TaskCenterWrite$FuelProduceData
  extends MessageMicro<FuelProduceData>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField feedsid = PBField.initString("");
  public final PBStringField hostUid = PBField.initString("");
  public final PBUInt32Field optCnt = PBField.initUInt32(0);
  public final PBUInt32Field optTime = PBField.initUInt32(0);
  public final PBEnumField optType = PBField.initEnum(0);
  public final PBStringField srcuid = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42, 48 }, new String[] { "hostUid", "optTime", "optType", "feedsid", "srcuid", "optCnt" }, new Object[] { "", localInteger, localInteger, "", "", localInteger }, FuelProduceData.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.TaskCenterWrite.FuelProduceData
 * JD-Core Version:    0.7.0.1
 */