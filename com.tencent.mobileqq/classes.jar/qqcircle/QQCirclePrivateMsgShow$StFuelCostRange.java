package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQCirclePrivateMsgShow$StFuelCostRange
  extends MessageMicro<StFuelCostRange>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field max = PBField.initUInt32(0);
  public final PBUInt32Field min = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "min", "max" }, new Object[] { localInteger, localInteger }, StFuelCostRange.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCirclePrivateMsgShow.StFuelCostRange
 * JD-Core Version:    0.7.0.1
 */