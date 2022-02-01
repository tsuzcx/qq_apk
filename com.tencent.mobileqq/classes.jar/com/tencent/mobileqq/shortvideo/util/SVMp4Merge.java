package com.tencent.mobileqq.shortvideo.util;

import java.io.File;
import java.util.List;

public class SVMp4Merge
{
  public static int a = 2;
  public static int b;
  
  public static int a(List<String> paramList, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int k = paramList.size();
    if (k <= 1) {
      return -1;
    }
    int j = 0;
    int i = 0;
    label29:
    if (j < k)
    {
      localStringBuilder.append((String)paramList.get(j));
      if (j != k - 1) {
        localStringBuilder.append('#');
      }
      File localFile = new File((String)paramList.get(j));
      if (!localFile.exists()) {
        break label184;
      }
      i = (int)localFile.length() + i;
    }
    label184:
    for (;;)
    {
      j += 1;
      break label29;
      if (i <= 0) {
        break;
      }
      try
      {
        nativeSetDropStrategy(a, b);
      }
      catch (UnsatisfiedLinkError paramList)
      {
        try
        {
          for (;;)
          {
            i = nativeMergeMp4(localStringBuilder.toString().getBytes(), paramString, k, i);
            paramList = new File(paramString);
            if ((paramList.exists()) && (i < 0)) {
              paramList.delete();
            }
            return i;
            paramList = paramList;
            paramList.printStackTrace();
          }
        }
        catch (UnsatisfiedLinkError paramList)
        {
          for (;;)
          {
            paramList.printStackTrace();
            i = -1;
          }
        }
      }
    }
  }
  
  private static native int nativeMergeMp4(byte[] paramArrayOfByte, String paramString, int paramInt1, int paramInt2);
  
  private static native void nativeSetDropStrategy(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.SVMp4Merge
 * JD-Core Version:    0.7.0.1
 */