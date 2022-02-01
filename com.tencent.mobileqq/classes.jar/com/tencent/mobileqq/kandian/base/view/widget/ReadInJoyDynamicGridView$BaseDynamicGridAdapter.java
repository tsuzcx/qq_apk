package com.tencent.mobileqq.kandian.base.view.widget;

import android.content.Context;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public abstract class ReadInJoyDynamicGridView$BaseDynamicGridAdapter<T>
  extends ReadInJoyDynamicGridView.AbstractDynamicGridAdapter<T>
{
  protected Context a;
  protected List<T> b = new ArrayList();
  protected int c;
  
  protected ReadInJoyDynamicGridView$BaseDynamicGridAdapter(Context paramContext, int paramInt)
  {
    this.a = paramContext;
    this.c = paramInt;
  }
  
  private void c(List<T> paramList)
  {
    a(paramList);
    this.b.addAll(paramList);
  }
  
  public void a(int paramInt)
  {
    if (paramInt < getCount())
    {
      this.b.remove(paramInt);
      notifyDataSetChanged();
    }
  }
  
  public void a(int paramInt, T paramT)
  {
    a(paramT);
    this.b.add(paramInt, paramT);
    notifyDataSetChanged();
  }
  
  public void b()
  {
    a();
    this.b.clear();
    notifyDataSetChanged();
  }
  
  public void b(T paramT)
  {
    a(paramT);
    this.b.add(paramT);
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
  
  public boolean b(int paramInt)
  {
    return true;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public void c_(int paramInt1, int paramInt2)
  {
    if (paramInt2 < getCount())
    {
      ReadInJoyDynamicGridView.a(this.b, paramInt1, paramInt2);
      notifyDataSetChanged();
    }
  }
  
  public List<T> d()
  {
    return this.b;
  }
  
  public int getCount()
  {
    return this.b.size();
  }
  
  public T getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.b.size())) {
      return this.b.get(paramInt);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyDynamicGridView.BaseDynamicGridAdapter
 * JD-Core Version:    0.7.0.1
 */