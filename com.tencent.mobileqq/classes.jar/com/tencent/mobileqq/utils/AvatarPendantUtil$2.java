package com.tencent.mobileqq.utils;

import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.webview.util.WebProcessStartListener;

final class AvatarPendantUtil$2
  implements WebProcessStartListener
{
  AvatarPendantUtil$2(PreloadProcHitSession paramPreloadProcHitSession) {}
  
  public void onResult(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      PreloadProcHitSession localPreloadProcHitSession = this.a;
      if (localPreloadProcHitSession != null) {
        localPreloadProcHitSession.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.AvatarPendantUtil.2
 * JD-Core Version:    0.7.0.1
 */