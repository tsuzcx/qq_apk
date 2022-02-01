package com.tencent.mtt.supportui.adapters.image;

public abstract interface IImageRequestListener<T>
{
  public abstract void onRequestFail(Throwable paramThrowable, String paramString);
  
  public abstract void onRequestStart(T paramT);
  
  public abstract void onRequestSuccess(T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.supportui.adapters.image.IImageRequestListener
 * JD-Core Version:    0.7.0.1
 */