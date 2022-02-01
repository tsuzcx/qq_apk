package com.tencent.mobileqq.leba.more;

import android.content.Context;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.leba.business.LebaMoreVipBizProxy;
import com.tencent.mobileqq.leba.entity.LebaMoreViewItem;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.leba.entity.LebaPluginSetting;
import com.tencent.mobileqq.leba.entity.LebaPluginSettingItem;
import com.tencent.mobileqq.leba.entity.LebaShowData;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.mobileqq.leba.feed.LebaFeedUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class LebaMoreDataLogic
{
  public final List<LebaMoreViewItem> a = new ArrayList();
  public final List<LebaMoreViewItem> b = new ArrayList();
  public final List<LebaMoreViewItem> c = new ArrayList();
  public final List<LebaMoreViewItem> d = new ArrayList();
  public final List<List<LebaMoreViewItem>> e = new ArrayList();
  public int f;
  public int g;
  protected AppRuntime h;
  protected LebaMoreVipBizProxy i;
  protected boolean j = false;
  public long k = 0L;
  
  public LebaMoreDataLogic()
  {
    this.e.add(this.a);
    this.e.add(this.b);
    this.e.add(this.c);
    this.e.add(this.d);
  }
  
  public int a()
  {
    Iterator localIterator = this.e.iterator();
    int m = 0;
    while (localIterator.hasNext()) {
      m += ((List)localIterator.next()).size();
    }
    return m;
  }
  
  public int a(int paramInt)
  {
    LebaMoreViewItem localLebaMoreViewItem = b(paramInt);
    if (localLebaMoreViewItem == null) {
      return 1;
    }
    return localLebaMoreViewItem.a;
  }
  
  public int a(LebaMoreViewItem paramLebaMoreViewItem)
  {
    int m = 0;
    int i1;
    for (int n = 0; m < this.d.size(); n = i1)
    {
      LebaMoreViewItem localLebaMoreViewItem = (LebaMoreViewItem)this.d.get(m);
      i1 = n;
      if (localLebaMoreViewItem != null)
      {
        i1 = n;
        if (localLebaMoreViewItem.c != null) {
          if (localLebaMoreViewItem.c.b == null)
          {
            i1 = n;
          }
          else
          {
            if (paramLebaMoreViewItem.e) {
              if ((!localLebaMoreViewItem.e) || (paramLebaMoreViewItem.f <= localLebaMoreViewItem.f)) {
                break;
              }
            } else {
              if (!localLebaMoreViewItem.e) {
                break label114;
              }
            }
            for (;;)
            {
              i1 = m + 1;
              break;
              label114:
              if (paramLebaMoreViewItem.c.b.sPriority <= localLebaMoreViewItem.c.b.sPriority) {
                return n;
              }
            }
          }
        }
      }
      m += 1;
    }
    return n;
  }
  
  public int a(List<LebaMoreViewItem> paramList)
  {
    Iterator localIterator = this.e.iterator();
    int m = 0;
    while (localIterator.hasNext())
    {
      List localList = (List)localIterator.next();
      if (localList == paramList) {
        return m;
      }
      m += localList.size();
    }
    return m;
  }
  
  public LebaMoreViewItem a(LebaViewItem paramLebaViewItem, boolean paramBoolean)
  {
    LebaMoreViewItem localLebaMoreViewItem = new LebaMoreViewItem();
    localLebaMoreViewItem.a = 2;
    localLebaMoreViewItem.d = paramBoolean;
    localLebaMoreViewItem.c = paramLebaViewItem;
    return localLebaMoreViewItem;
  }
  
  public LebaMoreViewItem a(boolean paramBoolean)
  {
    LebaMoreViewItem localLebaMoreViewItem = new LebaMoreViewItem();
    localLebaMoreViewItem.a = 1;
    if (paramBoolean)
    {
      localLebaMoreViewItem.b = HardCodeUtil.a(2131891160);
      return localLebaMoreViewItem;
    }
    localLebaMoreViewItem.b = HardCodeUtil.a(2131891162);
    return localLebaMoreViewItem;
  }
  
  public void a(Context paramContext, LebaShowData paramLebaShowData, int paramInt1, LebaMoreAdapter paramLebaMoreAdapter, int paramInt2)
  {
    if (paramLebaMoreAdapter == null)
    {
      QLog.i("LebaMoreDataLogic", 1, "initShowMgrData adpter == null ");
      return;
    }
    this.g = paramInt2;
    this.f = paramInt1;
    this.a.clear();
    this.b.clear();
    this.c.clear();
    this.d.clear();
    if ((paramLebaShowData != null) && ((!paramLebaShowData.a.isEmpty()) || (!paramLebaShowData.b.isEmpty())))
    {
      paramContext = this.i;
      if (paramContext != null) {
        paramContext.a(paramInt1, LebaFeedUtil.a(), this.b, this.d);
      }
      a(paramLebaShowData.a, true);
      a(paramLebaShowData.b, false);
      paramContext = new StringBuilder();
      paramContext.append("initShowMgrData model=");
      paramContext.append(this.f);
      paramContext.append(",maxSize=");
      paramContext.append(this.g);
      QLog.i("LebaMoreDataLogic", 1, paramContext.toString());
      paramLebaMoreAdapter.notifyDataSetChanged();
      return;
    }
    paramContext = new StringBuilder();
    paramContext.append("initShowMgrData srcList isEmpty ");
    paramContext.append(this.f);
    QLog.i("LebaMoreDataLogic", 1, paramContext.toString());
    paramLebaMoreAdapter.notifyDataSetChanged();
  }
  
  public void a(LebaMoreVipBizProxy paramLebaMoreVipBizProxy)
  {
    this.i = paramLebaMoreVipBizProxy;
  }
  
  public void a(LebaMoreAdapter paramLebaMoreAdapter, LebaMoreViewItem paramLebaMoreViewItem, LebaMoreAdapter.PluginViewHolder paramPluginViewHolder)
  {
    if (b())
    {
      QLog.i("LebaMoreDataLogic", 1, "closePlugin isFastClick");
      return;
    }
    if ((paramLebaMoreViewItem != null) && (paramLebaMoreViewItem.c != null) && (paramLebaMoreViewItem.a == 2) && (this.b.contains(paramLebaMoreViewItem)))
    {
      b(true);
      int m = a(this.b);
      int n = this.b.indexOf(paramLebaMoreViewItem);
      paramLebaMoreViewItem.d = false;
      paramLebaMoreAdapter.b(paramPluginViewHolder, paramLebaMoreViewItem);
      int i1 = a(paramLebaMoreViewItem);
      this.d.add(i1, paramLebaMoreViewItem);
      this.b.remove(paramLebaMoreViewItem);
      paramLebaMoreAdapter.notifyItemMoved(m + n, a(this.d) + i1);
      if (this.c.isEmpty())
      {
        this.c.add(a(false));
        paramLebaMoreAdapter.notifyItemInserted(a(this.c));
      }
      return;
    }
    QLog.i("LebaMoreDataLogic", 1, "closePlugin error ");
  }
  
  public void a(List<LebaViewItem> paramList, boolean paramBoolean)
  {
    List localList1;
    if (paramBoolean) {
      localList1 = this.a;
    } else {
      localList1 = this.c;
    }
    List localList2;
    if (paramBoolean) {
      localList2 = this.b;
    } else {
      localList2 = this.d;
    }
    if (!paramList.isEmpty())
    {
      localList1.add(a(paramBoolean));
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localList2.add(a((LebaViewItem)paramList.next(), paramBoolean));
      }
    }
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    this.h = paramAppRuntime;
  }
  
  public int b(LebaMoreViewItem paramLebaMoreViewItem)
  {
    int m = 0;
    int i1;
    for (int n = 0; m < this.b.size(); n = i1)
    {
      LebaMoreViewItem localLebaMoreViewItem = (LebaMoreViewItem)this.b.get(m);
      i1 = n;
      if (localLebaMoreViewItem != null)
      {
        i1 = n;
        if (localLebaMoreViewItem.c != null) {
          if (localLebaMoreViewItem.c.b == null)
          {
            i1 = n;
          }
          else
          {
            if (paramLebaMoreViewItem.e) {
              if ((!localLebaMoreViewItem.e) || (paramLebaMoreViewItem.f <= localLebaMoreViewItem.f)) {
                break;
              }
            } else {
              if (!localLebaMoreViewItem.e) {
                break label114;
              }
            }
            for (;;)
            {
              i1 = m + 1;
              break;
              label114:
              if (paramLebaMoreViewItem.c.b.sPriority <= localLebaMoreViewItem.c.b.sPriority) {
                return n;
              }
            }
          }
        }
      }
      m += 1;
    }
    return n;
  }
  
  public LebaMoreViewItem b(int paramInt)
  {
    if (paramInt < 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getItem");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("LebaMoreDataLogic", 1, ((StringBuilder)localObject).toString());
      return null;
    }
    int m = 0;
    Object localObject = this.e.iterator();
    while (((Iterator)localObject).hasNext())
    {
      List localList = (List)((Iterator)localObject).next();
      if (paramInt < localList.size() + m) {
        return (LebaMoreViewItem)localList.get(paramInt - m);
      }
      m += localList.size();
    }
    return null;
  }
  
  public void b(LebaMoreAdapter paramLebaMoreAdapter, LebaMoreViewItem paramLebaMoreViewItem, LebaMoreAdapter.PluginViewHolder paramPluginViewHolder)
  {
    if (b())
    {
      QLog.i("LebaMoreDataLogic", 1, "openPlugin isFastClick");
      return;
    }
    if ((paramLebaMoreViewItem != null) && (paramLebaMoreViewItem.c != null) && (paramLebaMoreViewItem.a == 2) && (this.d.contains(paramLebaMoreViewItem)))
    {
      b(true);
      int m;
      if ((this.g != 0) && (this.b.size() >= this.g)) {
        m = 1;
      } else {
        m = 0;
      }
      Object localObject = null;
      if (m != 0)
      {
        localObject = this.b;
        LebaMoreViewItem localLebaMoreViewItem = (LebaMoreViewItem)((List)localObject).get(((List)localObject).size() - 1);
        if ((localLebaMoreViewItem != null) && (localLebaMoreViewItem.c != null) && (localLebaMoreViewItem.a == 2))
        {
          localObject = localLebaMoreViewItem;
          if (localLebaMoreViewItem.c.c()) {}
        }
        else
        {
          QLog.i("LebaMoreDataLogic", 1, "moveToShowPlugin  closeItem error ");
          return;
        }
      }
      int n = a(this.d);
      int i1 = this.d.indexOf(paramLebaMoreViewItem);
      paramLebaMoreViewItem.d = true;
      paramLebaMoreAdapter.b(paramPluginViewHolder, paramLebaMoreViewItem);
      int i2 = b(paramLebaMoreViewItem);
      this.b.add(i2, paramLebaMoreViewItem);
      this.d.remove(paramLebaMoreViewItem);
      paramLebaMoreAdapter.notifyItemMoved(n + i1, a(this.b) + i2);
      if (m != 0)
      {
        ((LebaMoreViewItem)localObject).d = false;
        m = a(this.b);
        n = this.b.indexOf(localObject);
        i1 = a((LebaMoreViewItem)localObject);
        this.d.add(i1, localObject);
        this.b.remove(localObject);
        paramLebaMoreAdapter.notifyItemMoved(m + n, a(this.d) + i1);
        paramLebaMoreAdapter.notifyItemRangeChanged(a(this.b), this.b.size() + this.d.size() + this.c.size());
      }
      if (this.d.isEmpty())
      {
        this.c.clear();
        paramLebaMoreAdapter.notifyItemRemoved(a(this.c));
      }
      return;
    }
    QLog.i("LebaMoreDataLogic", 1, "moveToShowPlugin error ");
  }
  
  public void b(AppRuntime paramAppRuntime)
  {
    LebaPluginSetting localLebaPluginSetting = new LebaPluginSetting();
    localLebaPluginSetting.a = new ArrayList();
    Iterator localIterator = this.b.iterator();
    LebaMoreViewItem localLebaMoreViewItem;
    while (localIterator.hasNext())
    {
      localLebaMoreViewItem = (LebaMoreViewItem)localIterator.next();
      if ((localLebaMoreViewItem != null) && (localLebaMoreViewItem.c != null) && (!localLebaMoreViewItem.e)) {
        localLebaPluginSetting.a.add(new LebaPluginSettingItem(localLebaMoreViewItem.c.a, 1));
      }
    }
    localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      localLebaMoreViewItem = (LebaMoreViewItem)localIterator.next();
      if ((localLebaMoreViewItem != null) && (localLebaMoreViewItem.c != null) && (!localLebaMoreViewItem.e)) {
        localLebaPluginSetting.a.add(new LebaPluginSettingItem(localLebaMoreViewItem.c.a, 2));
      }
    }
    ThreadManager.excute(new LebaMoreDataLogic.1(this, paramAppRuntime, localLebaPluginSetting), 160, null, true);
  }
  
  public void b(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public boolean b()
  {
    if (Math.abs(this.k - System.currentTimeMillis()) < 400L) {
      return true;
    }
    this.k = System.currentTimeMillis();
    return false;
  }
  
  public void c(AppRuntime paramAppRuntime)
  {
    Iterator localIterator = this.b.iterator();
    LebaMoreViewItem localLebaMoreViewItem;
    LebaMoreVipBizProxy localLebaMoreVipBizProxy;
    while (localIterator.hasNext())
    {
      localLebaMoreViewItem = (LebaMoreViewItem)localIterator.next();
      if ((localLebaMoreViewItem != null) && (localLebaMoreViewItem.e))
      {
        localLebaMoreVipBizProxy = this.i;
        if (localLebaMoreVipBizProxy != null) {
          localLebaMoreVipBizProxy.a(paramAppRuntime, localLebaMoreViewItem.d, localLebaMoreViewItem);
        }
      }
    }
    localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      localLebaMoreViewItem = (LebaMoreViewItem)localIterator.next();
      if ((localLebaMoreViewItem != null) && (localLebaMoreViewItem.e))
      {
        localLebaMoreVipBizProxy = this.i;
        if (localLebaMoreVipBizProxy != null) {
          localLebaMoreVipBizProxy.a(paramAppRuntime, localLebaMoreViewItem.d, localLebaMoreViewItem);
        }
      }
    }
  }
  
  public boolean c()
  {
    return this.j;
  }
  
  public List<LebaViewItem> d()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.b.iterator();
    LebaMoreViewItem localLebaMoreViewItem;
    while (localIterator.hasNext())
    {
      localLebaMoreViewItem = (LebaMoreViewItem)localIterator.next();
      if ((localLebaMoreViewItem != null) && (localLebaMoreViewItem.c != null) && (!localLebaMoreViewItem.e)) {
        localArrayList.add(localLebaMoreViewItem.c);
      }
    }
    localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      localLebaMoreViewItem = (LebaMoreViewItem)localIterator.next();
      if ((localLebaMoreViewItem != null) && (localLebaMoreViewItem.c != null) && (!localLebaMoreViewItem.e)) {
        localArrayList.add(localLebaMoreViewItem.c);
      }
    }
    return localArrayList;
  }
  
  public boolean e()
  {
    return (this.b.isEmpty()) && (this.d.isEmpty());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.more.LebaMoreDataLogic
 * JD-Core Version:    0.7.0.1
 */