package fudai;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class fd_interactive_pack$GrabeRedEnvelopeReq
  extends MessageMicro<GrabeRedEnvelopeReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 88 }, new String[] { "op_prof", "host_uin", "share_meta", "src_version" }, new Object[] { null, Long.valueOf(0L), null, Integer.valueOf(0) }, GrabeRedEnvelopeReq.class);
  public final PBUInt64Field host_uin = PBField.initUInt64(0L);
  public fd_comm.UinProf op_prof = new fd_comm.UinProf();
  public fd_comm.FDShareMeta share_meta = new fd_comm.FDShareMeta();
  public final PBUInt32Field src_version = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     fudai.fd_interactive_pack.GrabeRedEnvelopeReq
 * JD-Core Version:    0.7.0.1
 */