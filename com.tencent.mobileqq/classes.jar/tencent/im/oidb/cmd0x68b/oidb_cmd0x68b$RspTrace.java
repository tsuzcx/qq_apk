package tencent.im.oidb.cmd0x68b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_cmd0x68b$RspTrace
  extends MessageMicro<RspTrace>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_trace_record_list" }, new Object[] { null }, RspTrace.class);
  public final PBRepeatMessageField<oidb_cmd0x68b.RspTraceRecord> rpt_trace_record_list = PBField.initRepeatMessage(oidb_cmd0x68b.RspTraceRecord.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspTrace
 * JD-Core Version:    0.7.0.1
 */