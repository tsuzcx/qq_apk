package msf.msgsvc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class msg_svc$PbDelRoamMsgReq$GrpMsg
  extends MessageMicro<GrpMsg>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "group_code", "msg_seq", "uint32_resv_flag" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0) }, GrpMsg.class);
  public final PBUInt64Field group_code = PBField.initUInt64(0L);
  public final PBUInt64Field msg_seq = PBField.initUInt64(0L);
  public final PBUInt32Field uint32_resv_flag = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     msf.msgsvc.msg_svc.PbDelRoamMsgReq.GrpMsg
 * JD-Core Version:    0.7.0.1
 */