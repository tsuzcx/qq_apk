package tencent.im.oidb.cmd0x7f5;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x7f5$LabelInfo
  extends MessageMicro<LabelInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "int32_result", "uint64_group_code", "rpt_group_label" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), null }, LabelInfo.class);
  public final PBInt32Field int32_result = PBField.initInt32(0);
  public final PBRepeatMessageField<cmd0x7f5.Label> rpt_group_label = PBField.initRepeatMessage(cmd0x7f5.Label.class);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7f5.cmd0x7f5.LabelInfo
 * JD-Core Version:    0.7.0.1
 */