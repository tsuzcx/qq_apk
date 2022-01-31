package com.tencent.widget;

import android.content.Context;
import java.util.ArrayList;

public abstract class DynamicGridView$BaseDynamicGridAdapter
  extends DynamicGridView.AbstractDynamicGridAdapter
{
  public Context a;
  protected ArrayList a;
  protected int c;
  
  public DynamicGridView$BaseDynamicGridAdapter(Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.c = paramInt;
  }
  
  public void a(int paramInt, Object paramObject)
  {
    a(paramObject);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramInt, paramObject);
    notifyDataSetChanged();
  }
  
  public boolean a(int paramInt)
  {
    return true;
  }
  
  public int b()
  {
    return this.c;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (paramInt2 < getCount())
    {
      DynamicGridView.a(this.jdField_a_of_type_JavaUtilArrayList, paramInt1, paramInt2);
      notifyDataSetChanged();
    }
  }
  
  public void c(Object paramObject)
  {
    a(paramObject);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramObject);
    notifyDataSetChanged();
  }
  
  public void d()
  {
    c();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    notifyDataSetChanged();
  }
  
  public void d(Object paramObject)
  {
    this.jdField_a_of_type_JavaUtilArrayList.remove(paramObject);
    b(paramObject);
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return null;
    }
    return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.widget.DynamicGridView.BaseDynamicGridAdapter
 * JD-Core Version:    0.7.0.1
 */