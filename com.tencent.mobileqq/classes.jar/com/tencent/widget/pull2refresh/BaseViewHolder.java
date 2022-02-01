package com.tencent.widget.pull2refresh;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BaseViewHolder<M>
  extends RecyclerView.ViewHolder
{
  private SparseArray<View> a = new SparseArray();
  
  public BaseViewHolder(View paramView)
  {
    super(paramView);
  }
  
  public BaseViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    super(LayoutInflater.from(paramViewGroup.getContext()).inflate(paramInt, paramViewGroup, false));
  }
  
  public Context a()
  {
    return this.itemView.getContext();
  }
  
  protected <T extends View> T a(@IdRes int paramInt)
  {
    View localView2 = (View)this.a.get(paramInt);
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = this.itemView.findViewById(paramInt);
      this.a.put(paramInt, localView1);
    }
    return localView1;
  }
  
  public void a(M paramM) {}
  
  public void h() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.pull2refresh.BaseViewHolder
 * JD-Core Version:    0.7.0.1
 */