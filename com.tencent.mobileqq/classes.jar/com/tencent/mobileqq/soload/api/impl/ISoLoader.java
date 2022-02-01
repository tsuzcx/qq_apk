package com.tencent.mobileqq.soload.api.impl;

import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.mobileqq.soload.biz.entity.LoadParam;

public abstract interface ISoLoader
{
  public abstract LoadExtResult a(LoadParam paramLoadParam);
  
  public abstract void a(LoadParam paramLoadParam, OnLoadListener paramOnLoadListener);
  
  public abstract void a(String paramString);
  
  public abstract boolean a(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.soload.api.impl.ISoLoader
 * JD-Core Version:    0.7.0.1
 */