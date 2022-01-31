package tencent.im.oidb.cmd0x64e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_cmd0x64e$ReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_report_info" }, new Object[] { null }, ReqBody.class);
  public final PBRepeatMessageField rpt_report_info = PBField.initRepeatMessage(oidb_cmd0x64e.ReportInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x64e.oidb_cmd0x64e.ReqBody
 * JD-Core Version:    0.7.0.1
 */