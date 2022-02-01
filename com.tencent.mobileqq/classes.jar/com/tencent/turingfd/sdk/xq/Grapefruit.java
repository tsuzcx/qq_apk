package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import android.os.Process;
import java.io.File;
import java.util.HashMap;

public class Grapefruit
{
  public static final String a = import.a(import.A0);
  public static final String b = import.a(import.B0);
  public static boolean c = false;
  
  public static String a(Context paramContext)
  {
    paramContext = paramContext.getDir(a, 0);
    if (paramContext == null) {
      return "";
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramContext.getAbsolutePath());
    paramContext = File.separator;
    ((StringBuilder)localObject).append(paramContext);
    ((StringBuilder)localObject).append("1");
    localObject = new File(((StringBuilder)localObject).toString());
    if ((!((File)localObject).exists()) && (!((File)localObject).mkdirs())) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((File)localObject).getAbsolutePath());
    localStringBuilder.append(paramContext);
    localStringBuilder.append(b);
    return localStringBuilder.toString();
  }
  
  public static void a(Context paramContext, Date paramDate)
  {
    try
    {
      if (c) {
        return;
      }
      c = true;
      long l = paramDate.a(paramContext, "502");
      int i = Process.myUid();
      if ((l != 0L) && (i != 0) && (i != l))
      {
        paramDate.a(paramContext, "101", "", true);
        paramDate.b(paramContext, 0L);
        paramDate = new HashMap();
        paramDate.put("901", "");
        Date.a(paramContext, paramDate);
        new File(a(paramContext)).delete();
        return;
      }
    }
    finally
    {
      paramContext.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Grapefruit
 * JD-Core Version:    0.7.0.1
 */