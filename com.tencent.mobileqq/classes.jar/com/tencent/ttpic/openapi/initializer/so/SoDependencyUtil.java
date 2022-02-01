package com.tencent.ttpic.openapi.initializer.so;

import com.tencent.ttpic.baseutils.log.LogUtils;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class SoDependencyUtil
{
  private static final String TAG = SoDependencyUtil.class.getSimpleName();
  
  public static List<String> getDependencies(String paramString1, String paramString2)
  {
    paramString1 = getDependencies1(paramString1, paramString2);
    if (paramString1 == null) {
      return null;
    }
    return Arrays.asList(paramString1);
  }
  
  public static String[] getDependencies1(String paramString1, String paramString2)
  {
    paramString1 = new File(paramString1, paramString2);
    try
    {
      paramString1 = MinElf.extract_DT_NEEDED(paramString1);
      return paramString1;
    }
    catch (IOException paramString1)
    {
      paramString1.printStackTrace();
      LogUtils.e(TAG, paramString1);
      return null;
    }
    catch (Throwable paramString1)
    {
      for (;;)
      {
        LogUtils.e(TAG, paramString1);
      }
    }
    catch (MinElf.ElfError paramString1)
    {
      label18:
      break label18;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.initializer.so.SoDependencyUtil
 * JD-Core Version:    0.7.0.1
 */