package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

public final class oidb_0xb6f$ReportFreqRspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "identity", "remain_minute_times", "remain_day_times" }, new Object[] { null, Long.valueOf(0L), Long.valueOf(0L) }, ReportFreqRspBody.class);
  public oidb_0xb6f.Identity identity = new oidb_0xb6f.Identity();
  public final PBInt64Field remain_day_times = PBField.initInt64(0L);
  public final PBInt64Field remain_minute_times = PBField.initInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xb6f.ReportFreqRspBody
 * JD-Core Version:    0.7.0.1
 */