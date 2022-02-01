package msf.msgsvc;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class msg_svc$PbThirdQQUnReadMsgNumReq$ThirdQQReqInfo
  extends MessageMicro<ThirdQQReqInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field third_uin = PBField.initUInt64(0L);
  public final PBBytesField third_uin_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField third_uin_sig = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "third_uin", "third_uin_sig", "third_uin_cookie" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2 }, ThirdQQReqInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     msf.msgsvc.msg_svc.PbThirdQQUnReadMsgNumReq.ThirdQQReqInfo
 * JD-Core Version:    0.7.0.1
 */