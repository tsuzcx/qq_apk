package org.light;

public class MovieController
  extends Controller
{
  static
  {
    LibraryLoadUtils.loadLibrary("light-sdk");
    nativeInit();
  }
  
  private static native void nativeInit();
  
  public native long duration();
  
  public native TimeRange[] getBoundsTrackTimeRanges();
  
  public native ClipInfo[][] getClipInfos();
  
  public native ClipPlaceHolder[] getClipPlaceHolders();
  
  public native LUTPlaceHolder[] getLUTPlaceHolders();
  
  public native TimeRange[] getTextTimeRanges();
  
  public native boolean hasAudio();
  
  public native void replaceLUTAsset(String paramString, LUTAsset paramLUTAsset);
  
  public native void setClipAssets(ClipAsset[] paramArrayOfClipAsset, String paramString);
  
  public int type()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.light.MovieController
 * JD-Core Version:    0.7.0.1
 */