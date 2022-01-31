package me.ele.uetool.recyclerview;

import android.support.annotation.LayoutRes;

public abstract class BaseItem<T>
{
  public T data;
  private Object tag;
  
  public BaseItem(T paramT)
  {
    this.data = paramT;
  }
  
  @LayoutRes
  public abstract int getLayout();
  
  public final Object getTag()
  {
    return this.tag;
  }
  
  public abstract void onBinding(int paramInt, UniversalAdapter.ViewPool paramViewPool, T paramT);
  
  public final BaseItem setTag(Object paramObject)
  {
    this.tag = paramObject;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     me.ele.uetool.recyclerview.BaseItem
 * JD-Core Version:    0.7.0.1
 */