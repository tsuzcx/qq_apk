package com.tencent.mobileqq.text;

import android.view.View;

public abstract interface ITopic
{
  public abstract Object getData();
  
  public abstract void onClick(View paramView);
  
  public abstract void setCustomFont(boolean paramBoolean);
  
  public abstract void setPressed(View paramView, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.text.ITopic
 * JD-Core Version:    0.7.0.1
 */