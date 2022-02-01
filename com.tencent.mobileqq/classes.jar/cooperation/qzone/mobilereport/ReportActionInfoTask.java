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

public class ReportActionInfoTask
  extends BaseReportTask
{
  protected void doMobileReport(HashMap<ReportKey, ArrayList<ItemInfo>> paramHashMap)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    ArrayList localArrayList = new ArrayList();
    paramHashMap = paramHashMap.entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      Object localObject = (Map.Entry)paramHashMap.next();
      UserActionReportBuilder localUserActionReportBuilder = new UserActionReportBuilder();
      localUserActionReportBuilder.setReportKey((ReportKey)((Map.Entry)localObject).getKey());
      localObject = ((ArrayList)((Map.Entry)localObject).getValue()).iterator();
      while (((Iterator)localObject).hasNext()) {
        localUserActionReportBuilder.addItemInfo((ItemInfo)((Iterator)localObject).next());
      }
      localArrayList.add(localUserActionReportBuilder.build());
    }
    MobileReportServlet.a(localAppRuntime, new UserCommReportBuilder().setUin(localAppRuntime.getLongAccountUin()).setNetwork_type(Tools.c()).build(), localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.mobilereport.ReportActionInfoTask
 * JD-Core Version:    0.7.0.1
 */