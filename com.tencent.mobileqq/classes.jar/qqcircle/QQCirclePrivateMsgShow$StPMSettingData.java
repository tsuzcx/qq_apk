package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQCirclePrivateMsgShow$StPMSettingData
  extends MessageMicro<StPMSettingData>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field fuelCost = PBField.initUInt32(0);
  public final PBEnumField privilgetype = PBField.initEnum(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "privilgetype", "fuelCost" }, new Object[] { localInteger, localInteger }, StPMSettingData.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCirclePrivateMsgShow.StPMSettingData
 * JD-Core Version:    0.7.0.1
 */