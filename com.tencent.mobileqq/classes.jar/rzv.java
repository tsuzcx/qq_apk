import UserGrowth.stWeishiReportRsp;

final class rzv
  implements ryo
{
  rzv(String paramString) {}
  
  public void a(ryz paramryz)
  {
    sai.b("weishi-report", "report " + this.a + " start...");
    if ((paramryz != null) && (paramryz.a != null) && ((paramryz.a instanceof stWeishiReportRsp)))
    {
      paramryz = (stWeishiReportRsp)paramryz.a;
      sai.b("weishi-report", "report" + this.a + "end: " + paramryz.code + paramryz.msg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rzv
 * JD-Core Version:    0.7.0.1
 */