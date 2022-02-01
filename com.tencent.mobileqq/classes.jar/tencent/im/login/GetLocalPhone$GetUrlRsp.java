package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class GetLocalPhone$GetUrlRsp
  extends MessageMicro<GetUrlRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_head", "msg_get_url_rsp_body" }, new Object[] { null, null }, GetUrlRsp.class);
  public GetLocalPhone.GetUrlRspBody msg_get_url_rsp_body = new GetLocalPhone.GetUrlRspBody();
  public GetLocalPhone.Head msg_head = new GetLocalPhone.Head();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.login.GetLocalPhone.GetUrlRsp
 * JD-Core Version:    0.7.0.1
 */