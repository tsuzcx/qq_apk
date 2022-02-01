package tencent.im.oidb.cmd0x592;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x592$GetDateHasOnceScheduleReq
  extends MessageMicro<GetDateHasOnceScheduleReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_req_start_time", "uint64_req_end_time", "uint32_main_type" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0) }, GetDateHasOnceScheduleReq.class);
  public final PBUInt32Field uint32_main_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_req_end_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_req_start_time = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x592.oidb_0x592.GetDateHasOnceScheduleReq
 * JD-Core Version:    0.7.0.1
 */