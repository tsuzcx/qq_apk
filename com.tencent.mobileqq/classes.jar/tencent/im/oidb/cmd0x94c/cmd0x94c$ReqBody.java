package tencent.im.oidb.cmd0x94c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x94c$ReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 90, 98, 104, 114, 120, 130, 136 }, new String[] { "uint64_uin", "uint32_status", "str_actualname", "str_school", "uint32_school_type", "str_college", "uint32_grade", "str_class", "uint32_admission_year" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "", "", Integer.valueOf(0), "", Integer.valueOf(0), "", Integer.valueOf(0) }, ReqBody.class);
  public final PBStringField str_actualname = PBField.initString("");
  public final PBStringField str_class = PBField.initString("");
  public final PBStringField str_college = PBField.initString("");
  public final PBStringField str_school = PBField.initString("");
  public final PBUInt32Field uint32_admission_year = PBField.initUInt32(0);
  public final PBUInt32Field uint32_grade = PBField.initUInt32(0);
  public final PBUInt32Field uint32_school_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_status = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x94c.cmd0x94c.ReqBody
 * JD-Core Version:    0.7.0.1
 */