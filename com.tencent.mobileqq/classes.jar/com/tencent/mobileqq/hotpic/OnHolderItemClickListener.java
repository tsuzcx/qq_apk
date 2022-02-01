package com.tencent.mobileqq.hotpic;

import android.view.View;
import android.view.View.OnTouchListener;

public abstract interface OnHolderItemClickListener
  extends View.OnTouchListener
{
  public abstract void a(View paramView, int paramInt);
  
  public abstract void b(View paramView, int paramInt);
  
  public abstract void c(HotPicPageView.MyVideoViewHolder paramMyVideoViewHolder, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.OnHolderItemClickListener
 * JD-Core Version:    0.7.0.1
 */