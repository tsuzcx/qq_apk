package msf.msgsvc;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class msg_svc$TransReq
  extends MessageMicro<TransReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field command = PBField.initInt32(0);
  public final PBBytesField req_buff = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field req_tag = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "command", "req_tag", "req_buff" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, TransReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     msf.msgsvc.msg_svc.TransReq
 * JD-Core Version:    0.7.0.1
 */