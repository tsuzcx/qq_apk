import com.tencent.pts.utils.PTSReportUtil.DefaultPTSReport;

final class qhr
  extends PTSReportUtil.DefaultPTSReport
{
  public void reportEvent(String paramString1, String paramString2, int paramInt)
  {
    qhy.a("0X800B241", "", "", "", new qhz().a("tag", paramString1).a("msg", paramString2).a("reportType", "" + paramInt).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qhr
 * JD-Core Version:    0.7.0.1
 */