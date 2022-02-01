package com.tencent.mobileqq.hotpic;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
import com.tencent.widget.OneViewPagerAdapter;
import java.util.List;

public class HotPicPanelViewPagerAdapter
  extends OneViewPagerAdapter
{
  HotPicMainPanel a;
  Context b;
  HotPicIndexAndIDMap c;
  SparseArray<HotPicPageView> d = new SparseArray();
  protected HotPicPageView.OnHotPicItemClickListener e;
  protected HotPicPanelViewPagerAdapter.OnHotPicPageSelectedListener f;
  
  public HotPicPanelViewPagerAdapter(HotPicMainPanel paramHotPicMainPanel, ViewPager paramViewPager)
  {
    super(paramViewPager);
    this.a = paramHotPicMainPanel;
    this.b = paramHotPicMainPanel.g;
    this.c = paramHotPicMainPanel.h;
    this.f = paramHotPicMainPanel;
  }
  
  public void a()
  {
    this.a = null;
  }
  
  public void a(int paramInt)
  {
    int i = 0;
    while (i < this.d.size())
    {
      HotPicPageView localHotPicPageView = (HotPicPageView)this.d.valueAt(i);
      if (localHotPicPageView.q == null) {
        return;
      }
      if (localHotPicPageView.m == paramInt)
      {
        localHotPicPageView.q.b(true);
        localHotPicPageView.q();
      }
      else
      {
        localHotPicPageView.q.b(false);
        localHotPicPageView.k();
      }
      i += 1;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject2 = HotPicManager.a(this.a.f);
    HotPicPageView localHotPicPageView = (HotPicPageView)this.d.get(paramInt1);
    if ((localHotPicPageView != null) && (localHotPicPageView.H))
    {
      localHotPicPageView.i.a(false);
      if (paramInt2 != 3)
      {
        if (paramInt2 != 5)
        {
          if (paramInt2 != 6)
          {
            if (paramInt2 != 7)
            {
              if (paramInt2 != 8) {
                return;
              }
              localHotPicPageView.l();
              return;
            }
            localHotPicPageView.l();
            this.a.i();
            return;
          }
          if (((HotPicManager)localObject2).d(paramInt1)) {
            paramInt1 = 2;
          } else {
            paramInt1 = 1;
          }
          localHotPicPageView.i.a(paramInt1);
          localHotPicPageView.i.a(false);
          localHotPicPageView.h.notifyItemChanged(localHotPicPageView.h.getItemCount());
        }
      }
      else {
        try
        {
          localHotPicPageView.f.mClearSpanOnItemsChanged = false;
          paramInt2 = localHotPicPageView.h.a.size();
          localObject2 = ((HotPicManager)localObject2).a(paramInt1);
          localHotPicPageView.h.a((List)localObject2);
          int i = ((List)localObject2).size();
          paramInt1 = paramInt2;
          while (paramInt1 < i - paramInt2)
          {
            localHotPicPageView.h.notifyItemInserted(paramInt1);
            paramInt1 += 1;
          }
          localHotPicPageView.h.notifyItemRangeChanged(paramInt2, ((List)localObject2).size());
          localHotPicPageView.n();
          return;
        }
        finally {}
      }
    }
  }
  
  public void a(HotPicPageView.OnHotPicItemClickListener paramOnHotPicItemClickListener)
  {
    this.e = paramOnHotPicItemClickListener;
  }
  
  public void b(int paramInt)
  {
    Object localObject = this.d;
    if ((localObject != null) && (((SparseArray)localObject).size() > paramInt) && (paramInt >= 0))
    {
      localObject = (HotPicPageView)this.d.valueAt(paramInt);
      if (localObject != null) {
        ((HotPicPageView)localObject).d();
      }
    }
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    super.destroyItem(paramViewGroup, paramInt, paramObject);
    ((HotPicPageView)paramObject).m();
  }
  
  public int getCount()
  {
    return this.c.c();
  }
  
  public View getView(int paramInt)
  {
    HotPicTagInfo localHotPicTagInfo = this.c.b(paramInt);
    HotPicPageView localHotPicPageView = (HotPicPageView)LayoutInflater.from(this.b).inflate(2131624108, null);
    localHotPicPageView.setOnHotPicItemClickListener(this.e);
    if (localHotPicTagInfo != null)
    {
      localHotPicPageView.a(this.a, localHotPicTagInfo);
      this.d.put(localHotPicTagInfo.tagId, localHotPicPageView);
    }
    return localHotPicPageView;
  }
  
  public void initView(Object paramObject, int paramInt)
  {
    if ((paramObject != null) && ((paramObject instanceof HotPicPageView))) {
      ((HotPicPageView)paramObject).a();
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    super.onPageSelected(paramInt);
    HotPicPanelViewPagerAdapter.OnHotPicPageSelectedListener localOnHotPicPageSelectedListener = this.f;
    if (localOnHotPicPageSelectedListener != null) {
      localOnHotPicPageSelectedListener.a(paramInt);
    }
  }
  
  public void unInitView(Object paramObject, int paramInt)
  {
    if ((paramObject != null) && ((paramObject instanceof HotPicPageView))) {
      ((HotPicPageView)paramObject).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicPanelViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */