package msf.msgsvc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class msg_svc$PbThirdQQUnReadMsgNumReq
  extends MessageMicro<PbThirdQQUnReadMsgNumReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "thirdqq_req_info", "source" }, new Object[] { null, Integer.valueOf(0) }, PbThirdQQUnReadMsgNumReq.class);
  public final PBUInt32Field source = PBField.initUInt32(0);
  public final PBRepeatMessageField<msg_svc.PbThirdQQUnReadMsgNumReq.ThirdQQReqInfo> thirdqq_req_info = PBField.initRepeatMessage(msg_svc.PbThirdQQUnReadMsgNumReq.ThirdQQReqInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     msf.msgsvc.msg_svc.PbThirdQQUnReadMsgNumReq
 * JD-Core Version:    0.7.0.1
 */