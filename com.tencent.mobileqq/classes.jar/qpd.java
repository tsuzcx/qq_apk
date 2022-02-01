import com.tencent.pts.utils.PTSReportUtil.DefaultPTSReport;

final class qpd
  extends PTSReportUtil.DefaultPTSReport
{
  public void reportEvent(String paramString1, String paramString2, int paramInt)
  {
    qpk.a("0X800B241", "", "", "", new qpl().a("tag", paramString1).a("msg", paramString2).a("reportType", "" + paramInt).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qpd
 * JD-Core Version:    0.7.0.1
 */