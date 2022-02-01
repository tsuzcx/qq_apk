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
    int n = paramList.size();
    int m = -1;
    if (n <= 1) {
      return -1;
    }
    int i = 0;
    int k;
    for (int j = 0; i < n; j = k)
    {
      localStringBuilder.append((String)paramList.get(i));
      if (i != n - 1) {
        localStringBuilder.append('#');
      }
      File localFile = new File((String)paramList.get(i));
      k = j;
      if (localFile.exists()) {
        k = j + (int)localFile.length();
      }
      i += 1;
    }
    if (j <= 0) {
      return -1;
    }
    try
    {
      nativeSetDropStrategy(a, b);
    }
    catch (UnsatisfiedLinkError paramList)
    {
      paramList.printStackTrace();
    }
    try
    {
      i = nativeMergeMp4(localStringBuilder.toString().getBytes(), paramString, n, j);
    }
    catch (UnsatisfiedLinkError paramList)
    {
      paramList.printStackTrace();
      i = m;
    }
    paramList = new File(paramString);
    if ((paramList.exists()) && (i < 0)) {
      paramList.delete();
    }
    return i;
  }
  
  private static native int nativeMergeMp4(byte[] paramArrayOfByte, String paramString, int paramInt1, int paramInt2);
  
  private static native void nativeSetDropStrategy(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.SVMp4Merge
 * JD-Core Version:    0.7.0.1
 */