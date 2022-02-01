package tencent.im.lbs;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class member_lbs$Cell
  extends MessageMicro<Cell>
{
  public static final int INT32_CELL_ID_FIELD_NUMBER = 4;
  public static final int INT32_LOCATION_AREA_CODE_FIELD_NUMBER = 3;
  public static final int INT32_MOBILE_COUNTRY_CODE_FIELD_NUMBER = 1;
  public static final int INT32_MOBILE_NETWORK_CODE_FIELD_NUMBER = 2;
  public static final int INT32_RSSI_FIELD_NUMBER = 5;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field int32_cell_id = PBField.initInt32(0);
  public final PBInt32Field int32_location_area_code = PBField.initInt32(0);
  public final PBInt32Field int32_mobile_country_code = PBField.initInt32(0);
  public final PBInt32Field int32_mobile_network_code = PBField.initInt32(0);
  public final PBInt32Field int32_rssi = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "int32_mobile_country_code", "int32_mobile_network_code", "int32_location_area_code", "int32_cell_id", "int32_rssi" }, new Object[] { localInteger, localInteger, localInteger, localInteger, localInteger }, Cell.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.lbs.member_lbs.Cell
 * JD-Core Version:    0.7.0.1
 */