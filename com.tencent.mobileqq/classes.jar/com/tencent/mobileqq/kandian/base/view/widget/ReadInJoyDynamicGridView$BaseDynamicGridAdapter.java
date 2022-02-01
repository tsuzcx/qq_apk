package com.tencent.mobileqq.kandian.base.view.widget;

import android.content.Context;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public abstract class ReadInJoyDynamicGridView$BaseDynamicGridAdapter<T>
  extends ReadInJoyDynamicGridView.AbstractDynamicGridAdapter<T>
{
  protected int a;
  protected Context a;
  protected List<T> a;
  
  protected ReadInJoyDynamicGridView$BaseDynamicGridAdapter(Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void c(List<T> paramList)
  {
    a(paramList);
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public List<T> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(int paramInt)
  {
    if (paramInt < getCount())
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramInt);
      notifyDataSetChanged();
    }
  }
  
  public void a(int paramInt, T paramT)
  {
    a(paramT);
    this.jdField_a_of_type_JavaUtilList.add(paramInt, paramT);
    notifyDataSetChanged();
  }
  
  public boolean a(int paramInt)
  {
    return true;
  }
  
  public void b()
  {
    a();
    this.jdField_a_of_type_JavaUtilList.clear();
    notifyDataSetChanged();
  }
  
  public void b(T paramT)
  {
    a(paramT);
    this.jdField_a_of_type_JavaUtilList.add(paramT);
    notifyDataSetChanged();
  }
  
  public void b(List<T> paramList)
  {
    if (paramList == null)
    {
      QLog.d("ReadInJoyDynamicGridView", 2, "items cannot be null!");
      return;
    }
    b();
    c(paramList);
    notifyDataSetChanged();
  }
  
  public void c_(int paramInt1, int paramInt2)
  {
    if (paramInt2 < getCount())
    {
      ReadInJoyDynamicGridView.a(this.jdField_a_of_type_JavaUtilList, paramInt1, paramInt2);
      notifyDataSetChanged();
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public T getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyDynamicGridView.BaseDynamicGridAdapter
 * JD-Core Version:    0.7.0.1
 */