package tencent.im.oidb.cmd0xafc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class cmd0xafc$Location
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "int32_lat", "int32_lon", "int32_coo" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, Location.class);
  public final PBInt32Field int32_coo = PBField.initInt32(0);
  public final PBInt32Field int32_lat = PBField.initInt32(0);
  public final PBInt32Field int32_lon = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0xafc.cmd0xafc.Location
 * JD-Core Version:    0.7.0.1
 */