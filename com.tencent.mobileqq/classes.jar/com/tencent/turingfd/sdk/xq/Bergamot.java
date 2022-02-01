package com.tencent.turingfd.sdk.xq;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;

public class Bergamot
{
  public static final float<Bergamot> zg = new Banana();
  
  public static Bergamot getInstance()
  {
    return (Bergamot)zg.get();
  }
  
  public void a(Throwable paramThrowable)
  {
    f("2", Log.getStackTraceString(paramThrowable));
  }
  
  public final void f(String paramString1, String paramString2)
  {
    paramString1 = o(paramString1);
    if (TextUtils.isEmpty(paramString1)) {}
    while (new File(paramString1).exists()) {
      return;
    }
    new Bennet(this, paramString1, paramString2).start();
  }
  
  public final String o(String paramString)
  {
    try
    {
      Object localObject = Environment.getExternalStorageDirectory().getAbsolutePath();
      localObject = new File(File.separator + ".turingdebug");
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      return ((File)localObject).getAbsolutePath() + File.separator + paramString;
    }
    catch (Throwable paramString) {}
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Bergamot
 * JD-Core Version:    0.7.0.1
 */