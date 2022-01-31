package com.tencent.mobileqq.nearby.now.widget;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;

public class CommonViewHolder
  extends RecyclerView.ViewHolder
  implements View.OnClickListener, View.OnLongClickListener
{
  @Nullable
  private CommonViewHolder.ItemClickListener a;
  
  public void onClick(View paramView)
  {
    if (this.a != null) {
      this.a.a(getPosition(), paramView);
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    if (this.a != null)
    {
      this.a.b(getPosition(), paramView);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.widget.CommonViewHolder
 * JD-Core Version:    0.7.0.1
 */