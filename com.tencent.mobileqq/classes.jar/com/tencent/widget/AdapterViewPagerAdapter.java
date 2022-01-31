package com.tencent.widget;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import behl;
import behm;
import behn;
import belt;

public class AdapterViewPagerAdapter
  extends PagerAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private SparseArray<AdapterView> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private behm jdField_a_of_type_Behm;
  private behn jdField_a_of_type_Behn;
  private belt jdField_a_of_type_Belt;
  
  public AdapterViewPagerAdapter(Context paramContext, BaseAdapter paramBaseAdapter, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Belt = new belt(paramBaseAdapter, paramInt);
    this.jdField_a_of_type_Belt.registerDataSetObserver(new behl(this));
  }
  
  public AdapterView a(int paramInt)
  {
    Object localObject2 = (AdapterView)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      if (this.jdField_a_of_type_Behm != null) {
        localObject1 = this.jdField_a_of_type_Behm.a(this.jdField_a_of_type_AndroidContentContext, paramInt);
      }
    }
    else
    {
      if (localObject1 != null)
      {
        localObject2 = new belt(this.jdField_a_of_type_Belt.a(), this.jdField_a_of_type_Belt.a());
        ((belt)localObject2).a(paramInt);
        ((AdapterView)localObject1).setAdapter((Adapter)localObject2);
        this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject1);
      }
      return localObject1;
    }
    throw new IllegalArgumentException("setAdapterViewFactory should be invoked first!");
  }
  
  public void a(behm parambehm)
  {
    this.jdField_a_of_type_Behm = parambehm;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if (this.jdField_a_of_type_Behn != null)
    {
      this.jdField_a_of_type_Behn.a(paramViewGroup, (View)paramObject, paramInt);
      return;
    }
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_Belt.b();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    AdapterView localAdapterView = a(paramInt);
    if (localAdapterView == null) {
      return null;
    }
    if (this.jdField_a_of_type_Behn != null) {
      return this.jdField_a_of_type_Behn.a(paramViewGroup, localAdapterView, paramInt);
    }
    paramViewGroup.addView(localAdapterView);
    return localAdapterView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.widget.AdapterViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */