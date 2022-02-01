package msf.msgsvc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class msg_svc$PbDelRoamMsgReq$C2CMsg
  extends MessageMicro<C2CMsg>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field from_uin = PBField.initUInt64(0L);
  public final PBUInt32Field msg_random = PBField.initUInt32(0);
  public final PBUInt32Field msg_seq = PBField.initUInt32(0);
  public final PBUInt32Field msg_time = PBField.initUInt32(0);
  public final PBUInt64Field peer_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "from_uin", "peer_uin", "msg_time", "msg_random", "msg_seq" }, new Object[] { localLong, localLong, localInteger, localInteger, localInteger }, C2CMsg.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     msf.msgsvc.msg_svc.PbDelRoamMsgReq.C2CMsg
 * JD-Core Version:    0.7.0.1
 */