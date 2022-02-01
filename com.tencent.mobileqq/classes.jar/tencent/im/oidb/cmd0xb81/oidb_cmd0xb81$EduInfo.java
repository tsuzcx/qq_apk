package tencent.im.oidb.cmd0xb81;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_cmd0xb81$EduInfo
  extends MessageMicro<EduInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_school_info" }, new Object[] { null }, EduInfo.class);
  public final PBRepeatMessageField<oidb_cmd0xb81.SchoolInfo> rpt_school_info = PBField.initRepeatMessage(oidb_cmd0xb81.SchoolInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.EduInfo
 * JD-Core Version:    0.7.0.1
 */