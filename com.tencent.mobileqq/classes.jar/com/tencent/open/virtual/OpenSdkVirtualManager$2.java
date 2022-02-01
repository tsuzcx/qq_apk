package com.tencent.open.virtual;

import com.tencent.mobileqq.forward.ForwardStatisticsReporter;
import com.tencent.open.agent.authority.AuthCallback;
import com.tencent.open.model.AccountInfo;
import org.json.JSONObject;

class OpenSdkVirtualManager$2
  implements Runnable
{
  OpenSdkVirtualManager$2(OpenSdkVirtualManager paramOpenSdkVirtualManager, AccountInfo paramAccountInfo, JSONObject paramJSONObject, AuthCallback paramAuthCallback) {}
  
  public void run()
  {
    ForwardStatisticsReporter.a("KEY_DELETE_VIRTUAL_D18");
    OpenSdkVirtualUtil.a("oidb_0xd18_1", this.jdField_a_of_type_ComTencentOpenModelAccountInfo, this.jdField_a_of_type_OrgJsonJSONObject.toString(), new OpenSdkVirtualManager.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.open.virtual.OpenSdkVirtualManager.2
 * JD-Core Version:    0.7.0.1
 */