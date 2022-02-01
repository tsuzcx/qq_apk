package com.tencent.tmdownloader;

import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.tmassistant.appinfo.aidl.IGetAppInfoCallback;
import com.tencent.tmassistant.appinfo.data.AppDetailReqParam;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmassistantbase.util.s;
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
  
  public int a(AppDetailReqParam paramAppDetailReqParam, IGetAppInfoCallback paramIGetAppInfoCallback)
  {
    if (this.mServiceInterface != null) {
      try
      {
        ab.c("RemoteOpProxy", "<requestAppInfo> process:" + s.e() + ", mServiceInterface is ok");
        int i = ((com.tencent.tmdownloader.internal.remote.a)this.mServiceInterface).a(paramAppDetailReqParam, paramIGetAppInfoCallback);
        return i;
      }
      catch (Exception paramAppDetailReqParam)
      {
        paramAppDetailReqParam.printStackTrace();
      }
    }
    ab.c("RemoteOpProxy", "<requestAppInfo> process:" + s.e() + ", mServiceInterface is null");
    return -1;
  }
  
  public void a(int paramInt, String paramString)
  {
    com.tencent.tmassistantbase.util.k.a().post(new g(this, paramInt, paramString));
  }
  
  public void a(String paramString, int paramInt)
  {
    if (this.mServiceInterface != null) {
      try
      {
        ab.c("RemoteOpProxy", "<setInt> process:" + s.e() + ", mServiceInterface is ok");
        ((com.tencent.tmdownloader.internal.remote.a)this.mServiceInterface).a(paramString, paramInt);
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
    }
    ab.c("RemoteOpProxy", "<setInt> process:" + s.e() + ", mServiceInterface is null, post the operation");
    com.tencent.tmassistantbase.util.k.a().post(new p(this, paramString, paramInt));
  }
  
  public void a(String paramString, long paramLong)
  {
    if (this.mServiceInterface != null) {
      try
      {
        ab.c("RemoteOpProxy", "<setLong> process:" + s.e() + ", mServiceInterface is ok");
        ((com.tencent.tmdownloader.internal.remote.a)this.mServiceInterface).a(paramString, paramLong);
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
    }
    ab.c("RemoteOpProxy", "<setLong> process:" + s.e() + ", mServiceInterface is null, post the operation");
    com.tencent.tmassistantbase.util.k.a().post(new o(this, paramString, paramLong));
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.mServiceInterface != null) {
      try
      {
        ab.c("RemoteOpProxy", "<setString> process:" + s.e() + ", mServiceInterface is ok");
        ((com.tencent.tmdownloader.internal.remote.a)this.mServiceInterface).a(paramString1, paramString2);
        return;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
    }
    ab.c("RemoteOpProxy", "<setString> process:" + s.e() + ", mServiceInterface is null, post the operation");
    com.tencent.tmassistantbase.util.k.a().post(new n(this, paramString1, paramString2));
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (this.mServiceInterface != null) {
      try
      {
        ab.c("RemoteOpProxy", "<setBoolean> process:" + s.e() + ", mServiceInterface is ok");
        ((com.tencent.tmdownloader.internal.remote.a)this.mServiceInterface).a(paramString, paramBoolean);
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
    }
    ab.c("RemoteOpProxy", "<setBoolean> process:" + s.e() + ", mServiceInterface is null, post the operation");
    com.tencent.tmassistantbase.util.k.a().post(new q(this, paramString, paramBoolean));
  }
  
  public void a(String paramString, byte[] paramArrayOfByte)
  {
    if (this.mServiceInterface != null) {
      try
      {
        ab.c("RemoteOpProxy", "<setBlob> process:" + s.e() + ", mServiceInterface is ok");
        ((com.tencent.tmdownloader.internal.remote.a)this.mServiceInterface).a(paramString, paramArrayOfByte);
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
    }
    ab.c("RemoteOpProxy", "<setBlob> process:" + s.e() + ", mServiceInterface is null, post the operation");
    com.tencent.tmassistantbase.util.k.a().post(new m(this, paramString, paramArrayOfByte));
  }
  
  public byte[] a(String paramString)
  {
    if (this.mServiceInterface != null) {
      try
      {
        ab.c("RemoteOpProxy", "<getBlob> process:" + s.e() + ", mServiceInterface is ok");
        paramString = ((com.tencent.tmdownloader.internal.remote.a)this.mServiceInterface).a(paramString);
        return paramString;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
    ab.c("RemoteOpProxy", "<getBlob> process:" + s.e() + ", mServiceInterface is null");
    com.tencent.tmassistantbase.util.k.a().post(new h(this));
    return new byte[0];
  }
  
  public String b(String paramString)
  {
    if (this.mServiceInterface != null) {
      try
      {
        ab.c("RemoteOpProxy", "<getString> process:" + s.e() + ", mServiceInterface is ok");
        paramString = ((com.tencent.tmdownloader.internal.remote.a)this.mServiceInterface).d(paramString);
        return paramString;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
    ab.c("RemoteOpProxy", "<getString> process:" + s.e() + ", mServiceInterface is null");
    return "";
  }
  
  public void b()
  {
    if (this.mServiceInterface != null) {
      try
      {
        ab.c("RemoteOpProxy", "<requestAllConfig> process:" + s.e() + ", mServiceInterface is ok");
        ((com.tencent.tmdownloader.internal.remote.a)this.mServiceInterface).b();
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
    }
    ab.c("RemoteOpProxy", "<requestAllConfig> process:" + s.e() + ", mServiceInterface is null, post the operation");
    com.tencent.tmassistantbase.util.k.a().post(new j(this));
  }
  
  public long c(String paramString)
  {
    if (this.mServiceInterface != null) {
      try
      {
        ab.c("RemoteOpProxy", "<getLong> process:" + s.e() + ", mServiceInterface is ok");
        long l = ((com.tencent.tmdownloader.internal.remote.a)this.mServiceInterface).c(paramString);
        return l;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
    ab.c("RemoteOpProxy", "<getLong> process:" + s.e() + ", mServiceInterface is null");
    return 0L;
  }
  
  public void c()
  {
    if (this.mServiceInterface != null) {
      try
      {
        ab.c("RemoteOpProxy", "<requestShareUrl> process:" + s.e() + ", mServiceInterface is ok");
        ((com.tencent.tmdownloader.internal.remote.a)this.mServiceInterface).c();
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
    }
    ab.c("RemoteOpProxy", "<requestShareUrl> process:" + s.e() + ", mServiceInterface is null, post the operation");
    com.tencent.tmassistantbase.util.k.a().post(new k(this));
  }
  
  public int d(String paramString)
  {
    if (this.mServiceInterface != null) {
      try
      {
        ab.c("RemoteOpProxy", "<getInt> process:" + s.e() + ", mServiceInterface is ok");
        int i = ((com.tencent.tmdownloader.internal.remote.a)this.mServiceInterface).b(paramString);
        return i;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
    ab.c("RemoteOpProxy", "<getInt> process:" + s.e() + ", mServiceInterface is null");
    return 0;
  }
  
  public void d()
  {
    if (this.mServiceInterface != null) {
      try
      {
        ab.c("RemoteOpProxy", "<requestNewAppCenterConfig> process:" + s.e() + ", mServiceInterface is ok");
        ((com.tencent.tmdownloader.internal.remote.a)this.mServiceInterface).d();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        localRemoteException.printStackTrace();
        return;
      }
    }
    ab.c("RemoteOpProxy", "<requestNewAppCenterConfig> process:" + s.e() + ", mServiceInterface is null, post the operation");
    com.tencent.tmassistantbase.util.k.a().post(new l(this));
  }
  
  public void e()
  {
    com.tencent.tmassistantbase.util.k.a().post(new i(this));
  }
  
  public boolean e(String paramString)
  {
    if (this.mServiceInterface != null) {
      try
      {
        ab.c("RemoteOpProxy", "<getBoolean> process:" + s.e() + ", mServiceInterface is ok");
        boolean bool = ((com.tencent.tmdownloader.internal.remote.a)this.mServiceInterface).e(paramString);
        return bool;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
    ab.c("RemoteOpProxy", "<getBoolean> process:" + s.e() + ", mServiceInterface is null");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tmdownloader.f
 * JD-Core Version:    0.7.0.1
 */