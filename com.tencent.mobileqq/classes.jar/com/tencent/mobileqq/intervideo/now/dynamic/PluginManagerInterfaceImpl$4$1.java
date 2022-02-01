package com.tencent.mobileqq.intervideo.now.dynamic;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.intervideo.ILoginKeyHelper;
import com.tencent.mobileqq.intervideo.ILoginKeyHelper.AccountInfo;
import com.tencent.mobileqq.intervideo.ILoginKeyHelper.GetLoginKeyListener;
import java.util.concurrent.CountDownLatch;

class PluginManagerInterfaceImpl$4$1
  implements ILoginKeyHelper.GetLoginKeyListener
{
  PluginManagerInterfaceImpl$4$1(PluginManagerInterfaceImpl.4 param4, ILoginKeyHelper paramILoginKeyHelper, Bundle[] paramArrayOfBundle, CountDownLatch paramCountDownLatch) {}
  
  public void onGetKeyComplete(String paramString, boolean paramBoolean, int paramInt)
  {
    paramString = new Bundle(this.jdField_a_of_type_ComTencentMobileqqIntervideoILoginKeyHelper.getAccountInfo().a.getExtras());
    Bundle localBundle = new Bundle();
    localBundle.putBundle("data", paramString);
    localBundle.putBoolean("isSuccess", paramBoolean);
    localBundle.putInt("code", paramInt);
    this.jdField_a_of_type_ArrayOfAndroidOsBundle[0] = localBundle;
    this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.PluginManagerInterfaceImpl.4.1
 * JD-Core Version:    0.7.0.1
 */