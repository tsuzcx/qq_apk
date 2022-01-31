package tencent.im.oidb.cmd0xa2a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class oidb_0xa2a$Cell
  extends MessageMicro<Cell>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "int32_mobile_country_code", "int32_mobile_network_code", "int32_location_area_code", "int32_cell_id", "int32_rssi" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, Cell.class);
  public final PBInt32Field int32_cell_id = PBField.initInt32(0);
  public final PBInt32Field int32_location_area_code = PBField.initInt32(0);
  public final PBInt32Field int32_mobile_country_code = PBField.initInt32(0);
  public final PBInt32Field int32_mobile_network_code = PBField.initInt32(0);
  public final PBInt32Field int32_rssi = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xa2a.oidb_0xa2a.Cell
 * JD-Core Version:    0.7.0.1
 */