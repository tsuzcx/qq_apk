package tencent.im.oidb.cmd0x83e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x83e$PGCSubmitPara
  extends MessageMicro<PGCSubmitPara>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 90 }, new String[] { "uint64_puin", "rpt_pgc_fans_list" }, new Object[] { Long.valueOf(0L), null }, PGCSubmitPara.class);
  public final PBRepeatMessageField<oidb_cmd0x83e.PGCFuns> rpt_pgc_fans_list = PBField.initRepeatMessage(oidb_cmd0x83e.PGCFuns.class);
  public final PBUInt64Field uint64_puin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.PGCSubmitPara
 * JD-Core Version:    0.7.0.1
 */