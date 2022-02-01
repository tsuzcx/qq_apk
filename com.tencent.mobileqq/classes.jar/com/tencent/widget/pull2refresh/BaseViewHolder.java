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
  private SparseArray<View> viewArray = new SparseArray();
  
  public BaseViewHolder(View paramView)
  {
    super(paramView);
  }
  
  public BaseViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    super(LayoutInflater.from(paramViewGroup.getContext()).inflate(paramInt, paramViewGroup, false));
  }
  
  public void bindData(M paramM) {}
  
  protected Context getContext()
  {
    return this.itemView.getContext();
  }
  
  protected <T extends View> T getView(@IdRes int paramInt)
  {
    View localView2 = (View)this.viewArray.get(paramInt);
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = this.itemView.findViewById(paramInt);
      this.viewArray.put(paramInt, localView1);
    }
    return localView1;
  }
  
  public void onViewDetachedFromWindow() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.pull2refresh.BaseViewHolder
 * JD-Core Version:    0.7.0.1
 */