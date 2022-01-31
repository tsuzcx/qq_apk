package com.tencent.viola.ui.baseComponent;

import java.util.List;

public abstract interface IVReuseComponent
{
  public abstract boolean isReuse();
  
  public abstract void resetAttrs(List<String> paramList);
  
  public abstract void resetComponent();
  
  public abstract void resetEvents(List<String> paramList);
  
  public abstract void resetStyles(List<String> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.viola.ui.baseComponent.IVReuseComponent
 * JD-Core Version:    0.7.0.1
 */