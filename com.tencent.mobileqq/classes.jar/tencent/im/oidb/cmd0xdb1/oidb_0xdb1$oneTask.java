package tencent.im.oidb.cmd0xdb1;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xdb1$oneTask
  extends MessageMicro<oneTask>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField str_msg = PBField.initString("");
  public final PBUInt32Field uint32_task_match_times = PBField.initUInt32(0);
  public final PBUInt32Field uint32_task_status = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint32_task_status", "uint32_task_match_times", "str_msg" }, new Object[] { localInteger, localInteger, "" }, oneTask.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xdb1.oidb_0xdb1.oneTask
 * JD-Core Version:    0.7.0.1
 */