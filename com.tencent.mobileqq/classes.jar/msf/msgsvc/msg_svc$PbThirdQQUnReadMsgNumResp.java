package msf.msgsvc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class msg_svc$PbThirdQQUnReadMsgNumResp
  extends MessageMicro<PbThirdQQUnReadMsgNumResp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField errmsg = PBField.initString("");
  public final PBUInt32Field interval = PBField.initUInt32(0);
  public final PBUInt32Field result = PBField.initUInt32(0);
  public final PBRepeatMessageField<msg_svc.PbThirdQQUnReadMsgNumResp.ThirdQQRespInfo> thirdqq_resp_info = PBField.initRepeatMessage(msg_svc.PbThirdQQUnReadMsgNumResp.ThirdQQRespInfo.class);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "result", "errmsg", "thirdqq_resp_info", "interval" }, new Object[] { localInteger, "", null, localInteger }, PbThirdQQUnReadMsgNumResp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     msf.msgsvc.msg_svc.PbThirdQQUnReadMsgNumResp
 * JD-Core Version:    0.7.0.1
 */