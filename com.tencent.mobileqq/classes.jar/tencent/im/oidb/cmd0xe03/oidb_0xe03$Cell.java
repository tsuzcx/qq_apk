package tencent.im.oidb.cmd0xe03;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class oidb_0xe03$Cell
  extends MessageMicro<Cell>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field int32_cellid = PBField.initInt32(-1);
  public final PBInt32Field int32_lac = PBField.initInt32(-1);
  public final PBInt32Field int32_mcc = PBField.initInt32(-1);
  public final PBInt32Field int32_mnc = PBField.initInt32(-1);
  public final PBInt32Field int32_rssi = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(-1);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "int32_mcc", "int32_mnc", "int32_lac", "int32_cellid", "int32_rssi" }, new Object[] { localInteger, localInteger, localInteger, localInteger, Integer.valueOf(0) }, Cell.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe03.oidb_0xe03.Cell
 * JD-Core Version:    0.7.0.1
 */