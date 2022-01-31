package tencent.im.new_year_report;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class PackShareReport$PkgResp
  extends MessageMicro<PkgResp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 82 }, new String[] { "head", "report_share" }, new Object[] { null, null }, PkgResp.class);
  public PackShareReport.PkgHead head = new PackShareReport.PkgHead();
  public PackShareReport.ReportShareResp report_share = new PackShareReport.ReportShareResp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.new_year_report.PackShareReport.PkgResp
 * JD-Core Version:    0.7.0.1
 */