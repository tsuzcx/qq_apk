package msf.msgsvc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class msg_svc$PbDelRoamMsgResp
  extends MessageMicro<PbDelRoamMsgResp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "result", "errmsg" }, new Object[] { Integer.valueOf(0), "" }, PbDelRoamMsgResp.class);
  public final PBStringField errmsg = PBField.initString("");
  public final PBUInt32Field result = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     msf.msgsvc.msg_svc.PbDelRoamMsgResp
 * JD-Core Version:    0.7.0.1
 */