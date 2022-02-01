package com.tencent.mobileqq.teamwork.api.impl;

import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;

class VoiceInputHelperImpl$2
{
  VoiceInputHelperImpl$2(VoiceInputHelperImpl paramVoiceInputHelperImpl, boolean paramBoolean) {}
  
  @QQPermissionDenied(1818)
  public void denied()
  {
    QLog.e("VoiceInputHelperImpl", 1, "checkPermission user denied");
    VoiceInputHelperImpl.access$100(this.b);
    if (this.a)
    {
      this.b.onGetError(1830001);
      return;
    }
    VoiceInputHelperImpl.access$300(this.b, false, 1830001);
  }
  
  @QQPermissionGrant(1818)
  public void grant()
  {
    QLog.d("VoiceInputHelperImpl", 1, "checkPermission user grant");
    VoiceInputHelperImpl.access$100(this.b);
    if (this.a)
    {
      VoiceInputHelperImpl.access$200(this.b);
      return;
    }
    VoiceInputHelperImpl.access$300(this.b, true, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.api.impl.VoiceInputHelperImpl.2
 * JD-Core Version:    0.7.0.1
 */