package com.tencent.mobileqq.nearby.now.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.ViewGroup;
import java.util.List;

public abstract class CommonAdapter
  extends RecyclerView.Adapter
{
  private int jdField_a_of_type_Int = 2130969127;
  public Context a;
  @Nullable
  public CommonViewHolder.ItemClickListener a;
  public List a;
  private boolean jdField_a_of_type_Boolean = true;
  public int b;
  private boolean b;
  private int c = 2130969130;
  
  public CommonAdapter(Context paramContext, int paramInt, List paramList)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException(" context is null !!!");
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public int a(int paramInt)
  {
    return this.jdField_b_of_type_Int;
  }
  
  public CommonViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == this.c) {
      return NetworkErrorViewHolder.a(this.jdField_a_of_type_AndroidContentContext, paramViewGroup, this.c);
    }
    if (paramInt == this.jdField_a_of_type_Int) {
      return EmptyViewHolder.a(this.jdField_a_of_type_AndroidContentContext, paramViewGroup, this.jdField_a_of_type_Int);
    }
    paramViewGroup = CommonViewHolder.a(this.jdField_a_of_type_AndroidContentContext, paramViewGroup, a(paramInt));
    paramViewGroup.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowWidgetCommonViewHolder$ItemClickListener);
    return paramViewGroup;
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    notifyDataSetChanged();
  }
  
  public void a(CommonViewHolder.ItemClickListener paramItemClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowWidgetCommonViewHolder$ItemClickListener = paramItemClickListener;
  }
  
  public void a(CommonViewHolder paramCommonViewHolder, int paramInt)
  {
    int i = getItemViewType(paramInt);
    if ((i == this.jdField_a_of_type_Int) || (i == this.c)) {
      return;
    }
    a(paramCommonViewHolder, paramInt, this.jdField_a_of_type_JavaUtilList.get(paramInt));
  }
  
  public void a(CommonViewHolder paramCommonViewHolder, int paramInt, Object paramObject)
  {
    a(paramCommonViewHolder, this.jdField_a_of_type_JavaUtilList.get(paramInt));
  }
  
  public abstract void a(CommonViewHolder paramCommonViewHolder, Object paramObject);
  
  void a(List paramList)
  {
    if (paramList == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public int b(int paramInt)
  {
    return this.jdField_b_of_type_Int;
  }
  
  public void b(List paramList)
  {
    a(paramList);
  }
  
  public int getItemCount()
  {
    if (!this.jdField_a_of_type_Boolean) {}
    while (this.jdField_a_of_type_JavaUtilList.size() == 0) {
      return 1;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Boolean)) {
      return this.c;
    }
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
      return this.jdField_a_of_type_Int;
    }
    return b(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.widget.CommonAdapter
 * JD-Core Version:    0.7.0.1
 */