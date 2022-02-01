package com.tencent.mobileqq.flashchat;

import android.view.View;
import android.view.View.OnTouchListener;

public abstract interface OnHolderItemClickListener
  extends View.OnTouchListener
{
  public abstract void a(View paramView, int paramInt1, int paramInt2);
  
  public abstract void b(View paramView, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flashchat.OnHolderItemClickListener
 * JD-Core Version:    0.7.0.1
 */