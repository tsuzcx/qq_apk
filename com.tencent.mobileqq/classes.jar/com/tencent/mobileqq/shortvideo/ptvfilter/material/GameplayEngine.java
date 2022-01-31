package com.tencent.mobileqq.shortvideo.ptvfilter.material;

import android.content.res.AssetManager;
import axjl;
import axjm;

public class GameplayEngine
{
  private long jdField_a_of_type_Long = 0L;
  private axjl jdField_a_of_type_Axjl = new axjl(new Game3DNativeEvent());
  
  private native int createEngineContext(AssetManager paramAssetManager);
  
  private native void nativeOnOrientationChanged(long paramLong, int paramInt);
  
  private native void nativeOnSensorChanged(long paramLong1, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, long paramLong2);
  
  private native int onEngineOperateNative(long paramLong, int paramInt, String paramString);
  
  private native int onSurfaceOperateNative(long paramLong, int paramInt1, int paramInt2, int paramInt3);
  
  public void a(axjm paramaxjm)
  {
    this.jdField_a_of_type_Axjl.a(paramaxjm, this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ptvfilter.material.GameplayEngine
 * JD-Core Version:    0.7.0.1
 */