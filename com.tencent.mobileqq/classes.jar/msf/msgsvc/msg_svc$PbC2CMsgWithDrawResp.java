package msf.msgsvc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class msg_svc$PbC2CMsgWithDrawResp
  extends MessageMicro<PbC2CMsgWithDrawResp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField errmsg = PBField.initString("");
  public final PBRepeatMessageField<msg_svc.PbC2CMsgWithDrawResp.MsgStatus> msg_status = PBField.initRepeatMessage(msg_svc.PbC2CMsgWithDrawResp.MsgStatus.class);
  public msg_svc.WithDrawWordingInfo msg_wording_info = new msg_svc.WithDrawWordingInfo();
  public final PBUInt32Field result = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42 }, new String[] { "result", "errmsg", "msg_status", "uint32_sub_cmd", "msg_wording_info" }, new Object[] { localInteger, "", null, localInteger, null }, PbC2CMsgWithDrawResp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     msf.msgsvc.msg_svc.PbC2CMsgWithDrawResp
 * JD-Core Version:    0.7.0.1
 */