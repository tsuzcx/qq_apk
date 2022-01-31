package fudai;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class fd_interactive_pack$ShareFDReq
  extends MessageMicro<ShareFDReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "host_prof", "share_meta" }, new Object[] { null, null }, ShareFDReq.class);
  public fd_comm.UinProf host_prof = new fd_comm.UinProf();
  public fd_comm.FDShareMeta share_meta = new fd_comm.FDShareMeta();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     fudai.fd_interactive_pack.ShareFDReq
 * JD-Core Version:    0.7.0.1
 */