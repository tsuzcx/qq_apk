package com.tencent.mobileqq.doc.jsp;

import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;

class VoiceInputHelper$2
{
  VoiceInputHelper$2(VoiceInputHelper paramVoiceInputHelper, boolean paramBoolean) {}
  
  @QQPermissionDenied(1818)
  public void denied()
  {
    QLog.e("VoiceInputHelper", 1, "checkPermission user denied");
    VoiceInputHelper.a(this.jdField_a_of_type_ComTencentMobileqqDocJspVoiceInputHelper);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqDocJspVoiceInputHelper.onGetError(1830001);
      return;
    }
    VoiceInputHelper.a(this.jdField_a_of_type_ComTencentMobileqqDocJspVoiceInputHelper, false, 1830001);
  }
  
  @QQPermissionGrant(1818)
  public void grant()
  {
    QLog.d("VoiceInputHelper", 1, "checkPermission user grant");
    VoiceInputHelper.a(this.jdField_a_of_type_ComTencentMobileqqDocJspVoiceInputHelper);
    if (this.jdField_a_of_type_Boolean)
    {
      VoiceInputHelper.b(this.jdField_a_of_type_ComTencentMobileqqDocJspVoiceInputHelper);
      return;
    }
    VoiceInputHelper.a(this.jdField_a_of_type_ComTencentMobileqqDocJspVoiceInputHelper, true, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.doc.jsp.VoiceInputHelper.2
 * JD-Core Version:    0.7.0.1
 */