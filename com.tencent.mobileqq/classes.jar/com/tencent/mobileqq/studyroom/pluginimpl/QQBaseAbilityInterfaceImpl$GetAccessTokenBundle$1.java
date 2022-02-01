package com.tencent.mobileqq.studyroom.pluginimpl;

import android.os.Bundle;
import avry;
import avsb;
import avsc;
import java.util.concurrent.CountDownLatch;

class QQBaseAbilityInterfaceImpl$GetAccessTokenBundle$1
  implements avsc
{
  QQBaseAbilityInterfaceImpl$GetAccessTokenBundle$1(QQBaseAbilityInterfaceImpl.GetAccessTokenBundle paramGetAccessTokenBundle, avry paramavry, Bundle[] paramArrayOfBundle, CountDownLatch paramCountDownLatch) {}
  
  public void onGetKeyComplete(String paramString, boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      paramString = new Bundle();
      paramString.putString("authid", this.val$loginKeyHelper.a().b);
      paramString.putString("authKey", this.val$loginKeyHelper.a().jdField_a_of_type_JavaLangString);
      paramString.putLong("accountUpdateTime", this.val$loginKeyHelper.a().jdField_a_of_type_Long);
      paramString.putString("payToken", this.val$loginKeyHelper.a().c);
      Bundle localBundle = new Bundle();
      localBundle.putBundle("data", paramString);
      localBundle.putBoolean("isSuccess", true);
      localBundle.putInt("code", paramInt);
      this.val$result[0] = localBundle;
    }
    for (;;)
    {
      this.val$latch.countDown();
      return;
      paramString = new Bundle();
      paramString.putBoolean("isSuccess", false);
      paramString.putInt("code", paramInt);
      this.val$result[0] = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.pluginimpl.QQBaseAbilityInterfaceImpl.GetAccessTokenBundle.1
 * JD-Core Version:    0.7.0.1
 */