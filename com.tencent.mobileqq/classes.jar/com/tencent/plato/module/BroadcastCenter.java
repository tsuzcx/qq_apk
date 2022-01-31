package com.tencent.plato.module;

import com.tencent.plato.core.IReadableMap;
import com.tencent.plato.core.JSModule;

public abstract interface BroadcastCenter
  extends JSModule
{
  public abstract void fireBroadcast(String paramString, IReadableMap paramIReadableMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.plato.module.BroadcastCenter
 * JD-Core Version:    0.7.0.1
 */