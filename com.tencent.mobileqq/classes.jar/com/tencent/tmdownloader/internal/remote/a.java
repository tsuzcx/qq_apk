package com.tencent.tmdownloader.internal.remote;

import android.os.IInterface;
import com.tencent.tmassistant.appinfo.aidl.IGetAppInfoCallback;
import com.tencent.tmassistant.appinfo.data.AppDetailReqParam;

public abstract interface a
  extends IInterface
{
  public abstract int a(AppDetailReqParam paramAppDetailReqParam, IGetAppInfoCallback paramIGetAppInfoCallback);
  
  public abstract void a();
  
  public abstract void a(int paramInt, String paramString);
  
  public abstract void a(String paramString, int paramInt);
  
  public abstract void a(String paramString, long paramLong);
  
  public abstract void a(String paramString1, String paramString2);
  
  public abstract void a(String paramString, boolean paramBoolean);
  
  public abstract void a(String paramString, byte[] paramArrayOfByte);
  
  public abstract byte[] a(String paramString);
  
  public abstract int b(String paramString);
  
  public abstract void b();
  
  public abstract long c(String paramString);
  
  public abstract void c();
  
  public abstract String d(String paramString);
  
  public abstract void d();
  
  public abstract boolean e(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.remote.a
 * JD-Core Version:    0.7.0.1
 */