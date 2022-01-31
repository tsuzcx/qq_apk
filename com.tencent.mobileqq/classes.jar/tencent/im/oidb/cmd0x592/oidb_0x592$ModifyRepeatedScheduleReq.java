package tencent.im.oidb.cmd0x592;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.trunk.Qworkflow.Qworkflow.Timespan;
import com.trunk.Qworkflow.Qworkflow.Workflow;

public final class oidb_0x592$ModifyRepeatedScheduleReq
  extends MessageMicro<ModifyRepeatedScheduleReq>
{
  public static final int ALL_MODIFY = 1;
  public static final int PART_MODIFY = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_modify_schedule_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField enum_modify_type = PBField.initEnum(1);
  public Qworkflow.Timespan msg_modify_timespan = new Qworkflow.Timespan();
  public Qworkflow.Workflow msg_new_schedule = new Qworkflow.Workflow();
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34 }, new String[] { "msg_new_schedule", "enum_modify_type", "bytes_modify_schedule_id", "msg_modify_timespan" }, new Object[] { null, Integer.valueOf(1), localByteStringMicro, null }, ModifyRepeatedScheduleReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x592.oidb_0x592.ModifyRepeatedScheduleReq
 * JD-Core Version:    0.7.0.1
 */