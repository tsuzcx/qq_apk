package tencent.im.oidb.cmd0x94c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x94c$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 160170, 217754, 217760, 217770, 217778, 217808, 217816, 217856, 217866, 322832, 322896, 336912 }, new String[] { "str_school", "str_campus_school", "uint32_campus_enrol_time", "str_campus_college", "str_campus_realname", "uint32_campus_college_id", "uint32_campus_school_id", "uint32_campus_last_modify_time", "str_campus_class", "uint32_campus_cert_user", "uint32_campus_school_canbe_certified", "uint32_campus_school_certification_status" }, new Object[] { "", "", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, RspBody.class);
  public final PBStringField str_campus_class = PBField.initString("");
  public final PBStringField str_campus_college = PBField.initString("");
  public final PBStringField str_campus_realname = PBField.initString("");
  public final PBStringField str_campus_school = PBField.initString("");
  public final PBStringField str_school = PBField.initString("");
  public final PBUInt32Field uint32_campus_cert_user = PBField.initUInt32(0);
  public final PBUInt32Field uint32_campus_college_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_campus_enrol_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_campus_last_modify_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_campus_school_canbe_certified = PBField.initUInt32(0);
  public final PBUInt32Field uint32_campus_school_certification_status = PBField.initUInt32(0);
  public final PBUInt32Field uint32_campus_school_id = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x94c.cmd0x94c.RspBody
 * JD-Core Version:    0.7.0.1
 */