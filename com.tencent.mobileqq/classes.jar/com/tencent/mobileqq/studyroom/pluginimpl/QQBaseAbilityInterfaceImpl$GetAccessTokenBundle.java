package com.tencent.mobileqq.studyroom.pluginimpl;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.intervideo.ILoginKeyHelper;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

final class QQBaseAbilityInterfaceImpl$GetAccessTokenBundle
  implements Callable<Bundle>
{
  private final String appId;
  private final String pluginAppID;
  
  QQBaseAbilityInterfaceImpl$GetAccessTokenBundle(String paramString1, String paramString2)
  {
    this.appId = paramString1;
    this.pluginAppID = paramString2;
  }
  
  public Bundle call()
  {
    Bundle[] arrayOfBundle = new Bundle[1];
    AppInterface localAppInterface = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    ILoginKeyHelper localILoginKeyHelper = (ILoginKeyHelper)QRoute.api(ILoginKeyHelper.class);
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    localILoginKeyHelper.getAccessToken(localAppInterface, this.pluginAppID, BaseApplicationImpl.getContext(), this.appId, new QQBaseAbilityInterfaceImpl.GetAccessTokenBundle.1(this, localILoginKeyHelper, arrayOfBundle, localCountDownLatch));
    localCountDownLatch.await();
    return arrayOfBundle[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.pluginimpl.QQBaseAbilityInterfaceImpl.GetAccessTokenBundle
 * JD-Core Version:    0.7.0.1
 */