package com.tencent.plato.module;

import com.tencent.plato.core.IReadableMap;
import com.tencent.plato.core.JSModule;

public abstract interface AppRegistry
  extends JSModule
{
  public abstract void runApplication(String paramString, IReadableMap paramIReadableMap);
  
  public abstract void unmountApplication(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.plato.module.AppRegistry
 * JD-Core Version:    0.7.0.1
 */