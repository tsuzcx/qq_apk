package tencent.im.oidb.cmd0xc46;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class oidb_cmd0xc46$RptData
  extends MessageMicro<RptData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "data_type", "at_data", "herf_data", "text_data" }, new Object[] { Integer.valueOf(0), null, null, null }, RptData.class);
  public oidb_cmd0xc46.AtData at_data = new oidb_cmd0xc46.AtData();
  public final PBInt32Field data_type = PBField.initInt32(0);
  public oidb_cmd0xc46.HerfData herf_data = new oidb_cmd0xc46.HerfData();
  public oidb_cmd0xc46.TextData text_data = new oidb_cmd0xc46.TextData();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.RptData
 * JD-Core Version:    0.7.0.1
 */