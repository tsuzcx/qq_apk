package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import android.os.Process;
import java.io.File;

public class Durian
{
  public static final String FILE_NAME = final.get(final.kf);
  public static final String gi = final.get(final.jf);
  public static boolean hi = false;
  
  public static String Y(Context paramContext)
  {
    paramContext = paramContext.getDir(gi, 0);
    if (paramContext == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getAbsolutePath());
    paramContext = new File(do.a(localStringBuilder, File.separator, "1"));
    if ((!paramContext.exists()) && (!paramContext.mkdirs())) {
      return "";
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append(FILE_NAME);
    return localStringBuilder.toString();
  }
  
  public static void b(Context paramContext, Cascara paramCascara)
  {
    long l1 = paramCascara.f(paramContext, "502");
    long l2 = Process.myUid();
    if (l1 != l2)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(l2);
      paramCascara.a(paramContext, "502", localStringBuilder.toString(), false);
    }
  }
  
  public static void c(Context paramContext, Cascara paramCascara)
  {
    long l = paramCascara.f(paramContext, "502");
    int i = Process.myUid();
    boolean bool = l < 0L;
    if (!bool)
    {
      paramCascara.e(paramContext, 0L);
      return;
    }
    if ((bool) && (i != l))
    {
      paramCascara.e(paramContext, -1L);
      return;
    }
    paramCascara.e(paramContext, 1L);
  }
  
  public static void d(Context paramContext, Cascara paramCascara)
  {
    try
    {
      if (hi) {
        return;
      }
      hi = true;
      long l = paramCascara.f(paramContext, "502");
      int i = Process.myUid();
      if ((l != 0L) && (i != l))
      {
        paramCascara.a(paramContext, "101", "", true);
        new File(Y(paramContext)).delete();
        return;
      }
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Durian
 * JD-Core Version:    0.7.0.1
 */