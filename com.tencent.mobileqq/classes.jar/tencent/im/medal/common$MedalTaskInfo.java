package tencent.im.medal;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class common$MedalTaskInfo
  extends MessageMicro<MedalTaskInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 256, 264, 272, 280 }, new String[] { "uint32_taskid", "int32_task_value", "uint32_tar_value", "uint32_tar_value_level2", "uint32_tar_value_level3" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, MedalTaskInfo.class);
  public final PBInt32Field int32_task_value = PBField.initInt32(0);
  public final PBUInt32Field uint32_tar_value = PBField.initUInt32(0);
  public final PBUInt32Field uint32_tar_value_level2 = PBField.initUInt32(0);
  public final PBUInt32Field uint32_tar_value_level3 = PBField.initUInt32(0);
  public final PBUInt32Field uint32_taskid = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.medal.common.MedalTaskInfo
 * JD-Core Version:    0.7.0.1
 */