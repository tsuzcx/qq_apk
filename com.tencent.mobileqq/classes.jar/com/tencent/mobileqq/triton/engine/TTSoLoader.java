package com.tencent.mobileqq.triton.engine;

import com.tencent.mobileqq.triton.sdk.ITSoLoader;
import java.io.File;

public class TTSoLoader
{
  private static final String TAG = "SoLoader";
  private static final String[] sLibsNames = { "png-armeabi-v7a", "freetypejni", "v8jni", "c++_shared", "triton" };
  private static ITSoLoader sSoloaderProxy;
  
  public static ITSoLoader getSoLoader()
  {
    if (sSoloaderProxy == null) {
      sSoloaderProxy = new TTSoLoader.DefSoLoader(null);
    }
    return sSoloaderProxy;
  }
  
  public static boolean loadSo()
  {
    boolean bool2 = true;
    for (;;)
    {
      int i;
      boolean bool1;
      try
      {
        String[] arrayOfString = sLibsNames;
        int k = arrayOfString.length;
        i = 0;
        bool1 = bool2;
        if (i < k)
        {
          String str1 = arrayOfString[i];
          String str2 = getSoLoader().getSoPath("lib" + str1 + ".so");
          if (str2 == null) {
            break label157;
          }
          if (new File(str2).exists())
          {
            j = 0;
            if (j != 0)
            {
              System.loadLibrary(str1);
              break label150;
            }
          }
          else
          {
            TTLog.e("SoLoader", "loadSo so file do not exits :" + str2);
            break label157;
          }
          System.load(str2);
        }
      }
      catch (Throwable localThrowable)
      {
        TTLog.e("SoLoader", "loadSo error ", localThrowable);
        bool1 = false;
      }
      return bool1;
      label150:
      i += 1;
      continue;
      label157:
      int j = 1;
    }
  }
  
  public static void setSoLoader(ITSoLoader paramITSoLoader)
  {
    sSoloaderProxy = paramITSoLoader;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.triton.engine.TTSoLoader
 * JD-Core Version:    0.7.0.1
 */