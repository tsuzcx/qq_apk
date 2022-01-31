package msf.msgsvc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class msg_svc$PbDelRoamMsgReq
  extends MessageMicro<PbDelRoamMsgReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "c2c_msg", "grp_msg", "dis_msg" }, new Object[] { null, null, null }, PbDelRoamMsgReq.class);
  public msg_svc.PbDelRoamMsgReq.C2CMsg c2c_msg = new msg_svc.PbDelRoamMsgReq.C2CMsg();
  public msg_svc.PbDelRoamMsgReq.DisMsg dis_msg = new msg_svc.PbDelRoamMsgReq.DisMsg();
  public msg_svc.PbDelRoamMsgReq.GrpMsg grp_msg = new msg_svc.PbDelRoamMsgReq.GrpMsg();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     msf.msgsvc.msg_svc.PbDelRoamMsgReq
 * JD-Core Version:    0.7.0.1
 */