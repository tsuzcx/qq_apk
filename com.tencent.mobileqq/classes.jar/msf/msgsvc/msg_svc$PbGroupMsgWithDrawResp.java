package msf.msgsvc;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class msg_svc$PbGroupMsgWithDrawResp
  extends MessageMicro<PbGroupMsgWithDrawResp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_userdef = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField errmsg = PBField.initString("");
  public final PBRepeatMessageField<msg_svc.PbGroupMsgWithDrawResp.MessageResult> failed_msg_list = PBField.initRepeatMessage(msg_svc.PbGroupMsgWithDrawResp.MessageResult.class);
  public msg_svc.WithDrawWordingInfo msg_wording_info = new msg_svc.WithDrawWordingInfo();
  public final PBUInt32Field result = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 50, 58, 66 }, new String[] { "result", "errmsg", "uint32_sub_cmd", "uint32_group_type", "uint64_group_code", "failed_msg_list", "bytes_userdef", "msg_wording_info" }, new Object[] { localInteger, "", localInteger, localInteger, Long.valueOf(0L), null, localByteStringMicro, null }, PbGroupMsgWithDrawResp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     msf.msgsvc.msg_svc.PbGroupMsgWithDrawResp
 * JD-Core Version:    0.7.0.1
 */