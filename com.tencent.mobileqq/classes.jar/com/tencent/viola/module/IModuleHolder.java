package com.tencent.viola.module;

import com.tencent.viola.bridge.JavascriptInvokable;

public abstract interface IModuleHolder<T extends BaseModule>
  extends JavascriptInvokable
{
  public abstract T buildInstance();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.viola.module.IModuleHolder
 * JD-Core Version:    0.7.0.1
 */