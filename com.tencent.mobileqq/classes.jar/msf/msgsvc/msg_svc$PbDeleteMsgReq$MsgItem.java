package msf.msgsvc;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class msg_svc$PbDeleteMsgReq$MsgItem
  extends MessageMicro<MsgItem>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field from_uin = PBField.initUInt64(0L);
  public final PBUInt32Field msg_seq = PBField.initUInt32(0);
  public final PBUInt32Field msg_type = PBField.initUInt32(0);
  public final PBUInt64Field msg_uid = PBField.initUInt64(0L);
  public final PBBytesField sig = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field to_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 58 }, new String[] { "from_uin", "to_uin", "msg_type", "msg_seq", "msg_uid", "sig" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro }, MsgItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     msf.msgsvc.msg_svc.PbDeleteMsgReq.MsgItem
 * JD-Core Version:    0.7.0.1
 */