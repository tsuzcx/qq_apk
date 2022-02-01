package com.tencent.mobileqq.kandian.base.view.widget;

import android.widget.BaseAdapter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class ReadInJoyNinePicDeliverDynamicGridView$AbstractDynamicGridAdapter
  extends BaseAdapter
  implements ReadInJoyNinePicDeliverDynamicGridView.DynamicGridAdapterInterface
{
  private int a = 0;
  private HashMap<Object, Integer> b = new HashMap();
  
  protected void a(Object paramObject)
  {
    HashMap localHashMap = this.b;
    int i = this.a;
    this.a = (i + 1);
    localHashMap.put(paramObject, Integer.valueOf(i));
  }
  
  protected void a(List<?> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a(paramList.next());
    }
  }
  
  protected void b(Object paramObject)
  {
    this.b.remove(paramObject);
  }
  
  public final long getItemId(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.b.size()))
    {
      Object localObject = getItem(paramInt);
      return ((Integer)this.b.get(localObject)).intValue();
    }
    return -1L;
  }
  
  public final boolean hasStableIds()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyNinePicDeliverDynamicGridView.AbstractDynamicGridAdapter
 * JD-Core Version:    0.7.0.1
 */