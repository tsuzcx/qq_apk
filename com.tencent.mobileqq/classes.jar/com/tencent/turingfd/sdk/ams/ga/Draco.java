package com.tencent.turingfd.sdk.ams.ga;

import android.content.Context;
import android.os.Process;
import java.io.File;

public class Draco
{
  public static final String FILE_NAME = const.get(const.Ob);
  public static final String Nd = const.get(const.Nb);
  public static boolean Od = false;
  
  public static String P(Context paramContext)
  {
    paramContext = paramContext.getDir(Nd, 0);
    if (paramContext == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("1");
    paramContext = new File(localStringBuilder.toString());
    if ((!paramContext.exists()) && (!paramContext.mkdirs())) {
      return "";
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append(FILE_NAME);
    return localStringBuilder.toString();
  }
  
  public static void b(Context paramContext, Canesatici paramCanesatici)
  {
    long l1 = paramCanesatici.c(paramContext, "502");
    long l2 = Process.myUid();
    if (l1 != l2)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(l2);
      paramCanesatici.a(paramContext, "502", localStringBuilder.toString(), false);
    }
  }
  
  public static void c(Context paramContext, Canesatici paramCanesatici)
  {
    long l = paramCanesatici.c(paramContext, "502");
    int i = Process.myUid();
    boolean bool = l < 0L;
    if (!bool)
    {
      paramCanesatici.d(paramContext, 0L);
      return;
    }
    if ((bool) && (i != l))
    {
      paramCanesatici.d(paramContext, -1L);
      return;
    }
    paramCanesatici.d(paramContext, 1L);
  }
  
  public static void d(Context paramContext, Canesatici paramCanesatici)
  {
    try
    {
      if (Od) {
        return;
      }
      Od = true;
      long l = paramCanesatici.c(paramContext, "502");
      int i = Process.myUid();
      if ((l != 0L) && (i != l))
      {
        paramCanesatici.a(paramContext, "101", "", true);
        new File(P(paramContext)).delete();
        return;
      }
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.ams.ga.Draco
 * JD-Core Version:    0.7.0.1
 */