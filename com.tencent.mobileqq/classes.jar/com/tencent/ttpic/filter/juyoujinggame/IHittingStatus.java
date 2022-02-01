package com.tencent.ttpic.filter.juyoujinggame;

import android.graphics.RectF;

public abstract interface IHittingStatus
{
  public abstract RectF getRectF();
  
  public abstract boolean isAppear();
  
  public abstract boolean isHitting();
  
  public abstract void updateHitting(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.filter.juyoujinggame.IHittingStatus
 * JD-Core Version:    0.7.0.1
 */