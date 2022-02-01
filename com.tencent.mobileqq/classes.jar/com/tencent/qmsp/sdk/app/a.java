package com.tencent.qmsp.sdk.app;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.qmsp.sdk.c.i;
import com.tencent.qmsp.sdk.f.k;
import java.util.concurrent.atomic.AtomicInteger;

abstract class a
{
  private static byte[] LOGTag = { 20, 96, -3, 98, 31, 8 };
  private static byte[] Txt1 = { 23, 117, -93, 69, 47, 47, 114, -7, 101, 121, -67, 73, 58, 122 };
  private static volatile AtomicInteger atomCbTimeout = new AtomicInteger(i.a);
  private static volatile AtomicInteger atomConnTimeOut = new AtomicInteger(i.b);
  private static volatile AtomicInteger atomReadTimeOut = new AtomicInteger(i.c);
  private static volatile AtomicInteger atomUpdateInterval = new AtomicInteger(i.d);
  private static boolean isLogin = false;
  private static boolean isTaskRuning = false;
  private static String mAppID;
  private static Context mContext;
  private static String mDevID;
  private static String mQImeiVer;
  private static String mUid;
  
  private static int checkParam(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((paramContext != null) && (paramString1 != null) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)) && (!TextUtils.isEmpty(paramString4))) {
      return 0;
    }
    com.tencent.qmsp.sdk.f.g.a(k.a(LOGTag), 0, k.a(k.a));
    return -1;
  }
  
  public static String getAppID()
  {
    return mAppID;
  }
  
  public static AtomicInteger getAtomCbTimeout()
  {
    return atomCbTimeout;
  }
  
  public static AtomicInteger getAtomConnTimeOut()
  {
    return atomConnTimeOut;
  }
  
  public static AtomicInteger getAtomReadTimeOut()
  {
    return atomReadTimeOut;
  }
  
  public static AtomicInteger getAtomUpdateInterval()
  {
    return atomUpdateInterval;
  }
  
  public static Context getContext()
  {
    return mContext;
  }
  
  public static String getDevId()
  {
    return mDevID;
  }
  
  public static String getQImeiVer()
  {
    return mQImeiVer;
  }
  
  public static boolean getTaskStatus()
  {
    return isTaskRuning & isLogin;
  }
  
  public static String getUid()
  {
    return mUid;
  }
  
  private static void init(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    mContext = paramContext;
    mUid = paramString1;
    mDevID = paramString2;
    mAppID = paramString3;
    mQImeiVer = paramString4;
  }
  
  protected static int login(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      if (checkParam(paramContext, paramString1, paramString2, paramString3, paramString4) != 0) {
        return 1;
      }
      if (isLogin)
      {
        com.tencent.qmsp.sdk.f.g.d(k.a(LOGTag), 0, k.a(Txt1));
        return 2;
      }
      setTaskStatus(true);
      init(paramContext, paramString1, paramString2, paramString3, paramString4);
      com.tencent.qmsp.sdk.b.g.b().a();
      com.tencent.qmsp.sdk.c.f.i().f();
      com.tencent.qmsp.sdk.a.a.a(2, 4);
      return 0;
    }
    catch (Exception paramContext)
    {
      com.tencent.qmsp.sdk.a.a.a(2, 5);
      logout();
      paramContext.printStackTrace();
    }
    return 3;
  }
  
  protected static int login(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, com.tencent.qmsp.sdk.b.f paramf)
  {
    try
    {
      if (checkParam(paramContext, paramString1, paramString2, paramString3, paramString4) != 0) {
        return 1;
      }
      if (isLogin)
      {
        com.tencent.qmsp.sdk.f.g.d(k.a(LOGTag), 0, k.a(Txt1));
        return 2;
      }
      setTaskStatus(true);
      init(paramContext, paramString1, paramString2, paramString3, paramString4);
      com.tencent.qmsp.sdk.b.g.b().a(paramf);
      com.tencent.qmsp.sdk.c.f.i().f();
      com.tencent.qmsp.sdk.a.a.a(2, 4);
      return 0;
    }
    catch (Exception paramContext)
    {
      com.tencent.qmsp.sdk.a.a.a(2, 5);
      logout();
      paramContext.printStackTrace();
    }
    return 3;
  }
  
  protected static void logout()
  {
    try
    {
      setTaskStatus(false);
      b.e().d();
      com.tencent.qmsp.sdk.c.f.i().a();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private static void reset()
  {
    mContext = null;
    mUid = null;
    mDevID = null;
    mAppID = null;
    isLogin = false;
    mQImeiVer = null;
  }
  
  private static void setTaskStatus(boolean paramBoolean)
  {
    isTaskRuning = paramBoolean;
    isLogin = paramBoolean;
  }
  
  public static void setmUid(String paramString)
  {
    mUid = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qmsp.sdk.app.a
 * JD-Core Version:    0.7.0.1
 */