package msf.msgsvc;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class msg_svc$PbC2CMsgWithDrawReq
  extends MessageMicro<PbC2CMsgWithDrawReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_reserved = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<msg_svc.PbC2CMsgWithDrawReq.MsgInfo> msg_info = PBField.initRepeatMessage(msg_svc.PbC2CMsgWithDrawReq.MsgInfo.class);
  public final PBUInt32Field uint32_long_message_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32 }, new String[] { "msg_info", "uint32_long_message_flag", "bytes_reserved", "uint32_sub_cmd" }, new Object[] { null, Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, PbC2CMsgWithDrawReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     msf.msgsvc.msg_svc.PbC2CMsgWithDrawReq
 * JD-Core Version:    0.7.0.1
 */