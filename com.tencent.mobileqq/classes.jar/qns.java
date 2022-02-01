import com.tencent.pts.utils.PTSReportUtil.DefaultPTSReport;

final class qns
  extends PTSReportUtil.DefaultPTSReport
{
  public void reportEvent(String paramString1, String paramString2, int paramInt)
  {
    qob.a("0X800B241", "", "", "", new qoc().a("tag", paramString1).a("msg", paramString2).a("reportType", "" + paramInt).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qns
 * JD-Core Version:    0.7.0.1
 */