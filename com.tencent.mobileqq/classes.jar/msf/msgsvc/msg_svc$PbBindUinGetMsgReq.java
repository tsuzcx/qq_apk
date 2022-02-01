package msf.msgsvc;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class msg_svc$PbBindUinGetMsgReq
  extends MessageMicro<PbBindUinGetMsgReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field bind_uin = PBField.initUInt64(0L);
  public final PBBytesField bind_uin_sig = PBField.initBytes(ByteStringMicro.copyFromUtf8(""));
  public final PBBytesField sync_cookie = PBField.initBytes(ByteStringMicro.copyFromUtf8(""));
  public final PBEnumField sync_flag = PBField.initEnum(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.copyFromUtf8("");
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.copyFromUtf8("");
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34 }, new String[] { "bind_uin", "bind_uin_sig", "sync_flag", "sync_cookie" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2 }, PbBindUinGetMsgReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     msf.msgsvc.msg_svc.PbBindUinGetMsgReq
 * JD-Core Version:    0.7.0.1
 */