package tencent.im.msg.resv21;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class hummer_resv_21$FileAssitInfo
  extends MessageMicro<FileAssitInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint64_session_id", "uint32_group_id", "uint32_group_idx", "uint32_group_count" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, FileAssitInfo.class);
  public final PBUInt32Field uint32_group_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_idx = PBField.initUInt32(0);
  public final PBUInt64Field uint64_session_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.msg.resv21.hummer_resv_21.FileAssitInfo
 * JD-Core Version:    0.7.0.1
 */