package com.tencent.mobileqq.kandian.biz.viola.api;

import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import java.util.HashMap;

public abstract interface IViolaUiDelegate
{
  public abstract void a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(Bundle paramBundle);
  
  public abstract void a(ViewGroup paramViewGroup);
  
  public abstract void a(ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener);
  
  public abstract void a(HashMap<String, Object> paramHashMap, ViewGroup paramViewGroup);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract HashMap<String, Object> b();
  
  public abstract void b(boolean paramBoolean);
  
  public abstract OnTitleChangeListener c();
  
  public abstract boolean d();
  
  public abstract boolean e();
  
  public abstract void f();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.api.IViolaUiDelegate
 * JD-Core Version:    0.7.0.1
 */