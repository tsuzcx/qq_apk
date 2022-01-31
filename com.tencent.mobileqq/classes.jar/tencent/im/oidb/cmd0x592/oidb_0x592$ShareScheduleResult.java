package tencent.im.oidb.cmd0x592;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.trunk.Qworkflow.Qworkflow.Timespan;

public final class oidb_0x592$ShareScheduleResult
  extends MessageMicro<ShareScheduleResult>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_schedule_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<Qworkflow.Timespan> rpt_msg_fail_timespan = PBField.initRepeatMessage(Qworkflow.Timespan.class);
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34 }, new String[] { "bytes_schedule_id", "uint32_result", "bytes_error_msg", "rpt_msg_fail_timespan" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, null }, ShareScheduleResult.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x592.oidb_0x592.ShareScheduleResult
 * JD-Core Version:    0.7.0.1
 */