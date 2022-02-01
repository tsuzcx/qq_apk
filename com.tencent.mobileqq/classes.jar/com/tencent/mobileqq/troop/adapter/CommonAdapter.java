package com.tencent.mobileqq.troop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.mobileqq.troop.adapter.base.ViewHolder;

public abstract class CommonAdapter<T>
  extends QuickRecyclerAdapter<T>
{
  protected Context b;
  protected int c;
  protected LayoutInflater d;
  
  public CommonAdapter(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.b = paramContext;
    this.d = LayoutInflater.from(paramContext);
    this.c = paramInt;
    a(new CommonAdapter.1(this, paramInt));
  }
  
  protected abstract ViewHolder a(Context paramContext, ViewGroup paramViewGroup, int paramInt);
  
  protected abstract void a(ViewHolder paramViewHolder, T paramT, int paramInt);
  
  public ViewHolder b(Context paramContext, ViewGroup paramViewGroup, int paramInt)
  {
    return a(paramContext, paramViewGroup, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.adapter.CommonAdapter
 * JD-Core Version:    0.7.0.1
 */