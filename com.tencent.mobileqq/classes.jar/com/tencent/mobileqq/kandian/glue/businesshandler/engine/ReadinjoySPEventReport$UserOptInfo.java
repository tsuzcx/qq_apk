package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import android.util.Pair;
import android.util.SparseArray;
import android.view.View;
import android.widget.Adapter;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyXListView;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ReadinjoySPEventReport$UserOptInfo
  implements AbsListView.OnScrollListener
{
  public long a = 0L;
  public long b = 0L;
  public long c = 0L;
  public long d = 0L;
  public long e = 0L;
  public ArrayList<Long> f = new ArrayList();
  public ArrayList<Long> g = new ArrayList();
  public int h = 0;
  public boolean i = false;
  private ArrayList<ReadinjoySPEventReport.ScrollStep> k = new ArrayList();
  private ConcurrentHashMap<Long, ReadinjoySPEventReport.ArticleExposureInfoForReport> l = new ConcurrentHashMap();
  private HashMap<Long, Float> m = new HashMap();
  private ReadinjoySPEventReport.ScreenFeedsInfo n;
  private ReadinjoySPEventReport.ScreenFeedsInfo o;
  private SparseArray<Integer> p = new SparseArray();
  private int q;
  private int r;
  private int s;
  private int t;
  private int u = 0;
  
  public ReadinjoySPEventReport$UserOptInfo(ReadinjoySPEventReport paramReadinjoySPEventReport) {}
  
  private ReadinjoySPEventReport.ScreenFeedsInfo a(AbsListView paramAbsListView)
  {
    if (paramAbsListView != null)
    {
      if (paramAbsListView.getChildCount() <= 0) {
        return null;
      }
      ArrayList localArrayList = new ArrayList();
      int i3 = paramAbsListView.getFirstVisiblePosition();
      int i1 = 0;
      while (i1 < paramAbsListView.getChildCount())
      {
        Object localObject = a(paramAbsListView, i3 + i1);
        if ((!(localObject instanceof AdvertisementInfo)) && ((localObject instanceof BaseArticleInfo)))
        {
          View localView = paramAbsListView.getChildAt(i1);
          if (localView.getHeight() > 0)
          {
            int i2;
            if (localView.getBottom() > paramAbsListView.getHeight()) {
              i2 = paramAbsListView.getHeight();
            } else {
              i2 = localView.getBottom();
            }
            float f1;
            if (localView.getTop() > 0)
            {
              f1 = (i2 - localView.getTop()) * 1.0F;
              i2 = localView.getHeight();
            }
            else
            {
              f1 = i2 * 1.0F;
              i2 = localView.getHeight();
            }
            f1 /= i2;
            if (f1 > 0.0F) {
              localArrayList.add(new Pair((AbsBaseArticleInfo)localObject, Float.valueOf(f1)));
            }
          }
        }
        i1 += 1;
      }
      paramAbsListView = new ReadinjoySPEventReport.ScreenFeedsInfo(this.j, null);
      paramAbsListView.a = localArrayList;
      paramAbsListView.b = System.currentTimeMillis();
      long l1;
      long l2;
      if (this.n == null)
      {
        l1 = System.currentTimeMillis();
        l2 = this.d;
      }
      else
      {
        l1 = System.currentTimeMillis();
        l2 = this.n.b;
      }
      paramAbsListView.c = (l1 - l2);
      this.n = paramAbsListView;
      if (QLog.isColorLevel()) {
        QLog.d("ReadinjoySPEventReport", 2, new Object[] { paramAbsListView });
      }
      return paramAbsListView;
    }
    return null;
  }
  
  private Object a(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramAbsListView != null) && (paramInt >= 0))
    {
      if (paramAbsListView.getAdapter() == null) {
        return null;
      }
      paramAbsListView = paramAbsListView.getAdapter();
      if (paramInt >= paramAbsListView.getCount()) {
        return null;
      }
      try
      {
        paramAbsListView = paramAbsListView.getItem(paramInt);
        return paramAbsListView;
      }
      catch (Exception paramAbsListView)
      {
        paramAbsListView.printStackTrace();
      }
    }
    return null;
  }
  
  private ReadinjoySPEventReport.ScrollStep b(AbsListView paramAbsListView)
  {
    ReadinjoySPEventReport.ScrollStep localScrollStep = new ReadinjoySPEventReport.ScrollStep();
    localScrollStep.g = this.q;
    localScrollStep.h = this.r;
    int i1 = this.s;
    int i2 = this.u;
    if (i1 - i2 > 0) {
      i1 -= i2;
    } else {
      i1 = 0;
    }
    localScrollStep.i = i1;
    localScrollStep.a = this.t;
    localScrollStep.b = (this.c - this.b);
    localScrollStep.j = this.u;
    localScrollStep.k = paramAbsListView.getWidth();
    paramAbsListView = (ReadInJoyXListView)paramAbsListView;
    localScrollStep.l = ((float[])paramAbsListView.r.clone());
    localScrollStep.m = ((float[])paramAbsListView.s.clone());
    return localScrollStep;
  }
  
  private void d()
  {
    this.s = 0;
    this.q = -1;
    this.r = -1;
  }
  
  public String a()
  {
    Object localObject = new ArrayList(this.l.values());
    Collections.sort((List)localObject);
    StringBuilder localStringBuilder = new StringBuilder();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      localStringBuilder.append((ReadinjoySPEventReport.ArticleExposureInfoForReport)((Iterator)localObject).next());
      localStringBuilder.append("|");
    }
    if (localStringBuilder.length() == 0) {
      return "nil";
    }
    return localStringBuilder.substring(0, localStringBuilder.length() - 1);
  }
  
  public void a(int paramInt, AbsListView paramAbsListView)
  {
    if (paramAbsListView != null) {
      try
      {
        if ((paramAbsListView.getChildCount() > 0) && (this.d != 0L))
        {
          if (this.f.size() > 0)
          {
            int i1 = this.h;
            if ((i1 & paramInt) != 0) {
              return;
            }
          }
          if ((paramInt & 0x2) != 0)
          {
            boolean bool = this.i;
            if (!bool) {
              return;
            }
            this.i = false;
          }
          this.h |= paramInt;
          paramAbsListView = a(paramAbsListView);
          if (paramAbsListView == null) {
            return;
          }
          a(paramAbsListView);
          this.f = paramAbsListView.a();
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("updateFirstScreenArticleList from : ");
            localStringBuilder.append(paramInt);
            localStringBuilder.append(", ");
            localStringBuilder = new StringBuilder(localStringBuilder.toString());
            localStringBuilder.append(paramAbsListView);
            QLog.d("ReadinjoySPEventReport", 2, new Object[] { localStringBuilder });
          }
          return;
        }
      }
      finally {}
    }
  }
  
  public void a(View paramView, AbsListView paramAbsListView, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramView != null) && (paramAbsBaseArticleInfo != null))
    {
      if (paramAbsListView == null) {
        return;
      }
      float f1 = paramView.getHeight() / 2.0F;
      float f2 = paramView.getTop();
      float f3 = paramAbsListView.getHeight();
      this.m.put(Long.valueOf(paramAbsBaseArticleInfo.mArticleID), Float.valueOf((f2 + f1) / f3));
    }
  }
  
  public void a(ReadinjoySPEventReport.ScreenFeedsInfo paramScreenFeedsInfo)
  {
    if (paramScreenFeedsInfo != null)
    {
      if (this.d == 0L) {
        return;
      }
      Iterator localIterator = paramScreenFeedsInfo.a.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Pair)localIterator.next();
        AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)((Pair)localObject).first;
        long l1 = paramScreenFeedsInfo.c;
        float f1 = ((Float)((Pair)localObject).second).floatValue();
        ReadinjoySPEventReport.ArticleExposureInfoForReport localArticleExposureInfoForReport = (ReadinjoySPEventReport.ArticleExposureInfoForReport)this.l.get(Long.valueOf(localAbsBaseArticleInfo.mArticleID));
        localObject = localArticleExposureInfoForReport;
        if (localArticleExposureInfoForReport == null)
        {
          localObject = new ReadinjoySPEventReport.ArticleExposureInfoForReport(this.j, null);
          ((ReadinjoySPEventReport.ArticleExposureInfoForReport)localObject).b = localAbsBaseArticleInfo.mRecommendSeq;
          ((ReadinjoySPEventReport.ArticleExposureInfoForReport)localObject).c = localAbsBaseArticleInfo.mArticleID;
          ((ReadinjoySPEventReport.ArticleExposureInfoForReport)localObject).a = localAbsBaseArticleInfo.mTitle;
          this.l.put(Long.valueOf(localAbsBaseArticleInfo.mArticleID), localObject);
        }
        long l2 = ((ReadinjoySPEventReport.ArticleExposureInfoForReport)localObject).e;
        if (f1 <= 0.8F) {
          l1 = 0L;
        }
        ((ReadinjoySPEventReport.ArticleExposureInfoForReport)localObject).e = (l2 + l1);
        ((ReadinjoySPEventReport.ArticleExposureInfoForReport)localObject).d = Math.max(((ReadinjoySPEventReport.ArticleExposureInfoForReport)localObject).d, f1);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      long l1 = this.d;
      if (l1 == 0L) {
        l1 = System.currentTimeMillis();
      }
      this.d = l1;
      return;
    }
    this.e = System.currentTimeMillis();
    Object localObject1 = this.n;
    ArrayList localArrayList = null;
    if (localObject1 != null) {
      localObject1 = ((ReadinjoySPEventReport.ScreenFeedsInfo)localObject1).a();
    } else {
      localObject1 = null;
    }
    Object localObject2 = this.o;
    if (localObject2 != null) {
      localArrayList = ((ReadinjoySPEventReport.ScreenFeedsInfo)localObject2).a();
    }
    localObject2 = new StringBuilder("exposure info : \n");
    Iterator localIterator = this.l.keySet().iterator();
    while (localIterator.hasNext())
    {
      Long localLong = (Long)localIterator.next();
      ReadinjoySPEventReport.ArticleExposureInfoForReport localArticleExposureInfoForReport = (ReadinjoySPEventReport.ArticleExposureInfoForReport)this.l.get(localLong);
      if (localArticleExposureInfoForReport != null)
      {
        localArticleExposureInfoForReport.f = 1;
        if (this.f.contains(localLong)) {
          localArticleExposureInfoForReport.f = 0;
        } else if ((localObject1 != null) && (((List)localObject1).contains(localLong))) {
          localArticleExposureInfoForReport.f = 2;
        }
        if (this.g.contains(localLong)) {
          localArticleExposureInfoForReport.g = true;
        }
        if ((localArrayList != null) && (localArrayList.contains(localLong))) {
          localArticleExposureInfoForReport.h = true;
        }
        if (this.m.containsKey(localLong)) {
          localArticleExposureInfoForReport.i = String.format("%.2f", new Object[] { this.m.get(localLong) });
        }
        ((StringBuilder)localObject2).append(localArticleExposureInfoForReport.toString());
        ((StringBuilder)localObject2).append("\n");
      }
    }
    QLog.d("ReadinjoySPEventReport", 2, ((StringBuilder)localObject2).toString());
    localObject1 = this.j;
    ((ReadinjoySPEventReport)localObject1).g = this;
    ((ReadinjoySPEventReport)localObject1).f = new UserOptInfo((ReadinjoySPEventReport)localObject1);
  }
  
  public String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i1 = 0;
    while (i1 < this.k.size())
    {
      localStringBuilder.append(((ReadinjoySPEventReport.ScrollStep)this.k.get(i1)).a());
      localStringBuilder.append("|");
      i1 += 1;
    }
    if (localStringBuilder.length() == 0) {
      return "nil";
    }
    return localStringBuilder.substring(0, localStringBuilder.length() - 1);
  }
  
  public void c()
  {
    this.p.clear();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt3 = paramInt2 + paramInt1 - 1;
    int i1 = paramAbsListView.getChildCount();
    if (this.q == -1)
    {
      this.q = (paramInt1 + 1);
      this.r = paramInt1;
    }
    int i2 = this.q;
    View localView;
    if (paramInt1 < i2)
    {
      this.t = 1;
      paramInt2 = 0;
      while ((paramInt2 < i1) && (paramInt2 < i2 - paramInt1))
      {
        int i3 = paramInt1 + paramInt2;
        if (this.p.get(i3) != null)
        {
          this.s += ((Integer)this.p.get(i3)).intValue();
        }
        else
        {
          localView = paramAbsListView.getChildAt(paramInt2);
          if (localView != null)
          {
            this.p.put(i3, Integer.valueOf(localView.getHeight()));
            this.s += localView.getHeight();
          }
        }
        paramInt2 += 1;
      }
      this.q = paramInt1;
    }
    i2 = this.r;
    if (paramInt3 > i2)
    {
      this.t = 0;
      paramInt2 = i1 - 1;
      paramInt1 = paramInt2;
      for (;;)
      {
        i1 = paramInt2 - paramInt1;
        if (i1 >= paramInt3 - i2) {
          break;
        }
        i1 = paramInt3 - i1;
        if (this.p.get(i1) != null)
        {
          this.s += ((Integer)this.p.get(i1)).intValue();
        }
        else
        {
          localView = paramAbsListView.getChildAt(paramInt1);
          if (localView != null)
          {
            this.p.put(i1, Integer.valueOf(localView.getHeight()));
            this.s += localView.getHeight();
          }
        }
        paramInt1 -= 1;
      }
      this.r = paramInt3;
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramAbsListView == null) {
      return;
    }
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if ((paramInt != 5) && (paramInt != 6)) {
          return;
        }
        this.n = a(paramAbsListView);
        a(this.n);
        return;
      }
      d();
      this.b = System.currentTimeMillis();
      this.u = paramAbsListView.getHeight();
      if (this.a == 0L) {
        this.a = this.b;
      }
      this.n = a(paramAbsListView);
      paramAbsListView = this.n;
      this.o = paramAbsListView;
      a(paramAbsListView);
      return;
    }
    this.c = System.currentTimeMillis();
    ReadinjoySPEventReport.ScrollStep localScrollStep = b(paramAbsListView);
    this.k.add(localScrollStep);
    this.n = a(paramAbsListView);
    if ((paramAbsListView instanceof ReadInJoyXListView))
    {
      Object localObject = (ReadInJoyXListView)paramAbsListView;
      paramInt = ((ReadInJoyXListView)localObject).p;
      int i2 = ((ReadInJoyXListView)localObject).q;
      int i1 = Math.min(paramInt, i2);
      i2 = Math.max(paramInt, i2);
      this.g.clear();
      paramInt = i1;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("finger touch min :");
        ((StringBuilder)localObject).append(i1);
        ((StringBuilder)localObject).append(", max : ");
        ((StringBuilder)localObject).append(i2);
        QLog.d("ReadinjoySPEventReport", 2, ((StringBuilder)localObject).toString());
        paramInt = i1;
      }
      while ((paramInt <= i2) && (paramInt < paramAbsListView.getCount()))
      {
        localObject = a(paramAbsListView, paramInt);
        if (((localObject instanceof BaseArticleInfo)) && (!(localObject instanceof AdvertisementInfo))) {
          this.g.add(Long.valueOf(((AbsBaseArticleInfo)localObject).mArticleID));
        }
        paramInt += 1;
      }
    }
    if (QLog.isColorLevel())
    {
      paramAbsListView = new StringBuilder();
      paramAbsListView.append("one scroll ");
      paramAbsListView.append(localScrollStep.a());
      QLog.d("ReadinjoySPEventReport", 2, paramAbsListView.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport.UserOptInfo
 * JD-Core Version:    0.7.0.1
 */