package msf.msgsvc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class msg_svc$PbBindUinUnReadMsgNumResp
  extends MessageMicro<PbBindUinUnReadMsgNumResp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field bind_uin = PBField.initUInt64(0L);
  public final PBStringField errmsg = PBField.initString("");
  public final PBUInt32Field msg_num = PBField.initUInt32(0);
  public final PBUInt32Field result = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "result", "errmsg", "bind_uin", "msg_num" }, new Object[] { localInteger, "", Long.valueOf(0L), localInteger }, PbBindUinUnReadMsgNumResp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     msf.msgsvc.msg_svc.PbBindUinUnReadMsgNumResp
 * JD-Core Version:    0.7.0.1
 */