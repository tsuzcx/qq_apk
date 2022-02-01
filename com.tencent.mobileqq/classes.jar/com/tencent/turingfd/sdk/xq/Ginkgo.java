package com.tencent.turingfd.sdk.xq;

import android.os.Environment;
import android.text.TextUtils;
import java.io.File;

public class Ginkgo
{
  public static final public<Ginkgo> a = new Ginkgo.do();
  
  public static Ginkgo a()
  {
    return (Ginkgo)a.b();
  }
  
  public final String a(String paramString)
  {
    try
    {
      String str = Environment.getExternalStorageDirectory().getAbsolutePath();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      str = File.separator;
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(".turingdebug");
      localObject = new File(((StringBuilder)localObject).toString());
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((File)localObject).getAbsolutePath());
      localStringBuilder.append(str);
      localStringBuilder.append(paramString);
      return localStringBuilder.toString();
    }
    finally
    {
      label101:
      break label101;
    }
    return "";
  }
  
  public final void a(String paramString1, String paramString2)
  {
    paramString1 = a(paramString1);
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    if (new File(paramString1).exists()) {
      return;
    }
    new Ginkgo.if(this, paramString1, paramString2).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Ginkgo
 * JD-Core Version:    0.7.0.1
 */