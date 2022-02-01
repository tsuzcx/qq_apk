package com.tencent.turingfd.sdk.xq;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;

public class Damson
{
  public static final short<Damson> Tg = new Cranberry();
  
  public static Damson getInstance()
  {
    return (Damson)Tg.get();
  }
  
  public void a(Throwable paramThrowable)
  {
    f("2", Log.getStackTraceString(paramThrowable));
  }
  
  public void b(Throwable paramThrowable)
  {
    f("1", Log.getStackTraceString(paramThrowable));
  }
  
  public final void f(String paramString1, String paramString2)
  {
    paramString1 = k(paramString1);
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    if (new File(paramString1).exists()) {
      return;
    }
    new Cumquat(this, paramString1, paramString2).start();
  }
  
  public final String k(String paramString)
  {
    try
    {
      Object localObject = Environment.getExternalStorageDirectory().getAbsolutePath();
      localObject = new File(do.a(do.b((String)localObject), File.separator, ".turingdebug"));
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((File)localObject).getAbsolutePath());
      return do.a(localStringBuilder, File.separator, paramString);
    }
    catch (Throwable paramString)
    {
      label65:
      break label65;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Damson
 * JD-Core Version:    0.7.0.1
 */