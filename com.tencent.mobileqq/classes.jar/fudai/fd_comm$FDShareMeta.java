package fudai;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class fd_comm$FDShareMeta
  extends MessageMicro<FDShareMeta>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "type", "target_id" }, new Object[] { Integer.valueOf(1), Long.valueOf(0L) }, FDShareMeta.class);
  public final PBUInt64Field target_id = PBField.initUInt64(0L);
  public final PBEnumField type = PBField.initEnum(1);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     fudai.fd_comm.FDShareMeta
 * JD-Core Version:    0.7.0.1
 */