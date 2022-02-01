package com.tencent.mobileqq.kandian.base.view.widget;

import android.widget.BaseAdapter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class ReadInJoyDynamicGridView$AbstractDynamicGridAdapter<T>
  extends BaseAdapter
  implements ReadInJoyDynamicGridView.DynamicGridAdapterInterface
{
  private int jdField_a_of_type_Int = 0;
  private HashMap<T, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  protected void a()
  {
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  protected void a(T paramT)
  {
    HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = (i + 1);
    localHashMap.put(paramT, Integer.valueOf(i));
  }
  
  protected void a(List<T> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() <= 0) {
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        a(paramList.next());
      }
    }
  }
  
  public T getItem(int paramInt)
  {
    return null;
  }
  
  public final long getItemId(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilHashMap.size()))
    {
      Object localObject = getItem(paramInt);
      if (this.jdField_a_of_type_JavaUtilHashMap.get(localObject) != null) {
        paramInt = ((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(localObject)).intValue();
      }
      return paramInt;
    }
    return -1L;
  }
  
  public final boolean hasStableIds()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyDynamicGridView.AbstractDynamicGridAdapter
 * JD-Core Version:    0.7.0.1
 */