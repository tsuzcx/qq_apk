package msf.msgsvc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class msg_svc$PbC2CMsgWithDrawResp$MsgStatus
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "msg_info", "uint32_status" }, new Object[] { null, Integer.valueOf(0) }, MsgStatus.class);
  public msg_svc.PbC2CMsgWithDrawReq.MsgInfo msg_info = new msg_svc.PbC2CMsgWithDrawReq.MsgInfo();
  public final PBUInt32Field uint32_status = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     msf.msgsvc.msg_svc.PbC2CMsgWithDrawResp.MsgStatus
 * JD-Core Version:    0.7.0.1
 */