package com.tencent.mobileqq.intervideo.now.dynamic;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.intervideo.LoginKeyHelper;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import mqq.util.WeakReference;

final class PluginManagerInterfaceImpl$GetAccessTokenBundle
  implements Callable<Bundle>
{
  private final String jdField_a_of_type_JavaLangString;
  private final WeakReference<PluginManagerInterfaceImpl> jdField_a_of_type_MqqUtilWeakReference;
  private final String b;
  
  PluginManagerInterfaceImpl$GetAccessTokenBundle(PluginManagerInterfaceImpl paramPluginManagerInterfaceImpl, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramPluginManagerInterfaceImpl);
  }
  
  public Bundle a()
  {
    Object localObject = (PluginManagerInterfaceImpl)this.jdField_a_of_type_MqqUtilWeakReference.get();
    Bundle[] arrayOfBundle = new Bundle[1];
    if (localObject != null)
    {
      localObject = new LoginKeyHelper();
      CountDownLatch localCountDownLatch = new CountDownLatch(1);
      ((LoginKeyHelper)localObject).a(PluginManagerInterfaceImpl.a(), this.b, BaseApplicationImpl.getContext(), this.jdField_a_of_type_JavaLangString, new PluginManagerInterfaceImpl.GetAccessTokenBundle.1(this, (LoginKeyHelper)localObject, arrayOfBundle, localCountDownLatch));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.PluginManagerInterfaceImpl.GetAccessTokenBundle
 * JD-Core Version:    0.7.0.1
 */