package tencent.im.oidb.cmd0xb81;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xb81$SchoolInfo
  extends MessageMicro<SchoolInfo>
{
  public static final int EduAssociate = 5;
  public static final int EduBachelor = 6;
  public static final int EduDoctor = 8;
  public static final int EduJunior = 2;
  public static final int EduMaster = 7;
  public static final int EduPost_Doctoral = 9;
  public static final int EduPrimay = 1;
  public static final int EduSenior = 3;
  public static final int EduTechnical = 4;
  public static final int SchoolMid = 2;
  public static final int SchoolPri = 1;
  public static final int SchoolUniversity = 3;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field category = PBField.initUInt32(0);
  public final PBStringField id = PBField.initString("");
  public final PBStringField name = PBField.initString("");
  public final PBUInt32Field uint32_degree = PBField.initUInt32(0);
  public final PBUInt32Field uint32_enrollment_year = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 48, 56 }, new String[] { "category", "id", "name", "uint32_degree", "uint32_enrollment_year" }, new Object[] { localInteger, "", "", localInteger, localInteger }, SchoolInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.SchoolInfo
 * JD-Core Version:    0.7.0.1
 */