package com.tencent.mobileqq.kandian.biz.fastweb.event;

import android.util.SparseArray;
import android.view.View;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdSwitchService;
import com.tencent.mobileqq.kandian.biz.fastweb.data.AdData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.widget.AbsListView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class ItemShowDispatcher
{
  private static String c = "ItemShowDispatcher";
  public HashSet<Integer> a = new HashSet();
  public HashSet<String> b = new HashSet();
  private SparseArray<ItemShowDispatcher.ItemShowCallback> d;
  private SparseArray<ItemShowDispatcher.ItemShowCallback> e;
  private SparseArray<ItemShowDispatcher.ItemShowCallback> f;
  private Pair<Integer, Integer> g;
  private SparseArray<ItemShowDispatcher.ItemShowCallback> h;
  private Pair<Integer, Integer> i;
  private ItemHeightHelper j;
  private ItemShowDispatcher.OneSecondCallbackLoop k;
  private ArrayList<ItemShowDispatcher.AdPostionReportManager> l = new ArrayList();
  private ArrayList<ItemShowDispatcher.AdPostionReportManager> m = new ArrayList();
  private Runnable n = new ItemShowDispatcher.1(this);
  
  private float a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt4 >= paramInt1)
    {
      if (paramInt4 > paramInt2 + paramInt1) {
        return 0.0F;
      }
      Object localObject = paramAbsListView.getChildAt(paramInt4 - paramInt1);
      if (localObject == null) {
        return 0.0F;
      }
      try
      {
        paramInt1 = Math.abs(paramAbsListView.getBottom() - ((View)localObject).getTop() - paramAbsListView.getTop());
        paramInt2 = this.j.a(paramInt4);
        if (paramInt1 > 0)
        {
          if (paramInt2 <= 0) {
            return 0.0F;
          }
          return paramInt1 / paramInt2;
        }
        return 0.0F;
      }
      catch (RuntimeException paramAbsListView)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("adPos:");
        ((StringBuilder)localObject).append(paramInt4);
        AIOUtils.a("FastWebActivityCheckAdOutOfBounds", ((StringBuilder)localObject).toString(), paramAbsListView);
      }
    }
    return 0.0F;
  }
  
  private int a(SparseArray<ItemShowDispatcher.ItemShowCallback> paramSparseArray, BaseData paramBaseData)
  {
    if (paramSparseArray == null) {
      return -1;
    }
    int i1 = 0;
    while (i1 < paramSparseArray.size())
    {
      if (((ItemShowDispatcher.ItemShowCallback)paramSparseArray.valueAt(i1)).e() == paramBaseData) {
        return i1;
      }
      i1 += 1;
    }
    return -1;
  }
  
  private Pair<Integer, Integer> a(Pair<Integer, Integer> paramPair1, Pair<Integer, Integer> paramPair2)
  {
    if (paramPair1 != null)
    {
      if (paramPair2 == null) {
        return null;
      }
      if (((Integer)paramPair1.second).intValue() >= ((Integer)paramPair2.first).intValue())
      {
        if (((Integer)paramPair1.first).intValue() > ((Integer)paramPair2.second).intValue()) {
          return null;
        }
        Object localObject;
        if (((Integer)paramPair1.first).intValue() > ((Integer)paramPair2.first).intValue()) {
          localObject = paramPair1.first;
        } else {
          localObject = paramPair2.first;
        }
        int i1 = ((Integer)localObject).intValue();
        if (((Integer)paramPair1.second).intValue() < ((Integer)paramPair2.second).intValue()) {
          paramPair1 = paramPair1.second;
        } else {
          paramPair1 = paramPair2.second;
        }
        return new Pair(Integer.valueOf(i1), Integer.valueOf(((Integer)paramPair1).intValue()));
      }
    }
    return null;
  }
  
  private Pair<Integer, Integer> a(AbsListView paramAbsListView)
  {
    int i1 = paramAbsListView.getFirstVisiblePosition();
    i5 = paramAbsListView.getLastVisiblePosition();
    int i4 = i5 - i1;
    i3 = 0;
    try
    {
      localObject = paramAbsListView.getChildAt(0);
      View localView = paramAbsListView.getChildAt(i4);
      i7 = paramAbsListView.getHeight();
      for (i2 = ((View)localObject).getBottom(); !a(i2, this.j.a(i1), 50); i2 = paramAbsListView.getChildAt(i3).getBottom())
      {
        i3 += 1;
        i1 += 1;
      }
      int i6 = this.j.a(i5) - (localView.getBottom() - i7);
      i3 = i5;
      i5 = i6;
    }
    catch (Exception paramAbsListView)
    {
      for (;;)
      {
        Object localObject;
        int i7;
        int i2;
        continue;
        if (i5 <= 0) {
          if (i3 >= 0) {}
        }
      }
    }
    if (!a(i5, this.j.a(i3), 50))
    {
      i3 -= 1;
      i4 -= 1;
      localObject = paramAbsListView.getChildAt(i4);
      i5 = this.j.a(i3) - (((View)localObject).getBottom() - i7);
    }
    else
    {
      paramAbsListView = c;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("  ");
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append(" - ");
      ((StringBuilder)localObject).append(i3);
      ((StringBuilder)localObject).append("         ");
      ((StringBuilder)localObject).append(i2);
      ((StringBuilder)localObject).append("  ");
      ((StringBuilder)localObject).append(this.j.a(i1));
      ((StringBuilder)localObject).append("   ");
      ((StringBuilder)localObject).append(i5);
      ((StringBuilder)localObject).append("   ");
      ((StringBuilder)localObject).append(this.j.a(i3));
      QLog.d(paramAbsListView, 2, ((StringBuilder)localObject).toString());
      return new Pair(Integer.valueOf(i1), Integer.valueOf(i3));
      return null;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.executeOnSubThread(new ItemShowDispatcher.CheckAndStartWebProcessRunnable(paramQQAppInterface));
  }
  
  private void a(Pair<Integer, Integer> paramPair)
  {
    if (paramPair != null)
    {
      Object localObject = this.h;
      if (localObject != null)
      {
        if (((SparseArray)localObject).size() == 0) {
          return;
        }
        localObject = c;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("show : ");
        localStringBuilder.append(paramPair.first);
        localStringBuilder.append(" ---  ");
        localStringBuilder.append(paramPair.second);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
        localObject = new ArrayList();
        int i1 = 0;
        while (i1 < this.h.size())
        {
          int i2 = this.h.keyAt(i1);
          if ((i2 >= ((Integer)paramPair.first).intValue()) && (i2 <= ((Integer)paramPair.second).intValue()))
          {
            ((ItemShowDispatcher.ItemShowCallback)this.h.valueAt(i1)).a();
            ((List)localObject).add(Integer.valueOf(i2));
          }
          i1 += 1;
        }
        paramPair = ((List)localObject).iterator();
        while (paramPair.hasNext())
        {
          i1 = ((Integer)paramPair.next()).intValue();
          this.h.remove(i1);
        }
        e();
      }
    }
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt1 > 0)
    {
      if (paramInt2 <= 0) {
        return false;
      }
      bool1 = bool2;
      if (paramInt1 / paramInt2 >= paramInt3 / 100.0F) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean a(BaseData paramBaseData)
  {
    if (paramBaseData == null) {
      return false;
    }
    if (AdData.a(paramBaseData))
    {
      paramBaseData = (AdData)paramBaseData;
      return ((IRIJAdSwitchService)QRoute.api(IRIJAdSwitchService.class)).enableCheckWebProcess(paramBaseData);
    }
    return false;
  }
  
  private ItemShowDispatcher.ItemShowCallback b(int paramInt)
  {
    SparseArray localSparseArray = this.e;
    if ((localSparseArray != null) && (localSparseArray.size() != 0)) {
      return (ItemShowDispatcher.ItemShowCallback)this.e.get(paramInt);
    }
    return null;
  }
  
  private void b(AbsListView paramAbsListView, int paramInt)
  {
    a(a(a(paramAbsListView), this.i));
  }
  
  private void b(ArrayList<Integer> paramArrayList)
  {
    Object localObject1 = this.d;
    if (localObject1 != null)
    {
      if (((SparseArray)localObject1).size() == 0) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d(c, 2, " (ArrayList<Integer> adPositionlist) ");
      }
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        localObject1 = (Integer)paramArrayList.next();
        Object localObject2 = (ItemShowDispatcher.ItemShowCallback)this.d.get(((Integer)localObject1).intValue());
        if (localObject2 != null)
        {
          Object localObject3;
          if (QLog.isColorLevel())
          {
            localObject3 = c;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("doAdCallback(ArrayList<Integer> adPositionlist) pos=");
            localStringBuilder.append(localObject1);
            QLog.d((String)localObject3, 2, localStringBuilder.toString());
          }
          ((ItemShowDispatcher.ItemShowCallback)localObject2).a();
          this.d.remove(((Integer)localObject1).intValue());
          localObject2 = this.l.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (ItemShowDispatcher.AdPostionReportManager)((Iterator)localObject2).next();
            if ((localObject3 != null) && (((ItemShowDispatcher.AdPostionReportManager)localObject3).a == ((Integer)localObject1).intValue())) {
              this.l.remove(localObject3);
            }
          }
          if (this.a.contains(localObject1))
          {
            this.a.remove(localObject1);
            if (QLog.isColorLevel())
            {
              localObject2 = c;
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("invalidADExposurePos remove ");
              ((StringBuilder)localObject3).append(localObject1);
              QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
            }
          }
        }
      }
    }
  }
  
  private ItemShowDispatcher.ItemShowCallback c(int paramInt)
  {
    SparseArray localSparseArray = this.f;
    if ((localSparseArray != null) && (localSparseArray.size() != 0)) {
      return (ItemShowDispatcher.ItemShowCallback)this.f.get(paramInt);
    }
    return null;
  }
  
  private void c()
  {
    Object localObject = this.d;
    if (localObject != null)
    {
      if (((SparseArray)localObject).size() == 0) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d(c, 2, "doAdCallback(all) ");
      }
      localObject = new ArrayList();
      Iterator localIterator = this.l.iterator();
      while (localIterator.hasNext())
      {
        ItemShowDispatcher.AdPostionReportManager localAdPostionReportManager = (ItemShowDispatcher.AdPostionReportManager)localIterator.next();
        if ((localAdPostionReportManager.b.longValue() != 0L) && (System.currentTimeMillis() - localAdPostionReportManager.b.longValue() >= 1000L))
        {
          localAdPostionReportManager.c = (System.currentTimeMillis() - localAdPostionReportManager.b.longValue());
          ((ArrayList)localObject).add(Integer.valueOf(localAdPostionReportManager.a));
          if (QLog.isColorLevel())
          {
            String str = c;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("time is out , need report ,ad pos is =");
            localStringBuilder.append(localAdPostionReportManager.a);
            localStringBuilder.append("  show time=");
            localStringBuilder.append(localAdPostionReportManager.b);
            QLog.d(str, 2, localStringBuilder.toString());
          }
        }
      }
      if (((ArrayList)localObject).size() > 0) {
        b((ArrayList)localObject);
      }
    }
  }
  
  private void d()
  {
    SparseArray localSparseArray = this.d;
    int i2 = 2147483647;
    int i1 = -1;
    int i4 = i2;
    int i5 = i1;
    if (localSparseArray != null)
    {
      int i3 = 0;
      for (;;)
      {
        i4 = i2;
        i5 = i1;
        if (i3 >= this.d.size()) {
          break;
        }
        i5 = this.d.keyAt(i3);
        i4 = i2;
        if (i5 < i2) {
          i4 = i5;
        }
        int i6 = i1;
        if (i5 > i1) {
          i6 = i5;
        }
        i3 += 1;
        i2 = i4;
        i1 = i6;
      }
    }
    this.g = new Pair(Integer.valueOf(i4), Integer.valueOf(i5));
  }
  
  private void e()
  {
    SparseArray localSparseArray = this.h;
    int i2 = 2147483647;
    int i1 = -1;
    int i4 = i2;
    int i5 = i1;
    if (localSparseArray != null)
    {
      int i3 = 0;
      for (;;)
      {
        i4 = i2;
        i5 = i1;
        if (i3 >= this.h.size()) {
          break;
        }
        i5 = this.h.keyAt(i3);
        i4 = i2;
        if (i5 < i2) {
          i4 = i5;
        }
        int i6 = i1;
        if (i5 > i1) {
          i6 = i5;
        }
        i3 += 1;
        i2 = i4;
        i1 = i6;
      }
    }
    this.i = new Pair(Integer.valueOf(i4), Integer.valueOf(i5));
  }
  
  private boolean f()
  {
    Object localObject = this.g;
    boolean bool2 = false;
    if ((localObject == null) && (this.i == null)) {
      return false;
    }
    localObject = this.j;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      if (((ItemHeightHelper)localObject).a() == 0) {
        return false;
      }
      localObject = this.d;
      if ((localObject == null) || (((SparseArray)localObject).size() == 0))
      {
        localObject = this.h;
        if ((localObject == null) || (((SparseArray)localObject).size() == 0))
        {
          localObject = this.e;
          if ((localObject == null) || (((SparseArray)localObject).size() == 0))
          {
            localObject = this.f;
            bool1 = bool2;
            if (localObject == null) {
              return bool1;
            }
            bool1 = bool2;
            if (((SparseArray)localObject).size() == 0) {
              return bool1;
            }
          }
        }
      }
      bool1 = true;
    }
    return bool1;
  }
  
  public ItemShowDispatcher.AdPostionReportManager a(int paramInt)
  {
    Object localObject1 = this.l;
    Object localObject2 = null;
    if (localObject1 == null) {
      return null;
    }
    Iterator localIterator = ((ArrayList)localObject1).iterator();
    do
    {
      localObject1 = localObject2;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject1 = (ItemShowDispatcher.AdPostionReportManager)localIterator.next();
    } while (((ItemShowDispatcher.AdPostionReportManager)localObject1).a != paramInt);
    return localObject1;
  }
  
  public void a()
  {
    SparseArray localSparseArray = this.d;
    if (localSparseArray != null) {
      localSparseArray.clear();
    }
    localSparseArray = this.h;
    if (localSparseArray != null) {
      localSparseArray.clear();
    }
    localSparseArray = this.e;
    if (localSparseArray != null) {
      localSparseArray.clear();
    }
    localSparseArray = this.f;
    if (localSparseArray != null) {
      localSparseArray.clear();
    }
    if (this.n != null) {
      ThreadManager.getUIHandler().removeCallbacks(this.n);
    }
    if (this.k != null) {
      ThreadManager.getUIHandler().removeCallbacks(this.k);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 0)
    {
      Object localObject = this.h;
      int i1;
      if (localObject != null)
      {
        ((SparseArray)localObject).remove(paramInt1);
        i1 = paramInt1 + 1;
        while (i1 < paramInt2)
        {
          localObject = (ItemShowDispatcher.ItemShowCallback)this.h.get(i1);
          if (localObject != null)
          {
            this.h.delete(i1);
            this.h.put(i1 - 1, localObject);
          }
          i1 += 1;
        }
      }
      localObject = this.d;
      if (localObject != null)
      {
        ((SparseArray)localObject).remove(paramInt1);
        i1 = paramInt1 + 1;
        while (i1 < paramInt2)
        {
          localObject = (ItemShowDispatcher.ItemShowCallback)this.d.get(i1);
          if (localObject != null)
          {
            this.d.delete(i1);
            this.d.put(i1 - 1, localObject);
          }
          i1 += 1;
        }
      }
      localObject = this.e;
      if (localObject != null)
      {
        ((SparseArray)localObject).remove(paramInt1);
        i1 = paramInt1 + 1;
        while (i1 < paramInt2)
        {
          localObject = (ItemShowDispatcher.ItemShowCallback)this.e.get(i1);
          if (localObject != null)
          {
            this.e.delete(i1);
            this.e.put(i1 - 1, localObject);
          }
          i1 += 1;
        }
      }
      localObject = this.f;
      if (localObject != null)
      {
        ((SparseArray)localObject).remove(paramInt1);
        i1 = paramInt1 + 1;
        while (i1 < paramInt2)
        {
          localObject = (ItemShowDispatcher.ItemShowCallback)this.f.get(i1);
          if (localObject != null)
          {
            this.f.delete(i1);
            this.f.put(i1 - 1, localObject);
          }
          i1 += 1;
        }
      }
      localObject = this.l;
      if (localObject != null)
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          ItemShowDispatcher.AdPostionReportManager localAdPostionReportManager = (ItemShowDispatcher.AdPostionReportManager)((Iterator)localObject).next();
          if (localAdPostionReportManager.a == paramInt1) {
            ((Iterator)localObject).remove();
          } else if (localAdPostionReportManager.a > paramInt1) {
            localAdPostionReportManager.a -= 1;
          }
        }
      }
    }
  }
  
  public void a(int paramInt, ItemShowDispatcher.ItemShowCallback paramItemShowCallback)
  {
    if (this.d == null) {
      this.d = new SparseArray();
    }
    if (this.e == null) {
      this.e = new SparseArray();
    }
    if (this.f == null) {
      this.f = new SparseArray();
    }
    int i1 = a(this.d, paramItemShowCallback.e());
    if (i1 >= 0)
    {
      this.d.remove(i1);
      this.e.remove(i1);
      this.f.remove(i1);
    }
    this.d.put(paramInt, paramItemShowCallback);
    this.e.put(paramInt, paramItemShowCallback);
    this.f.put(paramInt, paramItemShowCallback);
    d();
  }
  
  public void a(QQAppInterface paramQQAppInterface, AbsListView paramAbsListView, int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.m.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (ItemShowDispatcher.AdPostionReportManager)localIterator.next();
      AdData localAdData = (AdData)((ItemShowDispatcher.AdPostionReportManager)localObject).e;
      if ((localAdData != null) && (a(((ItemShowDispatcher.AdPostionReportManager)localObject).e)) && (!this.b.contains(localAdData.D)) && (a(paramAbsListView, paramInt1, paramInt2, ((ItemShowDispatcher.AdPostionReportManager)localObject).a)))
      {
        StringBuilder localStringBuilder;
        if (((ItemShowDispatcher.AdPostionReportManager)localObject).f == 0L)
        {
          ((ItemShowDispatcher.AdPostionReportManager)localObject).f = System.currentTimeMillis();
          if (QLog.isColorLevel())
          {
            localObject = c;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("checkWebProcess set start time=, traceId=");
            localStringBuilder.append(localAdData.D);
            QLog.d((String)localObject, 2, localStringBuilder.toString());
          }
        }
        else if (System.currentTimeMillis() - ((ItemShowDispatcher.AdPostionReportManager)localObject).f >= 500L)
        {
          this.b.add(localAdData.D);
          a(paramQQAppInterface);
          if (QLog.isColorLevel())
          {
            localObject = c;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("checkWebProcess CHECK WebViwe! traceId=");
            localStringBuilder.append(localAdData.D);
            QLog.d((String)localObject, 2, localStringBuilder.toString());
          }
        }
      }
    }
  }
  
  public void a(ItemHeightHelper paramItemHeightHelper)
  {
    this.j = paramItemHeightHelper;
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    String str = c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramInt);
    QLog.d(str, 2, localStringBuilder.toString());
    if (!f()) {
      return;
    }
    if (this.k == null) {
      this.k = new ItemShowDispatcher.OneSecondCallbackLoop(this, paramAbsListView, paramInt);
    }
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      b(paramAbsListView, paramInt);
      ThreadManager.getUIHandler().removeCallbacks(this.n);
      return;
    }
    b(paramAbsListView, paramInt);
    ThreadManager.getUIHandler().postDelayed(this.n, 1000L);
  }
  
  public void a(ArrayList<ItemShowDispatcher.AdPostionReportManager> paramArrayList)
  {
    Iterator localIterator1 = paramArrayList.iterator();
    for (;;)
    {
      if (!localIterator1.hasNext()) {
        break label125;
      }
      ItemShowDispatcher.AdPostionReportManager localAdPostionReportManager1 = (ItemShowDispatcher.AdPostionReportManager)localIterator1.next();
      Iterator localIterator2 = this.l.iterator();
      ItemShowDispatcher.AdPostionReportManager localAdPostionReportManager2;
      while (localIterator2.hasNext())
      {
        localAdPostionReportManager2 = (ItemShowDispatcher.AdPostionReportManager)localIterator2.next();
        if (localAdPostionReportManager1.e == localAdPostionReportManager2.e) {
          localAdPostionReportManager1.a(localAdPostionReportManager2);
        }
      }
      localIterator2 = this.m.iterator();
      if (localIterator2.hasNext())
      {
        localAdPostionReportManager2 = (ItemShowDispatcher.AdPostionReportManager)localIterator2.next();
        if (localAdPostionReportManager1.e != localAdPostionReportManager2.e) {
          break;
        }
        localAdPostionReportManager1.a(localAdPostionReportManager2);
      }
    }
    label125:
    this.l.clear();
    this.l.addAll(paramArrayList);
    this.m.clear();
    this.m.addAll(paramArrayList);
  }
  
  public boolean a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = false;
    if (paramInt3 >= paramInt1)
    {
      if (paramInt3 > paramInt2 + paramInt1) {
        return false;
      }
      Object localObject = paramAbsListView.getChildAt(paramInt3 - paramInt1);
      if (localObject == null) {
        return false;
      }
      try
      {
        paramInt1 = Math.abs(paramAbsListView.getBottom() - ((View)localObject).getTop() - paramAbsListView.getTop());
        if (paramInt1 > 0) {
          bool = true;
        }
        return bool;
      }
      catch (RuntimeException paramAbsListView)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("adPos:");
        ((StringBuilder)localObject).append(paramInt3);
        AIOUtils.a("FastWebActivityCheckAdOutOfBounds", ((StringBuilder)localObject).toString(), paramAbsListView);
      }
    }
    return false;
  }
  
  public boolean a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (paramInt4 >= paramInt1)
    {
      if (paramInt4 > paramInt2 + paramInt1) {
        return false;
      }
      Object localObject = paramAbsListView.getChildAt(paramInt4 - paramInt1);
      if (localObject == null) {
        return false;
      }
      try
      {
        paramInt1 = Math.abs(paramAbsListView.getBottom() - ((View)localObject).getTop() - paramAbsListView.getTop());
        if ((paramInt1 > 0) && (!this.a.contains(Integer.valueOf(paramInt4))))
        {
          this.a.add(Integer.valueOf(paramInt4));
          if (QLog.isColorLevel())
          {
            String str = c;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("invalidADExposurePos add ");
            localStringBuilder.append(paramInt4);
            localStringBuilder.append(" showHeight = ");
            localStringBuilder.append(paramInt1);
            localStringBuilder.append(" viewHeight = ");
            localStringBuilder.append(this.j.a(paramInt4));
            QLog.d(str, 2, localStringBuilder.toString());
          }
        }
        boolean bool = a(Math.abs(paramAbsListView.getBottom() - ((View)localObject).getTop() - paramAbsListView.getTop()), this.j.a(paramInt4), paramInt5);
        return bool;
      }
      catch (RuntimeException paramAbsListView)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("adPos:");
        ((StringBuilder)localObject).append(paramInt4);
        AIOUtils.a("FastWebActivityCheckAdOutOfBounds", ((StringBuilder)localObject).toString(), paramAbsListView);
      }
    }
    return false;
  }
  
  public void b(int paramInt, ItemShowDispatcher.ItemShowCallback paramItemShowCallback)
  {
    if (this.h == null) {
      this.h = new SparseArray();
    }
    int i1 = a(this.h, paramItemShowCallback.e());
    if (i1 >= 0) {
      this.h.remove(i1);
    }
    this.h.put(paramInt, paramItemShowCallback);
    e();
  }
  
  public void b(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!f()) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.l.iterator();
    while (localIterator.hasNext())
    {
      ItemShowDispatcher.AdPostionReportManager localAdPostionReportManager = (ItemShowDispatcher.AdPostionReportManager)localIterator.next();
      Object localObject = b(localAdPostionReportManager.a);
      if ((localObject != null) && (a(paramAbsListView, paramInt1, paramInt2, paramInt3, localAdPostionReportManager.a, ((ItemShowDispatcher.ItemShowCallback)localObject).d())))
      {
        ((ItemShowDispatcher.ItemShowCallback)localObject).c();
        this.e.remove(localAdPostionReportManager.a);
      }
      localObject = c(localAdPostionReportManager.a);
      if ((localObject != null) && (a(paramAbsListView, paramInt1, paramInt2, paramInt3, localAdPostionReportManager.a, 1)))
      {
        ((ItemShowDispatcher.ItemShowCallback)localObject).b();
        this.f.remove(localAdPostionReportManager.a);
      }
      if (a(paramAbsListView, paramInt1, paramInt2, paramInt3, localAdPostionReportManager.a, 50))
      {
        if ((localAdPostionReportManager.b.longValue() != 0L) && (System.currentTimeMillis() - localAdPostionReportManager.b.longValue() >= 1000L))
        {
          localArrayList.add(Integer.valueOf(localAdPostionReportManager.a));
          localAdPostionReportManager.c = (System.currentTimeMillis() - localAdPostionReportManager.b.longValue());
          localAdPostionReportManager.d = a(paramAbsListView, paramInt1, paramInt2, paramInt3, localAdPostionReportManager.a);
          if (QLog.isColorLevel())
          {
            localObject = c;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("need report ,ad pos is =");
            localStringBuilder.append(localAdPostionReportManager.a);
            localStringBuilder.append("  show time=");
            localStringBuilder.append(localAdPostionReportManager.b);
            localStringBuilder.append(" exposureTime = ");
            localStringBuilder.append(localAdPostionReportManager.c);
            localStringBuilder.append(" exposureArea = ");
            localStringBuilder.append(localAdPostionReportManager.d);
            QLog.d((String)localObject, 2, localStringBuilder.toString());
          }
        }
        else if (localAdPostionReportManager.b.longValue() == 0L)
        {
          localAdPostionReportManager.d = a(paramAbsListView, paramInt1, paramInt2, paramInt3, localAdPostionReportManager.a);
          localAdPostionReportManager.b = Long.valueOf(System.currentTimeMillis());
        }
      }
      else {
        localAdPostionReportManager.b = Long.valueOf(0L);
      }
    }
    if (localArrayList.size() > 0) {
      b(localArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.event.ItemShowDispatcher
 * JD-Core Version:    0.7.0.1
 */