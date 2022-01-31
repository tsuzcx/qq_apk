package cooperation.qzone.report.lp;

import android.content.Context;
import java.util.ArrayList;
import java.util.Map;
import mqq.app.NewIntent;

public class LpReportNewIntent
  extends NewIntent
{
  public Map extra_info;
  public ArrayList info;
  public ArrayList multi_info;
  public long type;
  
  public LpReportNewIntent(Context paramContext, Class paramClass)
  {
    super(paramContext, paramClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.report.lp.LpReportNewIntent
 * JD-Core Version:    0.7.0.1
 */