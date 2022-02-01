package org.light;

public class LightAsset
{
  private long nativeContext = 0L;
  
  static
  {
    LibraryLoadUtils.loadLibrary("light-sdk");
    nativeInit();
  }
  
  public static native LightAsset Load(String paramString, int paramInt);
  
  private static native void nativeInit();
  
  public native long duration();
  
  protected void finalize()
  {
    super.finalize();
  }
  
  public native String[] getBgmMusicIDs();
  
  public native String[] getBoundsTrackerPlaceHolders();
  
  public native FontAsset[] getFontAssets();
  
  public native boolean hasLut();
  
  public native boolean hasMakeup();
  
  public native boolean hasMesh();
  
  public native int height();
  
  public boolean isEditableWatermarkMaterial()
  {
    return needRenderAbility("material.editWatermark");
  }
  
  public boolean isWatermarkMaterial()
  {
    return needRenderAbility("material.watermark");
  }
  
  public native MaterialConfig[] materialConfigs();
  
  public native void nativeFinalize();
  
  public native boolean nativeResetWhenStartRecord();
  
  public boolean needCyberpunkStyleAbility()
  {
    return needRenderAbility("material.cyberpunk");
  }
  
  public native boolean needRenderAbility(String paramString);
  
  public boolean stickerNeedMaskRecordTouchPoint()
  {
    return needRenderAbility("material.recordTouch");
  }
  
  public boolean stickerNeedTouchTriggerEvent()
  {
    return needRenderAbility("material.touch");
  }
  
  public native TemplateConfig templateConfig();
  
  public native int width();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.light.LightAsset
 * JD-Core Version:    0.7.0.1
 */