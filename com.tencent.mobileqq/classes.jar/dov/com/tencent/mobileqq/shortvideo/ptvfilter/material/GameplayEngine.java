package dov.com.tencent.mobileqq.shortvideo.ptvfilter.material;

import android.content.res.AssetManager;

public class GameplayEngine
{
  private long jdField_a_of_type_Long = 0L;
  private GameEventConsumer jdField_a_of_type_DovComTencentMobileqqShortvideoPtvfilterMaterialGameEventConsumer = new GameEventConsumer(new Game3DNativeEvent());
  
  private native int createEngineContext(AssetManager paramAssetManager);
  
  private native void nativeOnOrientationChanged(long paramLong, int paramInt);
  
  private native void nativeOnSensorChanged(long paramLong1, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, long paramLong2);
  
  private native int onEngineOperateNative(long paramLong, int paramInt, String paramString);
  
  private native int onSurfaceOperateNative(long paramLong, int paramInt1, int paramInt2, int paramInt3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.ptvfilter.material.GameplayEngine
 * JD-Core Version:    0.7.0.1
 */