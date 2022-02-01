package org.light;

import android.content.Context;
import org.light.report.avreport.LightSDKRecord;

public class LightEngine
{
  private Context appContext = null;
  private long nativeContext = 0L;
  
  static
  {
    LibraryLoadUtils.loadLibrary("YTCommon");
    LibraryLoadUtils.loadLibrary("light-sdk");
    nativeInit();
  }
  
  public static native int ComponentLevel();
  
  public static native LightEngine Make(VideoOutputConfig paramVideoOutputConfig, AudioOutputConfig paramAudioOutputConfig, RendererConfig paramRendererConfig);
  
  public static native void RegisterFont(FontAsset paramFontAsset, String paramString);
  
  public static native String Version();
  
  public static native boolean isDeviceAbilitySupported(String paramString);
  
  private native void nativeFinalize();
  
  private static native void nativeInit();
  
  private final native void nativeRelease();
  
  public native AudioOutput audioOutput();
  
  protected void finalize()
  {
    super.finalize();
    nativeFinalize();
  }
  
  public native String getBenchData();
  
  public native boolean getDisableRenderer();
  
  public native int getOriginTexture();
  
  public native int getResultTexture();
  
  public native LightSDKRecord getSDKRecord();
  
  public native PerformanceData performanceData();
  
  public void release()
  {
    nativeRelease();
  }
  
  public native CameraController setAssetForCamera(LightAsset paramLightAsset);
  
  public native MovieController setAssetForMovie(LightAsset paramLightAsset);
  
  public native void setBGMusicHidden(boolean paramBoolean);
  
  public native void setConfig(Config paramConfig);
  
  public native void setDefaultBeautyVersion(String paramString);
  
  public native void setDisableRenderer(boolean paramBoolean);
  
  public native void setImageDebugInfo(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3);
  
  public native boolean setSurface(LightSurface paramLightSurface);
  
  public native VideoOutput videoOutput();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.light.LightEngine
 * JD-Core Version:    0.7.0.1
 */