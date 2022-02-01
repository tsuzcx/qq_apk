package com.tencent.mobileqq.widget;

public abstract interface ISlidePanelListener
{
  public abstract void cancelAnimator();
  
  public abstract void displayPanel();
  
  public abstract void displayPanelFinish();
  
  public abstract void fadeBackground(float paramFloat);
  
  public abstract void hidePanel();
  
  public abstract void hidePanelFinish();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ISlidePanelListener
 * JD-Core Version:    0.7.0.1
 */