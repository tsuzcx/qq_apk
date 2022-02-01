package com.tencent.mobileqq.intervideo.now.dynamic;

import android.os.Bundle;
import com.tencent.mobileqq.intervideo.ILoginKeyHelper;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

class PluginManagerInterfaceImpl$4
  implements Callable<Bundle>
{
  PluginManagerInterfaceImpl$4(PluginManagerInterfaceImpl paramPluginManagerInterfaceImpl, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {}
  
  public Bundle a()
  {
    ILoginKeyHelper localILoginKeyHelper = (ILoginKeyHelper)QRoute.api(ILoginKeyHelper.class);
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    Bundle[] arrayOfBundle = new Bundle[1];
    localILoginKeyHelper.getA1(this.a, this.b, this.c, this.d, new PluginManagerInterfaceImpl.4.1(this, localILoginKeyHelper, arrayOfBundle, localCountDownLatch), true, this.e);
    localCountDownLatch.await();
    return arrayOfBundle[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.PluginManagerInterfaceImpl.4
 * JD-Core Version:    0.7.0.1
 */