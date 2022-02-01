package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class QQCircleSwitch$LBSData
  extends MessageMicro<LBSData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "stCommon", "stGps", "vCellData", "vWifiData" }, new Object[] { null, null, null, null }, LBSData.class);
  public QQCircleSwitch.ReqCommon_V2 stCommon = new QQCircleSwitch.ReqCommon_V2();
  public QQCircleSwitch.GPS_V2 stGps = new QQCircleSwitch.GPS_V2();
  public final PBRepeatMessageField<QQCircleSwitch.Cell_V2> vCellData = PBField.initRepeatMessage(QQCircleSwitch.Cell_V2.class);
  public final PBRepeatMessageField<QQCircleSwitch.Wifi_V2> vWifiData = PBField.initRepeatMessage(QQCircleSwitch.Wifi_V2.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleSwitch.LBSData
 * JD-Core Version:    0.7.0.1
 */