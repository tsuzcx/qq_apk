package com.tencent.qqlive.mediaplayer.sdkupdate;

import android.content.Context;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;

public class a
{
  private static a a = null;
  private static boolean f = false;
  private boolean b = false;
  private Thread c;
  private Context d = null;
  private b e = null;
  
  public static a a(Context paramContext)
  {
    try
    {
      if (a == null)
      {
        a = new a();
        f = a.b(paramContext);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  private boolean b(Context paramContext)
  {
    this.d = paramContext;
    this.e = new b(this.d);
    return this.e.a();
  }
  
  public void a()
  {
    a(false);
  }
  
  public void a(TVK_SDKMgr.InstallListener paramInstallListener)
  {
    this.e.a(paramInstallListener);
  }
  
  public void a(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        boolean bool = this.b;
        if (bool) {
          return;
        }
        if (!f) {
          this.e.f();
        }
        if ((paramBoolean) && (!d.a(this.d)))
        {
          d.a(3, "", "MediaPlayerMgr", "start no wifi, cancel");
          this.e.f();
          continue;
        }
        this.c = new Thread(new Runnable()
        {
          public void run()
          {
            try
            {
              SDKLocalConfig localSDKLocalConfig = a.a(a.this).a(false);
              if (localSDKLocalConfig == null) {
                return;
              }
              a.a(a.this).a(localSDKLocalConfig, false);
              return;
            }
            catch (Exception localException)
            {
              d.a(5, "", "MediaPlayerMgr", "startWithForceAndSilent, exception: " + localException.toString());
              localException.printStackTrace();
              return;
            }
            finally
            {
              a.a(a.this).f();
              a.a(a.this, false);
            }
          }
        });
      }
      finally {}
      if (this.c != null)
      {
        this.b = true;
        this.c.setName("TencentVideoKit");
        this.c.start();
      }
    }
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 31	com/tencent/qqlive/mediaplayer/sdkupdate/a:b	Z
    //   6: ifne +11 -> 17
    //   9: getstatic 25	com/tencent/qqlive/mediaplayer/sdkupdate/a:f	Z
    //   12: istore_1
    //   13: iload_1
    //   14: ifne +6 -> 20
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: aload_0
    //   21: new 74	java/lang/Thread
    //   24: dup
    //   25: new 8	com/tencent/qqlive/mediaplayer/sdkupdate/a$2
    //   28: dup
    //   29: aload_0
    //   30: invokespecial 92	com/tencent/qqlive/mediaplayer/sdkupdate/a$2:<init>	(Lcom/tencent/qqlive/mediaplayer/sdkupdate/a;)V
    //   33: invokespecial 80	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   36: putfield 82	com/tencent/qqlive/mediaplayer/sdkupdate/a:c	Ljava/lang/Thread;
    //   39: aload_0
    //   40: getfield 82	com/tencent/qqlive/mediaplayer/sdkupdate/a:c	Ljava/lang/Thread;
    //   43: ifnull -26 -> 17
    //   46: aload_0
    //   47: iconst_1
    //   48: putfield 31	com/tencent/qqlive/mediaplayer/sdkupdate/a:b	Z
    //   51: aload_0
    //   52: getfield 82	com/tencent/qqlive/mediaplayer/sdkupdate/a:c	Ljava/lang/Thread;
    //   55: ldc 94
    //   57: invokevirtual 88	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   60: aload_0
    //   61: getfield 82	com/tencent/qqlive/mediaplayer/sdkupdate/a:c	Ljava/lang/Thread;
    //   64: invokevirtual 91	java/lang/Thread:start	()V
    //   67: goto -50 -> 17
    //   70: astore_2
    //   71: aload_0
    //   72: monitorexit
    //   73: aload_2
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	a
    //   12	2	1	bool	boolean
    //   70	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	13	70	finally
    //   20	67	70	finally
  }
  
  public boolean c()
  {
    if (f) {
      return this.e.c();
    }
    return false;
  }
  
  public String d()
  {
    if (f) {
      return this.e.g();
    }
    return null;
  }
  
  public String e()
  {
    d.a(3, "", "MediaPlayerMgr", "getLibs, is init: " + f);
    if (f) {
      return this.e.h();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.qqlive.mediaplayer.sdkupdate.a
 * JD-Core Version:    0.7.0.1
 */