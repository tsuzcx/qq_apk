package com.tencent.viola.ui.context;

import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.ui.baseComponent.VComponent;

public abstract interface ActionContext
{
  public abstract VComponent getComponent(String paramString);
  
  public abstract ViolaInstance getInstance();
  
  public abstract void registerComponent(String paramString, VComponent paramVComponent);
  
  public abstract VComponent unregisterComponent(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.context.ActionContext
 * JD-Core Version:    0.7.0.1
 */