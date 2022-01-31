package com.tencent.mobileqq.leba.header;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.List;

public class GridMenuAdapter$LebaGridAdapter
  extends BaseAdapter
{
  protected int a;
  List jdField_a_of_type_JavaUtilList;
  private int b;
  
  public GridMenuAdapter$LebaGridAdapter(GridMenuAdapter paramGridMenuAdapter, List paramList, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.b = paramInt2;
    this.jdField_a_of_type_Int = paramInt1;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() > (this.jdField_a_of_type_Int + 1) * this.b) {
      return this.b;
    }
    return this.jdField_a_of_type_JavaUtilList.size() - this.jdField_a_of_type_Int * this.b;
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int * this.b + paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return this.jdField_a_of_type_Int * this.b + paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return this.jdField_a_of_type_ComTencentMobileqqLebaHeaderGridMenuAdapter.a(paramInt, paramView, paramViewGroup, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.leba.header.GridMenuAdapter.LebaGridAdapter
 * JD-Core Version:    0.7.0.1
 */