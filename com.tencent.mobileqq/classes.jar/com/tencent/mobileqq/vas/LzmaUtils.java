package com.tencent.mobileqq.vas;

import android.content.Context;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class LzmaUtils
{
  private static native int DecodeEx(String paramString1, String paramString2);
  
  public static int a(Context paramContext, String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null))
    {
      if (!new File(paramString1).exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d("lzmaDecode", 2, "lzma File not exists.");
        }
        return -1;
      }
      File localFile = new File(paramString2);
      if ((!localFile.exists()) && (!localFile.mkdirs()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("lzmaDecode", 2, "cannot create dirs.");
        }
        return -1;
      }
      int i;
      int j;
      try
      {
        SoLoadUtil.a(paramContext, "DecodeSo", 0, false, false);
        int k = 0;
        i = 0;
        for (;;)
        {
          j = i;
          if (k > 3) {
            break label187;
          }
          try
          {
            j = DecodeEx(paramString1, paramString2);
            if (j == 0) {
              break label187;
            }
            k += 1;
            i = j;
          }
          catch (UnsatisfiedLinkError paramContext) {}
        }
        j = i;
      }
      catch (UnsatisfiedLinkError paramContext)
      {
        i = 0;
      }
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("Unsatisfied Link error: ");
        paramString1.append(paramContext.toString());
        QLog.d("lzmaDecode", 2, paramString1.toString());
        j = i;
      }
      label187:
      if (j != 0)
      {
        if (QLog.isColorLevel())
        {
          paramContext = new StringBuilder();
          paramContext.append("decode file, result:");
          paramContext.append(j);
          QLog.d("lzmaDecode", 2, paramContext.toString());
        }
        return j;
      }
      return 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("lzmaDecode", 2, "path is null.");
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.LzmaUtils
 * JD-Core Version:    0.7.0.1
 */