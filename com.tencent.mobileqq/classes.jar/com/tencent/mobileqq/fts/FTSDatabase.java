package com.tencent.mobileqq.fts;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.fts.v2.FTSQueryArgsV2;
import com.tencent.mobileqq.fts.v2.entity.FTSEntityV2;
import com.tencent.mobileqq.fts.v2.logger.ILogger;
import com.tencent.mobileqq.fts.v2.logger.Logger;
import com.tencent.mobileqq.fts.v2.utils.FTSUtils;
import com.tencent.mobileqq.fts.v2.utils.FileUtils;
import com.tencent.mobileqq.fts.v2.utils.SQLUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FTSDatabase
{
  private static ILogger a = new Logger();
  private boolean b = false;
  private boolean c = true;
  
  public FTSDatabase()
  {
    if (!this.c) {
      log("Q.fts.troop.FTSDatabase", "w", "load so failed.");
    }
  }
  
  public static ILogger a()
  {
    return a;
  }
  
  public static void a(ILogger paramILogger)
  {
    a = paramILogger;
  }
  
  private synchronized native void closeNative();
  
  private synchronized native boolean execSQLNative(String paramString);
  
  private void g()
  {
    if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
      return;
    }
    throw new RuntimeException("Cannot operate database on UI Thread.");
  }
  
  private synchronized native String getErrorMsg();
  
  private synchronized native boolean initNative(String paramString, boolean paramBoolean);
  
  private synchronized native boolean insertNative(String paramString, int[] paramArrayOfInt, byte[]... paramVarArgs);
  
  public static void log(String paramString1, String paramString2, String paramString3)
  {
    a().a(paramString1, paramString2, paramString3);
  }
  
  private synchronized native int mergeCommand(String paramString, int paramInt1, int paramInt2);
  
  private synchronized native int queryIndexCount(String paramString);
  
  private synchronized native Object queryNative(String paramString, int[] paramArrayOfInt);
  
  private synchronized native boolean updateNative(String paramString, int[] paramArrayOfInt, byte[]... paramVarArgs);
  
  public int a(String paramString, int paramInt1, int paramInt2)
  {
    if (!f()) {
      return -1;
    }
    if (!c())
    {
      QLog.d("Q.fts.troop.FTSDatabase", 1, "mergeCommand begin transaction failed");
      return -1;
    }
    int i = mergeCommand(paramString, paramInt1, paramInt2);
    if (!d())
    {
      QLog.d("Q.fts.troop.FTSDatabase", 1, "mergeCommand commit transaction failed");
      return -1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.fts.troop.FTSDatabase", 2, new Object[] { "mergeCommand ", paramString, " x=", Integer.valueOf(paramInt1), " y=", Integer.valueOf(paramInt2), " ret:", Integer.valueOf(i) });
    }
    return i;
  }
  
  public List<FTSEntityV2> a(FTSQueryArgsV2 paramFTSQueryArgsV2)
  {
    g();
    if (!f())
    {
      log("Q.fts.troop.FTSDatabase", "w", "query failed. FTSDatabase is not available");
      return null;
    }
    Object localObject1 = new ArrayList();
    Object localObject2 = SQLUtils.a(paramFTSQueryArgsV2, (List)localObject1);
    Object localObject3 = new int[((List)localObject1).size()];
    int i = 0;
    while (i < ((List)localObject1).size())
    {
      localObject3[i] = ((Integer)((List)localObject1).get(i)).intValue();
      i += 1;
    }
    long l1 = System.currentTimeMillis();
    Iterator localIterator;
    try
    {
      localObject1 = (List)queryNative((String)localObject2, (int[])localObject3);
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
      localIterator = null;
    }
    long l2 = System.currentTimeMillis();
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("query cost time = ");
    ((StringBuilder)localObject3).append(l2 - l1);
    ((StringBuilder)localObject3).append(" ; sql = ");
    ((StringBuilder)localObject3).append((String)localObject2);
    log("Q.fts.troop.FTSDatabase", "d", ((StringBuilder)localObject3).toString());
    localObject2 = new ArrayList();
    if (localIterator != null)
    {
      localIterator = localIterator.iterator();
      while (localIterator.hasNext()) {
        ((List)localObject2).add(SQLUtils.a((Map)localIterator.next(), paramFTSQueryArgsV2.a));
      }
      return localObject2;
    }
    return null;
  }
  
  @Deprecated
  public List<Map> a(String paramString, int[] paramArrayOfInt)
  {
    g();
    if (!f())
    {
      log("Q.fts.troop.FTSDatabase", "w", "querySQL failed. FTSDatabase is not available");
      return null;
    }
    try
    {
      paramString = (List)queryNative(paramString, paramArrayOfInt);
      return paramString;
    }
    catch (UnsatisfiedLinkError paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public void a(String paramString)
  {
    g();
    if (this.b)
    {
      log("Q.fts.troop.FTSDatabase", "w", "already initialized.");
      return;
    }
    if (!this.c)
    {
      this.b = true;
      log("Q.fts.troop.FTSDatabase", "w", "init failed because so is not available.");
      return;
    }
    FileUtils.a(new File(paramString));
    boolean bool;
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(Thread.currentThread().getName());
      localStringBuilder.append(" native initNative V2");
      log("Q.fts.troop.FTSDatabase", "i", localStringBuilder.toString());
      bool = initNative(paramString, true);
    }
    catch (UnsatisfiedLinkError paramString)
    {
      paramString.printStackTrace();
      bool = false;
    }
    if (!bool)
    {
      this.c = false;
      this.b = true;
      log("Q.fts.troop.FTSDatabase", "w", "init failed because initNative failed.");
      return;
    }
    this.b = true;
    log("Q.fts.troop.FTSDatabase", "d", "initNative succeed.");
  }
  
  public boolean a(FTSEntityV2 paramFTSEntityV2)
  {
    g();
    boolean bool2 = f();
    boolean bool1 = false;
    if (!bool2)
    {
      log("Q.fts.troop.FTSDatabase", "w", "insert failed. FTSDatabase is not available");
      return false;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    paramFTSEntityV2 = SQLUtils.a(paramFTSEntityV2, localArrayList2, localArrayList1);
    int[] arrayOfInt = new int[localArrayList2.size()];
    int i = 0;
    while (i < localArrayList2.size())
    {
      arrayOfInt[i] = ((Integer)localArrayList2.get(i)).intValue();
      i += 1;
    }
    try
    {
      bool2 = insertNative(paramFTSEntityV2, arrayOfInt, (byte[][])localArrayList1.toArray(new byte[localArrayList1.size()][]));
      bool1 = bool2;
    }
    catch (UnsatisfiedLinkError paramFTSEntityV2)
    {
      paramFTSEntityV2.printStackTrace();
    }
    if (!bool1) {
      try
      {
        paramFTSEntityV2 = new StringBuilder();
        paramFTSEntityV2.append("insert failed. error msg = ");
        paramFTSEntityV2.append(getErrorMsg());
        log("Q.fts.troop.FTSDatabase", "w", paramFTSEntityV2.toString());
        return bool1;
      }
      catch (UnsatisfiedLinkError paramFTSEntityV2)
      {
        paramFTSEntityV2.printStackTrace();
      }
    }
    return bool1;
  }
  
  public boolean a(Class<? extends FTSEntityV2> paramClass)
  {
    g();
    if (!f())
    {
      log("Q.fts.troop.FTSDatabase", "w", "createTable failed. FTSDatabase is not available");
      return false;
    }
    boolean bool3 = true;
    boolean bool2 = true;
    boolean bool1 = true;
    String str3;
    String str2;
    for (;;)
    {
      str3 = SQLUtils.a(paramClass, FTSUtils.a(), bool3, bool2, bool1);
      boolean bool4;
      try
      {
        bool4 = execSQLNative(str3);
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
      {
        localUnsatisfiedLinkError1.printStackTrace();
        bool4 = false;
      }
      if (bool4) {
        break label378;
      }
      try
      {
        String str1 = getErrorMsg();
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
      {
        localUnsatisfiedLinkError2.printStackTrace();
        str2 = "";
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Can't create virtual table. ");
      localStringBuilder.append(str2);
      log("Q.fts.troop.FTSDatabase", "e", localStringBuilder.toString());
      if (!FTSUtils.a())
      {
        paramClass = new StringBuilder();
        paramClass.append("createTable failed.");
        paramClass.append(str2);
        log("Q.fts.troop.FTSDatabase", "e", paramClass.toString());
        return false;
      }
      if (TextUtils.isEmpty(str2))
      {
        log("Q.fts.troop.FTSDatabase", "e", "createTable failed. No error msg.");
        return false;
      }
      if ((str2.contains("unrecognized parameter: notindexed")) && (bool2))
      {
        bool2 = false;
      }
      else if ((str2.contains("unrecognized parameter: compress")) && (bool1))
      {
        bool1 = false;
      }
      else
      {
        if ((!str2.contains("near \"NOT\": syntax error")) || (!bool3)) {
          break;
        }
        bool3 = false;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("table ");
    localStringBuilder.append(paramClass.getSimpleName());
    localStringBuilder.append(" already exists");
    if (str2.contains(localStringBuilder.toString()))
    {
      paramClass = new StringBuilder();
      paramClass.append("createTable succeed. ");
      paramClass.append(str3);
      log("Q.fts.troop.FTSDatabase", "d", paramClass.toString());
      return true;
    }
    paramClass = new StringBuilder();
    paramClass.append("createTable failed. ");
    paramClass.append(str2);
    log("Q.fts.troop.FTSDatabase", "e", paramClass.toString());
    return false;
    label378:
    paramClass = new StringBuilder();
    paramClass.append("createTable succeed. ");
    paramClass.append(str3);
    log("Q.fts.troop.FTSDatabase", "d", paramClass.toString());
    return true;
  }
  
  protected boolean b()
  {
    try
    {
      System.loadLibrary("FTSDatabaseV2");
      return true;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      a().a("Q.fts.troop.FTSDatabase", "w", "load FTSDatabaseV2 failed.", localUnsatisfiedLinkError);
    }
    return false;
  }
  
  public boolean b(String paramString)
  {
    g();
    if (!f())
    {
      log("Q.fts.troop.FTSDatabase", "w", "execSQL failed. FTSDatabase is not available");
      return false;
    }
    try
    {
      boolean bool = execSQLNative(paramString);
      return bool;
    }
    catch (UnsatisfiedLinkError paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  public boolean c()
  {
    g();
    if (!f())
    {
      log("Q.fts.troop.FTSDatabase", "w", "beginTransaction failed. FTSDatabase is not available");
      return false;
    }
    boolean bool = b("BEGIN;");
    if (!bool)
    {
      log("Q.fts.troop.FTSDatabase", "e", "beginTransaction failed.");
      if (!b("ROLLBACK;")) {
        log("Q.fts.troop.FTSDatabase", "e", "beginTransaction ROLLBACK failed.");
      }
    }
    return bool;
  }
  
  public boolean d()
  {
    g();
    if (!f())
    {
      log("Q.fts.troop.FTSDatabase", "w", "commitTransaction failed. FTSDatabase is not available");
      return false;
    }
    boolean bool = b("COMMIT;");
    if (!bool)
    {
      log("Q.fts.troop.FTSDatabase", "e", "commitTransaction failed.");
      if (!b("ROLLBACK;")) {
        log("Q.fts.troop.FTSDatabase", "e", "commitTransaction ROLLBACK failed.");
      }
    }
    return bool;
  }
  
  public void e()
  {
    if (f())
    {
      this.b = false;
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(Thread.currentThread().getName());
        localStringBuilder.append(" native closeNative V2");
        log("Q.fts.troop.FTSDatabase", "i", localStringBuilder.toString());
        closeNative();
        return;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        localUnsatisfiedLinkError.printStackTrace();
      }
    }
  }
  
  public boolean f()
  {
    return (this.b) && (this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fts.FTSDatabase
 * JD-Core Version:    0.7.0.1
 */