package com.tencent.rlottie;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.rlottie.decoder.AXrFileReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class AXrLottieCacheManager
{
  public static long a;
  private Context b;
  private File c;
  private File d;
  private Set<String> e = new HashSet();
  private AXrLottieCacheManager.CacheListener f;
  
  public AXrLottieCacheManager(Context paramContext)
  {
    this.b = paramContext.getApplicationContext();
    this.c = new File(paramContext.getCacheDir(), "lottie");
    this.d = new File(this.c, "aCache");
    if (!this.d.exists()) {
      this.d.mkdirs();
    }
  }
  
  private String c(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString.replaceAll("\\W+", ""));
    localStringBuilder.append(".json");
    return localStringBuilder.toString();
  }
  
  private void e()
  {
    AXrLottieNative.configureModelCacheSize(0);
    AXrLottieNative.configureModelCacheSize(10);
  }
  
  public File a(String paramString1, String paramString2)
  {
    paramString2 = new File(b(), c(paramString2));
    if (paramString2.exists()) {
      return paramString2;
    }
    try
    {
      OutputStreamWriter localOutputStreamWriter = new OutputStreamWriter(new FileOutputStream(paramString2));
      localOutputStreamWriter.write(paramString1);
      localOutputStreamWriter.close();
      return paramString2;
    }
    catch (IOException paramString1)
    {
      if (paramString2.exists()) {
        paramString2.delete();
      }
      paramString1.printStackTrace();
    }
    return null;
  }
  
  public String a(File paramFile)
  {
    String str1 = this.d.getAbsolutePath();
    Object localObject = paramFile.getAbsolutePath();
    if (((String)localObject).startsWith(str1)) {
      return localObject;
    }
    if (!this.e.isEmpty())
    {
      Iterator localIterator = this.e.iterator();
      while (localIterator.hasNext())
      {
        str2 = (String)localIterator.next();
        if (((String)localObject).contains(str2))
        {
          int i = ((String)localObject).indexOf(str2);
          if (str2.length() + i + 1 < ((String)localObject).length())
          {
            paramFile = ((String)localObject).substring(i + str2.length() + 1).replace('\\', '-').replace('/', '-');
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(str1);
            ((StringBuilder)localObject).append(File.separator);
            ((StringBuilder)localObject).append(str2);
            ((StringBuilder)localObject).append(File.separator);
            ((StringBuilder)localObject).append(paramFile);
            return ((StringBuilder)localObject).toString();
          }
        }
      }
    }
    String str2 = AXrFileReader.a(paramFile);
    if (!TextUtils.isEmpty(str2))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str1);
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append(paramFile.getName());
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(str2);
      return ((StringBuilder)localObject).toString();
    }
    return "";
  }
  
  public void a(AXrLottieCacheManager.CacheListener paramCacheListener)
  {
    this.f = paramCacheListener;
  }
  
  public boolean a()
  {
    boolean bool = AXrFileReader.a(this.c.getAbsolutePath());
    e();
    if (!this.d.exists()) {
      this.d.mkdirs();
    }
    return bool;
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = this.d;
    } else {
      paramString = new File(this.d, paramString);
    }
    boolean bool = AXrFileReader.a(paramString.getAbsolutePath());
    e();
    if (!this.d.exists()) {
      this.d.mkdirs();
    }
    return bool;
  }
  
  public File b()
  {
    File localFile = this.c;
    if (localFile.isFile()) {
      localFile.delete();
    }
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile;
  }
  
  public void b(String paramString)
  {
    this.e.add(paramString);
  }
  
  public boolean c()
  {
    if (a == 0L) {
      a = this.b.getSharedPreferences("rlottie_cache", 0).getLong("lastCheckTime", 0L);
    }
    long l = System.currentTimeMillis() / 1000L;
    boolean bool;
    if (Math.abs(l - a) < 14400L) {
      bool = true;
    } else {
      bool = false;
    }
    if (!bool)
    {
      a = l;
      this.b.getSharedPreferences("rlottie_cache", 0).edit().putLong("lastCheckTime", a).apply();
    }
    return bool;
  }
  
  public void d()
  {
    try
    {
      String str = this.d.getAbsolutePath();
      long l1 = AXrLottieNative.getDirSize(str, true);
      if (l1 > 157286400L)
      {
        long l2 = System.currentTimeMillis() / 1000L;
        AXrLottieNative.clearDir(str, l2 - 172800L, true);
        e();
        SharedPreferences localSharedPreferences = this.b.getSharedPreferences("rlottie_cache", 0);
        long l3 = localSharedPreferences.getLong("lastClearTime", 0L);
        if ((l3 > 0L) && (this.f != null))
        {
          long l4 = AXrLottieNative.getFileCount(str, true);
          this.f.onClearCache(l2 - l3, l1, l4);
        }
        localSharedPreferences.edit().putLong("lastClearTime", l2).apply();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rlottie.AXrLottieCacheManager
 * JD-Core Version:    0.7.0.1
 */