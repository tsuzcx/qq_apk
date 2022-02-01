package com.tencent.mobileqq.multiaio.model;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.multiaio.manager.MultiAIOEntranceConfigData;
import com.tencent.mobileqq.multiaio.presenter.MultiAioContext;
import com.tencent.mobileqq.shortvideo.qmcf.QmcfDevicesStrategy;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.manager.Manager;

public class MultiAIOManager
  implements Manager
{
  private MultiAIOEntranceConfigData a;
  private AtomicInteger b = new AtomicInteger(0);
  private Map<Integer, MultiAioContext> c = new HashMap();
  private QQAppInterface d;
  private boolean e = false;
  private boolean f = false;
  
  public MultiAIOManager(QQAppInterface paramQQAppInterface)
  {
    this.d = paramQQAppInterface;
  }
  
  public int a(MultiAioContext paramMultiAioContext)
  {
    int i = this.b.getAndIncrement();
    try
    {
      this.c.put(Integer.valueOf(i), paramMultiAioContext);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("addAioContext() called with: multiAioContext = [");
        localStringBuilder.append(paramMultiAioContext);
        localStringBuilder.append("], id = [");
        localStringBuilder.append(i);
        localStringBuilder.append("]");
        QLog.d("MultiAIOManager", 2, localStringBuilder.toString());
      }
      return i;
    }
    finally {}
  }
  
  public MultiAioContext a(int paramInt)
  {
    try
    {
      MultiAioContext localMultiAioContext = (MultiAioContext)this.c.remove(Integer.valueOf(paramInt));
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("removeAioContext() called with: id = [");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("], multiAioContext = ");
        localStringBuilder.append(localMultiAioContext);
        QLog.d("MultiAIOManager", 2, localStringBuilder.toString());
      }
      return localMultiAioContext;
    }
    finally {}
  }
  
  public void a()
  {
    try
    {
      Iterator localIterator = this.c.values().iterator();
      while (localIterator.hasNext())
      {
        MultiAioContext localMultiAioContext = (MultiAioContext)localIterator.next();
        if (localMultiAioContext != null) {
          localMultiAioContext.b();
        }
      }
      this.c.clear();
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void a(MultiAIOEntranceConfigData paramMultiAIOEntranceConfigData)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onConfUpdate : ");
      localStringBuilder.append(paramMultiAIOEntranceConfigData);
      QLog.d("MultiAIOManager", 2, localStringBuilder.toString());
    }
    this.a = paramMultiAIOEntranceConfigData;
  }
  
  public MultiAioContext b(int paramInt)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getAioContext() called with: id = [");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append("]");
      QLog.d("MultiAIOManager", 2, ((StringBuilder)localObject1).toString());
    }
    try
    {
      localObject1 = (MultiAioContext)this.c.get(Integer.valueOf(paramInt));
      return localObject1;
    }
    finally {}
  }
  
  public void b()
  {
    this.a = ((MultiAIOEntranceConfigData)QConfigManager.b().b(478));
    if (this.a == null)
    {
      this.a = new MultiAIOEntranceConfigData();
      if (QLog.isColorLevel()) {
        QLog.d("MultiAIOManager", 2, "MultiAIOEntranceConfigData =null, general new bean");
      }
    }
  }
  
  public boolean c()
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("MultiAIOEntranceConfigData isConfigInited = ");
      ((StringBuilder)localObject1).append(this.f);
      QLog.d("MultiAIOManager", 2, ((StringBuilder)localObject1).toString());
    }
    if (this.f) {
      return this.e;
    }
    this.f = true;
    b();
    if (!this.a.a())
    {
      this.e = false;
      return false;
    }
    Object localObject1 = this.a.c();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(Build.MANUFACTURER);
    ((StringBuilder)localObject2).append(Build.MODEL);
    localObject2 = ((StringBuilder)localObject2).toString().trim();
    if ((localObject1 != null) && (((List)localObject1).contains(localObject2)))
    {
      this.e = false;
      return false;
    }
    localObject1 = this.a.b();
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (QmcfDevicesStrategy.b((String)localObject1) <= 0))
    {
      this.e = false;
      return false;
    }
    this.e = true;
    return true;
  }
  
  public void onDestroy()
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.model.MultiAIOManager
 * JD-Core Version:    0.7.0.1
 */