package msf.msgsvc;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class msg_svc$PbThirdQQUnReadMsgNumResp$ThirdQQRespInfo
  extends MessageMicro<ThirdQQRespInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field last_msg_time = PBField.initUInt32(0);
  public final PBUInt32Field msg_flag = PBField.initUInt32(0);
  public final PBUInt32Field msg_num = PBField.initUInt32(0);
  public final PBUInt32Field redbag_time = PBField.initUInt32(0);
  public final PBUInt32Field status = PBField.initUInt32(0);
  public final PBUInt64Field third_uin = PBField.initUInt64(0L);
  public final PBBytesField third_uin_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 48, 56 }, new String[] { "third_uin", "third_uin_cookie", "msg_num", "msg_flag", "redbag_time", "status", "last_msg_time" }, new Object[] { Long.valueOf(0L), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ThirdQQRespInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     msf.msgsvc.msg_svc.PbThirdQQUnReadMsgNumResp.ThirdQQRespInfo
 * JD-Core Version:    0.7.0.1
 */