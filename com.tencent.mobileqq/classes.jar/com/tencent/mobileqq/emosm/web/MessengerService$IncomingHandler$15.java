package com.tencent.mobileqq.emosm.web;

import android.os.Bundle;
import com.tencent.mobileqq.video.VipVideoManager;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;

class MessengerService$IncomingHandler$15
  implements TVK_SDKMgr.InstallListener
{
  MessengerService$IncomingHandler$15(MessengerService.IncomingHandler paramIncomingHandler, Bundle paramBundle, MessengerService paramMessengerService) {}
  
  public void onInstallProgress(float paramFloat)
  {
    int i = (int)Math.floor(paramFloat * 100.0F);
    if (i > VipVideoManager.a)
    {
      VipVideoManager.a = i;
      Bundle localBundle = new Bundle();
      localBundle.putInt("status", 1);
      localBundle.putFloat("progress", i);
      this.a.putBundle("response", localBundle);
      this.b.a(this.a);
    }
  }
  
  public void onInstalledFailed(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("status", 2);
    localBundle.putInt("errCode", paramInt);
    this.a.putBundle("response", localBundle);
    this.b.a(this.a);
  }
  
  public void onInstalledSuccessed()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("status", 3);
    localBundle.putBoolean("result", true);
    this.a.putBundle("response", localBundle);
    this.b.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.IncomingHandler.15
 * JD-Core Version:    0.7.0.1
 */