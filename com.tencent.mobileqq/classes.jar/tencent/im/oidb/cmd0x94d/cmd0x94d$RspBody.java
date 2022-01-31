package tencent.im.oidb.cmd0x94d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class cmd0x94d$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 90 }, new String[] { "rpt_schools" }, new Object[] { null }, RspBody.class);
  public final PBRepeatMessageField rpt_schools = PBField.initRepeatMessage(cmd0x94d.TSchool.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x94d.cmd0x94d.RspBody
 * JD-Core Version:    0.7.0.1
 */