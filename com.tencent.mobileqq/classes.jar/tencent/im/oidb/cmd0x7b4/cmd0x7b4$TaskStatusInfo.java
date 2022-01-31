package tencent.im.oidb.cmd0x7b4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x7b4$TaskStatusInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_task_id", "uint32_status" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, TaskStatusInfo.class);
  public final PBUInt32Field uint32_status = PBField.initUInt32(0);
  public final PBUInt64Field uint64_task_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7b4.cmd0x7b4.TaskStatusInfo
 * JD-Core Version:    0.7.0.1
 */