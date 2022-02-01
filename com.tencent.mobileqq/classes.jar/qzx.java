import com.tencent.pts.utils.PTSReportUtil.DefaultPTSReport;

final class qzx
  extends PTSReportUtil.DefaultPTSReport
{
  public void reportEvent(String paramString1, String paramString2, int paramInt)
  {
    rag.a("0X800B241", "", "", "", new rah().a("tag", paramString1).a("msg", paramString2).a("reportType", "" + paramInt).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qzx
 * JD-Core Version:    0.7.0.1
 */