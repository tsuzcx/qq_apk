package com.tencent.mobileqq.troop.utils;

import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;

class TroopNativeUtils
{
  public boolean a = false;
  
  private TroopNativeUtils()
  {
    a();
  }
  
  public void a()
  {
    try
    {
      System.loadLibrary("qq_troop");
      this.a = true;
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopNativeUtils", 2, "load library error", localThrowable);
      }
      this.a = false;
    }
  }
  
  protected native void blurBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2);
  
  protected native void doBlur(byte[] paramArrayOfByte, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public native void yuv420spToArgb(byte[] paramArrayOfByte, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopNativeUtils
 * JD-Core Version:    0.7.0.1
 */