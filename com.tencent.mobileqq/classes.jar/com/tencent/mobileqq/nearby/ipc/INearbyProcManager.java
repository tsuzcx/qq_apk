package com.tencent.mobileqq.nearby.ipc;

import android.graphics.Bitmap;
import android.os.Message;
import com.tencent.mobileqq.nearby.redtouch.NearbyRedNum;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import java.util.ArrayList;

public abstract interface INearbyProcManager
{
  public abstract int a();
  
  public abstract Bitmap a(String paramString, int paramInt, boolean paramBoolean);
  
  public abstract Message a(Message paramMessage);
  
  public abstract NearbyRedNum a();
  
  public abstract BusinessInfoCheckUpdate.RedTypeInfo a(int paramInt);
  
  public abstract Object a(int paramInt, String paramString);
  
  public abstract void a();
  
  public abstract void a(byte paramByte);
  
  public abstract void a(int paramInt);
  
  public abstract void a(INearbyProcObserver paramINearbyProcObserver);
  
  public abstract void a(Object paramObject);
  
  public abstract void a(String paramString);
  
  public abstract void a(ArrayList<String> paramArrayList);
  
  public abstract void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9);
  
  public abstract void a(byte[] paramArrayOfByte);
  
  public abstract boolean a();
  
  public abstract boolean a(int paramInt, boolean paramBoolean);
  
  public abstract Object[] a(int paramInt, Object... paramVarArgs);
  
  public abstract int b();
  
  public abstract NearbyRedNum b();
  
  public abstract BusinessInfoCheckUpdate.RedTypeInfo b(int paramInt);
  
  public abstract void b();
  
  public abstract void b(INearbyProcObserver paramINearbyProcObserver);
  
  public abstract void b(Object paramObject);
  
  public abstract void c();
  
  public abstract void d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.ipc.INearbyProcManager
 * JD-Core Version:    0.7.0.1
 */