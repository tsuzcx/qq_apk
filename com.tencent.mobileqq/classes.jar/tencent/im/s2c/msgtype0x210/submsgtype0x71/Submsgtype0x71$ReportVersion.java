package tencent.im.s2c.msgtype0x210.submsgtype0x71;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class Submsgtype0x71$ReportVersion
  extends MessageMicro<ReportVersion>
{
  public static final int BOOL_ALLVER_FIELD_NUMBER = 2;
  public static final int INT32_PLANT_ID_FIELD_NUMBER = 1;
  public static final int RPT_STR_VERSION_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "int32_plant_id", "bool_allver", "rpt_str_version" }, new Object[] { Integer.valueOf(0), Boolean.valueOf(false), "" }, ReportVersion.class);
  public final PBBoolField bool_allver = PBField.initBool(false);
  public final PBInt32Field int32_plant_id = PBField.initInt32(0);
  public final PBRepeatField<String> rpt_str_version = PBField.initRepeat(PBStringField.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x71.Submsgtype0x71.ReportVersion
 * JD-Core Version:    0.7.0.1
 */