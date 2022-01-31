package com.tencent.widget;

import android.widget.BaseAdapter;
import java.util.HashMap;

public abstract class DynamicGridView$AbstractDynamicGridAdapter
  extends BaseAdapter
  implements DynamicGridView.DynamicGridAdapterInterface
{
  private int jdField_a_of_type_Int;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  protected void a(Object paramObject)
  {
    HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = (i + 1);
    localHashMap.put(paramObject, Integer.valueOf(i));
  }
  
  protected void b(Object paramObject)
  {
    this.jdField_a_of_type_JavaUtilHashMap.remove(paramObject);
  }
  
  protected void c()
  {
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  public final long getItemId(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilHashMap.size())) {
      return -1L;
    }
    Object localObject = getItem(paramInt);
    return ((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(localObject)).intValue();
  }
  
  public final boolean hasStableIds()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.widget.DynamicGridView.AbstractDynamicGridAdapter
 * JD-Core Version:    0.7.0.1
 */