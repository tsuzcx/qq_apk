package tencent.im.s2c.frdsysmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class FrdSysMsg$SchoolInfo
  extends MessageMicro<SchoolInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "str_school_id", "str_school_name" }, new Object[] { "", "" }, SchoolInfo.class);
  public final PBStringField str_school_id = PBField.initString("");
  public final PBStringField str_school_name = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.s2c.frdsysmsg.FrdSysMsg.SchoolInfo
 * JD-Core Version:    0.7.0.1
 */