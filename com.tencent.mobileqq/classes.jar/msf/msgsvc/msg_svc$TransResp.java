package msf.msgsvc;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class msg_svc$TransResp
  extends MessageMicro<TransResp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField errmsg = PBField.initString("");
  public final PBBytesField resp_buff = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field resp_tag = PBField.initUInt32(0);
  public final PBUInt32Field result = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34 }, new String[] { "result", "errmsg", "resp_tag", "resp_buff" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), localByteStringMicro }, TransResp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     msf.msgsvc.msg_svc.TransResp
 * JD-Core Version:    0.7.0.1
 */