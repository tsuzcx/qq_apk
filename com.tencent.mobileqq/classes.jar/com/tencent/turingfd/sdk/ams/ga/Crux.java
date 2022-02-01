package com.tencent.turingfd.sdk.ams.ga;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;

public class Crux
{
  public static final float<Crux> rd = new Chamaeleon();
  
  public static Crux getInstance()
  {
    return (Crux)rd.get();
  }
  
  public void a(Throwable paramThrowable)
  {
    f("2", Log.getStackTraceString(paramThrowable));
  }
  
  public final void f(String paramString1, String paramString2)
  {
    paramString1 = i(paramString1);
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    if (new File(paramString1).exists()) {
      return;
    }
    new ComaBerenices(this, paramString1, paramString2).start();
  }
  
  public final String i(String paramString)
  {
    try
    {
      Object localObject = Environment.getExternalStorageDirectory().getAbsolutePath();
      localObject = do.b((String)localObject);
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append(".turingdebug");
      localObject = new File(((StringBuilder)localObject).toString());
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((File)localObject).getAbsolutePath());
      localStringBuilder.append(File.separator);
      localStringBuilder.append(paramString);
      return localStringBuilder.toString();
    }
    catch (Throwable paramString)
    {
      label87:
      break label87;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.ams.ga.Crux
 * JD-Core Version:    0.7.0.1
 */