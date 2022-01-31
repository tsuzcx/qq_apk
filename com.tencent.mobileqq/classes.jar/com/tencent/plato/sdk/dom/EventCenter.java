package com.tencent.plato.sdk.dom;

import com.tencent.plato.core.IReadableMap;
import com.tencent.plato.core.JSModule;

public abstract interface EventCenter
  extends JSModule
{
  public abstract void fireEvent(int paramInt1, int paramInt2, String paramString, IReadableMap paramIReadableMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.plato.sdk.dom.EventCenter
 * JD-Core Version:    0.7.0.1
 */