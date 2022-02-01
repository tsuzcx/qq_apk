package com.tencent.qqmusic.mediaplayer.upstream;

import com.tencent.qqmusic.mediaplayer.NativeLibs;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.util.Arrays;

public class NativeDataSourceFactory
{
  private static final String TAG = "NativeDataSourceFactory";
  private static final boolean soLoaded = NativeLibs.loadAll(Arrays.asList(new NativeLibs[] { NativeLibs.audioCommon, NativeLibs.formatDetector, NativeLibs.codecFactory, NativeLibs.decoderJni, NativeLibs.cppShared, NativeLibs.stlportShared, NativeLibs.xlog, NativeLibs.FFmpeg }));
  
  static
  {
    if (!soLoaded) {
      Logger.e("NativeDataSourceFactory", "[static initializer] failed to load so!");
    }
  }
  
  public static INativeDataSource fileDataSource(String paramString)
  {
    return new NativeDataSourceFactory.1(paramString);
  }
  
  public static INativeDataSource fileDataSource(String paramString, int paramInt)
  {
    return new NativeDataSourceFactory.2(paramString, paramInt);
  }
  
  public static native long localFile(String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.NativeDataSourceFactory
 * JD-Core Version:    0.7.0.1
 */