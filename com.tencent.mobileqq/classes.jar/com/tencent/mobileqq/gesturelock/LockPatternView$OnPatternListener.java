package com.tencent.mobileqq.gesturelock;

import java.util.List;

public abstract interface LockPatternView$OnPatternListener
{
  public abstract void onPatternCellAdded(List<LockPatternView.Cell> paramList);
  
  public abstract void onPatternCleared();
  
  public abstract void onPatternDetected(List<LockPatternView.Cell> paramList);
  
  public abstract void onPatternStart();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gesturelock.LockPatternView.OnPatternListener
 * JD-Core Version:    0.7.0.1
 */