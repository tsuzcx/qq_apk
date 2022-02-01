package com.tencent.mobileqq.leba.business.mainbiz;

import com.tencent.biz.TroopRedpoint.TroopRedTouchManager;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QZoneEntryReporterInLeba;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.servlet.CliNotifyPush;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.ReportInfo;
import cooperation.qzone.QZoneHelper;
import java.util.HashMap;

class LebaQzoneAndPluginPart$11
  implements Runnable
{
  LebaQzoneAndPluginPart$11(LebaQzoneAndPluginPart paramLebaQzoneAndPluginPart, boolean paramBoolean, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if (this.a) {
      StoryReportor.a("dynamic", "exp_story", 0, ((TroopRedTouchManager)this.b.getManager(QQManagerFactory.MGR_RED_TOUCH_EX)).s(), new String[0]);
    }
    this.this$0.n.a();
    QZoneHelper.preloadQzone(this.b, "Leba");
    this.this$0.g(this.b);
    Object localObject = (QZoneManagerImp)this.b.getManager(QQManagerFactory.QZONE_MANAGER);
    if (localObject != null)
    {
      QZoneEntryReporterInLeba.a((QZoneManagerImp)localObject, true, this.this$0.g());
      if (((QZoneManagerImp)localObject).d(1) > 0)
      {
        localObject = new QZoneClickReport.ReportInfo();
        ((QZoneClickReport.ReportInfo)localObject).actionType = "1";
        ((QZoneClickReport.ReportInfo)localObject).subactionType = "5";
        QZoneClickReport.report(this.b.getAccount(), (QZoneClickReport.ReportInfo)localObject, false);
        localObject = new HashMap();
        ((HashMap)localObject).put("unread_type", "5");
        StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(this.b.getAccount(), "actQZUnreadDataReport", true, 0L, 0L, (HashMap)localObject, null);
      }
      else if (((QZoneManagerImp)localObject).d(2) > 0)
      {
        localObject = new QZoneClickReport.ReportInfo();
        ((QZoneClickReport.ReportInfo)localObject).actionType = "1";
        ((QZoneClickReport.ReportInfo)localObject).subactionType = "6";
        QZoneClickReport.report(this.b.getAccount(), (QZoneClickReport.ReportInfo)localObject, false);
        localObject = new HashMap();
        ((HashMap)localObject).put("unread_type", "6");
        StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(this.b.getAccount(), "actQZUnreadDataReport", true, 0L, 0L, (HashMap)localObject, null);
      }
    }
    long l = System.currentTimeMillis();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(BaseApplicationImpl.getContext().getString(2131915889));
    ((StringBuilder)localObject).append(this.b.getAccount());
    if (l - LocalMultiProcConfig.getLong(((StringBuilder)localObject).toString(), 0L) > 86400000L)
    {
      localObject = new HashMap();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(BaseApplicationImpl.getContext().getString(2131915888));
      localStringBuilder.append(this.b.getAccount());
      if (LocalMultiProcConfig.getBool(localStringBuilder.toString(), true)) {
        ((HashMap)localObject).put("myfeednotifypush", "0");
      } else {
        ((HashMap)localObject).put("myfeednotifypush", "1");
      }
      if (CliNotifyPush.a(BaseApplicationImpl.getContext(), "com.qzone")) {
        ((HashMap)localObject).put("qzoneinstalled", "0");
      } else {
        ((HashMap)localObject).put("qzoneinstalled", "1");
      }
      StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(this.b.getAccount(), "qzonepushstate", true, 0L, 0L, (HashMap)localObject, null);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(BaseApplicationImpl.getContext().getString(2131915889));
      ((StringBuilder)localObject).append(this.b.getAccount());
      LocalMultiProcConfig.putLong(((StringBuilder)localObject).toString(), System.currentTimeMillis());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.mainbiz.LebaQzoneAndPluginPart.11
 * JD-Core Version:    0.7.0.1
 */