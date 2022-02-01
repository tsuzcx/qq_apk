package cooperation.qqindividuality.ipc;

import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.app.AppRuntime;

public class QQIndividualityRemoteProxy
{
  public final String a = "QQIndividualityRemoteProxy";
  public final String b = "com.qqindividuality.ipc.QQIndividualityRemoteProxyService";
  protected boolean c = false;
  protected WeakReference<AppRuntime> d = null;
  protected IQQIndividualityRemoteProxyInterface e = null;
  protected ConcurrentLinkedQueue<QQIndividualityRemoteProxy.QQIndividualityRemoteProxyCallWrapper> f = new ConcurrentLinkedQueue();
  protected HashSet<String> g = new HashSet();
  private ServiceConnection h = new QQIndividualityRemoteProxy.2(this);
  
  public QQIndividualityRemoteProxy(AppRuntime paramAppRuntime)
  {
    this.d = new WeakReference(paramAppRuntime);
    a("qqindividuality_signature");
  }
  
  private boolean a()
  {
    if ((this.e == null) && (!this.c))
    {
      Object localObject = this.d;
      if (localObject != null)
      {
        localObject = (AppRuntime)((WeakReference)localObject).get();
        if (localObject != null)
        {
          QQIndividualityPluginProxyService.a((AppRuntime)localObject, this.h, "com.qqindividuality.ipc.QQIndividualityRemoteProxyService");
          this.c = true;
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean b()
  {
    if (this.e != null)
    {
      Object localObject = this.d;
      if (localObject != null)
      {
        localObject = (AppRuntime)((WeakReference)localObject).get();
        if (localObject != null)
        {
          QQIndividualityPluginProxyService.a((AppRuntime)localObject, this.h);
          this.e = null;
          this.c = false;
        }
      }
    }
    return true;
  }
  
  private boolean b(QQIndividualityRemoteProxy.QQIndividualityRemoteProxyCallWrapper paramQQIndividualityRemoteProxyCallWrapper)
  {
    return this.f.add(paramQQIndividualityRemoteProxyCallWrapper);
  }
  
  public void a(QQIndividualityRemoteProxy.QQIndividualityRemoteProxyCallWrapper paramQQIndividualityRemoteProxyCallWrapper)
  {
    if ((this.e != null) && (paramQQIndividualityRemoteProxyCallWrapper != null))
    {
      Looper localLooper = Looper.getMainLooper();
      if (Thread.currentThread() != localLooper.getThread())
      {
        new Handler(localLooper).post(new QQIndividualityRemoteProxy.1(this, paramQQIndividualityRemoteProxyCallWrapper));
        return;
      }
    }
    try
    {
      this.e.a(paramQQIndividualityRemoteProxyCallWrapper.a, paramQQIndividualityRemoteProxyCallWrapper.b);
      return;
    }
    catch (RemoteException paramQQIndividualityRemoteProxyCallWrapper) {}
  }
  
  public boolean a(String paramString)
  {
    if (!this.g.contains(paramString))
    {
      this.g.add(paramString);
      return true;
    }
    return false;
  }
  
  public boolean a(String paramString, int paramInt, Bundle paramBundle)
  {
    if (this.g.contains(paramString))
    {
      paramString = new QQIndividualityRemoteProxy.QQIndividualityRemoteProxyCallWrapper(this, paramInt, paramBundle);
      if (this.e != null)
      {
        a(paramString);
      }
      else
      {
        b(paramString);
        a();
      }
      return true;
    }
    return false;
  }
  
  public boolean b(String paramString)
  {
    if (this.g.contains(paramString))
    {
      this.g.remove(paramString);
      if (this.g.isEmpty()) {
        b();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqindividuality.ipc.QQIndividualityRemoteProxy
 * JD-Core Version:    0.7.0.1
 */