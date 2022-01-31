package tencent.im.oidb.cmd0xcdd;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_cmd0xcdd$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "get_qr_rsp", "confirm_qr_rsp", "query_state_rsp" }, new Object[] { null, null, null }, RspBody.class);
  public oidb_cmd0xcdd.ConfirmQrRsp confirm_qr_rsp = new oidb_cmd0xcdd.ConfirmQrRsp();
  public oidb_cmd0xcdd.GetQrRsp get_qr_rsp = new oidb_cmd0xcdd.GetQrRsp();
  public oidb_cmd0xcdd.QueryStateRsp query_state_rsp = new oidb_cmd0xcdd.QueryStateRsp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0xcdd.oidb_cmd0xcdd.RspBody
 * JD-Core Version:    0.7.0.1
 */