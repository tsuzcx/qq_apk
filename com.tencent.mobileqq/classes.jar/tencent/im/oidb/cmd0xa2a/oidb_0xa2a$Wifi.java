package tencent.im.oidb.cmd0xa2a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;

public final class oidb_0xa2a$Wifi
  extends MessageMicro<Wifi>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "int64_mac", "int32_rssi" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, Wifi.class);
  public final PBInt32Field int32_rssi = PBField.initInt32(0);
  public final PBInt64Field int64_mac = PBField.initInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0xa2a.oidb_0xa2a.Wifi
 * JD-Core Version:    0.7.0.1
 */