package tencent.im.oidb.cmd0x922;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x922$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32 }, new String[] { "uint32_need_update_flag", "uint64_timestamp", "msg_push_info", "uint32_next_req_time" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), null, Integer.valueOf(0) }, RspBody.class);
  public cmd0x922.PushInfo msg_push_info = new cmd0x922.PushInfo();
  public final PBUInt32Field uint32_need_update_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_next_req_time = PBField.initUInt32(0);
  public final PBUInt64Field uint64_timestamp = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x922.cmd0x922.RspBody
 * JD-Core Version:    0.7.0.1
 */