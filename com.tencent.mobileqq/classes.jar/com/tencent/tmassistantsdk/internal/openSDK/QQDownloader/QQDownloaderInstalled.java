package com.tencent.tmassistantsdk.internal.openSDK.QQDownloader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.tmassistantbase.util.ab;

public class QQDownloaderInstalled
  extends BroadcastReceiver
{
  protected static final String a = "QQDownloaderInstalled";
  protected static QQDownloaderInstalled b;
  protected boolean c = false;
  protected d d = null;
  
  public static QQDownloaderInstalled a()
  {
    try
    {
      if (b == null) {
        b = new QQDownloaderInstalled();
      }
      QQDownloaderInstalled localQQDownloaderInstalled = b;
      return localQQDownloaderInstalled;
    }
    finally {}
  }
  
  public void a(Context paramContext)
  {
    Object localObject = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("context = ");
    localStringBuilder.append(paramContext);
    ab.c((String)localObject, localStringBuilder.toString());
    if (!this.c)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("registeReceiver   context");
      ((StringBuilder)localObject).append(paramContext);
      ((StringBuilder)localObject).append("  receiver:");
      ((StringBuilder)localObject).append(this);
      ab.c("QQDownloaderInstalled", ((StringBuilder)localObject).toString());
      localObject = new IntentFilter("com.tencent.assistant.ipc.firststart.action");
      try
      {
        paramContext = paramContext.registerReceiver(this, (IntentFilter)localObject);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(paramContext);
        ab.c("QQDownloaderInstalled", ((StringBuilder)localObject).toString());
        this.c = true;
        return;
      }
      catch (Throwable paramContext)
      {
        ab.c("QQDownloaderInstalled", "registeReceiver exception!!!");
        this.c = false;
        paramContext.printStackTrace();
      }
    }
  }
  
  public void a(d paramd)
  {
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("listener = ");
    localStringBuilder.append(paramd);
    ab.c(str, localStringBuilder.toString());
    this.d = paramd;
  }
  
  public void b()
  {
    ab.c(a, "unregisteListener start");
    this.d = null;
  }
  
  public void b(Context paramContext)
  {
    if ((paramContext != null) && (b != null))
    {
      if (this.c)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("realy unRegisteReceiver  context:");
        ((StringBuilder)localObject).append(paramContext);
        ((StringBuilder)localObject).append("  receiver:");
        ((StringBuilder)localObject).append(this);
        ab.c("QQDownloaderInstalled", ((StringBuilder)localObject).toString());
        try
        {
          paramContext.unregisterReceiver(this);
          this.c = false;
          return;
        }
        catch (Throwable paramContext)
        {
          ab.c("QQDownloaderInstalled", "unRegisteReceiver exception!!!");
          this.c = false;
          paramContext.printStackTrace();
        }
      }
      return;
    }
    Object localObject = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("unRegisteReceiver fail! context = ");
    localStringBuilder.append(paramContext);
    localStringBuilder.append(",mInstance = ");
    localStringBuilder.append(b);
    ab.c((String)localObject, localStringBuilder.toString());
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    ab.c("QQDownloaderInstalled", "onReceive!");
    new c(this, paramContext).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmassistantsdk.internal.openSDK.QQDownloader.QQDownloaderInstalled
 * JD-Core Version:    0.7.0.1
 */