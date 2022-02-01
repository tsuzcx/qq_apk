package com.tencent.qqmini.sdk.utils;

import android.widget.Toast;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;

final class DomainUtil$2
  implements Runnable
{
  DomainUtil$2(int paramInt, String paramString) {}
  
  public void run()
  {
    Toast.makeText(AppLoaderFactory.g().getContext(), DomainUtil.access$000()[this.val$domainType] + "域名不合法，需使用https或wss协议:" + this.val$lowCaseUrl, 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.utils.DomainUtil.2
 * JD-Core Version:    0.7.0.1
 */