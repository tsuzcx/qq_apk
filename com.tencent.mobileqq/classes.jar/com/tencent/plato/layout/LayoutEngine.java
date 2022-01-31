package com.tencent.plato.layout;

import com.tencent.plato.jni.HybridObject;

public class LayoutEngine
  extends HybridObject
{
  public LayoutEngine()
  {
    setNativePointer(nativeInit());
  }
  
  private native void jniSetWindow(long paramLong, float paramFloat1, float paramFloat2, float paramFloat3);
  
  private native void nativeDestroy(long paramLong);
  
  private native long nativeInit();
  
  private native long nativeNewPlatoNode(Object paramObject, long paramLong, int paramInt);
  
  public void destroy()
  {
    nativeDestroy(this.nativePointer);
  }
  
  long newNativePlatoNode(Object paramObject, int paramInt)
  {
    return nativeNewPlatoNode(paramObject, this.nativePointer, paramInt);
  }
  
  public void setWindow(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    jniSetWindow(this.nativePointer, paramFloat1, paramFloat2, paramFloat3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.plato.layout.LayoutEngine
 * JD-Core Version:    0.7.0.1
 */