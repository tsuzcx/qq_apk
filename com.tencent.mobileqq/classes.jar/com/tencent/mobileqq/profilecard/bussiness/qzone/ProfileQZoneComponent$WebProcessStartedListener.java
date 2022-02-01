package com.tencent.mobileqq.profilecard.bussiness.qzone;

import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.webview.util.WebProcessStartListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ProfileQZoneComponent$WebProcessStartedListener
  implements WebProcessStartListener
{
  private WeakReference<PreloadProcHitSession> mPreloadHitSessionRef;
  
  ProfileQZoneComponent$WebProcessStartedListener(PreloadProcHitSession paramPreloadProcHitSession)
  {
    this.mPreloadHitSessionRef = new WeakReference(paramPreloadProcHitSession);
  }
  
  public void onResult(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      PreloadProcHitSession localPreloadProcHitSession = (PreloadProcHitSession)this.mPreloadHitSessionRef.get();
      if (localPreloadProcHitSession != null) {
        localPreloadProcHitSession.a();
      }
      if (QLog.isColorLevel()) {
        QLog.d("ProfileQZoneComponent", 2, "check friend's profile and preload web-process!");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.qzone.ProfileQZoneComponent.WebProcessStartedListener
 * JD-Core Version:    0.7.0.1
 */