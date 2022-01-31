package msf.msgsvc;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class msg_svc$PbBindUinMsgReadedConfirmReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field bind_uin = PBField.initUInt64(0L);
  public final PBBytesField sync_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "sync_cookie", "bind_uin" }, new Object[] { localByteStringMicro, Long.valueOf(0L) }, PbBindUinMsgReadedConfirmReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     msf.msgsvc.msg_svc.PbBindUinMsgReadedConfirmReq
 * JD-Core Version:    0.7.0.1
 */