package tencent.im.oidb.cmd0x84c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x84c$QueryCountReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "adcodes", "want_empty", "status", "check_task_ids" }, new Object[] { Long.valueOf(0L), Boolean.valueOf(false), Integer.valueOf(0), Long.valueOf(0L) }, QueryCountReq.class);
  public final PBRepeatField adcodes = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBRepeatField check_task_ids = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt32Field status = PBField.initUInt32(0);
  public final PBBoolField want_empty = PBField.initBool(false);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x84c.oidb_0x84c.QueryCountReq
 * JD-Core Version:    0.7.0.1
 */