package com.tencent.tav.extractor.wrapper;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.tav.extractor.AssetExtractor;

public class ExtractorLoader
{
  private static Handler loadHandler;
  private static HandlerThread loadThread = new HandlerThread("ExtractorLoader");
  
  static
  {
    loadThread.start();
  }
  
  public static void cacheExtractor(AssetExtractor paramAssetExtractor)
  {
    checkAndStart();
    loadHandler.post(new ExtractorLoader.ExtractorLoaderRunnable(paramAssetExtractor));
  }
  
  public static void cacheExtractor(String paramString)
  {
    checkAndStart();
    loadHandler.post(new ExtractorLoader.VideoPathLoaderRunnable(paramString));
  }
  
  private static void checkAndStart()
  {
    if ((loadHandler == null) && (loadThread.getLooper() != null)) {
      loadHandler = new Handler(loadThread.getLooper());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tav.extractor.wrapper.ExtractorLoader
 * JD-Core Version:    0.7.0.1
 */