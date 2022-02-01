package com.tencent.ttpic.particle;

public class PDBackground
{
  private long mNativeObject = nCreateSystem();
  
  public PDBackground()
  {
    reset();
  }
  
  private static native long nCreateSystem();
  
  private static native void nDestroy(long paramLong);
  
  private static native void nRender(long paramLong);
  
  private static native void nReset(long paramLong);
  
  private static native void nSetTexture(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  private static native void nSetTimeDelta(long paramLong, double paramDouble);
  
  private static native void nSetUniform(long paramLong, int paramInt1, float paramFloat1, int paramInt2, float paramFloat2);
  
  private static native void nUpdateFboSize(long paramLong, int paramInt1, int paramInt2, int paramInt3);
  
  public void destroy()
  {
    nDestroy(this.mNativeObject);
    this.mNativeObject = 0L;
  }
  
  public void render()
  {
    nRender(this.mNativeObject);
  }
  
  public void reset()
  {
    nReset(this.mNativeObject);
  }
  
  public void setTexture(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    nSetTexture(this.mNativeObject, paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void setTimeDelta(double paramDouble)
  {
    nSetTimeDelta(this.mNativeObject, paramDouble);
  }
  
  public void setUniform(int paramInt1, float paramFloat1, int paramInt2, float paramFloat2)
  {
    nSetUniform(this.mNativeObject, paramInt1, paramFloat1, paramInt2, paramFloat2);
  }
  
  public void updateFboSize(int paramInt1, int paramInt2, int paramInt3)
  {
    nUpdateFboSize(this.mNativeObject, paramInt1, paramInt2, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.particle.PDBackground
 * JD-Core Version:    0.7.0.1
 */