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
  protected TroopAppObserver a;
  private QQAppInterface b;
  private ConcurrentHashMap<Long, TroopShortcutBarInfo> c = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Long> d = new ConcurrentHashMap();
  private boolean e = false;
  private BroadcastReceiver f;
  private ConcurrentHashMap<Long, Integer> g = new ConcurrentHashMap();
  
  public TroopShortcutBarManager(QQAppInterface paramQQAppInterface)
  {
    this.b = paramQQAppInterface;
    this.c.clear();
    this.d.clear();
    c();
    this.a = new TroopShortcutBarManager.1(this);
    paramQQAppInterface.addObserver(this.a);
  }
  
  private void a(TroopShortcutBarApp paramTroopShortcutBarApp, Object paramObject)
  {
    if ((paramTroopShortcutBarApp != null) && (paramObject != null))
    {
      if (!(paramObject instanceof Long)) {
        return;
      }
      long l = ((Long)paramObject).longValue();
      if (paramTroopShortcutBarApp.d() == l) {
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
        TroopShortcutBarUtil.a(this.b, String.valueOf(paramLong), paramObject);
      }
    }
  }
  
  private static SharedPreferences b()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplicationImpl.getApplication().getRuntime().getAccount());
    localStringBuilder.append("troop_shortcut_bar");
    return localBaseApplicationImpl.getSharedPreferences(localStringBuilder.toString(), 0);
  }
  
  private void c()
  {
    this.f = new TroopShortcutBarManager.3(this);
    d();
  }
  
  private void d()
  {
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.mobileqq.addgroupapplication");
      this.b.getApp().registerReceiver(this.f, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      label31:
      break label31;
    }
    QLog.e("TroopShortcutBarManager", 1, "registerMiniAppAdd exception.");
  }
  
  private void e()
  {
    try
    {
      this.b.getApp().unregisterReceiver(this.f);
      return;
    }
    catch (Exception localException)
    {
      label15:
      break label15;
    }
    QLog.e("TroopShortcutBarManager", 1, "unregisterMiniAppAdd exception.");
  }
  
  public TroopShortcutBarInfo a(Long paramLong)
  {
    if (paramLong == null) {
      return null;
    }
    return (TroopShortcutBarInfo)this.c.get(paramLong);
  }
  
  public void a(long paramLong)
  {
    TroopShortcutBarInfo localTroopShortcutBarInfo = (TroopShortcutBarInfo)this.c.get(Long.valueOf(paramLong));
    if (localTroopShortcutBarInfo != null)
    {
      localTroopShortcutBarInfo.c(0);
      localTroopShortcutBarInfo.d(0);
      localTroopShortcutBarInfo.b(0L);
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    this.g.put(Long.valueOf(paramLong), Integer.valueOf(paramInt));
  }
  
  public void a(long paramLong, int paramInt, boolean paramBoolean)
  {
    TroopShortcutBarInfo localTroopShortcutBarInfo = (TroopShortcutBarInfo)this.c.get(Long.valueOf(paramLong));
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
    this.d.put(String.valueOf(paramLong1), Long.valueOf(paramLong2));
    ThreadManager.postImmediately(new TroopShortcutBarManager.2(this, paramLong1, paramLong2), null, false);
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt)
  {
    Object localObject = a(Long.valueOf(paramLong1));
    if (localObject == null) {
      return;
    }
    localObject = ((TroopShortcutBarInfo)localObject).d();
    if (localObject == null) {
      return;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      TroopShortcutBarApp localTroopShortcutBarApp = (TroopShortcutBarApp)((Iterator)localObject).next();
      if (localTroopShortcutBarApp.d() == paramLong2) {
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
      Object localObject = (TroopShortcutBarInfo)this.c.get(paramLong);
      Iterator localIterator1;
      if ((localObject != null) && (!paramBoolean))
      {
        paramTroopShortcutBarInfo.b(((TroopShortcutBarInfo)localObject).e());
        localObject = ((TroopShortcutBarInfo)localObject).d();
        localIterator1 = paramTroopShortcutBarInfo.d().iterator();
      }
      while (localIterator1.hasNext())
      {
        TroopShortcutBarApp localTroopShortcutBarApp1 = (TroopShortcutBarApp)localIterator1.next();
        Iterator localIterator2 = ((ArrayList)localObject).iterator();
        while (localIterator2.hasNext())
        {
          TroopShortcutBarApp localTroopShortcutBarApp2 = (TroopShortcutBarApp)localIterator2.next();
          if (localTroopShortcutBarApp1.d() == localTroopShortcutBarApp2.d()) {
            localTroopShortcutBarApp1.b(localTroopShortcutBarApp2.i());
          }
        }
        a(localTroopShortcutBarApp1, paramObject);
        continue;
        paramTroopShortcutBarInfo.b(System.currentTimeMillis() + paramTroopShortcutBarInfo.f());
      }
      this.c.put(paramLong, paramTroopShortcutBarInfo);
      d(paramLong.longValue());
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
      if (f(l) != 0)
      {
        Object localObject1 = (ITroopAppHandler)this.b.getBusinessHandler(BusinessHandlerFactory.TROOP_APP_HANDLER);
        if (localObject1 != null)
        {
          Object localObject2 = (ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class);
          QQAppInterface localQQAppInterface = this.b;
          if (!((ITroopUtilsApi)localObject2).isTroopAdmin(localQQAppInterface, paramString, localQQAppInterface.getCurrentUin()))
          {
            localObject2 = this.b;
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
        ((ITroopRedDotHandler)this.b.getBusinessHandler(BusinessHandlerFactory.TROOP_RED_DOT_HANDLER)).a(paramString, 101896870);
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
    SharedPreferences localSharedPreferences = b();
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
    this.e = paramBoolean;
  }
  
  public boolean a()
  {
    return this.e;
  }
  
  public long b(long paramLong)
  {
    SharedPreferences localSharedPreferences = b();
    if (localSharedPreferences != null) {
      return localSharedPreferences.getLong(String.valueOf(paramLong), 0L);
    }
    return 0L;
  }
  
  public long b(String paramString)
  {
    SharedPreferences localSharedPreferences = b();
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
  
  public void b(String paramString, long paramLong)
  {
    Object localObject = b();
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
    String str = String.valueOf(paramLong);
    if (this.d.containsKey(str)) {
      return ((Long)this.d.get(str)).longValue();
    }
    paramLong = b(paramLong);
    this.d.put(str, Long.valueOf(paramLong));
    return paramLong;
  }
  
  public void d(long paramLong)
  {
    Object localObject1 = (TroopShortcutBarInfo)this.c.get(Long.valueOf(paramLong));
    if (localObject1 == null) {
      return;
    }
    if (((TroopShortcutBarInfo)localObject1).a() != 1)
    {
      if (((TroopShortcutBarInfo)localObject1).b() == 1) {
        return;
      }
      Object localObject2 = ((TroopShortcutBarInfo)localObject1).d();
      if (localObject2 == null) {
        return;
      }
      if (c(paramLong) == 0L)
      {
        long l = e(paramLong);
        if (l > c(paramLong)) {
          a(paramLong, l);
        }
        return;
      }
      paramLong = Math.max(c(paramLong), ((TroopShortcutBarInfo)localObject1).g());
      localObject1 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (TroopShortcutBarApp)((Iterator)localObject1).next();
        if (localObject2 != null) {
          if (((TroopShortcutBarApp)localObject2).j() > paramLong) {
            ((TroopShortcutBarApp)localObject2).b(true);
          } else {
            ((TroopShortcutBarApp)localObject2).b(false);
          }
        }
      }
    }
  }
  
  public long e(long paramLong)
  {
    Object localObject = (TroopShortcutBarInfo)this.c.get(Long.valueOf(paramLong));
    if (localObject == null) {
      return 0L;
    }
    if (((TroopShortcutBarInfo)localObject).a() != 1)
    {
      if (((TroopShortcutBarInfo)localObject).b() == 1) {
        return 0L;
      }
      localObject = ((TroopShortcutBarInfo)localObject).d();
      if (localObject == null) {
        return 0L;
      }
      paramLong = c(paramLong);
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        TroopShortcutBarApp localTroopShortcutBarApp = (TroopShortcutBarApp)((Iterator)localObject).next();
        if (localTroopShortcutBarApp != null)
        {
          long l = localTroopShortcutBarApp.j();
          if (l > paramLong) {
            paramLong = l;
          }
        }
      }
      return paramLong;
    }
    return 0L;
  }
  
  public int f(long paramLong)
  {
    if (this.g.containsKey(Long.valueOf(paramLong))) {
      return ((Integer)this.g.get(Long.valueOf(paramLong))).intValue();
    }
    return 0;
  }
  
  public void onDestroy()
  {
    e();
    TroopAppObserver localTroopAppObserver = this.a;
    if (localTroopAppObserver != null) {
      this.b.removeObserver(localTroopAppObserver);
    }
    this.g.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarManager
 * JD-Core Version:    0.7.0.1
 */