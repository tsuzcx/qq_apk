package tencent.im.hw;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class group_mgr$GroupHomeworkInfo
  extends MessageMicro<GroupHomeworkInfo>
{
  public static final int CITY_CODE_FIELD_NUMBER = 1;
  public static final int CL_CLASS_FIELD_NUMBER = 6;
  public static final int CL_ENROL_YEAR_FIELD_NUMBER = 4;
  public static final int CL_GRADE_FIELD_NUMBER = 5;
  public static final int SC_NAME_FIELD_NUMBER = 3;
  public static final int SC_TYPE_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50 }, new String[] { "city_code", "sc_type", "sc_name", "cl_enrol_year", "cl_grade", "cl_class" }, new Object[] { "", "", "", "", "", "" }, GroupHomeworkInfo.class);
  public final PBStringField city_code = PBField.initString("");
  public final PBStringField cl_class = PBField.initString("");
  public final PBStringField cl_enrol_year = PBField.initString("");
  public final PBStringField cl_grade = PBField.initString("");
  public final PBStringField sc_name = PBField.initString("");
  public final PBStringField sc_type = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.hw.group_mgr.GroupHomeworkInfo
 * JD-Core Version:    0.7.0.1
 */