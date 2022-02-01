package tencent.im.oidb.cmd0xdb1;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xdb1$SchoolInfo
  extends MessageMicro<SchoolInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 48, 56, 64, 72, 80, 88, 96, 104, 112, 120, 128, 800 }, new String[] { "uint32_category", "str_school_id", "str_school_name", "str_department_id", "str_department_name", "uint32_degree", "uint32_enrollment_year", "uint32_graduation_year", "uint32_allow_recommend", "uint32_create_source", "uint32_create_time", "uint32_update_source", "uint32_update_time", "uint32_hidden_flag", "uint32_verify_status", "uint32_verify_type", "uint32_idx" }, new Object[] { Integer.valueOf(0), "", "", "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, SchoolInfo.class);
  public final PBStringField str_department_id = PBField.initString("");
  public final PBStringField str_department_name = PBField.initString("");
  public final PBStringField str_school_id = PBField.initString("");
  public final PBStringField str_school_name = PBField.initString("");
  public final PBUInt32Field uint32_allow_recommend = PBField.initUInt32(0);
  public final PBUInt32Field uint32_category = PBField.initUInt32(0);
  public final PBUInt32Field uint32_create_source = PBField.initUInt32(0);
  public final PBUInt32Field uint32_create_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_degree = PBField.initUInt32(0);
  public final PBUInt32Field uint32_enrollment_year = PBField.initUInt32(0);
  public final PBUInt32Field uint32_graduation_year = PBField.initUInt32(0);
  public final PBUInt32Field uint32_hidden_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_idx = PBField.initUInt32(0);
  public final PBUInt32Field uint32_update_source = PBField.initUInt32(0);
  public final PBUInt32Field uint32_update_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_verify_status = PBField.initUInt32(0);
  public final PBUInt32Field uint32_verify_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xdb1.oidb_0xdb1.SchoolInfo
 * JD-Core Version:    0.7.0.1
 */