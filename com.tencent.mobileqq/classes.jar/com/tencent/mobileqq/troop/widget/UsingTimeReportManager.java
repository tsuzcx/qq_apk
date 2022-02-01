package com.tencent.mobileqq.troop.widget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;

public class UsingTimeReportManager
  extends BroadcastReceiver
  implements Manager
{
  private AppInterface a;
  private List<UsingTimeReportManager.IStateChangeCallBack> b = new ArrayList();
  private IntentFilter c;
  
  public UsingTimeReportManager(AppInterface paramAppInterface)
  {
    this.a = paramAppInterface;
    this.c = new IntentFilter();
    this.c.addAction("android.intent.action.SCREEN_OFF");
    this.c.addAction("mqq.intent.action.QQ_BACKGROUND");
    this.c.addAction("mqq.intent.action.QQ_FOREGROUND");
    this.c.addAction("mqq.intent.action.ACCOUNT_KICKED");
    try
    {
      paramAppInterface = paramAppInterface.getApp();
      if (paramAppInterface != null)
      {
        paramAppInterface.registerReceiver(this, this.c);
        return;
      }
    }
    catch (Exception paramAppInterface)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("init,");
      localStringBuilder.append(paramAppInterface.toString());
      QLog.e("UsingTimeReportManager", 1, localStringBuilder.toString(), paramAppInterface);
    }
  }
  
  private void b()
  {
    try
    {
      Object localObject1 = new ArrayList();
      ((List)localObject1).addAll(this.b);
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((UsingTimeReportManager.IStateChangeCallBack)((Iterator)localObject1).next()).d();
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  private void c()
  {
    try
    {
      Object localObject1 = new ArrayList();
      ((List)localObject1).addAll(this.b);
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((UsingTimeReportManager.IStateChangeCallBack)((Iterator)localObject1).next()).e();
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void a()
  {
    try
    {
      Object localObject1 = new ArrayList();
      ((List)localObject1).addAll(this.b);
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((UsingTimeReportManager.IStateChangeCallBack)((Iterator)localObject1).next()).f();
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void a(UsingTimeReportManager.IStateChangeCallBack paramIStateChangeCallBack)
  {
    try
    {
      if (!this.b.contains(paramIStateChangeCallBack)) {
        this.b.add(paramIStateChangeCallBack);
      }
      return;
    }
    finally
    {
      paramIStateChangeCallBack = finally;
      throw paramIStateChangeCallBack;
    }
  }
  
  public void b(UsingTimeReportManager.IStateChangeCallBack paramIStateChangeCallBack)
  {
    try
    {
      if (this.b.contains(paramIStateChangeCallBack)) {
        this.b.remove(paramIStateChangeCallBack);
      }
      return;
    }
    finally
    {
      paramIStateChangeCallBack = finally;
      throw paramIStateChangeCallBack;
    }
  }
  
  public void onDestroy()
  {
    try
    {
      this.b.clear();
      try
      {
        BaseApplication localBaseApplication = this.a.getApp();
        if (localBaseApplication != null) {
          localBaseApplication.unregisterReceiver(this);
        }
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("unInit");
        localStringBuilder.append(localException.toString());
        QLog.e("UsingTimeReportManager", 1, localStringBuilder.toString(), localException);
      }
      return;
    }
    finally {}
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("android.intent.action.SCREEN_OFF".equals(paramContext))
    {
      b();
      return;
    }
    if ("android.intent.action.SCREEN_ON".equals(paramContext))
    {
      c();
      return;
    }
    if ("mqq.intent.action.QQ_BACKGROUND".equals(paramContext))
    {
      b();
      return;
    }
    if ("mqq.intent.action.QQ_FOREGROUND".equals(paramContext))
    {
      c();
      return;
    }
    if ("mqq.intent.action.ACCOUNT_KICKED".equals(paramContext)) {
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.UsingTimeReportManager
 * JD-Core Version:    0.7.0.1
 */