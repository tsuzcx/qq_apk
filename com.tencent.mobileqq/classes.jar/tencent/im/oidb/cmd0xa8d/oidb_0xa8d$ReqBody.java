package tencent.im.oidb.cmd0xa8d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xa8d$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40 }, new String[] { "uint64_group_code", "uint32_req_type", "msg_join_group", "msg_exit_group", "uint32_req_client_type" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), null, null, Integer.valueOf(0) }, ReqBody.class);
  public oidb_0xa8d.Cmd0xa8dExitPublicGroupReqBody msg_exit_group = new oidb_0xa8d.Cmd0xa8dExitPublicGroupReqBody();
  public oidb_0xa8d.Cmd0xa8dJoinPublicGroupReqBody msg_join_group = new oidb_0xa8d.Cmd0xa8dJoinPublicGroupReqBody();
  public final PBUInt32Field uint32_req_client_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0xa8d.oidb_0xa8d.ReqBody
 * JD-Core Version:    0.7.0.1
 */