package tencent.im.oidb.cmd0xbe4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_cmd0xbe4$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "client_version", "msg_get_req" }, new Object[] { "", null }, ReqBody.class);
  public final PBStringField client_version = PBField.initString("");
  public oidb_cmd0xbe4.MsgGetReq msg_get_req = new oidb_cmd0xbe4.MsgGetReq();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbe4.oidb_cmd0xbe4.ReqBody
 * JD-Core Version:    0.7.0.1
 */