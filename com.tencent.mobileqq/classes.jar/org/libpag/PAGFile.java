package org.libpag;

import android.content.res.AssetManager;
import org.extra.tools.LibraryLoadUtils;

public class PAGFile
  extends PAGComposition
{
  static
  {
    LibraryLoadUtils.loadLibrary("libpag");
    nativeInit();
  }
  
  private PAGFile(long paramLong)
  {
    super(paramLong);
  }
  
  public static PAGFile Load(AssetManager paramAssetManager, String paramString)
  {
    return LoadFromAssets(paramAssetManager, paramString);
  }
  
  public static PAGFile Load(String paramString)
  {
    return LoadFromPath(paramString);
  }
  
  public static PAGFile Load(byte[] paramArrayOfByte)
  {
    return LoadFromBytes(paramArrayOfByte, paramArrayOfByte.length);
  }
  
  private static native PAGFile LoadFromAssets(AssetManager paramAssetManager, String paramString);
  
  private static native PAGFile LoadFromBytes(byte[] paramArrayOfByte, int paramInt);
  
  private static native PAGFile LoadFromPath(String paramString);
  
  public static native int MaxSupportedTagLevel();
  
  private static final native void nativeInit();
  
  public native PAGFile copyOriginal();
  
  public native PAGLayer[] getLayersByEditableIndex(int paramInt1, int paramInt2);
  
  public native PAGText getTextData(int paramInt);
  
  public native void nativeReplaceImage(int paramInt, long paramLong);
  
  public native int numImages();
  
  public native int numTexts();
  
  public native int numVideos();
  
  public native String path();
  
  public void replaceImage(int paramInt, PAGImage paramPAGImage)
  {
    if (paramPAGImage == null)
    {
      nativeReplaceImage(paramInt, 0L);
      return;
    }
    nativeReplaceImage(paramInt, paramPAGImage.nativeContext);
  }
  
  public native void replaceText(int paramInt, PAGText paramPAGText);
  
  public native void setDuration(long paramLong);
  
  public native void setTimeStretchMode(int paramInt);
  
  public native int tagLevel();
  
  public native int timeStretchMode();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.libpag.PAGFile
 * JD-Core Version:    0.7.0.1
 */