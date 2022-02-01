package cooperation.qzone.mobilereport;

import NS_USER_ACTION_REPORT.ItemInfo;
import bcvn;
import bmoq;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;

class MobileReportManager$ReportLiveTask
  extends MobileReportManager.ReportTask
{
  private MobileReportManager$ReportLiveTask()
  {
    super(null);
  }
  
  protected void doMobileReport(HashMap<MobileReportManager.ReportKey, ArrayList<ItemInfo>> paramHashMap)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    ArrayList localArrayList = new ArrayList();
    paramHashMap = paramHashMap.entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      Object localObject = (Map.Entry)paramHashMap.next();
      MobileReportManager.UserActionReportBuilder localUserActionReportBuilder = new MobileReportManager.UserActionReportBuilder(null);
      localUserActionReportBuilder.setReportKey((MobileReportManager.ReportKey)((Map.Entry)localObject).getKey());
      localObject = ((ArrayList)((Map.Entry)localObject).getValue()).iterator();
      while (((Iterator)localObject).hasNext()) {
        localUserActionReportBuilder.addItemInfo((ItemInfo)((Iterator)localObject).next());
      }
      localArrayList.add(localUserActionReportBuilder.build());
    }
    bcvn.a(8, localAppRuntime, new MobileReportManager.UserCommReportBuilder(null).setUin(localAppRuntime.getLongAccountUin()).setNetwork_type(bmoq.c()).build(), localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.mobilereport.MobileReportManager.ReportLiveTask
 * JD-Core Version:    0.7.0.1
 */