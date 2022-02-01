package com.tencent.mtt.supportui.views.viewpager;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

public abstract class ViewPagerAdapter
{
  public static final int POSITION_NONE = -2;
  public static final int POSITION_UNCHANGED = -1;
  public static final int REFRESH_NONE = 0;
  public static final int REFRESH_SIZE_CHANGED = 1;
  private DataSetObservable mObservable = new DataSetObservable();
  
  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
    throw new UnsupportedOperationException("Required method destroyItem was not overridden");
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    destroyItem(paramViewGroup, paramInt, paramObject);
  }
  
  public void finishUpdate(View paramView) {}
  
  public void finishUpdate(ViewGroup paramViewGroup)
  {
    finishUpdate(paramViewGroup);
  }
  
  public abstract int getCount();
  
  public int getInitialItemIndex()
  {
    return 0;
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -1;
  }
  
  public float getPageSize(int paramInt)
  {
    return 1.0F;
  }
  
  public CharSequence getPageTitle(int paramInt)
  {
    return null;
  }
  
  public View getTab(int paramInt)
  {
    return null;
  }
  
  public Object instantiateItem(View paramView, int paramInt)
  {
    throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    return instantiateItem(paramViewGroup, paramInt);
  }
  
  public abstract boolean isViewFromObject(View paramView, Object paramObject);
  
  public void notifyDataSetChanged()
  {
    this.mObservable.notifyChanged();
  }
  
  public int refreshItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    return 0;
  }
  
  public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.mObservable.registerObserver(paramDataSetObserver);
  }
  
  public void restoreState(Parcelable paramParcelable, ClassLoader paramClassLoader) {}
  
  public Parcelable saveState()
  {
    return null;
  }
  
  public void setPrimaryItem(View paramView, int paramInt, Object paramObject) {}
  
  public void setPrimaryItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    setPrimaryItem(paramViewGroup, paramInt, paramObject);
  }
  
  public void startUpdate(View paramView, int paramInt) {}
  
  public void startUpdate(ViewGroup paramViewGroup, int paramInt)
  {
    startUpdate(paramViewGroup, paramInt);
  }
  
  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.mObservable.unregisterObserver(paramDataSetObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.supportui.views.viewpager.ViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */