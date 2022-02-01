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
  private Context jdField_a_of_type_AndroidContentContext;
  private SparseArray<AdapterView> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private AdapterViewPagerAdapter.AdapterViewFactory jdField_a_of_type_ComTencentWidgetAdapterViewPagerAdapter$AdapterViewFactory;
  private AdapterViewPagerAdapter.PageInflateDelegate jdField_a_of_type_ComTencentWidgetAdapterViewPagerAdapter$PageInflateDelegate;
  private PagerBaseAdapterWrapper jdField_a_of_type_ComTencentWidgetPagerBaseAdapterWrapper;
  
  public AdapterViewPagerAdapter(Context paramContext, BaseAdapter paramBaseAdapter, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentWidgetPagerBaseAdapterWrapper = new PagerBaseAdapterWrapper(paramBaseAdapter, paramInt);
    this.jdField_a_of_type_ComTencentWidgetPagerBaseAdapterWrapper.registerDataSetObserver(new AdapterViewPagerAdapter.1(this));
  }
  
  public AdapterView a(int paramInt)
  {
    Object localObject2 = (AdapterView)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentWidgetAdapterViewPagerAdapter$AdapterViewFactory;
      if (localObject1 != null) {
        localObject1 = ((AdapterViewPagerAdapter.AdapterViewFactory)localObject1).a(this.jdField_a_of_type_AndroidContentContext, paramInt);
      } else {
        throw new IllegalArgumentException("setAdapterViewFactory should be invoked first!");
      }
    }
    if (localObject1 != null)
    {
      localObject2 = new PagerBaseAdapterWrapper(this.jdField_a_of_type_ComTencentWidgetPagerBaseAdapterWrapper.a(), this.jdField_a_of_type_ComTencentWidgetPagerBaseAdapterWrapper.a());
      ((PagerBaseAdapterWrapper)localObject2).a(paramInt);
      ((AdapterView)localObject1).setAdapter((Adapter)localObject2);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject1);
    }
    return localObject1;
  }
  
  public void a(AdapterViewPagerAdapter.AdapterViewFactory paramAdapterViewFactory)
  {
    this.jdField_a_of_type_ComTencentWidgetAdapterViewPagerAdapter$AdapterViewFactory = paramAdapterViewFactory;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    AdapterViewPagerAdapter.PageInflateDelegate localPageInflateDelegate = this.jdField_a_of_type_ComTencentWidgetAdapterViewPagerAdapter$PageInflateDelegate;
    if (localPageInflateDelegate != null)
    {
      localPageInflateDelegate.a(paramViewGroup, (View)paramObject, paramInt);
      return;
    }
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_ComTencentWidgetPagerBaseAdapterWrapper.b();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    AdapterView localAdapterView = a(paramInt);
    if (localAdapterView == null) {
      return null;
    }
    AdapterViewPagerAdapter.PageInflateDelegate localPageInflateDelegate = this.jdField_a_of_type_ComTencentWidgetAdapterViewPagerAdapter$PageInflateDelegate;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.AdapterViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */