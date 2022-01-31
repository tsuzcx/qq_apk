import UserGrowth.stWeishiReportRsp;

final class smr
  implements slk
{
  smr(String paramString) {}
  
  public void a(slv paramslv)
  {
    sne.b("weishi-report", "report " + this.a + " start...");
    if ((paramslv != null) && (paramslv.a != null) && ((paramslv.a instanceof stWeishiReportRsp)))
    {
      paramslv = (stWeishiReportRsp)paramslv.a;
      sne.b("weishi-report", "report" + this.a + "end: " + paramslv.code + paramslv.msg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     smr
 * JD-Core Version:    0.7.0.1
 */