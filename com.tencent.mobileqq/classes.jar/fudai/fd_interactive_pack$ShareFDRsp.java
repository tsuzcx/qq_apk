package fudai;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class fd_interactive_pack$ShareFDRsp
  extends MessageMicro<ShareFDRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "share_meta" }, new Object[] { null }, ShareFDRsp.class);
  public fd_comm.FDShareMeta share_meta = new fd_comm.FDShareMeta();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     fudai.fd_interactive_pack.ShareFDRsp
 * JD-Core Version:    0.7.0.1
 */