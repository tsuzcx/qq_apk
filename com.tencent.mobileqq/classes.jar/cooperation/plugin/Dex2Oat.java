package cooperation.plugin;

import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import bdmb;
import bimc;
import bimd;
import bime;
import bina;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Dex2Oat
{
  private static final boolean a = b(System.getProperty("java.vm.version"));
  
  public static String a()
  {
    String str2 = (String)bdmb.a("dalvik.system.VMRuntime", "getCurrentInstructionSet");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "arm";
    }
    return str1;
  }
  
  public static String a(File paramFile1, File paramFile2)
  {
    String str = paramFile1.getName();
    paramFile1 = str;
    int i;
    if (!str.endsWith(".dex"))
    {
      i = str.lastIndexOf(".");
      if (i >= 0) {
        break label60;
      }
    }
    for (paramFile1 = str + ".dex";; paramFile1 = paramFile1.toString())
    {
      return new File(paramFile2, paramFile1).getPath();
      label60:
      paramFile1 = new StringBuilder(i + 4);
      paramFile1.append(str, 0, i);
      paramFile1.append(".dex");
    }
  }
  
  public static boolean a()
  {
    return (a) || (Build.VERSION.SDK_INT >= 21);
  }
  
  public static final boolean a(File paramFile)
  {
    return (paramFile != null) && (paramFile.exists()) && (paramFile.canRead()) && (paramFile.isFile()) && (paramFile.length() > 0L);
  }
  
  public static boolean a(String paramString)
  {
    String str = bina.a();
    if ((paramString == null) || (paramString.equals("")) || (str == null) || (str.equals("")))
    {
      Log.d("plugin_tag.Dex2Oat", "fingerprint empty:" + paramString + ",current:" + str);
      return false;
    }
    if (paramString.equals(str))
    {
      Log.d("plugin_tag.Dex2Oat", "same fingerprint:" + str);
      return false;
    }
    Log.d("plugin_tag.Dex2Oat", "system OTA,fingerprint not equal:" + paramString + "," + str);
    return true;
  }
  
  public static boolean a(Collection<File> paramCollection, File paramFile, boolean paramBoolean, String paramString, bime parambime)
  {
    return a(paramCollection, paramFile, paramBoolean, paramString, new AtomicInteger(0), parambime, 2);
  }
  
  private static boolean a(Collection<File> paramCollection, File paramFile, boolean paramBoolean, String paramString, AtomicInteger paramAtomicInteger, bime parambime, int paramInt)
  {
    try
    {
      CountDownLatch localCountDownLatch = new CountDownLatch(paramCollection.size());
      ExecutorService localExecutorService = Executors.newFixedThreadPool(paramInt, new bimc());
      long l = System.nanoTime();
      Object localObject = new ArrayList(paramCollection);
      Collections.sort((List)localObject, new bimd());
      Collections.reverse((List)localObject);
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localExecutorService.submit(new Dex2Oat.OptimizeWorker((File)((Iterator)localObject).next(), paramFile, paramBoolean, paramString, paramAtomicInteger, localCountDownLatch, parambime));
      }
      try
      {
        localCountDownLatch.await();
        l = (System.nanoTime() - l) / 1000000L;
        if (paramAtomicInteger.get() == paramCollection.size())
        {
          Log.i("plugin_tag.Dex2Oat", "All dexes are optimized successfully, cost: " + l + " ms.");
          paramBoolean = true;
        }
      }
      catch (InterruptedException paramCollection)
      {
        for (;;)
        {
          Log.w("plugin_tag.Dex2Oat", "Dex optimizing was interrupted.", paramCollection);
          paramBoolean = false;
          localExecutorService.shutdown();
        }
      }
      finally
      {
        localExecutorService.shutdown();
      }
    }
    finally {}
    for (;;)
    {
      return paramBoolean;
      Log.e("plugin_tag.Dex2Oat", "Dexes optimizing failed, some dexes are not optimized.");
      paramBoolean = false;
      localExecutorService.shutdown();
    }
  }
  
  private static boolean b(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      paramString = Pattern.compile("(\\d+)\\.(\\d+)(\\.\\d+)?").matcher(paramString);
      bool1 = bool2;
      if (!paramString.matches()) {}
    }
    try
    {
      int i = Integer.parseInt(paramString.group(1));
      int j = Integer.parseInt(paramString.group(2));
      if (i <= 2)
      {
        bool1 = bool2;
        if (i == 2)
        {
          bool1 = bool2;
          if (j < 1) {}
        }
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }
    catch (NumberFormatException paramString) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.plugin.Dex2Oat
 * JD-Core Version:    0.7.0.1
 */