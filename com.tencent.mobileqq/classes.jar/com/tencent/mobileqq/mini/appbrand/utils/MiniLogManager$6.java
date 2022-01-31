package com.tencent.mobileqq.mini.appbrand.utils;

import Wallet.GetMiniAppRsp;
import android.os.Bundle;
import baip;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.observer.BusinessObserver;

final class MiniLogManager$6
  implements BusinessObserver
{
  MiniLogManager$6(String paramString, int paramInt) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    paramBundle = (GetMiniAppRsp)paramBundle.getSerializable("rsp");
    if ((paramBundle != null) && (!baip.a(paramBundle.extra)))
    {
      paramBundle = paramBundle.extra;
      MiniLogManager.access$800(paramBundle, this.val$filePath);
      if (QLog.isDebugVersion()) {
        QLog.d(MiniLogManager.access$100(), 4, " action:" + this.val$action + " logUrl:" + paramBundle + " filePath:" + this.val$filePath);
      }
      return;
    }
    new File(this.val$filePath).delete();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.utils.MiniLogManager.6
 * JD-Core Version:    0.7.0.1
 */