package fudai;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class fd_interactive_pack$RspFDPkg
  extends MessageMicro<RspFDPkg>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field cmd_type = PBField.initUInt32(0);
  public final PBStringField fdid = PBField.initString("");
  public fd_interactive_pack.GrabeRedEnvelopeRsp grabe_re = new fd_interactive_pack.GrabeRedEnvelopeRsp();
  public final PBUInt64Field op_uin = PBField.initUInt64(0L);
  public fd_interactive_pack.FDRecvDetailsRsp recv_details = new fd_interactive_pack.FDRecvDetailsRsp();
  public final PBUInt32Field result_code = PBField.initUInt32(0);
  public final PBStringField result_msg = PBField.initString("");
  public fd_interactive_pack.ShareFDRsp share_fd = new fd_interactive_pack.ShareFDRsp();
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 88, 98, 106, 114 }, new String[] { "op_uin", "result_code", "result_msg", "fdid", "cmd_type", "share_fd", "grabe_re", "recv_details" }, new Object[] { Long.valueOf(0L), localInteger, "", "", localInteger, null, null, null }, RspFDPkg.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     fudai.fd_interactive_pack.RspFDPkg
 * JD-Core Version:    0.7.0.1
 */