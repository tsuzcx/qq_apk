package msf.msgsvc;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class msg_svc$PbGroupMsgWithDrawReq
  extends MessageMicro<PbGroupMsgWithDrawReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_userdef = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<msg_svc.PbGroupMsgWithDrawReq.MessageInfo> msg_list = PBField.initRepeatMessage(msg_svc.PbGroupMsgWithDrawReq.MessageInfo.class);
  public final PBUInt32Field uint32_group_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42 }, new String[] { "uint32_sub_cmd", "uint32_group_type", "uint64_group_code", "msg_list", "bytes_userdef" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), null, localByteStringMicro }, PbGroupMsgWithDrawReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     msf.msgsvc.msg_svc.PbGroupMsgWithDrawReq
 * JD-Core Version:    0.7.0.1
 */