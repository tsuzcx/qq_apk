package com.tencent.mobileqq.richmediabrowser;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.richmediabrowser.api.depend.IBrowserProvider;

public abstract interface IProvider
  extends IBrowserProvider
{
  public abstract Intent a(long paramLong, int paramInt);
  
  public abstract void a(int paramInt);
  
  public abstract void a(int paramInt, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract void a(long paramLong);
  
  public abstract void a(long paramLong, int paramInt1, int paramInt2);
  
  public abstract void a(long paramLong, int paramInt, Bundle paramBundle);
  
  public abstract void a(String paramString, int paramInt);
  
  public abstract int b(long paramLong, int paramInt);
  
  public abstract void b(long paramLong);
  
  public abstract void b(long paramLong, int paramInt1, int paramInt2);
  
  public abstract Intent c(long paramLong, int paramInt1, int paramInt2);
  
  public abstract void c(long paramLong);
  
  public abstract void c(long paramLong, int paramInt);
  
  public abstract boolean c();
  
  public abstract void d(long paramLong);
  
  public abstract boolean e(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.IProvider
 * JD-Core Version:    0.7.0.1
 */