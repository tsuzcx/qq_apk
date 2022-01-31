package com.tencent.tissue.v8rt.engine;

import android.annotation.TargetApi;
import android.os.Trace;
import com.tencent.tissue.v8rt.BuildConfig;

public final class TraceUtil
{
  public static void beginSection(String paramString)
  {
    if ((BuildConfig.DEBUG) && (Util.SDK_INT >= 18)) {
      beginSectionV18(paramString);
    }
  }
  
  @TargetApi(18)
  private static void beginSectionV18(String paramString)
  {
    Trace.beginSection(paramString);
  }
  
  public static void endSection()
  {
    if ((BuildConfig.DEBUG) && (Util.SDK_INT >= 18)) {
      endSectionV18();
    }
  }
  
  @TargetApi(18)
  private static void endSectionV18() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tissue.v8rt.engine.TraceUtil
 * JD-Core Version:    0.7.0.1
 */