package com.tencent.mobileqq.jsp;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;

class TroopApiPlugin$3
{
  TroopApiPlugin$3(TroopApiPlugin paramTroopApiPlugin, String paramString) {}
  
  @QQPermissionDenied(1)
  public void denied()
  {
    this.jdField_a_of_type_ComTencentMobileqqJspTroopApiPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "-3", "{}" });
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).startLocation(new TroopApiPlugin.3.1(this, "webview"));
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_ComTencentMobileqqJspTroopApiPlugin.TAG, 2, "SosoInterface.startLocation");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.TroopApiPlugin.3
 * JD-Core Version:    0.7.0.1
 */