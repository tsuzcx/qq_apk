package com.tencent.mobileqq.intervideo.now.dynamic;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.intervideo.ILoginKeyHelper;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import mqq.util.WeakReference;

final class PluginManagerInterfaceImpl$GetAccessTokenBundle
  implements Callable<Bundle>
{
  private final WeakReference<PluginManagerInterfaceImpl> a;
  private final String b;
  private final String c;
  
  PluginManagerInterfaceImpl$GetAccessTokenBundle(PluginManagerInterfaceImpl paramPluginManagerInterfaceImpl, String paramString1, String paramString2)
  {
    this.b = paramString1;
    this.c = paramString2;
    this.a = new WeakReference(paramPluginManagerInterfaceImpl);
  }
  
  public Bundle a()
  {
    Object localObject = (PluginManagerInterfaceImpl)this.a.get();
    Bundle[] arrayOfBundle = new Bundle[1];
    if (localObject != null)
    {
      localObject = (ILoginKeyHelper)QRoute.api(ILoginKeyHelper.class);
      CountDownLatch localCountDownLatch = new CountDownLatch(1);
      ((ILoginKeyHelper)localObject).getAccessToken(PluginManagerInterfaceImpl.f(), this.c, BaseApplicationImpl.getContext(), this.b, new PluginManagerInterfaceImpl.GetAccessTokenBundle.1(this, (ILoginKeyHelper)localObject, arrayOfBundle, localCountDownLatch));
      localCountDownLatch.await();
      return arrayOfBundle[0];
    }
    localObject = new Bundle();
    ((Bundle)localObject).putBoolean("isSuccess", false);
    ((Bundle)localObject).putInt("code", -1000);
    arrayOfBundle[0] = localObject;
    return arrayOfBundle[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.PluginManagerInterfaceImpl.GetAccessTokenBundle
 * JD-Core Version:    0.7.0.1
 */