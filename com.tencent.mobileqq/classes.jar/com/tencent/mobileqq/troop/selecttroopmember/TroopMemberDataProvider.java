package com.tencent.mobileqq.troop.selecttroopmember;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.troop.api.handler.ITroopMemberListHandler;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class TroopMemberDataProvider
{
  protected static double h = 10.0D;
  protected static int i = 300000;
  private static int m = 1000;
  protected QQAppInterface a;
  protected Context b;
  protected String c;
  protected TroopMemberDataProvider.DataNotifyCallBack d;
  protected ArrayList<TroopMemberInfo> e = new ArrayList();
  protected boolean f = false;
  protected double g = 0.0D;
  protected int j = 0;
  Handler k = new TroopMemberDataProvider.1(this);
  private TroopObserver l = new TroopMemberDataProvider.2(this);
  
  public TroopMemberDataProvider(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, boolean paramBoolean, TroopMemberDataProvider.DataNotifyCallBack paramDataNotifyCallBack)
  {
    this.a = paramQQAppInterface;
    this.b = paramContext;
    this.c = paramString;
    this.d = paramDataNotifyCallBack;
    this.f = paramBoolean;
    this.a.addObserver(this.l);
  }
  
  private void a(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      Object localObject = ((TroopManager)this.a.getManager(QQManagerFactory.TROOP_MANAGER)).f(paramString);
      if (localObject != null) {
        localObject = ((TroopInfo)localObject).troopcode;
      } else {
        localObject = "0";
      }
      if ((localObject != null) && (((String)localObject).length() > 0))
      {
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
        {
          paramString = this.b;
          QQToast.makeText(paramString, paramString.getString(2131889169), 0).show();
          return;
        }
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("get troop members from server, troopUin: ");
          localStringBuilder.append(paramString);
          localStringBuilder.append(" troopCode: ");
          localStringBuilder.append((String)localObject);
          QLog.d("TroopMemberDataProvider", 2, localStringBuilder.toString());
        }
        ((ITroopMemberListHandler)this.a.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_LIST_HANDLER)).a(true, paramString, (String)localObject, true, 7, System.currentTimeMillis(), 0);
      }
    }
  }
  
  private void a(String paramString, List<TroopMemberInfo> paramList)
  {
    if (paramList == null) {}
    try
    {
      paramList = this.a.getEntityManagerFactory().createEntityManager();
      localObject = paramList.query(TroopMemberInfo.class, false, "troopuin=? ", new String[] { paramString }, null, null, null, null);
      paramList.close();
      if (!QLog.isColorLevel()) {
        break label401;
      }
      paramList = new StringBuilder();
      paramList.append("getTroopMemberFromDB, troopMemberInfoList==null, queryDB, troopUin=");
      paramList.append(paramString);
      paramList.append(",");
      if (localObject == null) {
        n = 0;
      } else {
        n = ((List)localObject).size();
      }
      paramList.append(n);
      QLog.d("TroopMemberDataProvider", 2, paramList.toString());
    }
    finally
    {
      for (;;)
      {
        Object localObject;
        int i1;
        int i2;
        StringBuilder localStringBuilder;
        for (;;)
        {
          throw paramString;
        }
        continue;
        int n = 1;
        continue;
        n = 0;
      }
    }
    localObject = paramList;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getTroopMemberFromDB, troopuin=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(",");
      if (paramList == null) {
        n = 0;
      } else {
        n = paramList.size();
      }
      ((StringBuilder)localObject).append(n);
      QLog.d("TroopMemberDataProvider", 2, ((StringBuilder)localObject).toString());
      localObject = paramList;
    }
    if (localObject == null)
    {
      paramString = this.k.obtainMessage(2);
      this.k.sendMessage(paramString);
      return;
    }
    i1 = ((List)localObject).size();
    this.j = (i1 - 1);
    if (i1 > 0)
    {
      i2 = i1 / m;
      if (i1 % m == 0)
      {
        n = 0;
        paramList = new AtomicInteger(i2 + n);
        if (!QLog.isColorLevel()) {
          break label409;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("parallel process mJobCount: ");
        localStringBuilder.append(paramList.get());
        QLog.d("TroopMemberDataProvider", 2, localStringBuilder.toString());
        break label409;
        while (n < i1)
        {
          ThreadManager.post(new TroopMemberDataProvider.4(this, paramString, (List)localObject, n, Math.min(m + n - 1, i1), paramList), 8, null, false);
          n += m;
        }
      }
    }
    else
    {
      paramString = this.k.obtainMessage(2);
      this.k.sendMessage(paramString);
      return;
    }
  }
  
  private void d()
  {
    ITroopMemberListHandler localITroopMemberListHandler = (ITroopMemberListHandler)this.a.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_LIST_HANDLER);
    if (localITroopMemberListHandler != null) {}
    try
    {
      localITroopMemberListHandler.a(Long.parseLong(this.c), 0L, 6, null, 0, 0);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void a()
  {
    Object localObject = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("last_update_time");
    localStringBuilder.append(this.a.getCurrentAccountUin());
    localObject = ((Context)localObject).getSharedPreferences(localStringBuilder.toString(), 4);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_last_update_time");
    localStringBuilder.append(this.c);
    long l1 = ((SharedPreferences)localObject).getLong(localStringBuilder.toString(), 0L);
    long l2 = System.currentTimeMillis();
    long l3 = Math.abs(l2 - l1);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getTroopMembers, lastUpdateTime=");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append(", curTime=");
      ((StringBuilder)localObject).append(l2);
      ((StringBuilder)localObject).append(", diff=");
      ((StringBuilder)localObject).append(l3);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(hashCode());
      QLog.d("TroopMemberDataProvider", 2, ((StringBuilder)localObject).toString());
    }
    localObject = ((TroopManager)this.a.getManager(QQManagerFactory.TROOP_MANAGER)).f(this.c);
    if (localObject != null)
    {
      this.j = (((TroopInfo)localObject).wMemberNum - 1);
      if (this.j > 0)
      {
        this.g = 0.0D;
        localObject = this.k;
        ((Handler)localObject).sendMessage(((Handler)localObject).obtainMessage(3));
      }
    }
    if ((!this.f) && ((l1 == 0L) || ((l1 > 0L) && (l3 > i))))
    {
      a(this.c);
      return;
    }
    localObject = new TroopMemberDataProvider.3(this);
    this.a.execute((Runnable)localObject);
  }
  
  public ArrayList<TroopMemberInfo> b()
  {
    return this.e;
  }
  
  public void c()
  {
    QQAppInterface localQQAppInterface = this.a;
    if (localQQAppInterface != null) {
      localQQAppInterface.removeObserver(this.l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.selecttroopmember.TroopMemberDataProvider
 * JD-Core Version:    0.7.0.1
 */