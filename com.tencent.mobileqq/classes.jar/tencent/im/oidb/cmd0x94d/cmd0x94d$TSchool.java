package tencent.im.oidb.cmd0x94d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x94d$TSchool
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 90, 98, 104, 114, 122 }, new String[] { "uint64_id", "str_name", "str_desc", "uint32_type", "rpt_colleges", "rpt_classes" }, new Object[] { Long.valueOf(0L), "", "", Integer.valueOf(0), null, null }, TSchool.class);
  public final PBRepeatMessageField rpt_classes = PBField.initRepeatMessage(cmd0x94d.TClass.class);
  public final PBRepeatMessageField rpt_colleges = PBField.initRepeatMessage(cmd0x94d.TCollege.class);
  public final PBStringField str_desc = PBField.initString("");
  public final PBStringField str_name = PBField.initString("");
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x94d.cmd0x94d.TSchool
 * JD-Core Version:    0.7.0.1
 */