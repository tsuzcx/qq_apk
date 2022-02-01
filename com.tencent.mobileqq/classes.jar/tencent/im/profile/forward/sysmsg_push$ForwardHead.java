package tencent.im.profile.forward;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class sysmsg_push$ForwardHead
  extends MessageMicro<ForwardHead>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 53, 61, 64, 72, 80 }, new String[] { "uint64_uin", "uint32_client_type", "uint32_req_type", "uint32_cmd", "uint32_sub_cmd", "fixed32_service_addr", "rpt_fixed32_client_addr", "uint32_sequence", "uint32_if_need_ack", "uint32_result" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ForwardHead.class);
  public final PBFixed32Field fixed32_service_addr = PBField.initFixed32(0);
  public final PBRepeatField<Integer> rpt_fixed32_client_addr = PBField.initRepeat(PBFixed32Field.__repeatHelper__);
  public final PBUInt32Field uint32_client_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
  public final PBUInt32Field uint32_if_need_ack = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sequence = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.profile.forward.sysmsg_push.ForwardHead
 * JD-Core Version:    0.7.0.1
 */