package com.tencent.tmdownloader;

import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.r;
import com.tencent.tmdownloader.internal.remote.b;

public class f
  extends a<com.tencent.tmdownloader.internal.remote.a>
{
  private static volatile f a;
  
  private f()
  {
    super(GlobalUtil.getInstance().getContext(), "com.tencent.tmdownloader.RemoteOpProxy", "com.tencent.tmdownloader.internal.remote.RemoteOpService");
    initTMAssistantDownloadSDK();
  }
  
  public static f a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new f();
      }
      return a;
    }
    finally {}
  }
  
  public void a(int paramInt, String paramString)
  {
    com.tencent.tmassistantbase.util.f.a(com.tencent.tmassistantbase.util.g.a).post(new g(this, paramInt, paramString));
  }
  
  public void a(String paramString, int paramInt)
  {
    if (this.mServiceInterface != null) {
      try
      {
        r.c("RemoteOpProxy", "<setInt> process:" + com.tencent.tmassistantbase.util.m.e() + ", mServiceInterface is ok");
        ((com.tencent.tmdownloader.internal.remote.a)this.mServiceInterface).a(paramString, paramInt);
        return;
      }
      catch (RemoteException paramString)
      {
        paramString.printStackTrace();
        return;
      }
    }
    r.c("RemoteOpProxy", "<setInt> process:" + com.tencent.tmassistantbase.util.m.e() + ", mServiceInterface is null, post the operation");
    com.tencent.tmassistantbase.util.f.a(com.tencent.tmassistantbase.util.g.b).post(new n(this, paramString, paramInt));
  }
  
  public void a(String paramString, long paramLong)
  {
    if (this.mServiceInterface != null) {
      try
      {
        r.c("RemoteOpProxy", "<setLong> process:" + com.tencent.tmassistantbase.util.m.e() + ", mServiceInterface is ok");
        ((com.tencent.tmdownloader.internal.remote.a)this.mServiceInterface).a(paramString, paramLong);
        return;
      }
      catch (RemoteException paramString)
      {
        paramString.printStackTrace();
        return;
      }
    }
    r.c("RemoteOpProxy", "<setLong> process:" + com.tencent.tmassistantbase.util.m.e() + ", mServiceInterface is null, post the operation");
    com.tencent.tmassistantbase.util.f.a(com.tencent.tmassistantbase.util.g.b).post(new m(this, paramString, paramLong));
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.mServiceInterface != null) {
      try
      {
        r.c("RemoteOpProxy", "<setString> process:" + com.tencent.tmassistantbase.util.m.e() + ", mServiceInterface is ok");
        ((com.tencent.tmdownloader.internal.remote.a)this.mServiceInterface).a(paramString1, paramString2);
        return;
      }
      catch (RemoteException paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
    }
    r.c("RemoteOpProxy", "<setString> process:" + com.tencent.tmassistantbase.util.m.e() + ", mServiceInterface is null, post the operation");
    com.tencent.tmassistantbase.util.f.a(com.tencent.tmassistantbase.util.g.b).post(new l(this, paramString1, paramString2));
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (this.mServiceInterface != null) {
      try
      {
        r.c("RemoteOpProxy", "<setBoolean> process:" + com.tencent.tmassistantbase.util.m.e() + ", mServiceInterface is ok");
        ((com.tencent.tmdownloader.internal.remote.a)this.mServiceInterface).a(paramString, paramBoolean);
        return;
      }
      catch (RemoteException paramString)
      {
        paramString.printStackTrace();
        return;
      }
    }
    r.c("RemoteOpProxy", "<setBoolean> process:" + com.tencent.tmassistantbase.util.m.e() + ", mServiceInterface is null, post the operation");
    com.tencent.tmassistantbase.util.f.a(com.tencent.tmassistantbase.util.g.b).post(new o(this, paramString, paramBoolean));
  }
  
  public void a(String paramString, byte[] paramArrayOfByte)
  {
    if (this.mServiceInterface != null) {
      try
      {
        r.c("RemoteOpProxy", "<setBlob> process:" + com.tencent.tmassistantbase.util.m.e() + ", mServiceInterface is ok");
        ((com.tencent.tmdownloader.internal.remote.a)this.mServiceInterface).a(paramString, paramArrayOfByte);
        return;
      }
      catch (RemoteException paramString)
      {
        paramString.printStackTrace();
        return;
      }
    }
    r.c("RemoteOpProxy", "<setBlob> process:" + com.tencent.tmassistantbase.util.m.e() + ", mServiceInterface is null, post the operation");
    com.tencent.tmassistantbase.util.f.a(com.tencent.tmassistantbase.util.g.b).post(new k(this, paramString, paramArrayOfByte));
  }
  
  public byte[] a(String paramString)
  {
    if (this.mServiceInterface != null) {
      try
      {
        r.c("RemoteOpProxy", "<getBlob> process:" + com.tencent.tmassistantbase.util.m.e() + ", mServiceInterface is ok");
        paramString = ((com.tencent.tmdownloader.internal.remote.a)this.mServiceInterface).a(paramString);
        return paramString;
      }
      catch (RemoteException paramString)
      {
        paramString.printStackTrace();
      }
    }
    r.c("RemoteOpProxy", "<getBlob> process:" + com.tencent.tmassistantbase.util.m.e() + ", mServiceInterface is null");
    com.tencent.tmassistantbase.util.f.a(com.tencent.tmassistantbase.util.g.b).post(new p(this));
    return new byte[0];
  }
  
  public String b(String paramString)
  {
    if (this.mServiceInterface != null) {
      try
      {
        r.c("RemoteOpProxy", "<getString> process:" + com.tencent.tmassistantbase.util.m.e() + ", mServiceInterface is ok");
        paramString = ((com.tencent.tmdownloader.internal.remote.a)this.mServiceInterface).d(paramString);
        return paramString;
      }
      catch (RemoteException paramString)
      {
        paramString.printStackTrace();
      }
    }
    r.c("RemoteOpProxy", "<getString> process:" + com.tencent.tmassistantbase.util.m.e() + ", mServiceInterface is null");
    return "";
  }
  
  public void b()
  {
    if (this.mServiceInterface != null) {
      try
      {
        r.c("RemoteOpProxy", "<requestAllConfig> process:" + com.tencent.tmassistantbase.util.m.e() + ", mServiceInterface is ok");
        ((com.tencent.tmdownloader.internal.remote.a)this.mServiceInterface).b();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        localRemoteException.printStackTrace();
        return;
      }
    }
    r.c("RemoteOpProxy", "<requestAllConfig> process:" + com.tencent.tmassistantbase.util.m.e() + ", mServiceInterface is null, post the operation");
    com.tencent.tmassistantbase.util.f.a(com.tencent.tmassistantbase.util.g.b).post(new i(this));
  }
  
  public long c(String paramString)
  {
    if (this.mServiceInterface != null) {
      try
      {
        r.c("RemoteOpProxy", "<getLong> process:" + com.tencent.tmassistantbase.util.m.e() + ", mServiceInterface is ok");
        long l = ((com.tencent.tmdownloader.internal.remote.a)this.mServiceInterface).c(paramString);
        return l;
      }
      catch (RemoteException paramString)
      {
        paramString.printStackTrace();
      }
    }
    r.c("RemoteOpProxy", "<getLong> process:" + com.tencent.tmassistantbase.util.m.e() + ", mServiceInterface is null");
    return 0L;
  }
  
  public void c()
  {
    if (this.mServiceInterface != null) {
      try
      {
        r.c("RemoteOpProxy", "<requestShareUrl> process:" + com.tencent.tmassistantbase.util.m.e() + ", mServiceInterface is ok");
        ((com.tencent.tmdownloader.internal.remote.a)this.mServiceInterface).c();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        localRemoteException.printStackTrace();
        return;
      }
    }
    r.c("RemoteOpProxy", "<requestShareUrl> process:" + com.tencent.tmassistantbase.util.m.e() + ", mServiceInterface is null, post the operation");
    com.tencent.tmassistantbase.util.f.a(com.tencent.tmassistantbase.util.g.b).post(new j(this));
  }
  
  public int d(String paramString)
  {
    if (this.mServiceInterface != null) {
      try
      {
        r.c("RemoteOpProxy", "<getInt> process:" + com.tencent.tmassistantbase.util.m.e() + ", mServiceInterface is ok");
        int i = ((com.tencent.tmdownloader.internal.remote.a)this.mServiceInterface).b(paramString);
        return i;
      }
      catch (RemoteException paramString)
      {
        paramString.printStackTrace();
      }
    }
    r.c("RemoteOpProxy", "<getInt> process:" + com.tencent.tmassistantbase.util.m.e() + ", mServiceInterface is null");
    return 0;
  }
  
  public void d()
  {
    com.tencent.tmassistantbase.util.f.a(com.tencent.tmassistantbase.util.g.b).post(new h(this));
  }
  
  public boolean e(String paramString)
  {
    if (this.mServiceInterface != null) {
      try
      {
        r.c("RemoteOpProxy", "<getBoolean> process:" + com.tencent.tmassistantbase.util.m.e() + ", mServiceInterface is ok");
        boolean bool = ((com.tencent.tmdownloader.internal.remote.a)this.mServiceInterface).e(paramString);
        return bool;
      }
      catch (RemoteException paramString)
      {
        paramString.printStackTrace();
      }
    }
    r.c("RemoteOpProxy", "<getBoolean> process:" + com.tencent.tmassistantbase.util.m.e() + ", mServiceInterface is null");
    return false;
  }
  
  protected Intent getBindServiceIntent()
  {
    return new Intent(this.mContext, Class.forName(this.mServiceName));
  }
  
  protected void onDownloadSDKServiceInvalid() {}
  
  protected void registerServiceCallback() {}
  
  protected void stubAsInterface(IBinder paramIBinder)
  {
    this.mServiceInterface = b.a(paramIBinder);
  }
  
  protected void unRegisterServiceCallback() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tmdownloader.f
 * JD-Core Version:    0.7.0.1
 */