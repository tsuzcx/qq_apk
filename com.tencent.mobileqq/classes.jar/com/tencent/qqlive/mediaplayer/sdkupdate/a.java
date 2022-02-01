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
  
  /* Error */
  public static a a(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 19	com/tencent/qqlive/mediaplayer/sdkupdate/a:a	Lcom/tencent/qqlive/mediaplayer/sdkupdate/a;
    //   6: ifnonnull +63 -> 69
    //   9: new 2	com/tencent/qqlive/mediaplayer/sdkupdate/a
    //   12: dup
    //   13: invokespecial 33	com/tencent/qqlive/mediaplayer/sdkupdate/a:<init>	()V
    //   16: putstatic 19	com/tencent/qqlive/mediaplayer/sdkupdate/a:a	Lcom/tencent/qqlive/mediaplayer/sdkupdate/a;
    //   19: getstatic 19	com/tencent/qqlive/mediaplayer/sdkupdate/a:a	Lcom/tencent/qqlive/mediaplayer/sdkupdate/a;
    //   22: astore_2
    //   23: aload_2
    //   24: aload_0
    //   25: putfield 29	com/tencent/qqlive/mediaplayer/sdkupdate/a:d	Landroid/content/Context;
    //   28: aload_2
    //   29: new 35	com/tencent/qqlive/mediaplayer/sdkupdate/b
    //   32: dup
    //   33: aload_2
    //   34: getfield 29	com/tencent/qqlive/mediaplayer/sdkupdate/a:d	Landroid/content/Context;
    //   37: invokespecial 38	com/tencent/qqlive/mediaplayer/sdkupdate/b:<init>	(Landroid/content/Context;)V
    //   40: putfield 31	com/tencent/qqlive/mediaplayer/sdkupdate/a:e	Lcom/tencent/qqlive/mediaplayer/sdkupdate/b;
    //   43: aload_2
    //   44: getfield 31	com/tencent/qqlive/mediaplayer/sdkupdate/a:e	Lcom/tencent/qqlive/mediaplayer/sdkupdate/b;
    //   47: invokevirtual 41	com/tencent/qqlive/mediaplayer/sdkupdate/b:a	()Z
    //   50: ifeq +28 -> 78
    //   53: iconst_3
    //   54: ldc 43
    //   56: ldc 45
    //   58: ldc 47
    //   60: invokestatic 52	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   63: iconst_1
    //   64: istore_1
    //   65: iload_1
    //   66: putstatic 21	com/tencent/qqlive/mediaplayer/sdkupdate/a:f	Z
    //   69: getstatic 19	com/tencent/qqlive/mediaplayer/sdkupdate/a:a	Lcom/tencent/qqlive/mediaplayer/sdkupdate/a;
    //   72: astore_0
    //   73: ldc 2
    //   75: monitorexit
    //   76: aload_0
    //   77: areturn
    //   78: iconst_5
    //   79: ldc 43
    //   81: ldc 45
    //   83: ldc 54
    //   85: invokestatic 52	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   88: iconst_0
    //   89: istore_1
    //   90: goto -25 -> 65
    //   93: astore_0
    //   94: ldc 2
    //   96: monitorexit
    //   97: aload_0
    //   98: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	paramContext	Context
    //   64	26	1	bool	boolean
    //   22	22	2	locala	a
    // Exception table:
    //   from	to	target	type
    //   3	63	93	finally
    //   65	69	93	finally
    //   69	73	93	finally
    //   78	88	93	finally
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 27	com/tencent/qqlive/mediaplayer/sdkupdate/a:b	Z
    //   6: ifne +11 -> 17
    //   9: getstatic 21	com/tencent/qqlive/mediaplayer/sdkupdate/a:f	Z
    //   12: istore_1
    //   13: iload_1
    //   14: ifne +6 -> 20
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: aload_0
    //   21: new 59	java/lang/Thread
    //   24: dup
    //   25: new 61	com/tencent/qqlive/mediaplayer/sdkupdate/a$2
    //   28: dup
    //   29: aload_0
    //   30: invokespecial 64	com/tencent/qqlive/mediaplayer/sdkupdate/a$2:<init>	(Lcom/tencent/qqlive/mediaplayer/sdkupdate/a;)V
    //   33: invokespecial 67	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   36: putfield 69	com/tencent/qqlive/mediaplayer/sdkupdate/a:c	Ljava/lang/Thread;
    //   39: aload_0
    //   40: getfield 69	com/tencent/qqlive/mediaplayer/sdkupdate/a:c	Ljava/lang/Thread;
    //   43: ifnull +24 -> 67
    //   46: aload_0
    //   47: iconst_1
    //   48: putfield 27	com/tencent/qqlive/mediaplayer/sdkupdate/a:b	Z
    //   51: aload_0
    //   52: getfield 69	com/tencent/qqlive/mediaplayer/sdkupdate/a:c	Ljava/lang/Thread;
    //   55: ldc 71
    //   57: invokevirtual 75	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   60: aload_0
    //   61: getfield 69	com/tencent/qqlive/mediaplayer/sdkupdate/a:c	Ljava/lang/Thread;
    //   64: invokevirtual 78	java/lang/Thread:start	()V
    //   67: iconst_2
    //   68: ldc 43
    //   70: ldc 45
    //   72: ldc 80
    //   74: invokestatic 52	com/tencent/qqlive/mediaplayer/sdkupdate/d:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   77: goto -60 -> 17
    //   80: astore_2
    //   81: aload_0
    //   82: monitorexit
    //   83: aload_2
    //   84: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	this	a
    //   12	2	1	bool	boolean
    //   80	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	13	80	finally
    //   20	67	80	finally
    //   67	77	80	finally
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
          d.a(3, "SDKUpdate.java", "MediaPlayerMgr", "startWithForceAndSilent, start no wifi, cancel");
          this.e.f();
          continue;
        }
        this.c = new Thread(new a.1(this));
      }
      finally {}
      if (this.c != null)
      {
        this.b = true;
        this.c.setName("TVK_SDKUpdate1");
        this.c.start();
      }
    }
  }
  
  public boolean b()
  {
    if (f) {
      return this.e.c();
    }
    return false;
  }
  
  public String c()
  {
    if (f) {
      return this.e.g();
    }
    return null;
  }
  
  public String d()
  {
    if (f) {
      return this.e.h();
    }
    d.a(5, "SDKUpdate.java", "MediaPlayerMgr", "getLibs, return null");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.mediaplayer.sdkupdate.a
 * JD-Core Version:    0.7.0.1
 */