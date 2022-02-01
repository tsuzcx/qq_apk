package com.tencent.mobileqq.c2cshortcutbar;

import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class C2CShortcutBarManager
  implements Manager
{
  private QQAppInterface a;
  private ConcurrentHashMap<Long, List<C2CShortcutAppInfo>> b;
  private ConcurrentHashMap<Long, Long> c;
  private ConcurrentHashMap<String, List<C2CShortcutAppInfo>> d;
  private ConcurrentHashMap<String, Integer> e;
  private int f;
  
  public C2CShortcutBarManager(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    c();
  }
  
  public static C2CShortcutBarManager a(QQAppInterface paramQQAppInterface)
  {
    return (C2CShortcutBarManager)paramQQAppInterface.getManager(QQManagerFactory.C2C_SHORTCUT_BAR_MANAGER);
  }
  
  private void c()
  {
    this.b = new ConcurrentHashMap();
    this.c = new ConcurrentHashMap();
    this.d = new ConcurrentHashMap(16);
    this.e = new ConcurrentHashMap(16);
  }
  
  public int a()
  {
    return this.f;
  }
  
  public int a(String paramString)
  {
    if (this.e.containsKey(paramString)) {
      return ((Integer)this.e.get(paramString)).intValue();
    }
    return 0;
  }
  
  public Long a(Long paramLong)
  {
    paramLong = (Long)this.c.get(paramLong);
    long l;
    if (paramLong != null) {
      l = paramLong.longValue();
    } else {
      l = 0L;
    }
    return Long.valueOf(l);
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setShortcutBarMaxAppNum ");
      localStringBuilder.append(paramInt);
      QLog.d("C2CShortcutBarSwitcher", 2, localStringBuilder.toString());
    }
    if (paramInt > 0) {
      this.f = paramInt;
    }
  }
  
  public void a(Long paramLong1, Long paramLong2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateShortcutAppInfoReqTimeStamp friendUin = ");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append(",nextReqTimeStamp = ");
      localStringBuilder.append(paramLong2);
      QLog.d("C2CShortcutBarSwitcher", 2, localStringBuilder.toString());
    }
    this.c.put(paramLong1, paramLong2);
  }
  
  public void a(Long paramLong, List<C2CShortcutAppInfo> paramList)
  {
    this.b.put(paramLong, paramList);
  }
  
  public void a(String paramString, int paramInt)
  {
    this.e.put(paramString, Integer.valueOf(paramInt));
  }
  
  public void a(String paramString, List<C2CShortcutAppInfo> paramList)
  {
    this.d.put(paramString, paramList);
  }
  
  public void a(boolean paramBoolean)
  {
    b().a(paramBoolean);
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    b().a(paramString, paramBoolean);
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    boolean bool1 = QLog.isColorLevel();
    boolean bool2 = false;
    if (bool1) {
      QLog.d("C2CShortcutBarSwitcher", 2, new Object[] { "isClickManager() position =", Integer.valueOf(paramInt1), " appListSize = ", Integer.valueOf(paramInt2), " shortcutBarMaxAppNum =", Integer.valueOf(this.f) });
    }
    bool1 = bool2;
    if (paramInt1 == paramInt2 - 1)
    {
      bool1 = bool2;
      if (paramInt2 > this.f) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public C2CShortcutBarHandler b()
  {
    return (C2CShortcutBarHandler)this.a.getBusinessHandler(BusinessHandlerFactory.C2C_SHORTCUT_BAR_HANDLER);
  }
  
  public List<C2CShortcutAppInfo> b(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getC2CShortcutBarStoreInfo() data = ");
      localStringBuilder.append(this.d.get(paramString));
      QLog.d("C2CShortcutBarSwitcher", 2, localStringBuilder.toString());
    }
    return (List)this.d.get(paramString);
  }
  
  public boolean b(Long paramLong)
  {
    paramLong = a(paramLong);
    return System.currentTimeMillis() / 1000L > paramLong.longValue();
  }
  
  public List<C2CShortcutAppInfo> c(Long paramLong)
  {
    Object localObject = (List)this.b.get(paramLong);
    int i = a();
    paramLong = new ArrayList();
    if (localObject == null) {
      return paramLong;
    }
    if (((List)localObject).size() > i)
    {
      paramLong.addAll(((List)localObject).subList(0, i));
      localObject = new C2CShortcutAppInfo();
      ((C2CShortcutAppInfo)localObject).c = BaseApplicationImpl.getContext().getResources().getString(2131887633);
      ((C2CShortcutAppInfo)localObject).d = "https://qzonestyle.gtimg.cn/aoi/sola/20191009150544_g1DgkNhLui.png";
      paramLong.add(localObject);
      return paramLong;
    }
    paramLong.addAll((Collection)localObject);
    return paramLong;
  }
  
  public void onDestroy()
  {
    this.d.clear();
    this.d = null;
    this.b.clear();
    this.e.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.c2cshortcutbar.C2CShortcutBarManager
 * JD-Core Version:    0.7.0.1
 */