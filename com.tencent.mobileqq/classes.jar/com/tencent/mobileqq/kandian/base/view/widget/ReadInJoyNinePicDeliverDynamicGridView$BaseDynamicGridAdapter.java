package com.tencent.mobileqq.kandian.base.view.widget;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

public abstract class ReadInJoyNinePicDeliverDynamicGridView$BaseDynamicGridAdapter
  extends ReadInJoyNinePicDeliverDynamicGridView.AbstractDynamicGridAdapter
{
  protected Context a;
  protected ArrayList<Object> b = new ArrayList();
  protected int c;
  private ReadInJoyNinePicDeliverDynamicGridView.BaseDynamicGridAdapter.ExchangeItemsListener d;
  
  protected ReadInJoyNinePicDeliverDynamicGridView$BaseDynamicGridAdapter(Context paramContext, int paramInt)
  {
    this.a = paramContext;
    this.c = paramInt;
    b(this.b);
  }
  
  private void b(List<?> paramList)
  {
    a(paramList);
    this.b.addAll(paramList);
  }
  
  public int a()
  {
    return this.c;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt2 < getCount())
    {
      ReadInJoyNinePicDeliverDynamicGridView.BaseDynamicGridAdapter.ExchangeItemsListener localExchangeItemsListener = this.d;
      if (localExchangeItemsListener != null) {
        localExchangeItemsListener.a(paramInt1, paramInt2);
      }
      ReadInJoyNinePicDeliverDynamicGridView.a(this.b, paramInt1, paramInt2);
      notifyDataSetChanged();
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    a(paramObject);
    this.b.add(paramInt, paramObject);
  }
  
  public boolean a(int paramInt)
  {
    return true;
  }
  
  public List<Object> b()
  {
    return this.b;
  }
  
  public void c(Object paramObject)
  {
    a(paramObject);
    this.b.add(paramObject);
    notifyDataSetChanged();
  }
  
  public void d(Object paramObject)
  {
    this.b.remove(paramObject);
    b(paramObject);
  }
  
  public int getCount()
  {
    return this.b.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.b.size())) {
      return this.b.get(paramInt);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyNinePicDeliverDynamicGridView.BaseDynamicGridAdapter
 * JD-Core Version:    0.7.0.1
 */