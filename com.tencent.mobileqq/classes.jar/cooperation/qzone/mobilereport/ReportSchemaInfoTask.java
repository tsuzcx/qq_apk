package cooperation.qzone.mobilereport;

import NS_USER_ACTION_REPORT.ItemInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.servlet.MobileReportServlet;
import cooperation.vip.utils.Tools;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;

public class ReportSchemaInfoTask
  extends BaseReportTask
{
  protected void doMobileReport(HashMap<ReportKey, ArrayList<ItemInfo>> paramHashMap)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    ArrayList localArrayList = new ArrayList();
    paramHashMap = paramHashMap.entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramHashMap.next();
      QQSchemaBuilder localQQSchemaBuilder = new QQSchemaBuilder();
      localQQSchemaBuilder.setReportKey((ReportKey)localEntry.getKey());
      localArrayList.add(localQQSchemaBuilder.build());
    }
    MobileReportServlet.a(6, localAppRuntime, new UserCommReportBuilder().setUin(localAppRuntime.getLongAccountUin()).setNetwork_type(Tools.c()).build(), null, null, localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.mobilereport.ReportSchemaInfoTask
 * JD-Core Version:    0.7.0.1
 */