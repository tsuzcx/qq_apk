package com.tencent.mobileqq.studyroom.pluginimpl;

import android.os.Bundle;
import com.tencent.mobileqq.intervideo.ILoginKeyHelper;
import com.tencent.mobileqq.intervideo.ILoginKeyHelper.AccountInfo;
import com.tencent.mobileqq.intervideo.ILoginKeyHelper.GetLoginKeyListener;
import java.util.concurrent.CountDownLatch;

class QQBaseAbilityInterfaceImpl$GetAccessTokenBundle$1
  implements ILoginKeyHelper.GetLoginKeyListener
{
  QQBaseAbilityInterfaceImpl$GetAccessTokenBundle$1(QQBaseAbilityInterfaceImpl.GetAccessTokenBundle paramGetAccessTokenBundle, ILoginKeyHelper paramILoginKeyHelper, Bundle[] paramArrayOfBundle, CountDownLatch paramCountDownLatch) {}
  
  public void onGetKeyComplete(String paramString, boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      paramString = new Bundle();
      paramString.putString("authid", this.val$loginKeyHelper.getAccountInfo().b);
      paramString.putString("authKey", this.val$loginKeyHelper.getAccountInfo().a);
      paramString.putLong("accountUpdateTime", this.val$loginKeyHelper.getAccountInfo().e);
      paramString.putString("payToken", this.val$loginKeyHelper.getAccountInfo().c);
      Bundle localBundle = new Bundle();
      localBundle.putBundle("data", paramString);
      localBundle.putBoolean("isSuccess", true);
      localBundle.putInt("code", paramInt);
      this.val$result[0] = localBundle;
    }
    else
    {
      paramString = new Bundle();
      paramString.putBoolean("isSuccess", false);
      paramString.putInt("code", paramInt);
      this.val$result[0] = paramString;
    }
    this.val$latch.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.pluginimpl.QQBaseAbilityInterfaceImpl.GetAccessTokenBundle.1
 * JD-Core Version:    0.7.0.1
 */