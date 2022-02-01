package tencent.im.oidb.cmd0x83e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x83e$PgcParam
  extends MessageMicro<PgcParam>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_puin", "uint64_insert_time" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, PgcParam.class);
  public final PBUInt64Field uint64_insert_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_puin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.PgcParam
 * JD-Core Version:    0.7.0.1
 */