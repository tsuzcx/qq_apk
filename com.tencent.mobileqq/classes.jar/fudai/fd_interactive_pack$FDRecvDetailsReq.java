package fudai;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class fd_interactive_pack$FDRecvDetailsReq
  extends MessageMicro<FDRecvDetailsReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "op_uin", "host_uin" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, FDRecvDetailsReq.class);
  public final PBUInt64Field host_uin = PBField.initUInt64(0L);
  public final PBUInt64Field op_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     fudai.fd_interactive_pack.FDRecvDetailsReq
 * JD-Core Version:    0.7.0.1
 */