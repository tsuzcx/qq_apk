package com.tencent.mobileqq.leba.core;

import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.leba.business.LebaItemFilterProxy;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.leba.entity.LebaShowData;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.mobileqq.leba.logic.LebaPluginLogic;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import mqq.app.AppRuntime;

public class LebaShowListManager
{
  public static volatile int a;
  protected static volatile LebaShowListManager c;
  private static final Object g = new Object();
  public List<LebaViewItem> b = new ArrayList();
  public LebaItemFilterProxy d = new LebaItemFilterProxy();
  public boolean e = false;
  public HashMap<String, LebaViewItem> f = new HashMap();
  
  private LebaShowListManager()
  {
    a = 0;
    c();
  }
  
  public static LebaShowListManager a()
  {
    if (c == null) {
      synchronized (g)
      {
        if (c == null) {
          c = new LebaShowListManager();
        }
      }
    }
    return c;
  }
  
  public LebaViewItem a(long paramLong)
  {
    Iterator localIterator = d().iterator();
    while (localIterator.hasNext())
    {
      LebaViewItem localLebaViewItem = (LebaViewItem)localIterator.next();
      if (localLebaViewItem.b.uiResId == paramLong) {
        return localLebaViewItem;
      }
    }
    return null;
  }
  
  public List<LebaViewItem> a(AppRuntime paramAppRuntime)
  {
    return LebaPluginLogic.a(paramAppRuntime, this.b).a;
  }
  
  public void a(AppRuntime paramAppRuntime, List<LebaViewItem> paramList)
  {
    if (QLog.isDevelopLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("setAllLebaList, ");
      int i;
      if (paramList == null) {
        i = 0;
      } else {
        i = paramList.size();
      }
      ((StringBuilder)???).append(i);
      QLog.i("Q.lebatab.mgr", 4, ((StringBuilder)???).toString());
    }
    synchronized (this.b)
    {
      this.b.clear();
      if (paramList != null) {
        this.b.addAll(paramList);
      }
      LebaPluginLogic.a(paramAppRuntime, this.b);
      return;
    }
  }
  
  public List<LebaViewItem> b(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null)
    {
      QLog.i("LebaShowListManager", 1, "reloadLebaItems app == null");
      return new ArrayList();
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.lebatab.mgr", 4, String.format(Locale.getDefault(), "reloadLebaItems [%s, %s]", new Object[] { Boolean.valueOf(this.e), paramAppRuntime }));
    }
    ArrayList localArrayList = new ArrayList();
    List localList = null;
    Object localObject1 = (ILebaHelperService)paramAppRuntime.getRuntimeService(ILebaHelperService.class, "multi");
    if (localObject1 != null) {
      localList = ((ILebaHelperService)localObject1).getLebaConfigList();
    } else {
      QLog.d("LebaShowListManager", 1, "reloadLebaItems lebaHelperService == null");
    }
    if (localList != null)
    {
      Object localObject2 = new ArrayList(localList);
      localObject1 = new ArrayList();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        LebaPluginInfo localLebaPluginInfo = (LebaPluginInfo)((Iterator)localObject2).next();
        if (localLebaPluginInfo != null)
        {
          LebaViewItem localLebaViewItem = new LebaViewItem();
          try
          {
            localLebaViewItem.a = localLebaPluginInfo.uiResId;
            localLebaViewItem.b = localLebaPluginInfo;
            if (LebaUtil.a(localLebaViewItem))
            {
              this.f.put(localLebaViewItem.b.strPkgName, localLebaViewItem);
              continue;
            }
            if (this.d.a(localLebaViewItem)) {
              continue;
            }
            ((List)localObject1).add(localLebaViewItem);
          }
          catch (Exception localException) {}
          if (QLog.isColorLevel()) {
            QLog.d("Q.lebatab.mgr", 2, localException.toString());
          }
        }
      }
      LebaUtil.b((List)localObject1);
      Collections.sort((List)localObject1, new LebaUtil.LebaItemComparator());
      a(paramAppRuntime, (List)localObject1);
      paramAppRuntime = a(paramAppRuntime);
      LebaUtil.a(localArrayList, paramAppRuntime);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("reloadLebaItems, info.size=");
        ((StringBuilder)localObject1).append(localList.size());
        ((StringBuilder)localObject1).append(", alldatasize=");
        ((StringBuilder)localObject1).append(this.b.size());
        ((StringBuilder)localObject1).append(", pluginShowList=");
        ((StringBuilder)localObject1).append(paramAppRuntime.size());
        QLog.i("Q.lebatab.mgr", 2, ((StringBuilder)localObject1).toString());
      }
    }
    return localArrayList;
  }
  
  public void b()
  {
    synchronized (this.b)
    {
      this.b.clear();
      a = 0;
      return;
    }
  }
  
  public boolean b(long paramLong)
  {
    Object localObject = d();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      LebaViewItem localLebaViewItem;
      do
      {
        bool1 = bool2;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localLebaViewItem = (LebaViewItem)((Iterator)localObject).next();
      } while ((localLebaViewItem.b == null) || (localLebaViewItem.b.uiResId != paramLong));
      bool1 = bool2;
      if (localLebaViewItem.f == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void c()
  {
    this.d.a();
  }
  
  public void c(AppRuntime paramAppRuntime)
  {
    Object localObject = d();
    if (localObject == null) {
      return;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      LebaViewItem localLebaViewItem = (LebaViewItem)((Iterator)localObject).next();
      if (localLebaViewItem != null) {
        if (localLebaViewItem.f == 0)
        {
          if (localLebaViewItem.b != null) {
            ReportController.b(paramAppRuntime, "CliStatus", "", "", "trends_tab", "Clk_plug_in_s", 0, 0, "1", String.valueOf(localLebaViewItem.b.uiResId), "", "");
          }
        }
        else if ((localLebaViewItem.f == 1) && (localLebaViewItem.b != null)) {
          ReportController.b(paramAppRuntime, "CliStatus", "", "", "trends_tab", "Clk_plug_in_s", 0, 0, "0", String.valueOf(localLebaViewItem.b.uiResId), "", "");
        }
      }
    }
  }
  
  public List<LebaViewItem> d()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.b)
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        LebaViewItem localLebaViewItem = (LebaViewItem)localIterator.next();
        if ((localLebaViewItem != null) && (localLebaViewItem.b != null) && (localLebaViewItem.b.cDataType != 1)) {
          localArrayList.add(localLebaViewItem);
        }
      }
      LebaUtil.b(localArrayList);
      return localArrayList;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public List<LebaViewItem> e()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.b)
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        LebaViewItem localLebaViewItem = (LebaViewItem)localIterator.next();
        if ((localLebaViewItem != null) && (localLebaViewItem.b != null) && (localLebaViewItem.b.uiResId != 905L) && ((localLebaViewItem.f == 0) || (localLebaViewItem.b.uiResId == 0L))) {
          localArrayList.add(localLebaViewItem);
        }
      }
      return localArrayList;
    }
    for (;;)
    {
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.core.LebaShowListManager
 * JD-Core Version:    0.7.0.1
 */