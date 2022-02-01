package com.tencent.richframework.data.idata;

import java.util.Collection;

public abstract interface IDataCenter<T>
{
  public abstract String a(T paramT);
  
  public abstract Collection<IDataDisplaySurface<T>> d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richframework.data.idata.IDataCenter
 * JD-Core Version:    0.7.0.1
 */