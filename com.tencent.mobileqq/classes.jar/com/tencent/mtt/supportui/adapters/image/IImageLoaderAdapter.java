package com.tencent.mtt.supportui.adapters.image;

public abstract interface IImageLoaderAdapter<T>
{
  public abstract void fetchImage(String paramString, T paramT, Object paramObject);
  
  public abstract IDrawableTarget getImage(String paramString, Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.supportui.adapters.image.IImageLoaderAdapter
 * JD-Core Version:    0.7.0.1
 */