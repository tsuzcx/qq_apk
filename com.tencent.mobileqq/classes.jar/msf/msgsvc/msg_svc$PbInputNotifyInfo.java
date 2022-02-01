package msf.msgsvc;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class msg_svc$PbInputNotifyInfo
  extends MessageMicro<PbInputNotifyInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_pb_reserve = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field ime = PBField.initUInt32(0);
  public final PBBytesField ios_push_wording = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field notify_flag = PBField.initUInt32(0);
  public final PBUInt64Field to_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42 }, new String[] { "to_uin", "ime", "notify_flag", "bytes_pb_reserve", "ios_push_wording" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2 }, PbInputNotifyInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     msf.msgsvc.msg_svc.PbInputNotifyInfo
 * JD-Core Version:    0.7.0.1
 */