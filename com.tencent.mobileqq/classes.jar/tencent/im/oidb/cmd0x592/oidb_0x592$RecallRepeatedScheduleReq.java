package tencent.im.oidb.cmd0x592;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.trunk.Qworkflow.Qworkflow.AppID;

public final class oidb_0x592$RecallRepeatedScheduleReq
  extends MessageMicro<RecallRepeatedScheduleReq>
{
  public static final int ALL_RECALL = 1;
  public static final int PART_RECALL = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_workflow_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField enum_recall_type = PBField.initEnum(1);
  public Qworkflow.AppID msg_notify_source_id = new Qworkflow.AppID();
  public final PBUInt64Field uint64_recall_end_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_recall_start_time = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40 }, new String[] { "bytes_workflow_id", "msg_notify_source_id", "enum_recall_type", "uint64_recall_start_time", "uint64_recall_end_time" }, new Object[] { localByteStringMicro, null, Integer.valueOf(1), Long.valueOf(0L), Long.valueOf(0L) }, RecallRepeatedScheduleReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x592.oidb_0x592.RecallRepeatedScheduleReq
 * JD-Core Version:    0.7.0.1
 */