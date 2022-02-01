package com.tencent.mobileqq.troop.shortcutbar.troopapp;

import android.content.Intent;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.drawer.BaseChatDrawer;
import com.tencent.mobileqq.activity.aio.drawer.TroopAppShortcutDrawer;
import com.tencent.mobileqq.activity.aio.navigate.NavigateBarManager;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.qvip.QVipBigTroopExpiredConfig;
import com.tencent.mobileqq.config.business.qvip.QVipBigTroopExpiredProcessor;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceReportUtil;
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
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class AppShortcutBarProcessor
  extends IShortcutBarProcessor
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  public NavigateBarManager a;
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver;
  private TroopBusinessObserver jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver;
  private IShortcutBarDataProvider jdField_a_of_type_ComTencentMobileqqTroopShortcutbarIShortcutBarDataProvider;
  private TroopShortcutBarObserver jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopShortcutBarObserver;
  private String jdField_a_of_type_JavaLangString;
  
  public AppShortcutBarProcessor(BaseChatPie paramBaseChatPie, IShortcutBarDataProvider paramIShortcutBarDataProvider)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarIShortcutBarDataProvider = paramIShortcutBarDataProvider;
    this.jdField_a_of_type_Long = a();
    h();
    this.jdField_a_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_Long);
    a(this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopShortcutBarObserver);
    a(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    a(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
    if (StudyModeManager.a()) {
      i = 1;
    }
    this.jdField_a_of_type_Int = i;
  }
  
  private long a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) {}
    do
    {
      do
      {
        return 0L;
      } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString == null));
      try
      {
        long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        return l;
      }
      catch (Exception localException) {}
    } while (!QLog.isColorLevel());
    QLog.e("AppShortcutBarProcessor", 2, "getTroopUinNoEmpty is Exception");
    return 0L;
  }
  
  private ArrayList<ShortcutBarInfo> a(ArrayList<TroopShortcutBarApp> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return null;
    }
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
  
  private void a(BusinessObserver paramBusinessObserver)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (paramBusinessObserver != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(paramBusinessObserver);
    }
  }
  
  private void b(BusinessObserver paramBusinessObserver)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (paramBusinessObserver != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(paramBusinessObserver);
    }
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopShortcutBarObserver = new AppShortcutBarProcessor.1(this, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver = new AppShortcutBarProcessor.2(this);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new AppShortcutBarProcessor.3(this);
  }
  
  private void i()
  {
    Object localObject = (TroopShortcutBarManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_SHORTCUTBAR_MANAGER);
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) {}
    TroopInfo localTroopInfo;
    TroopShortcutBarConfig localTroopShortcutBarConfig;
    TroopShortcutBarHandler localTroopShortcutBarHandler;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AppShortcutBarProcessor", 2, "getAIOShortcutBarInfoOnShow.");
      }
      localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_a_of_type_JavaLangString);
      localTroopShortcutBarConfig = (TroopShortcutBarConfig)QConfigManager.a().a(590);
      localTroopShortcutBarHandler = (TroopShortcutBarHandler)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_SHORTCUTBAR_HANDLE);
    } while ((localTroopShortcutBarConfig == null) || (localTroopInfo == null) || ((!localTroopShortcutBarConfig.a((int)localTroopInfo.dwGroupClassExt)) && (!localTroopShortcutBarConfig.b((int)localTroopInfo.dwGroupClassExt))));
    for (;;)
    {
      boolean bool;
      try
      {
        localTroopShortcutBarInfo = ((TroopShortcutBarManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_SHORTCUTBAR_MANAGER)).a(Long.valueOf(this.jdField_a_of_type_Long));
        if (localTroopShortcutBarInfo == null) {
          break label358;
        }
        if (!StudyModeManager.a()) {
          break label327;
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
          break label389;
        }
        if (!localTroopInfo.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
          break label332;
        }
      }
      catch (Exception localException)
      {
        TroopShortcutBarInfo localTroopShortcutBarInfo;
        QLog.e("AppShortcutBarProcessor", 1, localException.getMessage());
        return;
      }
      if (i == 0)
      {
        if (localTroopShortcutBarConfig.jdField_a_of_type_Int == TroopShortcutBarConfig.c)
        {
          bool = true;
          if (((i == 0) && (localTroopShortcutBarInfo.a() == 0)) || ((i != 0) && (localTroopShortcutBarInfo.b() == 0)))
          {
            this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarIShortcutBarDataProvider.a(0, a(localTroopShortcutBarInfo.a()), bool);
            return;
            label327:
            i = 0;
            continue;
            label332:
            i = 0;
            continue;
          }
        }
        else
        {
          bool = false;
          continue;
        }
      }
      else
      {
        bool = true;
        continue;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarIShortcutBarDataProvider.a(0, null, bool);
      return;
      label358:
      if (QLog.isColorLevel()) {
        QLog.d("AppShortcutBarProcessor", 2, "onShow. AIO TroopShortcutBar cache is null. Getting list from server. ");
      }
      localTroopShortcutBarHandler.a(this.jdField_a_of_type_Long, (int)localException.dwGroupClassExt, null);
      return;
      label389:
      int i = 1;
    }
  }
  
  public void a()
  {
    i();
    b(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
    b(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    b(this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarTroopShortcutBarObserver);
    g();
    f();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopShortcutbarIShortcutBarDataProvider = null;
  }
  
  public void a(Object paramObject)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (paramObject == null)) {}
    String str;
    long l;
    TroopInfo localTroopInfo;
    do
    {
      do
      {
        return;
      } while (!(paramObject instanceof TroopShortcutBarApp));
      i();
      paramObject = (TroopShortcutBarApp)paramObject;
      str = paramObject.c();
      l = paramObject.b();
      localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_a_of_type_JavaLangString);
      if (localTroopInfo != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("AppShortcutBarProcessor", 2, "OnClickListener. troopInfo is null.");
    return;
    if (l == 101847770L) {
      ReportController.b(null, "dc00898", "", "", "0X800AAD4", "0X800AAD4", 0, 0, String.valueOf(paramObject.b()), this.jdField_a_of_type_JavaLangString, String.valueOf(localTroopInfo.dwGroupClassExt), "");
    }
    if ((l == 1101236949L) && (QVipBigTroopExpiredProcessor.c().mIsEnable) && (localTroopInfo.mIsFreezed == 1) && ((localTroopInfo.isAdmin()) || (localTroopInfo.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))) {
      ReportController.b(null, "dc00898", "", "", "0X800AAD4", "0X800AAD4", 0, 0, String.valueOf(paramObject.b()), this.jdField_a_of_type_JavaLangString, String.valueOf(localTroopInfo.dwGroupClassExt), "");
    }
    if (l == 101886235L)
    {
      TroopEssenceReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), this.jdField_a_of_type_JavaLangString, true);
      TroopEssenceReportUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(), this.jdField_a_of_type_JavaLangString, true);
    }
    int i = paramObject.c();
    if (str.startsWith("local"))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioDrawerBaseChatDrawer == null) {
        break label414;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioDrawerBaseChatDrawer.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioDrawerBaseChatDrawer.b(true);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioDrawerBaseChatDrawer instanceof TroopAppShortcutDrawer)) {
        ((TroopAppShortcutDrawer)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioDrawerBaseChatDrawer).c(3);
      }
    }
    for (;;)
    {
      ReportController.b(null, "dc00898", "", "", "0X800AAD4", "0X800AAD4", 0, 0, String.valueOf(paramObject.b()), this.jdField_a_of_type_JavaLangString, String.valueOf(localTroopInfo.dwGroupClassExt), "");
      TroopAppShortcutUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, l, str, 0, i);
      return;
      label414:
      Intent localIntent = new Intent();
      localIntent.putExtra("troop_uin", localTroopInfo.troopuin);
      localIntent.putExtra("session_info", this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      localIntent.putExtra("fling_action_key", 2);
      localIntent.putExtra("fling_code_key", hashCode());
      localIntent.putExtra("reportfrom", 3);
      PublicFragmentActivity.Launcher.a(PlayModeUtils.a(), localIntent, PublicFragmentActivity.class, TroopAppShortcutFragment.class);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) {}
  }
  
  public void b(Object paramObject) {}
  
  public void c() {}
  
  public void d()
  {
    j();
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioNavigateNavigateBarManager == null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null))
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c.findViewById(2131364598);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioNavigateNavigateBarManager = new NavigateBarManager(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localRelativeLayout);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioNavigateNavigateBarManager.a(4);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioNavigateNavigateBarManager.c(75);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioNavigateNavigateBarManager.a();
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioNavigateNavigateBarManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioNavigateNavigateBarManager.b();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioNavigateNavigateBarManager = null;
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioNavigateNavigateBarManager == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioNavigateNavigateBarManager.d(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.troopapp.AppShortcutBarProcessor
 * JD-Core Version:    0.7.0.1
 */