package com.tencent.widget;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import bljp;
import bljq;
import bljr;
import blnw;

public class AdapterViewPagerAdapter
  extends PagerAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private SparseArray<AdapterView> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private bljq jdField_a_of_type_Bljq;
  private bljr jdField_a_of_type_Bljr;
  private blnw jdField_a_of_type_Blnw;
  
  public AdapterViewPagerAdapter(Context paramContext, BaseAdapter paramBaseAdapter, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Blnw = new blnw(paramBaseAdapter, paramInt);
    this.jdField_a_of_type_Blnw.registerDataSetObserver(new bljp(this));
  }
  
  public AdapterView a(int paramInt)
  {
    Object localObject2 = (AdapterView)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      if (this.jdField_a_of_type_Bljq != null) {
        localObject1 = this.jdField_a_of_type_Bljq.a(this.jdField_a_of_type_AndroidContentContext, paramInt);
      }
    }
    else
    {
      if (localObject1 != null)
      {
        localObject2 = new blnw(this.jdField_a_of_type_Blnw.a(), this.jdField_a_of_type_Blnw.a());
        ((blnw)localObject2).a(paramInt);
        ((AdapterView)localObject1).setAdapter((Adapter)localObject2);
        this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject1);
      }
      return localObject1;
    }
    throw new IllegalArgumentException("setAdapterViewFactory should be invoked first!");
  }
  
  public void a(bljq parambljq)
  {
    this.jdField_a_of_type_Bljq = parambljq;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if (this.jdField_a_of_type_Bljr != null)
    {
      this.jdField_a_of_type_Bljr.a(paramViewGroup, (View)paramObject, paramInt);
      return;
    }
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_Blnw.b();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    AdapterView localAdapterView = a(paramInt);
    if (localAdapterView == null) {
      return null;
    }
    if (this.jdField_a_of_type_Bljr != null) {
      return this.jdField_a_of_type_Bljr.a(paramViewGroup, localAdapterView, paramInt);
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