package com.tencent.viola.ui.baseComponent;

import com.tencent.viola.bridge.Invoker;
import com.tencent.viola.bridge.JavascriptInvokable;

public abstract interface IFComponentHolder
  extends JavascriptInvokable, ComponentCreator
{
  public abstract Invoker getPropertyInvoker(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.viola.ui.baseComponent.IFComponentHolder
 * JD-Core Version:    0.7.0.1
 */