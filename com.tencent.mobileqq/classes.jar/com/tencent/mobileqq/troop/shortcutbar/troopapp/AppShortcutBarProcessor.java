package com.tencent.mobileqq.troop.shortcutbar.troopapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.navigate.NavigateBarManager;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarContext;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceReportUtil;
import com.tencent.mobileqq.troop.observer.TroopRedDotObserver;
import com.tencent.mobileqq.troop.shortcutbar.IShortcutBarDataProvider;
import com.tencent.mobileqq.troop.shortcutbar.IShortcutBarProcessor;
import com.tencent.mobileqq.troop.shortcutbar.ShortcutBarInfo;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarApp;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarConfig;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarHandler;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarInfo;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarManager;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarObserver;
import com.tencent.mobileqq.troop.troopapps.TroopAppShortcutFragment;
import com.tencent.mobileqq.troop.utils.TroopAppShortcutUtils;
import com.tencent.mobileqq.vas.config.business.qvip.QVipBigTroopExpiredConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipBigTroopExpiredProcessor;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;

public class AppShortcutBarProcessor
  extends IShortcutBarProcessor
{
  public NavigateBarManager a;
  private AIOShortcutBarContext b;
  private IShortcutBarDataProvider c;
  private long d;
  private String e;
  private int f;
  private TroopShortcutBarObserver g;
  private TroopRedDotObserver h;
  private MessageObserver i;
  private AppRuntime j;
  private SessionInfo k;
  private Context l;
  private Activity m;
  
  public AppShortcutBarProcessor(AIOShortcutBarContext paramAIOShortcutBarContext, IShortcutBarDataProvider paramIShortcutBarDataProvider) {}
  
  private ArrayList<ShortcutBarInfo> a(ArrayList<TroopShortcutBarApp> paramArrayList)
  {
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        TroopShortcutBarApp localTroopShortcutBarApp = (TroopShortcutBarApp)paramArrayList.next();
        if ((localTroopShortcutBarApp != null) && ((localTroopShortcutBarApp instanceof ShortcutBarInfo))) {
          localArrayList.add(localTroopShortcutBarApp);
        }
      }
      return localArrayList;
    }
    return null;
  }
  
  private void a(BusinessObserver paramBusinessObserver)
  {
    AppRuntime localAppRuntime = this.j;
    if ((localAppRuntime != null) && (paramBusinessObserver != null)) {
      ((QQAppInterface)localAppRuntime).addObserver(paramBusinessObserver);
    }
  }
  
  private void b(BusinessObserver paramBusinessObserver)
  {
    AppRuntime localAppRuntime = this.j;
    if ((localAppRuntime != null) && (paramBusinessObserver != null)) {
      ((QQAppInterface)localAppRuntime).removeObserver(paramBusinessObserver);
    }
  }
  
  private void h()
  {
    this.g = new AppShortcutBarProcessor.1(this);
    this.h = new AppShortcutBarProcessor.2(this);
    this.i = new AppShortcutBarProcessor.3(this);
  }
  
  private void i()
  {
    Object localObject = (TroopShortcutBarManager)this.j.getManager(QQManagerFactory.TROOP_SHORTCUTBAR_MANAGER);
    if ((!"".equals(this.e)) && (localObject != null))
    {
      long l1 = ((TroopShortcutBarManager)localObject).e(this.d);
      if (l1 > ((TroopShortcutBarManager)localObject).c(this.d)) {
        ((TroopShortcutBarManager)localObject).a(this.d, l1);
      }
      localObject = ((TroopShortcutBarManager)localObject).a(Long.valueOf(this.d));
      if (localObject != null)
      {
        localObject = ((TroopShortcutBarInfo)localObject).d().iterator();
        while (((Iterator)localObject).hasNext()) {
          ((TroopShortcutBarApp)((Iterator)localObject).next()).b(false);
        }
      }
    }
  }
  
  private long j()
  {
    SessionInfo localSessionInfo = this.k;
    if ((localSessionInfo != null) && (localSessionInfo.b != null)) {}
    try
    {
      long l1 = Long.parseLong(this.k.b);
      return l1;
    }
    catch (Exception localException)
    {
      label35:
      break label35;
    }
    if (QLog.isColorLevel()) {
      QLog.e("AppShortcutBarProcessor", 2, "getTroopUinNoEmpty is Exception");
    }
    return 0L;
  }
  
  private void k()
  {
    if (this.j == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AppShortcutBarProcessor", 2, "getAIOShortcutBarInfoOnShow.");
    }
    TroopInfo localTroopInfo = ((TroopManager)this.j.getManager(QQManagerFactory.TROOP_MANAGER)).f(this.e);
    TroopShortcutBarConfig localTroopShortcutBarConfig = (TroopShortcutBarConfig)QConfigManager.b().b(590);
    TroopShortcutBarHandler localTroopShortcutBarHandler = (TroopShortcutBarHandler)((QQAppInterface)this.j).getBusinessHandler(BusinessHandlerFactory.TROOP_SHORTCUTBAR_HANDLE);
    if ((localTroopShortcutBarConfig != null) && (localTroopInfo != null) && ((localTroopShortcutBarConfig.a((int)localTroopInfo.dwGroupClassExt)) || (localTroopShortcutBarConfig.b((int)localTroopInfo.dwGroupClassExt)))) {}
    for (;;)
    {
      try
      {
        TroopShortcutBarInfo localTroopShortcutBarInfo = ((TroopShortcutBarManager)this.j.getManager(QQManagerFactory.TROOP_SHORTCUTBAR_MANAGER)).a(Long.valueOf(this.d));
        if (localTroopShortcutBarInfo != null)
        {
          if (!StudyModeManager.h()) {
            break label364;
          }
          n = 1;
          if ((localTroopShortcutBarInfo.c() < System.currentTimeMillis()) || ((StudyModeManager.h()) && (this.f != n)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("AppShortcutBarProcessor", 2, "onShow. AIO TroopShortcutBar cache is out of date. Getting new list from server. ");
            }
            this.f = n;
            localTroopShortcutBarHandler.a(this.d, (int)localTroopInfo.dwGroupClassExt, null);
          }
          if (QLog.isColorLevel()) {
            QLog.d("AppShortcutBarProcessor", 2, "onShow. updateAppShortcutPanel. ");
          }
          if (localTroopInfo.isAdmin()) {
            break label374;
          }
          if (!localTroopInfo.isTroopOwner(this.j.getCurrentAccountUin())) {
            break label369;
          }
          break label374;
          if (n != 0) {
            break label384;
          }
          if (localTroopShortcutBarConfig.e != TroopShortcutBarConfig.g) {
            break label379;
          }
          break label384;
          if (((n == 0) && (localTroopShortcutBarInfo.a() == 0)) || ((n != 0) && (localTroopShortcutBarInfo.b() == 0)))
          {
            this.c.a(0, a(localTroopShortcutBarInfo.d()), bool);
            return;
          }
          this.c.a(0, null, bool);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("AppShortcutBarProcessor", 2, "onShow. AIO TroopShortcutBar cache is null. Getting list from server. ");
        }
        localTroopShortcutBarHandler.a(this.d, (int)localTroopInfo.dwGroupClassExt, null);
        return;
      }
      catch (Exception localException)
      {
        QLog.e("AppShortcutBarProcessor", 1, localException.getMessage());
      }
      return;
      label364:
      int n = 0;
      continue;
      label369:
      n = 0;
      continue;
      label374:
      n = 1;
      continue;
      label379:
      boolean bool = false;
      continue;
      label384:
      bool = true;
    }
  }
  
  public void a()
  {
    i();
    b(this.h);
    b(this.i);
    b(this.g);
    g();
    f();
    this.b = null;
    this.c = null;
  }
  
  public void a(Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    if ((paramObject instanceof TroopShortcutBarApp))
    {
      i();
      Object localObject = (TroopShortcutBarApp)paramObject;
      paramObject = ((TroopShortcutBarApp)localObject).h();
      long l1 = ((TroopShortcutBarApp)localObject).d();
      TroopInfo localTroopInfo = ((TroopManager)this.j.getManager(QQManagerFactory.TROOP_MANAGER)).f(this.e);
      if (localTroopInfo == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AppShortcutBarProcessor", 2, "OnClickListener. troopInfo is null.");
        }
        return;
      }
      if (l1 == 101847770L) {
        ReportController.b(null, "dc00898", "", "", "0X800AAD4", "0X800AAD4", 0, 0, String.valueOf(((TroopShortcutBarApp)localObject).d()), this.e, String.valueOf(localTroopInfo.dwGroupClassExt), "");
      }
      if ((l1 == 1101236949L) && (QVipBigTroopExpiredProcessor.e().mIsEnable) && (localTroopInfo.mIsFreezed == 1) && ((localTroopInfo.isAdmin()) || (localTroopInfo.isTroopOwner(this.j.getCurrentAccountUin())))) {
        ReportController.b(null, "dc00898", "", "", "0X800AAD4", "0X800AAD4", 0, 0, String.valueOf(((TroopShortcutBarApp)localObject).d()), this.e, String.valueOf(localTroopInfo.dwGroupClassExt), "");
      }
      if (l1 == 101886235L)
      {
        TroopEssenceReportUtil.a((QQAppInterface)this.j, this.e, true);
        TroopEssenceReportUtil.b((QQAppInterface)this.j, this.e, true);
      }
      int n = ((TroopShortcutBarApp)localObject).i();
      if (paramObject.startsWith("local")) {
        if (this.b.m())
        {
          this.b.a(true);
          this.b.b(3);
        }
        else
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("troop_uin", localTroopInfo.troopuin);
          localIntent.putExtra("session_info", this.k);
          localIntent.putExtra("fling_action_key", 2);
          localIntent.putExtra("fling_code_key", hashCode());
          localIntent.putExtra("reportfrom", 3);
          PublicFragmentActivity.Launcher.a(PlayModeUtils.a(), localIntent, PublicFragmentActivity.class, TroopAppShortcutFragment.class);
        }
      }
      ReportController.b(null, "dc00898", "", "", "0X800AAD4", "0X800AAD4", 0, 0, String.valueOf(((TroopShortcutBarApp)localObject).d()), this.e, String.valueOf(localTroopInfo.dwGroupClassExt), "");
      localObject = this.m;
      if ((localObject instanceof BaseActivity)) {
        TroopAppShortcutUtils.a((QQAppInterface)this.j, this.l, (BaseActivity)localObject, this.e, l1, paramObject, 0, n);
      }
    }
  }
  
  public void b() {}
  
  public void b(Object paramObject) {}
  
  public void c() {}
  
  public void d()
  {
    k();
  }
  
  public void e()
  {
    if (this.a == null)
    {
      this.a = this.b.n();
      this.a.a(4);
      this.a.c(75);
      this.a.a();
    }
  }
  
  public void f()
  {
    NavigateBarManager localNavigateBarManager = this.a;
    if (localNavigateBarManager != null)
    {
      localNavigateBarManager.b();
      this.a = null;
    }
  }
  
  public void g()
  {
    NavigateBarManager localNavigateBarManager = this.a;
    if (localNavigateBarManager == null) {
      return;
    }
    localNavigateBarManager.d(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.troopapp.AppShortcutBarProcessor
 * JD-Core Version:    0.7.0.1
 */