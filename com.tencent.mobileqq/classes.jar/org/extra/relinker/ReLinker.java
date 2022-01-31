package org.extra.relinker;

import android.content.Context;

public class ReLinker
{
  public static ReLinkerInstance force()
  {
    return new ReLinkerInstance().force();
  }
  
  public static void loadLibrary(Context paramContext, String paramString)
  {
    loadLibrary(paramContext, paramString, null, null);
  }
  
  public static void loadLibrary(Context paramContext, String paramString1, String paramString2)
  {
    loadLibrary(paramContext, paramString1, paramString2, null);
  }
  
  public static void loadLibrary(Context paramContext, String paramString1, String paramString2, ReLinker.LoadListener paramLoadListener)
  {
    new ReLinkerInstance().loadLibrary(paramContext, paramString1, paramString2, paramLoadListener);
  }
  
  public static void loadLibrary(Context paramContext, String paramString, ReLinker.LoadListener paramLoadListener)
  {
    loadLibrary(paramContext, paramString, null, paramLoadListener);
  }
  
  public static ReLinkerInstance log(ReLinker.Logger paramLogger)
  {
    return new ReLinkerInstance().log(paramLogger);
  }
  
  public static ReLinkerInstance recursively()
  {
    return new ReLinkerInstance().recursively();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     org.extra.relinker.ReLinker
 * JD-Core Version:    0.7.0.1
 */