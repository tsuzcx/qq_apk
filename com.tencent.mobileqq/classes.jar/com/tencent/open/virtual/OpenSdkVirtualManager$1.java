package com.tencent.open.virtual;

import com.tencent.mobileqq.forward.ForwardStatisticsReporter;
import com.tencent.open.agent.authority.AuthCallback;
import com.tencent.open.model.AccountInfo;
import org.json.JSONObject;

class OpenSdkVirtualManager$1
  implements Runnable
{
  OpenSdkVirtualManager$1(OpenSdkVirtualManager paramOpenSdkVirtualManager, AccountInfo paramAccountInfo, JSONObject paramJSONObject, AuthCallback paramAuthCallback) {}
  
  public void run()
  {
    ForwardStatisticsReporter.a("KEY_CREATE_VIRTUAL_D17");
    OpenSdkVirtualUtil.a("oidb_0xd17_1", this.jdField_a_of_type_ComTencentOpenModelAccountInfo, this.jdField_a_of_type_OrgJsonJSONObject.toString(), new OpenSdkVirtualManager.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.open.virtual.OpenSdkVirtualManager.1
 * JD-Core Version:    0.7.0.1
 */