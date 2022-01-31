package tencent.im.oidb.cmd0x7b4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x7b4$POIInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42 }, new String[] { "uint64_poi_id", "int32_lat", "int32_lon", "rpt_taskstatus_info", "rpt_control_point_info" }, new Object[] { Long.valueOf(0L), Integer.valueOf(900000000), Integer.valueOf(900000000), null, null }, POIInfo.class);
  public final PBInt32Field int32_lat = PBField.initInt32(900000000);
  public final PBInt32Field int32_lon = PBField.initInt32(900000000);
  public final PBRepeatMessageField rpt_control_point_info = PBField.initRepeatMessage(cmd0x7b4.ControlPointInfo.class);
  public final PBRepeatMessageField rpt_taskstatus_info = PBField.initRepeatMessage(cmd0x7b4.TaskStatusInfo.class);
  public final PBUInt64Field uint64_poi_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7b4.cmd0x7b4.POIInfo
 * JD-Core Version:    0.7.0.1
 */