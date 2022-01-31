package tencent.im.oidb.cmd0x954;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x954$Topic
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 80, 88, 96, 104, 112, 120, 128, 136, 146, 524282 }, new String[] { "uint32_id", "str_name", "uint32_type", "uint32_pos", "uint64_ontime", "uint64_offtime", "uint32_publihscope", "rpt_scope_list", "uint32_status", "uint32_statistics_type", "rpt_counters", "str_ext" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, "" }, Topic.class);
  public final PBRepeatMessageField rpt_counters = PBField.initRepeatMessage(cmd0x954.Counter.class);
  public final PBRepeatField rpt_scope_list = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBStringField str_ext = PBField.initString("");
  public final PBStringField str_name = PBField.initString("");
  public final PBUInt32Field uint32_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pos = PBField.initUInt32(0);
  public final PBUInt32Field uint32_publihscope = PBField.initUInt32(0);
  public final PBUInt32Field uint32_statistics_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_status = PBField.initUInt32(0);
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_offtime = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_ontime = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x954.cmd0x954.Topic
 * JD-Core Version:    0.7.0.1
 */