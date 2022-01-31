package com.tencent.tvkbeacon.g;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.tvkbeacon.core.BeaconIdJNI;
import com.tencent.tvkbeacon.core.c.c;
import com.tencent.tvkbeacon.core.c.i;

public class QimeiSDK
{
  private static volatile QimeiSDK instance;
  private String beaconId = "";
  private Context mContext;
  private b qimeiModule;
  
  public static QimeiSDK getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new QimeiSDK();
      }
      return instance;
    }
    finally {}
  }
  
  private boolean isInit(Context paramContext)
  {
    boolean bool = true;
    if (paramContext == null) {}
    for (;;)
    {
      try
      {
        c.d("[qimei] init context is null!", new Object[0]);
        return bool;
      }
      finally {}
      if (this.mContext != null) {
        c.a("[qimei] QimeiSdk has been initialized", new Object[0]);
      } else {
        bool = false;
      }
    }
  }
  
  public String getAppKey()
  {
    try
    {
      String str = com.tencent.tvkbeacon.core.info.b.a(this.mContext).b();
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  @Deprecated
  public String getBeaconIdInfo(Context paramContext)
  {
    try
    {
      if (i.a(this.beaconId)) {
        this.beaconId = BeaconIdJNI.a(paramContext, Build.VERSION.SDK_INT);
      }
      paramContext = this.beaconId;
      return paramContext;
    }
    finally {}
  }
  
  public void getQimei(IAsyncQimeiListener paramIAsyncQimeiListener)
  {
    for (;;)
    {
      try
      {
        String str = getQimeiInternal();
        if (!i.a(str))
        {
          paramIAsyncQimeiListener.onQimeiDispatch(str);
          return;
        }
        if (this.qimeiModule == null)
        {
          c.d("[qimei] QimeiModule is null, QimeiSDK has not initialized !", new Object[0]);
          paramIAsyncQimeiListener.onQimeiDispatch("");
        }
        else
        {
          this.qimeiModule.a(paramIAsyncQimeiListener);
        }
      }
      finally {}
    }
  }
  
  /* Error */
  @Deprecated
  public String getQimeiInternal()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 86	com/tencent/tvkbeacon/g/QimeiSDK:qimeiModule	Lcom/tencent/tvkbeacon/g/b;
    //   6: ifnull +24 -> 30
    //   9: aload_0
    //   10: getfield 86	com/tencent/tvkbeacon/g/QimeiSDK:qimeiModule	Lcom/tencent/tvkbeacon/g/b;
    //   13: invokevirtual 95	com/tencent/tvkbeacon/g/b:c	()Ljava/lang/String;
    //   16: astore_2
    //   17: aload_2
    //   18: invokestatic 61	com/tencent/tvkbeacon/core/c/i:a	(Ljava/lang/String;)Z
    //   21: istore_1
    //   22: iload_1
    //   23: ifne +7 -> 30
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_2
    //   29: areturn
    //   30: aload_0
    //   31: getfield 38	com/tencent/tvkbeacon/g/QimeiSDK:mContext	Landroid/content/Context;
    //   34: ifnull +14 -> 48
    //   37: aload_0
    //   38: getfield 38	com/tencent/tvkbeacon/g/QimeiSDK:mContext	Landroid/content/Context;
    //   41: invokestatic 99	com/tencent/tvkbeacon/g/d:a	(Landroid/content/Context;)Ljava/lang/String;
    //   44: astore_2
    //   45: goto -19 -> 26
    //   48: ldc 18
    //   50: astore_2
    //   51: goto -25 -> 26
    //   54: astore_2
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_2
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	QimeiSDK
    //   21	2	1	bool	boolean
    //   16	35	2	str	String
    //   54	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	22	54	finally
    //   30	45	54	finally
  }
  
  public QimeiSDK init(Context paramContext)
  {
    try
    {
      if (!isInit(paramContext))
      {
        this.mContext = paramContext;
        b.a(this.mContext).a();
      }
      return this;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public QimeiSDK setAppKey(String paramString)
  {
    if (!i.a(paramString)) {
      com.tencent.tvkbeacon.core.info.b.a = paramString;
    }
    return this;
  }
  
  public QimeiSDK setLogAble(boolean paramBoolean)
  {
    try
    {
      c.a = paramBoolean;
      c.c = paramBoolean;
      return this;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public QimeiSDK setOmgId(String paramString)
  {
    if (!i.a(paramString)) {
      com.tencent.tvkbeacon.core.info.c.a = paramString;
    }
    return this;
  }
  
  protected void setQimeiModule(b paramb)
  {
    this.qimeiModule = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.g.QimeiSDK
 * JD-Core Version:    0.7.0.1
 */