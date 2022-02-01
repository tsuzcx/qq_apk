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
    VoiceInputHelperImpl.access$100(this.jdField_a_of_type_ComTencentMobileqqTeamworkApiImplVoiceInputHelperImpl);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqTeamworkApiImplVoiceInputHelperImpl.onGetError(1830001);
      return;
    }
    VoiceInputHelperImpl.access$300(this.jdField_a_of_type_ComTencentMobileqqTeamworkApiImplVoiceInputHelperImpl, false, 1830001);
  }
  
  @QQPermissionGrant(1818)
  public void grant()
  {
    QLog.d("VoiceInputHelperImpl", 1, "checkPermission user grant");
    VoiceInputHelperImpl.access$100(this.jdField_a_of_type_ComTencentMobileqqTeamworkApiImplVoiceInputHelperImpl);
    if (this.jdField_a_of_type_Boolean)
    {
      VoiceInputHelperImpl.access$200(this.jdField_a_of_type_ComTencentMobileqqTeamworkApiImplVoiceInputHelperImpl);
      return;
    }
    VoiceInputHelperImpl.access$300(this.jdField_a_of_type_ComTencentMobileqqTeamworkApiImplVoiceInputHelperImpl, true, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.api.impl.VoiceInputHelperImpl.2
 * JD-Core Version:    0.7.0.1
 */