package tencent.im.oidb.cmd0xcdd;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_cmd0xcdd$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42 }, new String[] { "get_qr_req", "confirm_qr_req", "verify_token_req", "reject_qr_req", "query_state_req" }, new Object[] { null, null, null, null, null }, ReqBody.class);
  public oidb_cmd0xcdd.ConfirmQrReq confirm_qr_req = new oidb_cmd0xcdd.ConfirmQrReq();
  public oidb_cmd0xcdd.GetQrReq get_qr_req = new oidb_cmd0xcdd.GetQrReq();
  public oidb_cmd0xcdd.QueryStateReq query_state_req = new oidb_cmd0xcdd.QueryStateReq();
  public oidb_cmd0xcdd.RejectQrReq reject_qr_req = new oidb_cmd0xcdd.RejectQrReq();
  public oidb_cmd0xcdd.VerifyTokenReq verify_token_req = new oidb_cmd0xcdd.VerifyTokenReq();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xcdd.oidb_cmd0xcdd.ReqBody
 * JD-Core Version:    0.7.0.1
 */