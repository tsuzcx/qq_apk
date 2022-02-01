package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class GatewayVerify$ReqBindPhoneLogin
  extends MessageMicro<ReqBindPhoneLogin>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 82 }, new String[] { "msg_pic_verify_info" }, new Object[] { null }, ReqBindPhoneLogin.class);
  public GatewayVerify.PicVerifyInfo msg_pic_verify_info = new GatewayVerify.PicVerifyInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.login.GatewayVerify.ReqBindPhoneLogin
 * JD-Core Version:    0.7.0.1
 */