package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class GetLocalPhone$GetPhoneReq
  extends MessageMicro<GetPhoneReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_head", "msg_get_phone_req_body" }, new Object[] { null, null }, GetPhoneReq.class);
  public GetLocalPhone.GetPhoneReqBody msg_get_phone_req_body = new GetLocalPhone.GetPhoneReqBody();
  public GetLocalPhone.Head msg_head = new GetLocalPhone.Head();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.login.GetLocalPhone.GetPhoneReq
 * JD-Core Version:    0.7.0.1
 */