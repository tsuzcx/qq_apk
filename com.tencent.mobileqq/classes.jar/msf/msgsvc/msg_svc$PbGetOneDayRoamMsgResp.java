package msf.msgsvc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import msf.msgcomm.msg_comm.Msg;

public final class msg_svc$PbGetOneDayRoamMsgResp
  extends MessageMicro<PbGetOneDayRoamMsgResp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField errmsg = PBField.initString("");
  public final PBUInt32Field iscomplete = PBField.initUInt32(0);
  public final PBUInt64Field last_msgtime = PBField.initUInt64(0L);
  public final PBRepeatMessageField<msg_comm.Msg> msg = PBField.initRepeatMessage(msg_comm.Msg.class);
  public final PBUInt64Field peer_uin = PBField.initUInt64(0L);
  public final PBUInt64Field random = PBField.initUInt64(0L);
  public final PBUInt32Field result = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 50, 56 }, new String[] { "result", "errmsg", "peer_uin", "last_msgtime", "random", "msg", "iscomplete" }, new Object[] { localInteger, "", localLong, localLong, localLong, null, localInteger }, PbGetOneDayRoamMsgResp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     msf.msgsvc.msg_svc.PbGetOneDayRoamMsgResp
 * JD-Core Version:    0.7.0.1
 */