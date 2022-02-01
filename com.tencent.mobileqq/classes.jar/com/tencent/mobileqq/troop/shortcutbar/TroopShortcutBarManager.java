package com.tencent.mobileqq.troop.shortcutbar;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.troopapps.api.ITroopAppHandler;
import com.tencent.mobileqq.troop.troopapps.api.TroopAppObserver;
import com.tencent.mobileqq.troop.troopreddot.api.ITroopRedDotHandler;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import tencent.im.oidb.cmd0xece.oidb_0xece.RspBody;

public class TroopShortcutBarManager
  implements Manager
{
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected TroopAppObserver a;
  private ConcurrentHashMap<Long, TroopShortcutBarInfo> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_a_of_type_Boolean = false;
  private ConcurrentHashMap<String, Long> b = new ConcurrentHashMap();
  private ConcurrentHashMap<Long, Integer> c = new ConcurrentHashMap();
  
  public TroopShortcutBarManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.b.clear();
    a();
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsApiTroopAppObserver = new TroopShortcutBarManager.1(this);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsApiTroopAppObserver);
  }
  
  private static SharedPreferences a()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplicationImpl.getApplication().getRuntime().getAccount());
    localStringBuilder.append("troop_shortcut_bar");
    return localBaseApplicationImpl.getSharedPreferences(localStringBuilder.toString(), 0);
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new TroopShortcutBarManager.3(this);
    b();
  }
  
  private void a(TroopShortcutBarApp paramTroopShortcutBarApp, Object paramObject)
  {
    if ((paramTroopShortcutBarApp != null) && (paramObject != null))
    {
      if (!(paramObject instanceof Long)) {
        return;
      }
      long l = ((Long)paramObject).longValue();
      if (paramTroopShortcutBarApp.b() == l) {
        paramTroopShortcutBarApp.c(true);
      }
    }
  }
  
  private void a(boolean paramBoolean, long paramLong, Object paramObject, int paramInt)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleGetAddTroopAppRemindInfo isSuccess:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" troopUin:");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" errCode:");
      localStringBuilder.append(paramInt);
      QLog.d("TroopShortcutBarManager", 2, localStringBuilder.toString());
    }
    if ((paramBoolean) && (paramObject != null))
    {
      if (!(paramObject instanceof oidb_0xece.RspBody)) {
        return;
      }
      paramObject = (oidb_0xece.RspBody)paramObject;
      if (paramObject.busi_id.get() != 1053) {
        return;
      }
      paramObject = TroopShortcutBarUtil.a(paramObject);
      if (paramObject != null)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("addRemindGrayTip tipItem");
          localStringBuilder.append(paramObject.toString());
          QLog.d("TroopShortcutBarManager", 2, localStringBuilder.toString());
        }
        TroopShortcutBarUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(paramLong), paramObject);
      }
    }
  }
  
  private void b()
  {
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.mobileqq.addgroupapplication");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      label31:
      break label31;
    }
    QLog.e("TroopShortcutBarManager", 1, "registerMiniAppAdd exception.");
  }
  
  private void c()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      return;
    }
    catch (Exception localException)
    {
      label15:
      break label15;
    }
    QLog.e("TroopShortcutBarManager", 1, "unregisterMiniAppAdd exception.");
  }
  
  public int a(long paramLong)
  {
    if (this.c.containsKey(Long.valueOf(paramLong))) {
      return ((Integer)this.c.get(Long.valueOf(paramLong))).intValue();
    }
    return 0;
  }
  
  public long a(long paramLong)
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences != null) {
      return localSharedPreferences.getLong(String.valueOf(paramLong), 0L);
    }
    return 0L;
  }
  
  public long a(String paramString)
  {
    SharedPreferences localSharedPreferences = a();
    if (!TextUtils.isEmpty(paramString))
    {
      if (localSharedPreferences == null) {
        return 0L;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("_last_remind_graytip_uniseq");
      return localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
    }
    return 0L;
  }
  
  public TroopShortcutBarInfo a(Long paramLong)
  {
    if (paramLong == null) {
      return null;
    }
    return (TroopShortcutBarInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramLong);
  }
  
  public void a(long paramLong)
  {
    TroopShortcutBarInfo localTroopShortcutBarInfo = (TroopShortcutBarInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
    if (localTroopShortcutBarInfo != null)
    {
      localTroopShortcutBarInfo.c(0);
      localTroopShortcutBarInfo.d(0);
      localTroopShortcutBarInfo.a(0L);
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    this.c.put(Long.valueOf(paramLong), Integer.valueOf(paramInt));
  }
  
  public void a(long paramLong, int paramInt, boolean paramBoolean)
  {
    TroopShortcutBarInfo localTroopShortcutBarInfo = (TroopShortcutBarInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
    if (localTroopShortcutBarInfo == null) {
      return;
    }
    localTroopShortcutBarInfo.a(paramInt);
    if (paramBoolean) {
      localTroopShortcutBarInfo.b(paramInt);
    }
    a(true);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.b.put(String.valueOf(paramLong1), Long.valueOf(paramLong2));
    ThreadManager.postImmediately(new TroopShortcutBarManager.2(this, paramLong1, paramLong2), null, false);
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt)
  {
    Object localObject = a(Long.valueOf(paramLong1));
    if (localObject == null) {
      return;
    }
    localObject = ((TroopShortcutBarInfo)localObject).a();
    if (localObject == null) {
      return;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      TroopShortcutBarApp localTroopShortcutBarApp = (TroopShortcutBarApp)((Iterator)localObject).next();
      if (localTroopShortcutBarApp.b() == paramLong2) {
        localTroopShortcutBarApp.b(paramInt);
      }
    }
  }
  
  public void a(Long paramLong, TroopShortcutBarInfo paramTroopShortcutBarInfo, boolean paramBoolean, Object paramObject)
  {
    if ((paramTroopShortcutBarInfo != null) && (paramLong != null))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("addTroopInfoToAIOCache. troopCode:");
        ((StringBuilder)localObject).append(String.valueOf(paramLong));
        QLog.e("TroopShortcutBarManager", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = (TroopShortcutBarInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramLong);
      Iterator localIterator1;
      if ((localObject != null) && (!paramBoolean))
      {
        paramTroopShortcutBarInfo.a(((TroopShortcutBarInfo)localObject).b());
        localObject = ((TroopShortcutBarInfo)localObject).a();
        localIterator1 = paramTroopShortcutBarInfo.a().iterator();
      }
      while (localIterator1.hasNext())
      {
        TroopShortcutBarApp localTroopShortcutBarApp1 = (TroopShortcutBarApp)localIterator1.next();
        Iterator localIterator2 = ((ArrayList)localObject).iterator();
        while (localIterator2.hasNext())
        {
          TroopShortcutBarApp localTroopShortcutBarApp2 = (TroopShortcutBarApp)localIterator2.next();
          if (localTroopShortcutBarApp1.b() == localTroopShortcutBarApp2.b()) {
            localTroopShortcutBarApp1.b(localTroopShortcutBarApp2.c());
          }
        }
        a(localTroopShortcutBarApp1, paramObject);
        continue;
        paramTroopShortcutBarInfo.a(System.currentTimeMillis() + paramTroopShortcutBarInfo.c());
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramLong, paramTroopShortcutBarInfo);
      b(paramLong.longValue());
      return;
    }
    if (QLog.isColorLevel())
    {
      paramTroopShortcutBarInfo = new StringBuilder();
      paramTroopShortcutBarInfo.append("addTroopInfoToAIOCache. troopCode:");
      paramTroopShortcutBarInfo.append(String.valueOf(paramLong));
      paramTroopShortcutBarInfo.append("is null");
      QLog.e("TroopShortcutBarManager", 2, paramTroopShortcutBarInfo.toString());
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      long l = Long.parseLong(paramString);
      if (a(l) != 0)
      {
        Object localObject1 = (ITroopAppHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_APP_HANDLER);
        if (localObject1 != null)
        {
          Object localObject2 = (ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class);
          QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          if (!((ITroopUtilsApi)localObject2).isTroopAdmin(localQQAppInterface, paramString, localQQAppInterface.getCurrentUin()))
          {
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            if (!TroopUtils.a((QQAppInterface)localObject2, paramString, ((QQAppInterface)localObject2).getCurrentUin())) {}
          }
          else
          {
            ((ITroopAppHandler)localObject1).a(l);
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("reqGetAddTroopAppRemindInfo troopUin：");
              ((StringBuilder)localObject1).append(l);
              QLog.d("TroopShortcutBarManager", 2, ((StringBuilder)localObject1).toString());
            }
          }
        }
        ((ITroopRedDotHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_RED_DOT_HANDLER)).a(paramString, 101896870);
        a(l, 0);
      }
      return;
    }
    catch (Exception paramString)
    {
      label175:
      break label175;
    }
    QLog.e("TroopShortcutBarManager", 1, "getAddTroopAppRemindInfo parseLong troopUin exception");
  }
  
  public void a(String paramString, long paramLong)
  {
    SharedPreferences localSharedPreferences = a();
    if (!paramString.isEmpty())
    {
      if (localSharedPreferences == null) {
        return;
      }
      localSharedPreferences.edit().putLong(paramString, paramLong).apply();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public long b(long paramLong)
  {
    String str = String.valueOf(paramLong);
    if (this.b.containsKey(str)) {
      return ((Long)this.b.get(str)).longValue();
    }
    paramLong = a(paramLong);
    this.b.put(str, Long.valueOf(paramLong));
    return paramLong;
  }
  
  public void b(long paramLong)
  {
    Object localObject1 = (TroopShortcutBarInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
    if (localObject1 == null) {
      return;
    }
    if (((TroopShortcutBarInfo)localObject1).a() != 1)
    {
      if (((TroopShortcutBarInfo)localObject1).b() == 1) {
        return;
      }
      Object localObject2 = ((TroopShortcutBarInfo)localObject1).a();
      if (localObject2 == null) {
        return;
      }
      if (b(paramLong) == 0L)
      {
        long l = c(paramLong);
        if (l > b(paramLong)) {
          a(paramLong, l);
        }
        return;
      }
      paramLong = Math.max(b(paramLong), ((TroopShortcutBarInfo)localObject1).c());
      localObject1 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (TroopShortcutBarApp)((Iterator)localObject1).next();
        if (localObject2 != null) {
          if (((TroopShortcutBarApp)localObject2).c() > paramLong) {
            ((TroopShortcutBarApp)localObject2).b(true);
          } else {
            ((TroopShortcutBarApp)localObject2).b(false);
          }
        }
      }
    }
  }
  
  public void b(String paramString, long paramLong)
  {
    Object localObject = a();
    if (!TextUtils.isEmpty(paramString))
    {
      if (localObject == null) {
        return;
      }
      localObject = ((SharedPreferences)localObject).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("_last_remind_graytip_uniseq");
      ((SharedPreferences.Editor)localObject).putLong(localStringBuilder.toString(), paramLong).apply();
    }
  }
  
  public long c(long paramLong)
  {
    Object localObject = (TroopShortcutBarInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
    if (localObject == null) {
      return 0L;
    }
    if (((TroopShortcutBarInfo)localObject).a() != 1)
    {
      if (((TroopShortcutBarInfo)localObject).b() == 1) {
        return 0L;
      }
      localObject = ((TroopShortcutBarInfo)localObject).a();
      if (localObject == null) {
        return 0L;
      }
      paramLong = b(paramLong);
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        TroopShortcutBarApp localTroopShortcutBarApp = (TroopShortcutBarApp)((Iterator)localObject).next();
        if (localTroopShortcutBarApp != null)
        {
          long l = localTroopShortcutBarApp.c();
          if (l > paramLong) {
            paramLong = l;
          }
        }
      }
      return paramLong;
    }
    return 0L;
  }
  
  public void onDestroy()
  {
    c();
    TroopAppObserver localTroopAppObserver = this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsApiTroopAppObserver;
    if (localTroopAppObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(localTroopAppObserver);
    }
    this.c.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarManager
 * JD-Core Version:    0.7.0.1
 */