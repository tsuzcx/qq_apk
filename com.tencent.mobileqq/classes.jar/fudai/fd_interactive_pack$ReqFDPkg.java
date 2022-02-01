package fudai;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class fd_interactive_pack$ReqFDPkg
  extends MessageMicro<ReqFDPkg>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 18, 88, 98, 106, 114, 122 }, new String[] { "fdid", "cmd_type", "share_fd", "grabe_re", "recv_details", "device_info" }, new Object[] { "", Integer.valueOf(0), null, null, null, "" }, ReqFDPkg.class);
  public final PBUInt32Field cmd_type = PBField.initUInt32(0);
  public final PBStringField device_info = PBField.initString("");
  public final PBStringField fdid = PBField.initString("");
  public fd_interactive_pack.GrabeRedEnvelopeReq grabe_re = new fd_interactive_pack.GrabeRedEnvelopeReq();
  public fd_interactive_pack.FDRecvDetailsReq recv_details = new fd_interactive_pack.FDRecvDetailsReq();
  public fd_interactive_pack.ShareFDReq share_fd = new fd_interactive_pack.ShareFDReq();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     fudai.fd_interactive_pack.ReqFDPkg
 * JD-Core Version:    0.7.0.1
 */