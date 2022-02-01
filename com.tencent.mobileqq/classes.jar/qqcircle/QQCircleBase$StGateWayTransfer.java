package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

public final class QQCircleBase$StGateWayTransfer
  extends MessageMicro<StGateWayTransfer>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt64Field reqBeginTime = PBField.initInt64(0L);
  public final PBInt64Field reqCost = PBField.initInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "reqBeginTime", "reqCost" }, new Object[] { localLong, localLong }, StGateWayTransfer.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleBase.StGateWayTransfer
 * JD-Core Version:    0.7.0.1
 */