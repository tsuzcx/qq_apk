package msf.msgsvc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class msg_svc$PbDelRoamMsgReq$DisMsg
  extends MessageMicro<DisMsg>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field discuss_uin = PBField.initUInt64(0L);
  public final PBUInt64Field msg_seq = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "discuss_uin", "msg_seq" }, new Object[] { localLong, localLong }, DisMsg.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     msf.msgsvc.msg_svc.PbDelRoamMsgReq.DisMsg
 * JD-Core Version:    0.7.0.1
 */