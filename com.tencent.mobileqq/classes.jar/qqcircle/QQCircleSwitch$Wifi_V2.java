package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleSwitch$Wifi_V2
  extends MessageMicro<Wifi_V2>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "strMac", "iRssi" }, new Object[] { "", Integer.valueOf(0) }, Wifi_V2.class);
  public final PBInt32Field iRssi = PBField.initInt32(0);
  public final PBStringField strMac = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleSwitch.Wifi_V2
 * JD-Core Version:    0.7.0.1
 */