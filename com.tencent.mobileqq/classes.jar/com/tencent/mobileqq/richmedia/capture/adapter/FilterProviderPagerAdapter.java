package com.tencent.mobileqq.richmedia.capture.adapter;

import agej;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.PagerAdapter;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import bben;
import bljm;
import com.tencent.mobileqq.richmedia.capture.data.FilterCategory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GridView;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class FilterProviderPagerAdapter
  extends PagerAdapter
{
  public static final int a;
  public static final int b = agej.a(0.0F, BaseApplication.getContext().getResources());
  private Context jdField_a_of_type_AndroidContentContext;
  public SparseArray<GridView> a;
  private bljm jdField_a_of_type_Bljm;
  private List<FilterCategory> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  boolean jdField_a_of_type_Boolean = true;
  
  static
  {
    jdField_a_of_type_Int = agej.a(7.0F, BaseApplication.getContext().getResources());
  }
  
  public FilterProviderPagerAdapter(Context paramContext, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(bljm parambljm)
  {
    this.jdField_a_of_type_Bljm = parambljm;
  }
  
  public void a(List<FilterCategory> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt));
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FilterProviderPagerAdapter", 2, "instantiateItem position = " + paramInt);
    }
    Object localObject2 = (GridView)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new GridView(this.jdField_a_of_type_AndroidContentContext);
      ((GridView)localObject1).setNumColumns(4);
      ((GridView)localObject1).setSelector(new ColorDrawable(0));
      ((GridView)localObject1).setVerticalSpacing(b);
      ((GridView)localObject1).setHorizontalSpacing(b);
      ((GridView)localObject1).setClipToPadding(false);
      ((GridView)localObject1).setPadding(jdField_a_of_type_Int, jdField_a_of_type_Int, jdField_a_of_type_Int, jdField_a_of_type_Int * 4);
      ((GridView)localObject1).setVerticalScrollBarEnabled(false);
      localObject2 = new bben(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Boolean);
      ((GridView)localObject1).setAdapter((ListAdapter)localObject2);
      if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
        ((bben)localObject2).a(((FilterCategory)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_JavaUtilList);
      }
      ((GridView)localObject1).setOnItemClickListener(this.jdField_a_of_type_Bljm);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject1);
    }
    paramViewGroup.addView((View)localObject1, -1, -1);
    return localObject1;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.adapter.FilterProviderPagerAdapter
 * JD-Core Version:    0.7.0.1
 */