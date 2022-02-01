package cooperation.qqfav.ipc;

import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import cooperation.qqfav.QfavPluginProxyService;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.app.AppRuntime;

public class QfavRemoteProxyForQQ
{
  public final String a = "QfavRemoteProxyForQQ";
  protected boolean b = false;
  protected WeakReference<AppRuntime> c = null;
  protected IQfavRemoteProxyInterface d = null;
  protected ConcurrentLinkedQueue<QfavRemoteProxyForQQ.QfavRemoteProxyCallWrapper> e = new ConcurrentLinkedQueue();
  protected HashSet<String> f = new HashSet();
  private ServiceConnection g = new QfavRemoteProxyForQQ.2(this);
  
  public QfavRemoteProxyForQQ(AppRuntime paramAppRuntime)
  {
    this.c = new WeakReference(paramAppRuntime);
    a("com.tencent.qqfav");
  }
  
  private boolean a()
  {
    if ((this.d == null) && (!this.b))
    {
      Object localObject = this.c;
      if (localObject != null)
      {
        localObject = (AppRuntime)((WeakReference)localObject).get();
        if (localObject != null)
        {
          QfavPluginProxyService.a((AppRuntime)localObject, this.g, "com.qqfav.ipc.QfavRemoteProxyService");
          this.b = true;
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean a(QfavRemoteProxyForQQ.QfavRemoteProxyCallWrapper paramQfavRemoteProxyCallWrapper)
  {
    return this.e.add(paramQfavRemoteProxyCallWrapper);
  }
  
  private void b(QfavRemoteProxyForQQ.QfavRemoteProxyCallWrapper paramQfavRemoteProxyCallWrapper)
  {
    if ((this.d != null) && (paramQfavRemoteProxyCallWrapper != null))
    {
      Looper localLooper = Looper.getMainLooper();
      if (Thread.currentThread() != localLooper.getThread())
      {
        new Handler(localLooper).post(new QfavRemoteProxyForQQ.1(this, paramQfavRemoteProxyCallWrapper));
        return;
      }
    }
    try
    {
      this.d.a(paramQfavRemoteProxyCallWrapper.a, paramQfavRemoteProxyCallWrapper.b);
      return;
    }
    catch (RemoteException paramQfavRemoteProxyCallWrapper) {}
  }
  
  public boolean a(String paramString)
  {
    if (!this.f.contains(paramString))
    {
      this.f.add(paramString);
      a();
      return true;
    }
    return false;
  }
  
  public boolean a(String paramString, int paramInt, Bundle paramBundle)
  {
    if (this.f.contains(paramString))
    {
      paramString = new QfavRemoteProxyForQQ.QfavRemoteProxyCallWrapper(this, paramInt, paramBundle);
      if (this.d != null)
      {
        b(paramString);
      }
      else
      {
        a(paramString);
        a();
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqfav.ipc.QfavRemoteProxyForQQ
 * JD-Core Version:    0.7.0.1
 */