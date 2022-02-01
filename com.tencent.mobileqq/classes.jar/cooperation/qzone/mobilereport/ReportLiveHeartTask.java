package cooperation.qzone.mobilereport;

import NS_USER_ACTION_REPORT.ItemInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.servlet.MobileReportServlet;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.utils.Tools;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;

public class ReportLiveHeartTask
  extends BaseReportTask
{
  private static final String TAG = "ReportLiveHeartTask";
  
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
    if (localAppRuntime == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      paramHashMap = new StringBuilder();
      paramHashMap.append("doMobileReport size = ");
      paramHashMap.append(localArrayList.size());
      QLog.i("ReportLiveHeartTask", 2, paramHashMap.toString());
    }
    MobileReportServlet.a(10, localAppRuntime, new UserCommReportBuilder().setUin(localAppRuntime.getLongAccountUin()).setNetwork_type(Tools.c()).build(), localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.mobilereport.ReportLiveHeartTask
 * JD-Core Version:    0.7.0.1
 */