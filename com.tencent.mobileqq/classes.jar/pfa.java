import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.mobileqq.statistics.ReportController;

public final class pfa
  implements Runnable
{
  public pfa(Exception paramException) {}
  
  public void run()
  {
    ReportController.b(null, "P_CliOper", "BizTechReport", "", "leba_search", "leba_search_set_data", 0, 0, HtmlOffline.a("1002"), this.a.getClass().getSimpleName(), null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pfa
 * JD-Core Version:    0.7.0.1
 */