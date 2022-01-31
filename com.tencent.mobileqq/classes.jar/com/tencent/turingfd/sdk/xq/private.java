package com.tencent.turingfd.sdk.xq;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;

public class private
{
  public static final this<private> Yb = new finally();
  
  public static private getInstance()
  {
    return (private)Yb.get();
  }
  
  public void a(Throwable paramThrowable)
  {
    b("2", Log.getStackTraceString(paramThrowable));
  }
  
  public final void b(String paramString1, String paramString2)
  {
    paramString1 = g(paramString1);
    if (TextUtils.isEmpty(paramString1)) {}
    while (new File(paramString1).exists()) {
      return;
    }
    new package(this, paramString1, paramString2).start();
  }
  
  public void b(Throwable paramThrowable)
  {
    b("1", Log.getStackTraceString(paramThrowable));
  }
  
  public final String g(String paramString)
  {
    try
    {
      Object localObject = Environment.getExternalStorageDirectory().getAbsolutePath();
      localObject = new File((String)localObject + File.separator + ".turingdebug");
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      return ((File)localObject).getAbsolutePath() + File.separator + paramString;
    }
    catch (Throwable paramString) {}
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.private
 * JD-Core Version:    0.7.0.1
 */