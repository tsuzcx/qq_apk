package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class GetLocalPhone$GetUrlReq
  extends MessageMicro<GetUrlReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_head", "msg_get_url_req_body" }, new Object[] { null, null }, GetUrlReq.class);
  public GetLocalPhone.GetUrlReqBody msg_get_url_req_body = new GetLocalPhone.GetUrlReqBody();
  public GetLocalPhone.Head msg_head = new GetLocalPhone.Head();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.login.GetLocalPhone.GetUrlReq
 * JD-Core Version:    0.7.0.1
 */