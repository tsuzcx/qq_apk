package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQCirclePrivateMsgShow$StPMSettingData
  extends MessageMicro<StPMSettingData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "privilgetype", "fuelCost" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, StPMSettingData.class);
  public final PBUInt32Field fuelCost = PBField.initUInt32(0);
  public final PBEnumField privilgetype = PBField.initEnum(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qqcircle.QQCirclePrivateMsgShow.StPMSettingData
 * JD-Core Version:    0.7.0.1
 */