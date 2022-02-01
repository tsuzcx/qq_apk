package de.robv.android.xposed.callbacks;

public abstract interface IXUnhook<T>
{
  public abstract T getCallback();
  
  public abstract void unhook();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     de.robv.android.xposed.callbacks.IXUnhook
 * JD-Core Version:    0.7.0.1
 */