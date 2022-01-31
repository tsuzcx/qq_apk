package tencent.im.oidb.cmd0xa8d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xa8d$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint64_group_code", "uint32_req_type", "msg_join_group" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), null }, RspBody.class);
  public oidb_0xa8d.Cmd0xa8dJoinPublicGroupRspBody msg_join_group = new oidb_0xa8d.Cmd0xa8dJoinPublicGroupRspBody();
  public final PBUInt32Field uint32_req_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xa8d.oidb_0xa8d.RspBody
 * JD-Core Version:    0.7.0.1
 */