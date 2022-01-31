package tencent.im.oidb.cmd0x84c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x84c$QueryCountRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 48, 56, 64 }, new String[] { "infos", "empty_task_ids", "interval", "admission", "countdown", "display_led", "display_pendant", "display_cloud" }, new Object[] { null, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false) }, QueryCountRsp.class);
  public final PBUInt32Field admission = PBField.initUInt32(0);
  public final PBUInt32Field countdown = PBField.initUInt32(0);
  public final PBBoolField display_cloud = PBField.initBool(false);
  public final PBBoolField display_led = PBField.initBool(false);
  public final PBBoolField display_pendant = PBField.initBool(false);
  public final PBRepeatField empty_task_ids = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBRepeatMessageField infos = PBField.initRepeatMessage(oidb_0x84c.CAdcodeInfo.class);
  public final PBUInt32Field interval = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x84c.oidb_0x84c.QueryCountRsp
 * JD-Core Version:    0.7.0.1
 */