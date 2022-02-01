package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x6f5$TaskInfo
  extends MessageMicro<TaskInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48 }, new String[] { "uint32_task_id", "uint32_appid", "uint32_passthrough_level", "uint32_show_level", "uint32_extra", "uint32_priority" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, TaskInfo.class);
  public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_extra = PBField.initUInt32(0);
  public final PBUInt32Field uint32_passthrough_level = PBField.initUInt32(0);
  public final PBUInt32Field uint32_priority = PBField.initUInt32(0);
  public final PBUInt32Field uint32_show_level = PBField.initUInt32(0);
  public final PBUInt32Field uint32_task_id = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6f5.TaskInfo
 * JD-Core Version:    0.7.0.1
 */