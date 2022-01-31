package tencent.im.oidb.cmd0x8dd;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class oidb_0x8dd$Location
  extends MessageMicro<Location>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "int32_latitude", "int32_longitude", "int32_coordinate" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, Location.class);
  public final PBInt32Field int32_coordinate = PBField.initInt32(0);
  public final PBInt32Field int32_latitude = PBField.initInt32(0);
  public final PBInt32Field int32_longitude = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8dd.oidb_0x8dd.Location
 * JD-Core Version:    0.7.0.1
 */