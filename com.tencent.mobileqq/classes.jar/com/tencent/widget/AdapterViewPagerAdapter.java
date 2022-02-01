package com.tencent.widget;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import androidx.viewpager.widget.PagerAdapter;

public class AdapterViewPagerAdapter
  extends PagerAdapter
{
  private AdapterViewPagerAdapter.AdapterViewFactory a;
  private PagerBaseAdapterWrapper b;
  private SparseArray<AdapterView> c = new SparseArray();
  private Context d;
  private AdapterViewPagerAdapter.PageInflateDelegate e;
  
  public AdapterViewPagerAdapter(Context paramContext, BaseAdapter paramBaseAdapter, int paramInt)
  {
    this.d = paramContext;
    this.b = new PagerBaseAdapterWrapper(paramBaseAdapter, paramInt);
    this.b.registerDataSetObserver(new AdapterViewPagerAdapter.1(this));
  }
  
  public AdapterView a(int paramInt)
  {
    Object localObject2 = (AdapterView)this.c.get(paramInt);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = this.a;
      if (localObject1 != null) {
        localObject1 = ((AdapterViewPagerAdapter.AdapterViewFactory)localObject1).a(this.d, paramInt);
      } else {
        throw new IllegalArgumentException("setAdapterViewFactory should be invoked first!");
      }
    }
    if (localObject1 != null)
    {
      localObject2 = new PagerBaseAdapterWrapper(this.b.a(), this.b.b());
      ((PagerBaseAdapterWrapper)localObject2).a(paramInt);
      ((AdapterView)localObject1).setAdapter((Adapter)localObject2);
      this.c.put(paramInt, localObject1);
    }
    return localObject1;
  }
  
  public void a(AdapterViewPagerAdapter.AdapterViewFactory paramAdapterViewFactory)
  {
    this.a = paramAdapterViewFactory;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    AdapterViewPagerAdapter.PageInflateDelegate localPageInflateDelegate = this.e;
    if (localPageInflateDelegate != null)
    {
      localPageInflateDelegate.a(paramViewGroup, (View)paramObject, paramInt);
      return;
    }
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    return this.b.c();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    AdapterView localAdapterView = a(paramInt);
    if (localAdapterView == null) {
      return null;
    }
    AdapterViewPagerAdapter.PageInflateDelegate localPageInflateDelegate = this.e;
    if (localPageInflateDelegate != null) {
      return localPageInflateDelegate.a(paramViewGroup, localAdapterView, paramInt);
    }
    paramViewGroup.addView(localAdapterView);
    return localAdapterView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.AdapterViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */