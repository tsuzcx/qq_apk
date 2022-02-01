package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import android.os.Process;
import java.io.File;

public class Bilberry
{
  public static final String FILE_NAME = const.get(const.cf);
  public static final String nh = const.get(const.bf);
  public static boolean oh = false;
  
  public static String G(Context paramContext)
  {
    paramContext = paramContext.getDir(nh, 0);
    if (paramContext == null) {
      return "";
    }
    paramContext = new File(paramContext.getAbsolutePath() + File.separator + "1");
    if ((!paramContext.exists()) && (!paramContext.mkdirs())) {
      return "";
    }
    return paramContext.getAbsolutePath() + File.separator + FILE_NAME;
  }
  
  public static void b(Context paramContext, Almond paramAlmond)
  {
    long l1 = paramAlmond.d(paramContext, "502");
    long l2 = Process.myUid();
    if (l1 != l2) {
      paramAlmond.a(paramContext, "502", "" + l2, false);
    }
  }
  
  public static void c(Context paramContext, Almond paramAlmond)
  {
    long l = paramAlmond.d(paramContext, "502");
    int i = Process.myUid();
    boolean bool = l < 0L;
    if (!bool)
    {
      paramAlmond.e(paramContext, 0L);
      return;
    }
    if ((bool) && (i != l))
    {
      paramAlmond.e(paramContext, -1L);
      return;
    }
    paramAlmond.e(paramContext, 1L);
  }
  
  public static void d(Context paramContext, Almond paramAlmond)
  {
    try
    {
      if (oh) {
        return;
      }
      oh = true;
      long l = paramAlmond.d(paramContext, "502");
      int i = Process.myUid();
      if ((l != 0L) && (i != l))
      {
        paramAlmond.a(paramContext, "101", "", true);
        new File(G(paramContext)).delete();
        return;
      }
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Bilberry
 * JD-Core Version:    0.7.0.1
 */