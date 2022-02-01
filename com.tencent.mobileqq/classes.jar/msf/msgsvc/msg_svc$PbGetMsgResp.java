package msf.msgsvc;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import msf.msgcomm.msg_comm.UinPairMsg;

public final class msg_svc$PbGetMsgResp
  extends MessageMicro<PbGetMsgResp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field bind_uin = PBField.initUInt64(0L);
  public final PBStringField errmsg = PBField.initString("");
  public final PBBoolField is_partial_sync = PBField.initBool(false);
  public final PBBytesField msg_ctrl_buf = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field msg_rsp_type = PBField.initUInt32(0);
  public final PBBytesField pubaccount_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field result = PBField.initUInt32(0);
  public final PBBytesField sync_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField sync_flag = PBField.initEnum(0);
  public final PBRepeatMessageField<msg_comm.UinPairMsg> uin_pair_msgs = PBField.initRepeatMessage(msg_comm.UinPairMsg.class);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 48, 56, 66, 72, 82 }, new String[] { "result", "errmsg", "sync_cookie", "sync_flag", "uin_pair_msgs", "bind_uin", "msg_rsp_type", "pubaccount_cookie", "is_partial_sync", "msg_ctrl_buf" }, new Object[] { localInteger, "", localByteStringMicro1, localInteger, null, Long.valueOf(0L), localInteger, localByteStringMicro2, Boolean.valueOf(false), localByteStringMicro3 }, PbGetMsgResp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     msf.msgsvc.msg_svc.PbGetMsgResp
 * JD-Core Version:    0.7.0.1
 */