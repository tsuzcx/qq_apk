package tencent.im.oidb.cmd0x625;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class Oidb_0x625$Open2Tiny_ReqBody
  extends MessageMicro<Open2Tiny_ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_openid_req_info" }, new Object[] { null }, Open2Tiny_ReqBody.class);
  public final PBRepeatMessageField<Oidb_0x625.OpenIDInfoReq> msg_openid_req_info = PBField.initRepeatMessage(Oidb_0x625.OpenIDInfoReq.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0x625.Oidb_0x625.Open2Tiny_ReqBody
 * JD-Core Version:    0.7.0.1
 */