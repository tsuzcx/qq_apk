package tencent.im.oidb.cmd0x903;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x903$SubCmd0x2Req
  extends MessageMicro<SubCmd0x2Req>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "opt_uint64_group_code", "uint64_req_start_time", "uint32_uin_num" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0) }, SubCmd0x2Req.class);
  public final PBUInt64Field opt_uint64_group_code = PBField.initUInt64(0L);
  public final PBUInt32Field uint32_uin_num = PBField.initUInt32(0);
  public final PBUInt64Field uint64_req_start_time = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x903.cmd0x903.SubCmd0x2Req
 * JD-Core Version:    0.7.0.1
 */