package tencent.im.oidb.cmd0x84c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x84c$CTaskInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40 }, new String[] { "task_id", "items", "adcode", "begtime", "endtime" }, new Object[] { Long.valueOf(0L), null, Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, CTaskInfo.class);
  public final PBUInt64Field adcode = PBField.initUInt64(0L);
  public final PBUInt64Field begtime = PBField.initUInt64(0L);
  public final PBUInt64Field endtime = PBField.initUInt64(0L);
  public final PBRepeatMessageField items = PBField.initRepeatMessage(oidb_0x84c.CItemInfo.class);
  public final PBUInt64Field task_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x84c.oidb_0x84c.CTaskInfo
 * JD-Core Version:    0.7.0.1
 */