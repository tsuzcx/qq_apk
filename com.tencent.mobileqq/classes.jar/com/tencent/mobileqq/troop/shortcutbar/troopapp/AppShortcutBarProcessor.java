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
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  public NavigateBarManager a;
  private AIOShortcutBarContext jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext;
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver;
  private TroopRedDotObserver jdField_a_of_type_ComTencentMobileqqTroopObserverTroopRedDotObserver;
  private IShortcutBarDataProvider jdField_a_of_type_ComTencentMobileqqTroopShortcutbarIShortcutBarDataProvider;
  private TroopShortcutBarObserver jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopShortcutBarObserver;
  private String jdField_a_of_type_JavaLangString;
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  
  public AppShortcutBarProcessor(AIOShortcutBarContext paramAIOShortcutBarContext, IShortcutBarDataProvider paramIShortcutBarDataProvider) {}
  
  private long a()
  {
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    if ((localSessionInfo != null) && (localSessionInfo.jdField_a_of_type_JavaLangString != null)) {}
    try
    {
      long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      return l;
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
    AppRuntime localAppRuntime = this.jdField_a_of_type_MqqAppAppRuntime;
    if ((localAppRuntime != null) && (paramBusinessObserver != null)) {
      ((QQAppInterface)localAppRuntime).addObserver(paramBusinessObserver);
    }
  }
  
  private void b(BusinessObserver paramBusinessObserver)
  {
    AppRuntime localAppRuntime = this.jdField_a_of_type_MqqAppAppRuntime;
    if ((localAppRuntime != null) && (paramBusinessObserver != null)) {
      ((QQAppInterface)localAppRuntime).removeObserver(paramBusinessObserver);
    }
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopShortcutBarObserver = new AppShortcutBarProcessor.1(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopObserverTroopRedDotObserver = new AppShortcutBarProcessor.2(this);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new AppShortcutBarProcessor.3(this);
  }
  
  private void i()
  {
    Object localObject = (TroopShortcutBarManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.TROOP_SHORTCUTBAR_MANAGER);
    if ((!"".equals(this.jdField_a_of_type_JavaLangString)) && (localObject != null))
    {
      long l = ((TroopShortcutBarManager)localObject).c(this.jdField_a_of_type_Long);
      if (l > ((TroopShortcutBarManager)localObject).b(this.jdField_a_of_type_Long)) {
        ((TroopShortcutBarManager)localObject).a(this.jdField_a_of_type_Long, l);
      }
      localObject = ((TroopShortcutBarManager)localObject).a(Long.valueOf(this.jdField_a_of_type_Long));
      if (localObject != null)
      {
        localObject = ((TroopShortcutBarInfo)localObject).a().iterator();
        while (((Iterator)localObject).hasNext()) {
          ((TroopShortcutBarApp)((Iterator)localObject).next()).b(false);
        }
      }
    }
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_MqqAppAppRuntime == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AppShortcutBarProcessor", 2, "getAIOShortcutBarInfoOnShow.");
    }
    TroopInfo localTroopInfo = ((TroopManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_a_of_type_JavaLangString);
    TroopShortcutBarConfig localTroopShortcutBarConfig = (TroopShortcutBarConfig)QConfigManager.a().a(590);
    TroopShortcutBarHandler localTroopShortcutBarHandler = (TroopShortcutBarHandler)((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).getBusinessHandler(BusinessHandlerFactory.TROOP_SHORTCUTBAR_HANDLE);
    if ((localTroopShortcutBarConfig != null) && (localTroopInfo != null) && ((localTroopShortcutBarConfig.a((int)localTroopInfo.dwGroupClassExt)) || (localTroopShortcutBarConfig.b((int)localTroopInfo.dwGroupClassExt)))) {}
    for (;;)
    {
      try
      {
        TroopShortcutBarInfo localTroopShortcutBarInfo = ((TroopShortcutBarManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.TROOP_SHORTCUTBAR_MANAGER)).a(Long.valueOf(this.jdField_a_of_type_Long));
        if (localTroopShortcutBarInfo != null)
        {
          if (!StudyModeManager.a()) {
            break label364;
          }
          i = 1;
          if ((localTroopShortcutBarInfo.a() < System.currentTimeMillis()) || ((StudyModeManager.a()) && (this.jdField_a_of_type_Int != i)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("AppShortcutBarProcessor", 2, "onShow. AIO TroopShortcutBar cache is out of date. Getting new list from server. ");
            }
            this.jdField_a_of_type_Int = i;
            localTroopShortcutBarHandler.a(this.jdField_a_of_type_Long, (int)localTroopInfo.dwGroupClassExt, null);
          }
          if (QLog.isColorLevel()) {
            QLog.d("AppShortcutBarProcessor", 2, "onShow. updateAppShortcutPanel. ");
          }
          if (localTroopInfo.isAdmin()) {
            break label374;
          }
          if (!localTroopInfo.isTroopOwner(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin())) {
            break label369;
          }
          break label374;
          if (i != 0) {
            break label384;
          }
          if (localTroopShortcutBarConfig.jdField_a_of_type_Int != TroopShortcutBarConfig.c) {
            break label379;
          }
          break label384;
          if (((i == 0) && (localTroopShortcutBarInfo.a() == 0)) || ((i != 0) && (localTroopShortcutBarInfo.b() == 0)))
          {
            this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarIShortcutBarDataProvider.a(0, a(localTroopShortcutBarInfo.a()), bool);
            return;
          }
          this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarIShortcutBarDataProvider.a(0, null, bool);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("AppShortcutBarProcessor", 2, "onShow. AIO TroopShortcutBar cache is null. Getting list from server. ");
        }
        localTroopShortcutBarHandler.a(this.jdField_a_of_type_Long, (int)localTroopInfo.dwGroupClassExt, null);
        return;
      }
      catch (Exception localException)
      {
        QLog.e("AppShortcutBarProcessor", 1, localException.getMessage());
      }
      return;
      label364:
      int i = 0;
      continue;
      label369:
      i = 0;
      continue;
      label374:
      i = 1;
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
    b(this.jdField_a_of_type_ComTencentMobileqqTroopObserverTroopRedDotObserver);
    b(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    b(this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopShortcutBarObserver);
    g();
    f();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarIShortcutBarDataProvider = null;
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
      paramObject = ((TroopShortcutBarApp)localObject).c();
      long l = ((TroopShortcutBarApp)localObject).b();
      TroopInfo localTroopInfo = ((TroopManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_a_of_type_JavaLangString);
      if (localTroopInfo == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AppShortcutBarProcessor", 2, "OnClickListener. troopInfo is null.");
        }
        return;
      }
      if (l == 101847770L) {
        ReportController.b(null, "dc00898", "", "", "0X800AAD4", "0X800AAD4", 0, 0, String.valueOf(((TroopShortcutBarApp)localObject).b()), this.jdField_a_of_type_JavaLangString, String.valueOf(localTroopInfo.dwGroupClassExt), "");
      }
      if ((l == 1101236949L) && (QVipBigTroopExpiredProcessor.c().mIsEnable) && (localTroopInfo.mIsFreezed == 1) && ((localTroopInfo.isAdmin()) || (localTroopInfo.isTroopOwner(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin())))) {
        ReportController.b(null, "dc00898", "", "", "0X800AAD4", "0X800AAD4", 0, 0, String.valueOf(((TroopShortcutBarApp)localObject).b()), this.jdField_a_of_type_JavaLangString, String.valueOf(localTroopInfo.dwGroupClassExt), "");
      }
      if (l == 101886235L)
      {
        TroopEssenceReportUtil.a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_JavaLangString, true);
        TroopEssenceReportUtil.b((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_JavaLangString, true);
      }
      int i = ((TroopShortcutBarApp)localObject).c();
      if (paramObject.startsWith("local")) {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext.b())
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext.a(true);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext.a(3);
        }
        else
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("troop_uin", localTroopInfo.troopuin);
          localIntent.putExtra("session_info", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
          localIntent.putExtra("fling_action_key", 2);
          localIntent.putExtra("fling_code_key", hashCode());
          localIntent.putExtra("reportfrom", 3);
          PublicFragmentActivity.Launcher.a(PlayModeUtils.a(), localIntent, PublicFragmentActivity.class, TroopAppShortcutFragment.class);
        }
      }
      ReportController.b(null, "dc00898", "", "", "0X800AAD4", "0X800AAD4", 0, 0, String.valueOf(((TroopShortcutBarApp)localObject).b()), this.jdField_a_of_type_JavaLangString, String.valueOf(localTroopInfo.dwGroupClassExt), "");
      localObject = this.jdField_a_of_type_AndroidAppActivity;
      if ((localObject instanceof BaseActivity)) {
        TroopAppShortcutUtils.a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_AndroidContentContext, (BaseActivity)localObject, this.jdField_a_of_type_JavaLangString, l, paramObject, 0, i);
      }
    }
  }
  
  public void b() {}
  
  public void b(Object paramObject) {}
  
  public void c() {}
  
  public void d()
  {
    j();
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioNavigateNavigateBarManager == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioNavigateNavigateBarManager = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioNavigateNavigateBarManager.a(4);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioNavigateNavigateBarManager.c(75);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioNavigateNavigateBarManager.a();
    }
  }
  
  public void f()
  {
    NavigateBarManager localNavigateBarManager = this.jdField_a_of_type_ComTencentMobileqqActivityAioNavigateNavigateBarManager;
    if (localNavigateBarManager != null)
    {
      localNavigateBarManager.b();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioNavigateNavigateBarManager = null;
    }
  }
  
  public void g()
  {
    NavigateBarManager localNavigateBarManager = this.jdField_a_of_type_ComTencentMobileqqActivityAioNavigateNavigateBarManager;
    if (localNavigateBarManager == null) {
      return;
    }
    localNavigateBarManager.d(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.troopapp.AppShortcutBarProcessor
 * JD-Core Version:    0.7.0.1
 */