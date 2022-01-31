import com.tencent.biz.TroopRedpoint.TroopRedTouchManager;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.activity.QZoneEntryReporterInLeba;
import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.servlet.CliNotifyPush;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.ReportInfo;
import cooperation.qzone.QZoneHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class tci
  implements Runnable
{
  public tci(Leba paramLeba) {}
  
  public void run()
  {
    Object localObject1 = LebaShowListManager.a().a(this.a.a);
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (LebaViewItem)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          ReportController.b(this.a.a, "CliOper", "", "", "0X8005416", "0X8005416", 0, 0, ((LebaViewItem)localObject2).a.uiResId + "", "", "", "");
          if (((LebaViewItem)localObject2).a.uiResId == 6005L) {
            StoryReportor.a("dynamic", "exp_story", 0, ((TroopRedTouchManager)this.a.a.getManager(69)).c(), new String[0]);
          }
        }
      }
    }
    Leba.a(this.a).a();
    QZoneHelper.a(this.a.a, "Leba");
    Leba.a(this.a);
    localObject1 = (QZoneManagerImp)this.a.a.getManager(9);
    if (localObject1 != null)
    {
      if (((QZoneManagerImp)localObject1).a(1) > 0)
      {
        localObject2 = new QZoneClickReport.ReportInfo();
        ((QZoneClickReport.ReportInfo)localObject2).c = "1";
        ((QZoneClickReport.ReportInfo)localObject2).d = "5";
        QZoneClickReport.report(this.a.a.getAccount(), (QZoneClickReport.ReportInfo)localObject2, false);
        localObject2 = new HashMap();
        ((HashMap)localObject2).put("unread_type", "5");
        StatisticCollector.a(BaseApplicationImpl.getContext()).a(this.a.a.getAccount(), "actQZUnreadDataReport", true, 0L, 0L, (HashMap)localObject2, null);
        QZoneEntryReporterInLeba.b(this.a.a, ((QZoneManagerImp)localObject1).a(1));
      }
    }
    else if (System.currentTimeMillis() - LocalMultiProcConfig.getLong(BaseApplicationImpl.getContext().getString(2131434224) + this.a.a.getAccount(), 0L) > 86400000L)
    {
      localObject1 = new HashMap();
      if (!LocalMultiProcConfig.getBool(BaseApplicationImpl.getContext().getString(2131434223) + this.a.a.getAccount(), true)) {
        break label624;
      }
      ((HashMap)localObject1).put("myfeednotifypush", "0");
      label405:
      if (!CliNotifyPush.a(BaseApplicationImpl.getContext(), "com.qzone")) {
        break label636;
      }
      ((HashMap)localObject1).put("qzoneinstalled", "0");
    }
    for (;;)
    {
      StatisticCollector.a(BaseApplicationImpl.getContext()).a(this.a.a.getAccount(), "qzonepushstate", true, 0L, 0L, (HashMap)localObject1, null);
      LocalMultiProcConfig.putLong(BaseApplicationImpl.getContext().getString(2131434224) + this.a.a.getAccount(), System.currentTimeMillis());
      return;
      if (((QZoneManagerImp)localObject1).a(2) > 0)
      {
        localObject2 = new QZoneClickReport.ReportInfo();
        ((QZoneClickReport.ReportInfo)localObject2).c = "1";
        ((QZoneClickReport.ReportInfo)localObject2).d = "6";
        QZoneClickReport.report(this.a.a.getAccount(), (QZoneClickReport.ReportInfo)localObject2, false);
        localObject2 = new HashMap();
        ((HashMap)localObject2).put("unread_type", "6");
        StatisticCollector.a(BaseApplicationImpl.getContext()).a(this.a.a.getAccount(), "actQZUnreadDataReport", true, 0L, 0L, (HashMap)localObject2, null);
        localObject1 = ((QZoneManagerImp)localObject1).a();
        if ((localObject1 == null) || (((ArrayList)localObject1).size() <= 0)) {
          break;
        }
        QZoneEntryReporterInLeba.a(this.a.a, ((ArrayList)localObject1).size());
        break;
      }
      QZoneEntryReporterInLeba.b(this.a.a);
      break;
      label624:
      ((HashMap)localObject1).put("myfeednotifypush", "1");
      break label405;
      label636:
      ((HashMap)localObject1).put("qzoneinstalled", "1");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tci
 * JD-Core Version:    0.7.0.1
 */