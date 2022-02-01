package tencent.im.oidb.cmd0xd2d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_cmd0xd2d_common$EduHis
  extends MessageMicro<EduHis>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_school" }, new Object[] { null }, EduHis.class);
  public final PBRepeatMessageField<oidb_cmd0xd2d_common.SchoolInfo> rpt_msg_school = PBField.initRepeatMessage(oidb_cmd0xd2d_common.SchoolInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xd2d.oidb_cmd0xd2d_common.EduHis
 * JD-Core Version:    0.7.0.1
 */