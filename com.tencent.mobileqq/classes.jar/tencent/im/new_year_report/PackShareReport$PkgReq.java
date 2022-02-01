package tencent.im.new_year_report;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class PackShareReport$PkgReq
  extends MessageMicro<PkgReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 82 }, new String[] { "head", "report_share" }, new Object[] { null, null }, PkgReq.class);
  public PackShareReport.PkgHead head = new PackShareReport.PkgHead();
  public PackShareReport.ReportShareReq report_share = new PackShareReport.ReportShareReq();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.new_year_report.PackShareReport.PkgReq
 * JD-Core Version:    0.7.0.1
 */