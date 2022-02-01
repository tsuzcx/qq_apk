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
    if (a == null) {
      try
      {
        if (a == null) {
          a = new f();
        }
      }
      finally {}
    }
    return a;
  }
  
  public int a(AppDetailReqParam paramAppDetailReqParam, IGetAppInfoCallback paramIGetAppInfoCallback)
  {
    if (this.mServiceInterface != null) {
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("<requestAppInfo> process:");
        localStringBuilder.append(s.e());
        localStringBuilder.append(", mServiceInterface is ok");
        ab.c("RemoteOpProxy", localStringBuilder.toString());
        int i = ((com.tencent.tmdownloader.internal.remote.a)this.mServiceInterface).a(paramAppDetailReqParam, paramIGetAppInfoCallback);
        return i;
      }
      catch (Exception paramAppDetailReqParam)
      {
        paramAppDetailReqParam.printStackTrace();
      }
    }
    paramAppDetailReqParam = new StringBuilder();
    paramAppDetailReqParam.append("<requestAppInfo> process:");
    paramAppDetailReqParam.append(s.e());
    paramAppDetailReqParam.append(", mServiceInterface is null");
    ab.c("RemoteOpProxy", paramAppDetailReqParam.toString());
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
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("<setInt> process:");
        localStringBuilder.append(s.e());
        localStringBuilder.append(", mServiceInterface is ok");
        ab.c("RemoteOpProxy", localStringBuilder.toString());
        ((com.tencent.tmdownloader.internal.remote.a)this.mServiceInterface).a(paramString, paramInt);
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<setInt> process:");
    localStringBuilder.append(s.e());
    localStringBuilder.append(", mServiceInterface is null, post the operation");
    ab.c("RemoteOpProxy", localStringBuilder.toString());
    com.tencent.tmassistantbase.util.k.a().post(new p(this, paramString, paramInt));
  }
  
  public void a(String paramString, long paramLong)
  {
    if (this.mServiceInterface != null) {
      try
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("<setLong> process:");
        localStringBuilder.append(s.e());
        localStringBuilder.append(", mServiceInterface is ok");
        ab.c("RemoteOpProxy", localStringBuilder.toString());
        ((com.tencent.tmdownloader.internal.remote.a)this.mServiceInterface).a(paramString, paramLong);
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<setLong> process:");
    localStringBuilder.append(s.e());
    localStringBuilder.append(", mServiceInterface is null, post the operation");
    ab.c("RemoteOpProxy", localStringBuilder.toString());
    com.tencent.tmassistantbase.util.k.a().post(new o(this, paramString, paramLong));
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.mServiceInterface != null) {
      try
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("<setString> process:");
        localStringBuilder.append(s.e());
        localStringBuilder.append(", mServiceInterface is ok");
        ab.c("RemoteOpProxy", localStringBuilder.toString());
        ((com.tencent.tmdownloader.internal.remote.a)this.mServiceInterface).a(paramString1, paramString2);
        return;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<setString> process:");
    localStringBuilder.append(s.e());
    localStringBuilder.append(", mServiceInterface is null, post the operation");
    ab.c("RemoteOpProxy", localStringBuilder.toString());
    com.tencent.tmassistantbase.util.k.a().post(new n(this, paramString1, paramString2));
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (this.mServiceInterface != null) {
      try
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("<setBoolean> process:");
        localStringBuilder.append(s.e());
        localStringBuilder.append(", mServiceInterface is ok");
        ab.c("RemoteOpProxy", localStringBuilder.toString());
        ((com.tencent.tmdownloader.internal.remote.a)this.mServiceInterface).a(paramString, paramBoolean);
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<setBoolean> process:");
    localStringBuilder.append(s.e());
    localStringBuilder.append(", mServiceInterface is null, post the operation");
    ab.c("RemoteOpProxy", localStringBuilder.toString());
    com.tencent.tmassistantbase.util.k.a().post(new q(this, paramString, paramBoolean));
  }
  
  public void a(String paramString, byte[] paramArrayOfByte)
  {
    if (this.mServiceInterface != null) {
      try
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("<setBlob> process:");
        localStringBuilder.append(s.e());
        localStringBuilder.append(", mServiceInterface is ok");
        ab.c("RemoteOpProxy", localStringBuilder.toString());
        ((com.tencent.tmdownloader.internal.remote.a)this.mServiceInterface).a(paramString, paramArrayOfByte);
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<setBlob> process:");
    localStringBuilder.append(s.e());
    localStringBuilder.append(", mServiceInterface is null, post the operation");
    ab.c("RemoteOpProxy", localStringBuilder.toString());
    com.tencent.tmassistantbase.util.k.a().post(new m(this, paramString, paramArrayOfByte));
  }
  
  public byte[] a(String paramString)
  {
    if (this.mServiceInterface != null) {
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("<getBlob> process:");
        localStringBuilder.append(s.e());
        localStringBuilder.append(", mServiceInterface is ok");
        ab.c("RemoteOpProxy", localStringBuilder.toString());
        paramString = ((com.tencent.tmdownloader.internal.remote.a)this.mServiceInterface).a(paramString);
        return paramString;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
    paramString = new StringBuilder();
    paramString.append("<getBlob> process:");
    paramString.append(s.e());
    paramString.append(", mServiceInterface is null");
    ab.c("RemoteOpProxy", paramString.toString());
    com.tencent.tmassistantbase.util.k.a().post(new h(this));
    return new byte[0];
  }
  
  public String b(String paramString)
  {
    if (this.mServiceInterface != null) {
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("<getString> process:");
        localStringBuilder.append(s.e());
        localStringBuilder.append(", mServiceInterface is ok");
        ab.c("RemoteOpProxy", localStringBuilder.toString());
        paramString = ((com.tencent.tmdownloader.internal.remote.a)this.mServiceInterface).d(paramString);
        return paramString;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
    paramString = new StringBuilder();
    paramString.append("<getString> process:");
    paramString.append(s.e());
    paramString.append(", mServiceInterface is null");
    ab.c("RemoteOpProxy", paramString.toString());
    return "";
  }
  
  public void b()
  {
    if (this.mServiceInterface != null) {
      try
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("<requestAllConfig> process:");
        localStringBuilder1.append(s.e());
        localStringBuilder1.append(", mServiceInterface is ok");
        ab.c("RemoteOpProxy", localStringBuilder1.toString());
        ((com.tencent.tmdownloader.internal.remote.a)this.mServiceInterface).b();
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
    }
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("<requestAllConfig> process:");
    localStringBuilder2.append(s.e());
    localStringBuilder2.append(", mServiceInterface is null, post the operation");
    ab.c("RemoteOpProxy", localStringBuilder2.toString());
    com.tencent.tmassistantbase.util.k.a().post(new j(this));
  }
  
  public long c(String paramString)
  {
    if (this.mServiceInterface != null) {
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("<getLong> process:");
        localStringBuilder.append(s.e());
        localStringBuilder.append(", mServiceInterface is ok");
        ab.c("RemoteOpProxy", localStringBuilder.toString());
        long l = ((com.tencent.tmdownloader.internal.remote.a)this.mServiceInterface).c(paramString);
        return l;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
    paramString = new StringBuilder();
    paramString.append("<getLong> process:");
    paramString.append(s.e());
    paramString.append(", mServiceInterface is null");
    ab.c("RemoteOpProxy", paramString.toString());
    return 0L;
  }
  
  public void c()
  {
    if (this.mServiceInterface != null) {
      try
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("<requestShareUrl> process:");
        localStringBuilder1.append(s.e());
        localStringBuilder1.append(", mServiceInterface is ok");
        ab.c("RemoteOpProxy", localStringBuilder1.toString());
        ((com.tencent.tmdownloader.internal.remote.a)this.mServiceInterface).c();
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
    }
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("<requestShareUrl> process:");
    localStringBuilder2.append(s.e());
    localStringBuilder2.append(", mServiceInterface is null, post the operation");
    ab.c("RemoteOpProxy", localStringBuilder2.toString());
    com.tencent.tmassistantbase.util.k.a().post(new k(this));
  }
  
  public int d(String paramString)
  {
    if (this.mServiceInterface != null) {
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("<getInt> process:");
        localStringBuilder.append(s.e());
        localStringBuilder.append(", mServiceInterface is ok");
        ab.c("RemoteOpProxy", localStringBuilder.toString());
        int i = ((com.tencent.tmdownloader.internal.remote.a)this.mServiceInterface).b(paramString);
        return i;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
    paramString = new StringBuilder();
    paramString.append("<getInt> process:");
    paramString.append(s.e());
    paramString.append(", mServiceInterface is null");
    ab.c("RemoteOpProxy", paramString.toString());
    return 0;
  }
  
  public void d()
  {
    if (this.mServiceInterface != null) {
      try
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("<requestNewAppCenterConfig> process:");
        localStringBuilder1.append(s.e());
        localStringBuilder1.append(", mServiceInterface is ok");
        ab.c("RemoteOpProxy", localStringBuilder1.toString());
        ((com.tencent.tmdownloader.internal.remote.a)this.mServiceInterface).d();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        localRemoteException.printStackTrace();
        return;
      }
    }
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("<requestNewAppCenterConfig> process:");
    localStringBuilder2.append(s.e());
    localStringBuilder2.append(", mServiceInterface is null, post the operation");
    ab.c("RemoteOpProxy", localStringBuilder2.toString());
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
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("<getBoolean> process:");
        localStringBuilder.append(s.e());
        localStringBuilder.append(", mServiceInterface is ok");
        ab.c("RemoteOpProxy", localStringBuilder.toString());
        boolean bool = ((com.tencent.tmdownloader.internal.remote.a)this.mServiceInterface).e(paramString);
        return bool;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
    paramString = new StringBuilder();
    paramString.append("<getBoolean> process:");
    paramString.append(s.e());
    paramString.append(", mServiceInterface is null");
    ab.c("RemoteOpProxy", paramString.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmdownloader.f
 * JD-Core Version:    0.7.0.1
 */