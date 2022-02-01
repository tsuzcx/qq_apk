package com.tencent.tmassistantbase.util;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class ab
{
  protected static ArrayList<WeakReference<m>> A;
  private static List<String> B = Collections.synchronizedList(new ArrayList());
  private static long C = 0L;
  private static Boolean D = Boolean.valueOf(true);
  private static ThreadLocal<char[]> E = new ac();
  protected static boolean a = false;
  protected static String b = "";
  protected static int c = 2;
  protected static int d = 4;
  protected static boolean e = true;
  protected static boolean f = false;
  protected static boolean g = false;
  protected static Context h;
  protected static boolean i = false;
  static LinkedBlockingQueue<String> j;
  protected static BufferedWriter k;
  static long l;
  static final ReentrantLock m;
  protected static int n;
  protected static String o;
  protected static String p;
  protected static long q;
  protected static SimpleDateFormat r;
  protected static AtomicBoolean s;
  protected static AtomicBoolean t;
  protected static final int[] u;
  protected static AtomicInteger v;
  protected static Handler w;
  protected static Runnable x = new ad();
  static Thread y = new af();
  protected static ReferenceQueue<m> z;
  
  static
  {
    C = 0L;
    l = 0L;
    m = new ReentrantLock();
    o = "";
    p = "";
    q = 0L;
    r = new SimpleDateFormat("yy-MM-dd HH:mm");
    s = new AtomicBoolean(false);
    t = new AtomicBoolean(false);
    u = new int[] { 1, 2, 4, 8, 16, 29 };
    v = new AtomicInteger(0);
    w = new Handler(Looper.getMainLooper());
  }
  
  public static void a(int paramInt)
  {
    c = paramInt;
  }
  
  private static void a(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    if ((paramInt < c()) && (paramInt < b())) {
      return;
    }
    if (paramInt >= b())
    {
      if ((paramInt == 2) && (a())) {
        if (paramThrowable == null) {
          Log.v(paramString1, paramString2);
        } else {
          Log.v(paramString1, paramString2, paramThrowable);
        }
      }
      if ((paramInt == 3) && (a())) {
        if (paramThrowable == null) {
          Log.d(paramString1, paramString2);
        } else {
          Log.d(paramString1, paramString2, paramThrowable);
        }
      }
      if (paramInt == 4) {
        if (paramThrowable == null) {
          Log.i(paramString1, paramString2);
        } else {
          Log.i(paramString1, paramString2, paramThrowable);
        }
      }
      if (paramInt == 5) {
        if (paramThrowable == null) {
          Log.w(paramString1, paramString2);
        } else {
          Log.w(paramString1, paramString2, paramThrowable);
        }
      }
      if (paramInt == 6)
      {
        if (paramThrowable == null)
        {
          Log.e(paramString1, paramString2);
          return;
        }
        Log.e(paramString1, paramString2, paramThrowable);
      }
    }
  }
  
  public static void a(Context paramContext)
  {
    try
    {
      if (!i)
      {
        h = paramContext;
        x.run();
        i = true;
      }
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("/")) && (paramString.endsWith("/"))) {
      b = paramString;
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    a(2, paramString1, paramString2, null);
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    a(4, paramString1, paramString2, paramThrowable);
  }
  
  public static void a(boolean paramBoolean)
  {
    e = paramBoolean;
  }
  
  public static boolean a()
  {
    return false;
  }
  
  public static boolean a(m paramm)
  {
    if (paramm == null) {
      return false;
    }
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("registerLogListener : ");
      ((StringBuilder)localObject).append(paramm);
      Log.d("TMLog", ((StringBuilder)localObject).toString());
      if (A == null) {
        A = new ArrayList();
      }
      if (z == null) {
        z = new ReferenceQueue();
      }
      localObject = z.poll();
      while (localObject != null) {
        A.remove(localObject);
      }
      localObject = A.iterator();
      while (((Iterator)localObject).hasNext())
      {
        m localm = (m)((WeakReference)((Iterator)localObject).next()).get();
        if (localm == paramm) {
          return true;
        }
      }
      paramm = new WeakReference(paramm, z);
      A.add(paramm);
      return true;
    }
    finally {}
    for (;;)
    {
      throw paramm;
    }
  }
  
  public static int b()
  {
    return c;
  }
  
  public static void b(int paramInt)
  {
    d = paramInt;
  }
  
  public static void b(String paramString1, String paramString2)
  {
    a(3, paramString1, paramString2, null);
  }
  
  public static void b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    a(5, paramString1, paramString2, paramThrowable);
  }
  
  public static void b(boolean paramBoolean)
  {
    g = paramBoolean;
  }
  
  public static boolean b(m paramm)
  {
    if (paramm == null) {
      return false;
    }
    try
    {
      Iterator localIterator = A.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        int i1;
        if ((m)localWeakReference.get() == paramm)
        {
          A.remove(localWeakReference);
          i1 = 1;
        }
        else
        {
          i1 = 0;
        }
        if (i1 != 0) {
          return true;
        }
      }
      return false;
    }
    finally {}
    for (;;)
    {
      throw paramm;
    }
  }
  
  public static int c()
  {
    return d;
  }
  
  public static void c(String paramString1, String paramString2)
  {
    a(4, paramString1, paramString2, null);
  }
  
  public static void c(String paramString1, String paramString2, Throwable paramThrowable)
  {
    a(6, paramString1, paramString2, paramThrowable);
  }
  
  public static void c(boolean paramBoolean)
  {
    a = paramBoolean;
  }
  
  private static boolean c(String paramString)
  {
    try
    {
      j.add(paramString);
      return true;
    }
    catch (Exception paramString)
    {
      label10:
      break label10;
    }
    return false;
  }
  
  private static void d(String paramString)
  {
    if (!g()) {
      return;
    }
    if (k == null)
    {
      Log.d("TMLog", "can not write log.");
      long l1 = System.currentTimeMillis();
      long l2 = l;
      if (l2 == 0L)
      {
        l = l1;
      }
      else if (l1 - l2 > 60000L)
      {
        try
        {
          l();
        }
        catch (IOException paramString)
        {
          paramString.printStackTrace();
        }
        l = l1;
      }
    }
    else
    {
      if (m.tryLock()) {}
      try
      {
        k.write(paramString);
        if (!d()) {
          k.flush();
        }
        m.unlock();
      }
      finally
      {
        m.unlock();
      }
      Log.d("TMLog", "addLogToCache failed!");
    }
    s.compareAndSet(true, false);
  }
  
  public static void d(String paramString1, String paramString2)
  {
    a(5, paramString1, paramString2, null);
  }
  
  public static boolean d()
  {
    return e;
  }
  
  public static void e(String paramString1, String paramString2)
  {
    a(6, paramString1, paramString2, null);
  }
  
  public static boolean e()
  {
    return f;
  }
  
  public static boolean f()
  {
    return g;
  }
  
  public static boolean g()
  {
    return a;
  }
  
  public static String h()
  {
    if (TextUtils.isEmpty(b))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(Environment.getExternalStorageDirectory().getPath());
      localStringBuilder.append("/tencent/TMAssistantSDK/Logs/");
      b = localStringBuilder.toString();
    }
    return b;
  }
  
  public static String i()
  {
    try
    {
      long l1 = System.currentTimeMillis();
      if (l1 - q > 60000L)
      {
        q = l1;
        p = r.format(Long.valueOf(q));
      }
      String str = p;
      return str;
    }
    finally {}
  }
  
  private static void l()
  {
    try
    {
      Log.d("TMLog", "start to init log file!");
      Object localObject1 = new File(h());
      if (!((File)localObject1).exists()) {
        ((File)localObject1).mkdirs();
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(h());
      ((StringBuilder)localObject1).append(o);
      ((StringBuilder)localObject1).append("_tmlog.txt");
      localObject1 = new File(((StringBuilder)localObject1).toString());
      try
      {
        Object localObject3;
        StringBuilder localStringBuilder;
        if (!((File)localObject1).exists())
        {
          boolean bool = ((File)localObject1).createNewFile();
          m();
          if ((k != null) && (g()))
          {
            localObject3 = k;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(i());
            localStringBuilder.append("|");
            localStringBuilder.append(o);
            localStringBuilder.append("|");
            localStringBuilder.append(Build.MODEL);
            localStringBuilder.append(" ");
            localStringBuilder.append(Build.VERSION.RELEASE);
            localStringBuilder.append(" create newLogFile ");
            localStringBuilder.append(((File)localObject1).getName());
            localStringBuilder.append(" ");
            localStringBuilder.append(bool);
            localStringBuilder.append("\n");
            ((BufferedWriter)localObject3).write(localStringBuilder.toString());
            k.flush();
          }
        }
        else
        {
          if (((File)localObject1).length() >= 512000L)
          {
            ((File)localObject1).delete();
            ((File)localObject1).createNewFile();
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("old log file ");
            ((StringBuilder)localObject3).append(((File)localObject1).getName());
            ((StringBuilder)localObject3).append(" is deleted");
            Log.d("TMLog", ((StringBuilder)localObject3).toString());
          }
          m();
          if ((k != null) && (g()))
          {
            localObject3 = k;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(i());
            localStringBuilder.append("|");
            localStringBuilder.append(o);
            localStringBuilder.append("|");
            localStringBuilder.append(Build.MODEL);
            localStringBuilder.append(" ");
            localStringBuilder.append(Build.VERSION.RELEASE);
            localStringBuilder.append("|newLogFile ");
            localStringBuilder.append(((File)localObject1).getName());
            localStringBuilder.append(" is existed.\n");
            ((BufferedWriter)localObject3).write(localStringBuilder.toString());
            k.flush();
          }
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
      k = new BufferedWriter(new FileWriter((File)localObject1, true), 8192);
      m();
      return;
    }
    finally {}
  }
  
  private static void m()
  {
    if ((k != null) && (g()))
    {
      k.write("SDK_VERSION = 1.3|BUILD_NO = {BuildNo}|RELEASE_DATE: {ReleaseDate}\r\n");
      k.flush();
    }
  }
  
  private static void n()
  {
    if ("mounted".equals(Environment.getExternalStorageState()))
    {
      Object localObject1 = new Properties();
      try
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(Environment.getExternalStorageDirectory().getPath());
        ((StringBuilder)localObject2).append("/tencent/TMAssistantSDK/Logs/logConfig.properties");
        localObject2 = new File(((StringBuilder)localObject2).toString());
        if (!((File)localObject2).exists()) {
          return;
        }
        ((Properties)localObject1).load(new FileInputStream((File)localObject2));
        localObject2 = ((Properties)localObject1).getProperty("isWriteLogToFile", "");
        if (((String)localObject2).trim().equals("true")) {
          c(true);
        } else {
          c(false);
        }
        String str1 = ((Properties)localObject1).getProperty("logfileOutputLevel", "");
        boolean bool = TextUtils.isEmpty(str1);
        if (!bool) {
          try
          {
            b(Integer.valueOf(str1).intValue());
          }
          catch (NumberFormatException localNumberFormatException1)
          {
            localNumberFormatException1.printStackTrace();
          }
        }
        String str2 = ((Properties)localObject1).getProperty("logcatOutputLevel", "");
        bool = TextUtils.isEmpty(str2);
        if (!bool) {
          try
          {
            a(Integer.valueOf(str2).intValue());
          }
          catch (NumberFormatException localNumberFormatException2)
          {
            localNumberFormatException2.printStackTrace();
          }
        }
        String str3 = ((Properties)localObject1).getProperty("logDirPath", "");
        a(str3);
        String str4 = ((Properties)localObject1).getProperty("isUseWriterCache", "");
        if (str4.trim().equals("false")) {
          a(false);
        } else {
          a(true);
        }
        if (((Properties)localObject1).getProperty("isAppendLogTime", "").trim().equals("true")) {
          b(true);
        } else {
          b(false);
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Properties Local File : isWriteLogToFile = ");
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(", fileLevel = ");
        ((StringBuilder)localObject1).append(str1);
        ((StringBuilder)localObject1).append(", logcatLevel = ");
        ((StringBuilder)localObject1).append(str2);
        ((StringBuilder)localObject1).append(", dirPath = ");
        ((StringBuilder)localObject1).append(str3);
        ((StringBuilder)localObject1).append(", isUseCache = ");
        ((StringBuilder)localObject1).append(str4);
        ((StringBuilder)localObject1).append(", isAppendMethodName = ");
        ((StringBuilder)localObject1).append(e());
        ((StringBuilder)localObject1).append(", isAppendLogTime = ");
        ((StringBuilder)localObject1).append(f());
        Log.d("TMLog", ((StringBuilder)localObject1).toString());
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Log Configs : isWriteLogToFile = ");
        ((StringBuilder)localObject1).append(g());
        ((StringBuilder)localObject1).append(", fileLevel = ");
        ((StringBuilder)localObject1).append(c());
        ((StringBuilder)localObject1).append(", logcatLevel = ");
        ((StringBuilder)localObject1).append(b());
        ((StringBuilder)localObject1).append(", dirPath = ");
        ((StringBuilder)localObject1).append(h());
        ((StringBuilder)localObject1).append(", isUseCache = ");
        ((StringBuilder)localObject1).append(d());
        ((StringBuilder)localObject1).append(", isAppendMethodName = ");
        ((StringBuilder)localObject1).append(e());
        ((StringBuilder)localObject1).append(", isAppendLogTime = ");
        ((StringBuilder)localObject1).append(f());
        Log.d("TMLog", ((StringBuilder)localObject1).toString());
        return;
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
        return;
      }
    }
    c(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmassistantbase.util.ab
 * JD-Core Version:    0.7.0.1
 */