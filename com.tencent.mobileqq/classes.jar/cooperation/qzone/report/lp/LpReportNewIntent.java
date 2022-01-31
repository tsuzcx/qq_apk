package cooperation.qzone.report.lp;

import NS_MOBILE_CLIENT_UPDATE.REPORT_INFO;
import android.content.Context;
import java.util.ArrayList;
import java.util.Map;
import mqq.app.NewIntent;
import mqq.app.Servlet;

public class LpReportNewIntent
  extends NewIntent
{
  public Map<String, String> extra_info;
  public ArrayList<Map<String, String>> info;
  public ArrayList<REPORT_INFO> multi_info;
  public long type;
  
  public LpReportNewIntent(Context paramContext, Class<? extends Servlet> paramClass)
  {
    super(paramContext, paramClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.report.lp.LpReportNewIntent
 * JD-Core Version:    0.7.0.1
 */