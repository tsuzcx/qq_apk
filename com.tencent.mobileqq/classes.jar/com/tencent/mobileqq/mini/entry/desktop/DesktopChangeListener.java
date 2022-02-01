package com.tencent.mobileqq.mini.entry.desktop;

public abstract interface DesktopChangeListener
{
  public abstract void onDesktopAccountChanged();
  
  public abstract void onDesktopClosed();
  
  public abstract void onDesktopDestroy();
  
  public abstract void onDesktopOpened();
  
  public abstract void onDesktopResume();
  
  public abstract void onStartDesktopOpenAnimation();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.DesktopChangeListener
 * JD-Core Version:    0.7.0.1
 */