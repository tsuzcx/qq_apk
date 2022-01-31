package com.tencent.mobileqq.microapp.appbrand.utils;

import Wallet.GetMiniAppRsp;
import android.os.Bundle;
import baip;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.observer.BusinessObserver;

final class l
  implements BusinessObserver
{
  l(String paramString, int paramInt) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    paramBundle = (GetMiniAppRsp)paramBundle.getSerializable("rsp");
    if ((paramBundle != null) && (!baip.a(paramBundle.extra)))
    {
      paramBundle = paramBundle.extra;
      MiniLogManager.access$800(paramBundle, this.a);
      if (QLog.isDebugVersion()) {
        QLog.d(MiniLogManager.access$100(), 4, " action:" + this.b + " logUrl:" + paramBundle + " filePath:" + this.a);
      }
      return;
    }
    new File(this.a).delete();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.utils.l
 * JD-Core Version:    0.7.0.1
 */