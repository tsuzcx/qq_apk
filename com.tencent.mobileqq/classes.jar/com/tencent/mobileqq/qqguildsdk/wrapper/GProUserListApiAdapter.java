package com.tencent.mobileqq.qqguildsdk.wrapper;

import android.os.Handler;
import android.os.Looper;
import com.tencent.gprosdk.IGProSdkWrapper;
import com.tencent.mobileqq.qqguildsdk.callback.IGetGProUserListPaginationCallback.Result;
import com.tencent.mobileqq.qqguildsdk.callback.IGetUserListCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import java.util.ArrayList;

public class GProUserListApiAdapter
{
  private static final Handler a = new Handler(Looper.getMainLooper());
  private final IGProSdkWrapper b;
  private final ArrayList<IGProUserInfo> c = new ArrayList();
  private Object d = null;
  private GProUserListApiAdapter.ApiParameter e = null;
  
  public GProUserListApiAdapter(IGProSdkWrapper paramIGProSdkWrapper)
  {
    this.b = paramIGProSdkWrapper;
  }
  
  private void a()
  {
    GProUserListPaginationRequest.a(this.b).a(GProUserListApiAdapter.ApiParameter.b(this.e)).a(GProUserListApiAdapter.ApiParameter.a(this.e)).a(GProUserListApiAdapter.ApiParameter.c(this.e), this.d, new GProUserListApiAdapter.1(this));
  }
  
  private void a(IGetGProUserListPaginationCallback.Result paramResult)
  {
    this.d = paramResult.e;
    if (paramResult.a != 0)
    {
      b(paramResult);
      return;
    }
    this.c.addAll(paramResult.c);
    b();
  }
  
  private void b()
  {
    a.post(new GProUserListApiAdapter.2(this));
  }
  
  private void b(IGetGProUserListPaginationCallback.Result paramResult)
  {
    a.post(new GProUserListApiAdapter.3(this, paramResult));
  }
  
  private static boolean c(IGProUserInfo paramIGProUserInfo)
  {
    return paramIGProUserInfo.d() == 0;
  }
  
  private static boolean d(IGProUserInfo paramIGProUserInfo)
  {
    int i = paramIGProUserInfo.d();
    boolean bool = true;
    if (i != 1)
    {
      if (paramIGProUserInfo.d() == 2) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public void a(String paramString, long paramLong, boolean paramBoolean, IGetUserListCallback paramIGetUserListCallback)
  {
    this.e = new GProUserListApiAdapter.ApiParameter(paramString, paramLong, paramBoolean, paramIGetUserListCallback);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProUserListApiAdapter
 * JD-Core Version:    0.7.0.1
 */