package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class cmd0x6f5$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "str_config_version", "rpt_task_info" }, new Object[] { "", null }, RspBody.class);
  public final PBRepeatMessageField<cmd0x6f5.TaskInfo> rpt_task_info = PBField.initRepeatMessage(cmd0x6f5.TaskInfo.class);
  public final PBStringField str_config_version = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6f5.RspBody
 * JD-Core Version:    0.7.0.1
 */