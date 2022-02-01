package com.tencent.qqmini.sdk.runtime;

import android.widget.ImageView;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.core.proxy.KingCardProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.widget.CapsuleButton;

class AppUIProxy$6
  implements Runnable
{
  AppUIProxy$6(AppUIProxy paramAppUIProxy) {}
  
  public void run()
  {
    if (this.this$0.mCurrRuntimeLoader != null) {}
    for (BaseRuntime localBaseRuntime = this.this$0.mCurrRuntimeLoader.getRuntime(); (localBaseRuntime != null) && (localBaseRuntime.getPage() != null); localBaseRuntime = null)
    {
      Object localObject = localBaseRuntime.getPage().getCapsuleButton();
      if ((localObject instanceof CapsuleButton))
      {
        localObject = ((CapsuleButton)localObject).getMoreView();
        ((KingCardProxy)ProxyManager.get(KingCardProxy.class)).showKingCardTips(localBaseRuntime, (ImageView)localObject);
      }
      return;
    }
    QMLog.i("minisdk-start_UIProxy", "page is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.AppUIProxy.6
 * JD-Core Version:    0.7.0.1
 */