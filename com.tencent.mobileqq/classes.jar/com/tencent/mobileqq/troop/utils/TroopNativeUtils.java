package com.tencent.mobileqq.troop.utils;

import ajqg;
import android.graphics.Bitmap;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.qphone.base.util.QLog;

public class TroopNativeUtils
{
  public boolean a;
  
  private TroopNativeUtils()
  {
    a();
  }
  
  public static TroopNativeUtils a()
  {
    return ajqg.a;
  }
  
  public void a()
  {
    try
    {
      System.loadLibrary("qq_troop");
      this.a = true;
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopNativeUtils", 2, "load library error", localException);
      }
      this.a = false;
    }
  }
  
  public void a(Bitmap paramBitmap, int paramInt)
  {
    int j = VcSystemInfo.e();
    int i = j;
    if (j <= 0) {
      i = 1;
    }
    blurBitmap(paramBitmap, paramInt, i);
  }
  
  public void a(byte[] paramArrayOfByte, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = VcSystemInfo.e();
    int i = j;
    if (j <= 0) {
      i = 1;
    }
    doBlur(paramArrayOfByte, paramArrayOfInt, paramInt1, paramInt2, paramInt3, paramInt4, i);
  }
  
  protected native void blurBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2);
  
  protected native void doBlur(byte[] paramArrayOfByte, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public native void yuv420spToArgb(byte[] paramArrayOfByte, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopNativeUtils
 * JD-Core Version:    0.7.0.1
 */