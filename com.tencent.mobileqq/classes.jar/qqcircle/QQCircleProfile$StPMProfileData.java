package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQCircleProfile$StPMProfileData
  extends MessageMicro<StPMProfileData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "privilgetype", "fuelCost" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, StPMProfileData.class);
  public final PBUInt32Field fuelCost = PBField.initUInt32(0);
  public final PBEnumField privilgetype = PBField.initEnum(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     qqcircle.QQCircleProfile.StPMProfileData
 * JD-Core Version:    0.7.0.1
 */