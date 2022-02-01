package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class GetLocalPhone$GetPhoneRsp
  extends MessageMicro<GetPhoneRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_head", "msg_get_phone_rsp_body" }, new Object[] { null, null }, GetPhoneRsp.class);
  public GetLocalPhone.GetPhoneRspBody msg_get_phone_rsp_body = new GetLocalPhone.GetPhoneRspBody();
  public GetLocalPhone.Head msg_head = new GetLocalPhone.Head();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.login.GetLocalPhone.GetPhoneRsp
 * JD-Core Version:    0.7.0.1
 */