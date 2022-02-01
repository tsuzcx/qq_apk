package com.tencent.mobileqq.jsp;

import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.qphone.base.util.QLog;

class ConnectApiPlugin$1
  implements TroopMemberApiClient.Callback
{
  ConnectApiPlugin$1(ConnectApiPlugin paramConnectApiPlugin, String paramString) {}
  
  public void callback(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqJspConnectApiPlugin.isDestroy) {}
    do
    {
      return;
      paramBundle = String.format("{\"result\":%d, \"errMsg\":\"%s\", \"uin\":\"%s\"}", new Object[] { Integer.valueOf(paramBundle.getInt("result", -1)), paramBundle.getString("errMsg"), paramBundle.getString("retUin") });
      this.jdField_a_of_type_ComTencentMobileqqJspConnectApiPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { paramBundle });
    } while (!QLog.isColorLevel());
    QLog.e("ConnectApiPlugin", 2, new Object[] { "handleJsRequest callback:", paramBundle });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.ConnectApiPlugin.1
 * JD-Core Version:    0.7.0.1
 */