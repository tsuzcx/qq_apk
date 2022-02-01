package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class QQCircleSwitch$Cell_V2
  extends MessageMicro<Cell_V2>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBDoubleField dStationLat = PBField.initDouble(0.0D);
  public final PBDoubleField dStationLon = PBField.initDouble(0.0D);
  public final PBInt32Field iCellId = PBField.initInt32(0);
  public final PBInt32Field iLac = PBField.initInt32(0);
  public final PBInt32Field iRssi = PBField.initInt32(0);
  public final PBInt32Field shMcc = PBField.initInt32(0);
  public final PBInt32Field shMnc = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Double localDouble = Double.valueOf(0.0D);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 49, 57 }, new String[] { "shMcc", "shMnc", "iLac", "iCellId", "iRssi", "dStationLat", "dStationLon" }, new Object[] { localInteger, localInteger, localInteger, localInteger, localInteger, localDouble, localDouble }, Cell_V2.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleSwitch.Cell_V2
 * JD-Core Version:    0.7.0.1
 */