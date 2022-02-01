package com.tencent.mobileqq.intervideo.now.dynamic;

import android.os.Bundle;
import com.tencent.mobileqq.intervideo.ILoginKeyHelper;
import com.tencent.mobileqq.intervideo.ILoginKeyHelper.AccountInfo;
import com.tencent.mobileqq.intervideo.ILoginKeyHelper.GetLoginKeyListener;
import java.util.concurrent.CountDownLatch;

class PluginManagerInterfaceImpl$GetAccessTokenBundle$1
  implements ILoginKeyHelper.GetLoginKeyListener
{
  PluginManagerInterfaceImpl$GetAccessTokenBundle$1(PluginManagerInterfaceImpl.GetAccessTokenBundle paramGetAccessTokenBundle, ILoginKeyHelper paramILoginKeyHelper, Bundle[] paramArrayOfBundle, CountDownLatch paramCountDownLatch) {}
  
  public void onGetKeyComplete(String paramString, boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      paramString = new Bundle();
      paramString.putString("authid", this.jdField_a_of_type_ComTencentMobileqqIntervideoILoginKeyHelper.getAccountInfo().b);
      paramString.putString("authKey", this.jdField_a_of_type_ComTencentMobileqqIntervideoILoginKeyHelper.getAccountInfo().jdField_a_of_type_JavaLangString);
      paramString.putLong("accountUpdateTime", this.jdField_a_of_type_ComTencentMobileqqIntervideoILoginKeyHelper.getAccountInfo().jdField_a_of_type_Long);
      paramString.putString("payToken", this.jdField_a_of_type_ComTencentMobileqqIntervideoILoginKeyHelper.getAccountInfo().c);
      Bundle localBundle = new Bundle();
      localBundle.putBundle("data", paramString);
      localBundle.putBoolean("isSuccess", true);
      localBundle.putInt("code", paramInt);
      this.jdField_a_of_type_ArrayOfAndroidOsBundle[0] = localBundle;
    }
    else
    {
      paramString = new Bundle();
      paramString.putBoolean("isSuccess", false);
      paramString.putInt("code", paramInt);
      this.jdField_a_of_type_ArrayOfAndroidOsBundle[0] = paramString;
    }
    this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.PluginManagerInterfaceImpl.GetAccessTokenBundle.1
 * JD-Core Version:    0.7.0.1
 */