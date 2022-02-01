package com.tencent.widget;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import blds;

public class AdapterViewPagerAdapter
  extends PagerAdapter
{
  private SparseArray<AdapterView> mAdapterViewCache = new SparseArray();
  private AdapterViewPagerAdapter.AdapterViewFactory mAdapterViewFactory;
  private Context mContext;
  private AdapterViewPagerAdapter.PageInflateDelegate mInflateDelegate;
  private blds mPagerBaseAdapter;
  
  public AdapterViewPagerAdapter(Context paramContext, BaseAdapter paramBaseAdapter, int paramInt)
  {
    this.mContext = paramContext;
    this.mPagerBaseAdapter = new blds(paramBaseAdapter, paramInt);
    this.mPagerBaseAdapter.registerDataSetObserver(new AdapterViewPagerAdapter.1(this));
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if (this.mInflateDelegate != null)
    {
      this.mInflateDelegate.deflate(paramViewGroup, (View)paramObject, paramInt);
      return;
    }
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    return this.mPagerBaseAdapter.b();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    AdapterView localAdapterView = obtainAdapterView(paramInt);
    if (localAdapterView == null) {
      return null;
    }
    if (this.mInflateDelegate != null) {
      return this.mInflateDelegate.inflate(paramViewGroup, localAdapterView, paramInt);
    }
    paramViewGroup.addView(localAdapterView);
    return localAdapterView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public AdapterView obtainAdapterView(int paramInt)
  {
    Object localObject2 = (AdapterView)this.mAdapterViewCache.get(paramInt);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      if (this.mAdapterViewFactory != null) {
        localObject1 = this.mAdapterViewFactory.create(this.mContext, paramInt);
      }
    }
    else
    {
      if (localObject1 != null)
      {
        localObject2 = new blds(this.mPagerBaseAdapter.a(), this.mPagerBaseAdapter.a());
        ((blds)localObject2).a(paramInt);
        ((AdapterView)localObject1).setAdapter((Adapter)localObject2);
        this.mAdapterViewCache.put(paramInt, localObject1);
      }
      return localObject1;
    }
    throw new IllegalArgumentException("setAdapterViewFactory should be invoked first!");
  }
  
  public void setAdapterViewFactory(AdapterViewPagerAdapter.AdapterViewFactory paramAdapterViewFactory)
  {
    this.mAdapterViewFactory = paramAdapterViewFactory;
  }
  
  public void setInflateDelegate(AdapterViewPagerAdapter.PageInflateDelegate paramPageInflateDelegate)
  {
    this.mInflateDelegate = paramPageInflateDelegate;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.widget.AdapterViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */