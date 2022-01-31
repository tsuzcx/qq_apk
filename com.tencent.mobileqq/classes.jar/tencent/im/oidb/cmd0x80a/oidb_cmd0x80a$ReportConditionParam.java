package tencent.im.oidb.cmd0x80a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x80a$ReportConditionParam
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_event_id", "uint32_report_next_time", "report_time_seg" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, ReportConditionParam.class);
  public final PBRepeatField report_time_seg = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt32Field uint32_event_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_report_next_time = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.ReportConditionParam
 * JD-Core Version:    0.7.0.1
 */