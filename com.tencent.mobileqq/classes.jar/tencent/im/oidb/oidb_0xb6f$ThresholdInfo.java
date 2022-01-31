package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

public final class oidb_0xb6f$ThresholdInfo
  extends MessageMicro<ThresholdInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "threshold_per_minute", "threshold_per_day", "threshold_per_hour", "threshold_per_week" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, ThresholdInfo.class);
  public final PBInt64Field threshold_per_day = PBField.initInt64(0L);
  public final PBInt64Field threshold_per_hour = PBField.initInt64(0L);
  public final PBInt64Field threshold_per_minute = PBField.initInt64(0L);
  public final PBInt64Field threshold_per_week = PBField.initInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xb6f.ThresholdInfo
 * JD-Core Version:    0.7.0.1
 */