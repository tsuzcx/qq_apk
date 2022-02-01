package tencent.im.oidb.cmd0xf4d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_0xf4d$ExtraInfo
  extends MessageMicro<ExtraInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "report_info", "danmu_summary_info" }, new Object[] { null, null }, ExtraInfo.class);
  public oidb_0xf4d.DanmuSummaryInfo danmu_summary_info = new oidb_0xf4d.DanmuSummaryInfo();
  public final PBRepeatMessageField<oidb_0xf4d.ReportInfo> report_info = PBField.initRepeatMessage(oidb_0xf4d.ReportInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xf4d.oidb_0xf4d.ExtraInfo
 * JD-Core Version:    0.7.0.1
 */