package com.tencent.mobileqq.intervideo.now.dynamic;

import android.os.Bundle;
import com.tencent.mobileqq.intervideo.LoginKeyHelper;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

class PluginManagerInterfaceImpl$4
  implements Callable<Bundle>
{
  PluginManagerInterfaceImpl$4(PluginManagerInterfaceImpl paramPluginManagerInterfaceImpl, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {}
  
  public Bundle a()
  {
    LoginKeyHelper localLoginKeyHelper = new LoginKeyHelper();
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    Bundle[] arrayOfBundle = new Bundle[1];
    localLoginKeyHelper.a(this.jdField_a_of_type_JavaLangString, this.b, this.c, this.d, new PluginManagerInterfaceImpl.4.1(this, localLoginKeyHelper, arrayOfBundle, localCountDownLatch), true, this.e);
    localCountDownLatch.await();
    return arrayOfBundle[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.PluginManagerInterfaceImpl.4
 * JD-Core Version:    0.7.0.1
 */