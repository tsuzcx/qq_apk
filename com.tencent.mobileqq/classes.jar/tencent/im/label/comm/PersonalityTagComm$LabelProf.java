package tencent.im.label.comm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class PersonalityTagComm$LabelProf
  extends MessageMicro<LabelProf>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 50, 56, 64, 72, 80, 88, 96, 106, 114, 120 }, new String[] { "uint64_id", "str_text", "rpt_uint32_category", "uint64_ref_count", "str_fg_color", "str_bg_color", "uint32_source", "uint32_create_time", "uint32_hot_flag", "uint32_hit_flag", "uint32_audit_flag", "uint32_audit_time", "str_creater", "str_auditor", "uint32_op_flag" }, new Object[] { Long.valueOf(0L), "", Integer.valueOf(0), Long.valueOf(0L), "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0) }, LabelProf.class);
  public final PBRepeatField<Integer> rpt_uint32_category = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBStringField str_auditor = PBField.initString("");
  public final PBStringField str_bg_color = PBField.initString("");
  public final PBStringField str_creater = PBField.initString("");
  public final PBStringField str_fg_color = PBField.initString("");
  public final PBStringField str_text = PBField.initString("");
  public final PBUInt32Field uint32_audit_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_audit_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_create_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_hit_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_hot_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_op_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_source = PBField.initUInt32(0);
  public final PBUInt64Field uint64_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_ref_count = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.label.comm.PersonalityTagComm.LabelProf
 * JD-Core Version:    0.7.0.1
 */