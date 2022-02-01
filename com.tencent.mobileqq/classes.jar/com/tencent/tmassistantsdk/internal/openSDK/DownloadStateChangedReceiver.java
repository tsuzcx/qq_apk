package com.tencent.tmassistantsdk.internal.openSDK;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.tmassistantbase.util.ab;
import java.util.ArrayList;

public class DownloadStateChangedReceiver
  extends BroadcastReceiver
{
  protected static final String a = "DownloadStateChangedReceiver";
  protected static DownloadStateChangedReceiver b;
  protected HandlerThread c = new HandlerThread("downloadStateChangedThread");
  protected Handler d = null;
  protected boolean e = false;
  ArrayList<b> f = new ArrayList();
  
  public DownloadStateChangedReceiver()
  {
    this.c.start();
    this.d = new Handler(this.c.getLooper());
  }
  
  public static DownloadStateChangedReceiver a()
  {
    try
    {
      if (b == null) {
        b = new DownloadStateChangedReceiver();
      }
      DownloadStateChangedReceiver localDownloadStateChangedReceiver = b;
      return localDownloadStateChangedReceiver;
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
    if (!this.e)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("registeReceiver   context");
      ((StringBuilder)localObject).append(paramContext);
      ((StringBuilder)localObject).append("  receiver:");
      ((StringBuilder)localObject).append(this);
      ab.c("DownloadStateChangedReceiver", ((StringBuilder)localObject).toString());
      localObject = new IntentFilter("com.tencent.assistantOpenSDK.downloadStateChange.action");
      try
      {
        paramContext = paramContext.registerReceiver(this, (IntentFilter)localObject);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(paramContext);
        ab.c("DownloadStateChangedReceiver", ((StringBuilder)localObject).toString());
        this.e = true;
        return;
      }
      catch (Throwable paramContext)
      {
        ab.c("DownloadStateChangedReceiver", "registeReceiver exception!!!");
        this.e = false;
        paramContext.printStackTrace();
      }
    }
  }
  
  public void a(b paramb)
  {
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("listener = ");
    localStringBuilder.append(paramb);
    ab.c(str, localStringBuilder.toString());
    if ((paramb != null) && (!this.f.contains(paramb))) {
      this.f.add(paramb);
    }
  }
  
  public void b(Context paramContext)
  {
    if ((paramContext != null) && (b != null))
    {
      if (this.e)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("realy unRegisteReceiver  context:");
        ((StringBuilder)localObject).append(paramContext);
        ((StringBuilder)localObject).append("  receiver:");
        ((StringBuilder)localObject).append(this);
        ab.c("DownloadStateChangedReceiver", ((StringBuilder)localObject).toString());
        try
        {
          paramContext.unregisterReceiver(this);
          this.e = false;
          return;
        }
        catch (Throwable paramContext)
        {
          ab.a("DownloadStateChangedReceiver", "unRegisteReceiver exception!!!", paramContext);
          this.e = false;
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
  
  public void b(b paramb)
  {
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("listener = ");
    localStringBuilder.append(paramb);
    ab.c(str, localStringBuilder.toString());
    if (paramb != null) {
      this.f.remove(paramb);
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("context = ");
    localStringBuilder.append(paramContext);
    localStringBuilder.append(",intent = ");
    localStringBuilder.append(paramIntent);
    ab.c(str, localStringBuilder.toString());
    paramContext = this.d;
    if (paramContext != null) {
      paramContext.post(new a(this, paramIntent));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmassistantsdk.internal.openSDK.DownloadStateChangedReceiver
 * JD-Core Version:    0.7.0.1
 */