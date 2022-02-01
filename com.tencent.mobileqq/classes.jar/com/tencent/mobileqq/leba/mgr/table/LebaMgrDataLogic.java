package com.tencent.mobileqq.leba.mgr.table;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.leba.business.LebaTableMgrItemBizProxy;
import com.tencent.mobileqq.leba.core.LebaUtil;
import com.tencent.mobileqq.leba.core.LebaUtil.LebaItemComparator;
import com.tencent.mobileqq.leba.entity.LebaMgrViewItem;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.mobileqq.leba.report.DC03309ReportItem;
import com.tencent.mobileqq.leba.report.EXReportController;
import com.tencent.mobileqq.leba.report.LebaReportUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class LebaMgrDataLogic
{
  public int a;
  public long a;
  protected LebaTableMgrItemBizProxy a;
  public HashMap<Long, Integer> a;
  public final List<LebaMgrViewItem> a;
  protected AppRuntime a;
  private boolean a;
  public final List<LebaMgrViewItem> b;
  public final List<LebaMgrViewItem> c;
  public final List<LebaMgrViewItem> d;
  public final List<LebaMgrViewItem> e;
  public final List<LebaMgrViewItem> f;
  public final List<LebaMgrViewItem> g;
  public final List<LebaMgrViewItem> h;
  public final List<List<LebaMgrViewItem>> i;
  
  public LebaMgrDataLogic()
  {
    this.jdField_a_of_type_JavaUtilHashMap = null;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(a());
    this.b = new ArrayList();
    this.c = new ArrayList();
    this.d = new ArrayList();
    this.e = new ArrayList();
    this.f = new ArrayList();
    this.g = new ArrayList();
    this.h = new ArrayList();
    this.i = new ArrayList();
    this.i.add(this.jdField_a_of_type_JavaUtilList);
    this.i.add(this.b);
    this.i.add(this.c);
    this.i.add(this.d);
    this.i.add(this.e);
    this.i.add(this.f);
    this.i.add(this.g);
    this.i.add(this.h);
  }
  
  private void a(Context paramContext)
  {
    LebaTableMgrItemBizProxy localLebaTableMgrItemBizProxy = this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaTableMgrItemBizProxy;
    if (localLebaTableMgrItemBizProxy != null) {
      localLebaTableMgrItemBizProxy.a(paramContext, this.b);
    }
  }
  
  public int a()
  {
    Iterator localIterator = this.i.iterator();
    int j = 0;
    while (localIterator.hasNext()) {
      j += ((List)localIterator.next()).size();
    }
    return j;
  }
  
  public int a(int paramInt)
  {
    LebaMgrViewItem localLebaMgrViewItem = a(paramInt);
    if (localLebaMgrViewItem == null) {
      return 1;
    }
    return localLebaMgrViewItem.jdField_a_of_type_Int;
  }
  
  public int a(LebaMgrViewItem paramLebaMgrViewItem)
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.d.size();
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((LebaMgrViewItem)localIterator.next()).jdField_a_of_type_ComTencentMobileqqLebaEntityLebaViewItem);
    }
    localArrayList.add(paramLebaMgrViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaViewItem);
    LebaUtil.b(localArrayList, a());
    int k = localArrayList.indexOf(paramLebaMgrViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaViewItem);
    int j = k;
    if (k == -1)
    {
      QLog.i("LebaMgrDataLogic", 1, "findOpenInsertPosition index == -1");
      j = this.d.size();
    }
    return j;
  }
  
  public int a(List<LebaMgrViewItem> paramList)
  {
    Iterator localIterator = this.i.iterator();
    int j = 0;
    while (localIterator.hasNext())
    {
      List localList = (List)localIterator.next();
      if (localList == paramList) {
        return j;
      }
      j += localList.size();
    }
    return j;
  }
  
  public LebaMgrViewItem a()
  {
    LebaMgrViewItem localLebaMgrViewItem = new LebaMgrViewItem();
    localLebaMgrViewItem.jdField_a_of_type_Int = 1;
    return localLebaMgrViewItem;
  }
  
  public LebaMgrViewItem a(int paramInt)
  {
    if (paramInt < 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getItem");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("LebaMgrDataLogic", 1, ((StringBuilder)localObject).toString());
      return null;
    }
    int j = 0;
    Object localObject = this.i.iterator();
    while (((Iterator)localObject).hasNext())
    {
      List localList = (List)((Iterator)localObject).next();
      if (paramInt < localList.size() + j) {
        return (LebaMgrViewItem)localList.get(paramInt - j);
      }
      j += localList.size();
    }
    return null;
  }
  
  public LebaMgrViewItem a(Context paramContext, boolean paramBoolean)
  {
    LebaMgrViewItem localLebaMgrViewItem = new LebaMgrViewItem();
    localLebaMgrViewItem.jdField_a_of_type_Int = 1;
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Boolean) {
        paramContext = paramContext.getString(2131693591);
      } else {
        paramContext = paramContext.getString(2131693590);
      }
      localLebaMgrViewItem.jdField_a_of_type_JavaLangString = paramContext;
      return localLebaMgrViewItem;
    }
    localLebaMgrViewItem.jdField_a_of_type_JavaLangString = paramContext.getString(2131693589);
    return localLebaMgrViewItem;
  }
  
  public LebaMgrViewItem a(LebaViewItem paramLebaViewItem)
  {
    LebaMgrViewItem localLebaMgrViewItem = new LebaMgrViewItem();
    localLebaMgrViewItem.jdField_a_of_type_Int = 2;
    localLebaMgrViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaViewItem = paramLebaViewItem;
    return localLebaMgrViewItem;
  }
  
  public List<Integer> a()
  {
    AppRuntime localAppRuntime = this.jdField_a_of_type_MqqAppAppRuntime;
    if (localAppRuntime == null)
    {
      QLog.i("LebaMgrDataLogic", 1, "getSortList AppRuntime error ");
      return null;
    }
    return LebaUtil.a(localAppRuntime, this.jdField_a_of_type_Int);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilHashMap == null)
    {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
      int j = 0;
      while (j < this.d.size())
      {
        LebaMgrViewItem localLebaMgrViewItem = (LebaMgrViewItem)this.d.get(j);
        if ((localLebaMgrViewItem != null) && (localLebaMgrViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaViewItem != null)) {
          this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(localLebaMgrViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaViewItem.jdField_a_of_type_Long), Integer.valueOf(j));
        }
        j += 1;
      }
    }
  }
  
  public void a(Context paramContext, LebaTableMgrAdpter paramLebaTableMgrAdpter, LebaMgrViewItem paramLebaMgrViewItem, LebaTableMgrAdpter.PluginViewHolder paramPluginViewHolder)
  {
    try
    {
      if (a())
      {
        QLog.i("LebaMgrDataLogic", 1, "openPlugin isFastClick");
        return;
      }
      if ((paramLebaMgrViewItem != null) && (paramLebaMgrViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaViewItem != null) && (paramLebaMgrViewItem.jdField_a_of_type_Int == 2) && (this.g.contains(paramLebaMgrViewItem)))
      {
        long l = System.currentTimeMillis();
        int j = a(this.g) + this.g.indexOf(paramLebaMgrViewItem);
        paramLebaMgrViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaViewItem.a();
        paramLebaTableMgrAdpter.a(paramPluginViewHolder, paramLebaMgrViewItem);
        int k = a(paramLebaMgrViewItem);
        this.d.add(k, paramLebaMgrViewItem);
        this.g.remove(paramLebaMgrViewItem);
        paramLebaTableMgrAdpter.notifyItemMoved(j, a(this.d) + k);
        if (this.c.isEmpty())
        {
          this.c.add(a(paramContext, true));
          paramLebaTableMgrAdpter.notifyItemInserted(a(this.c));
        }
        if (this.g.isEmpty())
        {
          this.f.clear();
          paramLebaTableMgrAdpter.notifyItemRemoved(a(this.f));
        }
        a(paramLebaTableMgrAdpter, this.d, this.e);
        a(paramLebaTableMgrAdpter, this.g, this.h);
        a(paramLebaMgrViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaViewItem, true);
        if (this.jdField_a_of_type_Boolean) {
          b();
        }
        paramContext = new StringBuilder();
        paramContext.append("openPlugin position=");
        paramContext.append(j);
        paramContext.append(", time= ");
        paramContext.append(System.currentTimeMillis() - l);
        QLog.i("LebaMgrDataLogic", 1, paramContext.toString());
        return;
      }
      QLog.i("LebaMgrDataLogic", 1, "openPlugin error ");
      return;
    }
    catch (Exception paramContext)
    {
      QLog.i("LebaMgrDataLogic", 1, "closePlugin", paramContext);
    }
  }
  
  public void a(Context paramContext, List<LebaViewItem> paramList, List<Integer> paramList1, int paramInt, LebaTableMgrAdpter paramLebaTableMgrAdpter)
  {
    if (paramLebaTableMgrAdpter == null)
    {
      QLog.i("LebaMgrDataLogic", 1, "initShowMgrData adpter == null ");
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.b.clear();
      this.c.clear();
      this.d.clear();
      this.e.clear();
      this.f.clear();
      this.g.clear();
      this.h.clear();
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      a(localArrayList1, localArrayList2, paramList, paramList1);
      a(paramContext);
      a(paramContext, localArrayList1, true);
      a(paramContext, localArrayList2, false);
      paramLebaTableMgrAdpter.notifyDataSetChanged();
      a();
      paramContext = new StringBuilder();
      paramContext.append("initShowMgrData ");
      paramContext.append(this.jdField_a_of_type_Int);
      QLog.i("LebaMgrDataLogic", 1, paramContext.toString());
      return;
    }
    paramContext = new StringBuilder();
    paramContext.append("initShowMgrData srcList isEmpty ");
    paramContext.append(this.jdField_a_of_type_Int);
    QLog.i("LebaMgrDataLogic", 1, paramContext.toString());
    this.b.clear();
    this.c.clear();
    this.d.clear();
    this.e.clear();
    this.f.clear();
    this.g.clear();
    this.h.clear();
    paramLebaTableMgrAdpter.notifyDataSetChanged();
    a();
  }
  
  public void a(Context paramContext, List<LebaViewItem> paramList, boolean paramBoolean)
  {
    List localList1;
    if (paramBoolean) {
      localList1 = this.c;
    } else {
      localList1 = this.f;
    }
    List localList2;
    if (paramBoolean) {
      localList2 = this.d;
    } else {
      localList2 = this.g;
    }
    List localList3;
    if (paramBoolean) {
      localList3 = this.e;
    } else {
      localList3 = this.h;
    }
    if (!paramList.isEmpty())
    {
      localList1.add(a(paramContext, paramBoolean));
      paramContext = paramList.iterator();
      while (paramContext.hasNext()) {
        localList2.add(a((LebaViewItem)paramContext.next()));
      }
      int k = b(localList2.size());
      if (k > 0)
      {
        int j = 0;
        while (j < k)
        {
          localList3.add(a(null));
          j += 1;
        }
      }
    }
  }
  
  public void a(LebaTableMgrItemBizProxy paramLebaTableMgrItemBizProxy)
  {
    this.jdField_a_of_type_ComTencentMobileqqLebaBusinessLebaTableMgrItemBizProxy = paramLebaTableMgrItemBizProxy;
  }
  
  public void a(LebaMgrViewItem paramLebaMgrViewItem, long paramLong, boolean paramBoolean, StringBuilder paramStringBuilder)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap == null)
    {
      QLog.i("LebaMgrDataLogic", 1, "reportItemSequence mInitPosMap == null");
      return;
    }
    if ((paramLebaMgrViewItem != null) && (paramLebaMgrViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaViewItem != null))
    {
      long l3 = paramLebaMgrViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaViewItem.jdField_a_of_type_Long;
      paramLebaMgrViewItem = (Integer)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(l3));
      long l2 = 0L;
      long l1;
      if (paramLebaMgrViewItem != null) {
        l1 = paramLebaMgrViewItem.intValue() + 1;
      } else {
        l1 = 0L;
      }
      if (paramBoolean) {
        l2 = 1L + paramLong;
      }
      paramStringBuilder.append(l3);
      paramStringBuilder.append("_");
      paramStringBuilder.append(l1);
      paramStringBuilder.append("_");
      paramStringBuilder.append(l2);
      paramStringBuilder.append(";");
    }
  }
  
  public void a(LebaViewItem paramLebaViewItem, boolean paramBoolean)
  {
    QLog.i("LebaMgrDataLogic", 1, "handlePluginSwitch");
    ThreadManager.excute(new LebaMgrDataLogic.1(this, paramLebaViewItem, paramBoolean), 128, null, true);
  }
  
  public void a(LebaTableMgrAdpter paramLebaTableMgrAdpter)
  {
    if (paramLebaTableMgrAdpter != null) {
      try
      {
        paramLebaTableMgrAdpter.notifyDataSetChanged();
      }
      catch (Exception paramLebaTableMgrAdpter)
      {
        QLog.i("LebaMgrDataLogic", 1, "onDargEnd", paramLebaTableMgrAdpter);
      }
    }
    b();
  }
  
  public void a(LebaTableMgrAdpter paramLebaTableMgrAdpter, List<LebaMgrViewItem> paramList1, List<LebaMgrViewItem> paramList2)
  {
    int m = paramList2.size();
    int n = b(paramList1.size());
    int k = a(paramList2);
    int j = 0;
    if (m > n)
    {
      m -= n;
      j = 0;
      while (j < m)
      {
        paramList2.remove(0);
        j += 1;
      }
      paramLebaTableMgrAdpter.notifyItemRangeRemoved(k, m);
      return;
    }
    if (m < n)
    {
      m = n - m;
      while (j < m)
      {
        paramList2.add(a(null));
        j += 1;
      }
      paramLebaTableMgrAdpter.notifyItemRangeInserted(k + paramList2.size() - m, m);
    }
  }
  
  public void a(DC03309ReportItem paramDC03309ReportItem)
  {
    EXReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, paramDC03309ReportItem);
  }
  
  public void a(List<LebaViewItem> paramList1, List<LebaViewItem> paramList2, List<LebaViewItem> paramList3, List<Integer> paramList)
  {
    paramList3 = paramList3.iterator();
    while (paramList3.hasNext())
    {
      LebaViewItem localLebaViewItem = (LebaViewItem)paramList3.next();
      if ((localLebaViewItem != null) && (localLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo != null) && (TextUtils.isEmpty(localLebaViewItem.jdField_a_of_type_JavaLangString)) && (localLebaViewItem.b())) {
        if (localLebaViewItem.a()) {
          paramList1.add(localLebaViewItem);
        } else {
          paramList2.add(localLebaViewItem);
        }
      }
    }
    LebaUtil.b(paramList1, paramList);
    Collections.sort(paramList2, new LebaUtil.LebaItemComparator());
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    if (Math.abs(this.jdField_a_of_type_Long - System.currentTimeMillis()) < 500L) {
      return true;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    return false;
  }
  
  public boolean a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    Object localObject = a(paramInt1);
    if ((localObject != null) && (this.d.contains(localObject)))
    {
      LebaMgrViewItem localLebaMgrViewItem = a(paramInt2);
      if (localLebaMgrViewItem != null)
      {
        if ((!this.d.contains(localLebaMgrViewItem)) && (!this.e.contains(localLebaMgrViewItem))) {
          return false;
        }
        paramInt2 = this.d.indexOf(localObject);
        int j;
        if (this.e.contains(localLebaMgrViewItem)) {
          j = this.d.size() - 1;
        } else {
          j = this.d.indexOf(localLebaMgrViewItem);
        }
        int k;
        if (paramInt2 < j)
        {
          int m;
          for (k = paramInt2; k < j; k = m)
          {
            localObject = this.d;
            m = k + 1;
            Collections.swap((List)localObject, k, m);
          }
        }
        if (paramInt2 > j)
        {
          k = paramInt2;
          while (k > j)
          {
            Collections.swap(this.d, k, k - 1);
            k -= 1;
          }
          if (paramRecyclerView.getAdapter() != null) {
            paramRecyclerView.getAdapter().notifyItemMoved(paramInt1, j + paramInt1 - paramInt2);
          }
          return true;
        }
      }
      return false;
    }
    paramRecyclerView = new StringBuilder();
    paramRecyclerView.append("onDargMove start error ");
    paramRecyclerView.append(paramInt1);
    QLog.i("LebaMgrDataLogic", 1, paramRecyclerView.toString());
    return false;
  }
  
  public int b(int paramInt)
  {
    paramInt %= 3;
    if (paramInt == 0) {
      return 0;
    }
    return 3 - paramInt;
  }
  
  public int b(LebaMgrViewItem paramLebaMgrViewItem)
  {
    int j = 0;
    int m;
    for (int k = 0; j < this.g.size(); k = m)
    {
      LebaMgrViewItem localLebaMgrViewItem = (LebaMgrViewItem)this.g.get(j);
      m = k;
      if (localLebaMgrViewItem != null)
      {
        m = k;
        if (localLebaMgrViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaViewItem != null) {
          if (localLebaMgrViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo == null)
          {
            m = k;
          }
          else
          {
            if (paramLebaMgrViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.sPriority > localLebaMgrViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.sPriority) {
              m = 1;
            } else {
              m = 0;
            }
            if (m == 0) {
              break;
            }
            m = j + 1;
          }
        }
      }
      j += 1;
    }
    return k;
  }
  
  public void b()
  {
    ArrayList localArrayList = new ArrayList(this.e.size());
    int j = 0;
    while (j < this.d.size())
    {
      localObject = (LebaMgrViewItem)this.d.get(j);
      if (((LebaMgrViewItem)localObject).jdField_a_of_type_ComTencentMobileqqLebaEntityLebaViewItem != null)
      {
        localArrayList.add(Integer.valueOf((int)((LebaMgrViewItem)localObject).jdField_a_of_type_ComTencentMobileqqLebaEntityLebaViewItem.jdField_a_of_type_Long));
        ((LebaMgrViewItem)localObject).jdField_a_of_type_ComTencentMobileqqLebaEntityLebaViewItem.b = j;
      }
      j += 1;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handlePluginSort list = ");
    ((StringBuilder)localObject).append(localArrayList);
    QLog.i("LebaMgrDataLogic", 1, ((StringBuilder)localObject).toString());
    ThreadManager.excute(new LebaMgrDataLogic.2(this, localArrayList), 128, null, true);
  }
  
  public void b(Context paramContext, LebaTableMgrAdpter paramLebaTableMgrAdpter, LebaMgrViewItem paramLebaMgrViewItem, LebaTableMgrAdpter.PluginViewHolder paramPluginViewHolder)
  {
    try
    {
      if (a())
      {
        QLog.i("LebaMgrDataLogic", 1, "closePlugin isFastClick");
        return;
      }
      if ((paramLebaMgrViewItem != null) && (paramLebaMgrViewItem.jdField_a_of_type_Int == 2) && (paramLebaMgrViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaViewItem != null) && (this.d.contains(paramLebaMgrViewItem)))
      {
        long l = System.currentTimeMillis();
        int j = a(this.d) + this.d.indexOf(paramLebaMgrViewItem);
        paramLebaMgrViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaViewItem.b();
        paramLebaTableMgrAdpter.a(paramPluginViewHolder, paramLebaMgrViewItem);
        int k = b(paramLebaMgrViewItem);
        this.g.add(k, paramLebaMgrViewItem);
        this.d.remove(paramLebaMgrViewItem);
        paramLebaTableMgrAdpter.notifyItemMoved(j, a(this.g) + k);
        if (this.f.isEmpty())
        {
          this.f.add(a(paramContext, false));
          paramLebaTableMgrAdpter.notifyItemInserted(a(this.f));
        }
        if (this.d.isEmpty())
        {
          this.c.clear();
          paramLebaTableMgrAdpter.notifyItemRemoved(a(this.c));
        }
        a(paramLebaTableMgrAdpter, this.d, this.e);
        a(paramLebaTableMgrAdpter, this.g, this.h);
        a(paramLebaMgrViewItem.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaViewItem, false);
        if (this.jdField_a_of_type_Boolean) {
          b();
        }
        paramContext = new StringBuilder();
        paramContext.append("closePlugin position=");
        paramContext.append(j);
        paramContext.append(", time=");
        paramContext.append(System.currentTimeMillis() - l);
        QLog.i("LebaMgrDataLogic", 1, paramContext.toString());
        return;
      }
      QLog.i("LebaMgrDataLogic", 1, "closePlugin error");
      return;
    }
    catch (Exception paramContext)
    {
      QLog.i("LebaMgrDataLogic", 1, "closePlugin", paramContext);
    }
  }
  
  public void c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int m = 0;
    int j = 0;
    int k;
    for (;;)
    {
      k = m;
      if (j >= this.d.size()) {
        break;
      }
      a((LebaMgrViewItem)this.d.get(j), j, true, localStringBuilder);
      j += 1;
    }
    while (k < this.g.size())
    {
      a((LebaMgrViewItem)this.g.get(k), k, false, localStringBuilder);
      k += 1;
    }
    Object localObject = LebaReportUtils.a("plugin_sequence");
    ((DC03309ReportItem)localObject).jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    a((DC03309ReportItem)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("reportSequence ");
    ((StringBuilder)localObject).append(localStringBuilder);
    QLog.i("LebaMgrDataLogic", 1, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.mgr.table.LebaMgrDataLogic
 * JD-Core Version:    0.7.0.1
 */