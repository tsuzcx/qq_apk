package com.tencent.mobileqq.onlinestatus;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.OnlineStatusBean;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OnlineStatusPagerAdapter
  extends PagerAdapter
  implements View.OnClickListener, ViewPager.OnPageChangeListener
{
  public ArrayList<OnlineStatusItem> a = new ArrayList();
  private ArrayList<OnlineStatusItem> b = new ArrayList();
  private OnlineStatusRecycleBin c = new OnlineStatusRecycleBin();
  private Context d;
  private OnlineStatusPagerAdapter.OnStatusItemClickListener e;
  private int f;
  private boolean g = false;
  private int h;
  private ViewPager i;
  private OnlineStatusPanelParams j;
  
  OnlineStatusPagerAdapter(Context paramContext, OnlineStatusPanelParams paramOnlineStatusPanelParams, ViewPager paramViewPager)
  {
    this.d = paramContext;
    this.f = (paramOnlineStatusPanelParams.c * paramOnlineStatusPanelParams.d);
    this.g = paramOnlineStatusPanelParams.b;
    this.j = paramOnlineStatusPanelParams;
    this.i = paramViewPager;
  }
  
  private List<OnlineStatusItem> b(int paramInt)
  {
    paramInt *= this.f;
    int k = Math.min(this.b.size(), this.f + paramInt);
    return this.b.subList(paramInt, k);
  }
  
  public ArrayList<OnlineStatusItem> a()
  {
    return this.b;
  }
  
  public void a(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void a(OnlineStatusItem paramOnlineStatusItem)
  {
    OnlineStatusBean localOnlineStatusBean = (OnlineStatusBean)QConfigManager.b().b(578);
    boolean bool = localOnlineStatusBean.c(paramOnlineStatusItem.g, paramOnlineStatusItem.b);
    int n = 0;
    int k = 0;
    for (;;)
    {
      m = n;
      if (k >= this.b.size()) {
        break label109;
      }
      OnlineStatusItem localOnlineStatusItem = (OnlineStatusItem)this.b.get(k);
      if ((localOnlineStatusItem.b == paramOnlineStatusItem.b) || ((bool) && (localOnlineStatusBean.c(localOnlineStatusItem.g, localOnlineStatusItem.b)))) {
        break;
      }
      k += 1;
    }
    int m = k;
    label109:
    k = m / this.f;
    this.i.setCurrentItem(k);
  }
  
  public void a(OnlineStatusItem paramOnlineStatusItem, View paramView)
  {
    boolean bool = this.g;
    Object localObject = null;
    if (!bool)
    {
      if (this.a.size() > 0) {
        localObject = (OnlineStatusItem)this.a.get(0);
      }
      this.a.clear();
      this.a.add(paramOnlineStatusItem);
      OnlineStatusPagerAdapter.OnStatusItemClickListener localOnStatusItemClickListener = this.e;
      if (localOnStatusItemClickListener != null) {
        localOnStatusItemClickListener.a((OnlineStatusItem)localObject, paramOnlineStatusItem, paramView);
      }
      return;
    }
    if (this.a.contains(paramOnlineStatusItem))
    {
      this.a.remove(paramOnlineStatusItem);
      localObject = this.e;
      if (localObject != null) {
        ((OnlineStatusPagerAdapter.OnStatusItemClickListener)localObject).a(paramOnlineStatusItem, null, paramView);
      }
    }
    else
    {
      this.a.add(paramOnlineStatusItem);
      localObject = this.e;
      if (localObject != null) {
        ((OnlineStatusPagerAdapter.OnStatusItemClickListener)localObject).a(null, paramOnlineStatusItem, paramView);
      }
    }
  }
  
  void a(OnlineStatusPagerAdapter.OnStatusItemClickListener paramOnStatusItemClickListener)
  {
    this.e = paramOnStatusItemClickListener;
  }
  
  public void a(ArrayList<OnlineStatusItem> paramArrayList)
  {
    this.b = paramArrayList;
  }
  
  public int b()
  {
    boolean bool = this.g;
    int n = 0;
    if (bool) {
      return 0;
    }
    int m = n;
    if (this.a.size() == 1)
    {
      OnlineStatusItem localOnlineStatusItem = (OnlineStatusItem)this.a.get(0);
      int k = 0;
      for (;;)
      {
        m = n;
        if (k >= this.b.size()) {
          break;
        }
        if (((OnlineStatusItem)this.b.get(k)).b == localOnlineStatusItem.b)
        {
          m = k;
          break;
        }
        k += 1;
      }
    }
    return m / this.f;
  }
  
  public void c()
  {
    if (this.i == null) {
      return;
    }
    int m = getCount();
    int n = this.i.getChildCount();
    int k = 0;
    while (k < n)
    {
      OnlineStatusListLayout localOnlineStatusListLayout = (OnlineStatusListLayout)this.i.getChildAt(k);
      if (localOnlineStatusListLayout != null)
      {
        int i1 = localOnlineStatusListLayout.getPageIndex();
        if ((i1 >= 0) && (i1 < m)) {
          localOnlineStatusListLayout.a(b(i1), this.a);
        }
      }
      k += 1;
    }
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if ((paramObject instanceof OnlineStatusListLayout))
    {
      OnlineStatusListLayout localOnlineStatusListLayout = (OnlineStatusListLayout)paramObject;
      localOnlineStatusListLayout.setPageIndex(-1);
      paramViewGroup.removeView(localOnlineStatusListLayout);
      this.c.a(paramInt, (View)paramObject);
    }
  }
  
  public int getCount()
  {
    int k = this.b.size();
    int n = this.f;
    int m = k / n;
    if (k % n > 0) {
      k = 1;
    } else {
      k = 0;
    }
    return m + k;
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    List localList = b(paramInt);
    OnlineStatusListLayout localOnlineStatusListLayout2 = (OnlineStatusListLayout)this.c.a(paramInt);
    OnlineStatusListLayout localOnlineStatusListLayout1 = localOnlineStatusListLayout2;
    if (localOnlineStatusListLayout2 == null)
    {
      localOnlineStatusListLayout1 = new OnlineStatusListLayout(this.d);
      localOnlineStatusListLayout1.a(this.j);
      localOnlineStatusListLayout1.setItemWidth(this.h);
      localOnlineStatusListLayout1.setOnClickListener(this);
      localOnlineStatusListLayout1.a(this.f, this);
    }
    localOnlineStatusListLayout1.a(localList, this.a);
    localOnlineStatusListLayout1.setPageIndex(paramInt);
    if ((localOnlineStatusListLayout1.getParent() != paramViewGroup) && (paramInt < getCount())) {
      paramViewGroup.addView(localOnlineStatusListLayout1);
    }
    return localOnlineStatusListLayout1;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((paramView instanceof OnlineStatusListLayout))
    {
      if (((OnlineStatusListLayout)paramView).a())
      {
        localObject = this.e;
        if (localObject != null) {
          ((OnlineStatusPagerAdapter.OnStatusItemClickListener)localObject).c(paramView);
        }
      }
    }
    else if ((localObject instanceof OnlineStatusItem))
    {
      a((OnlineStatusItem)localObject, paramView);
      c();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    Iterator localIterator = b(paramInt).iterator();
    while (localIterator.hasNext()) {
      ReportHelperKt.a("0X800BB58", (int)((OnlineStatusItem)localIterator.next()).b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusPagerAdapter
 * JD-Core Version:    0.7.0.1
 */