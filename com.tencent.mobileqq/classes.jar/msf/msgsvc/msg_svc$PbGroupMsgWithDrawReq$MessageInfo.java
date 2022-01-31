package msf.msgsvc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class msg_svc$PbGroupMsgWithDrawReq$MessageInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_msg_seq", "uint32_msg_random", "uint32_msg_type" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, MessageInfo.class);
  public final PBUInt32Field uint32_msg_random = PBField.initUInt32(0);
  public final PBUInt32Field uint32_msg_seq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\acom2.jar
 * Qualified Name:     msf.msgsvc.msg_svc.PbGroupMsgWithDrawReq.MessageInfo
 * JD-Core Version:    0.7.0.1
 */