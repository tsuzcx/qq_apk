package com.tencent.qqmini.nativePlugins;

import android.os.Bundle;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import org.json.JSONObject;

class GameBuddyPlugin$2
  implements EIPCResultCallback
{
  GameBuddyPlugin$2(GameBuddyPlugin paramGameBuddyPlugin, RequestEvent paramRequestEvent) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    for (;;)
    {
      int j;
      int i;
      try
      {
        Object localObject = new JSONObject();
        if (paramEIPCResult == null)
        {
          if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent == null) {
            break label172;
          }
          this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent.fail("result is null");
          return;
        }
        if (paramEIPCResult.code == 0)
        {
          j = paramEIPCResult.data.getInt("uin_type");
          i = -1;
          if (j != 10009) {
            break label173;
          }
          i = 1;
          ((JSONObject)localObject).put("code", 0);
          ((JSONObject)localObject).put("type", i);
          GameBuddyPlugin.a(this.jdField_a_of_type_ComTencentQqminiNativePluginsGameBuddyPlugin).getAttachedActivity();
          paramEIPCResult = this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent;
          return;
        }
        if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent == null) {
          continue;
        }
        localObject = this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("result code:");
        localStringBuilder.append(paramEIPCResult.code);
        ((RequestEvent)localObject).fail(localStringBuilder.toString());
        return;
      }
      catch (Throwable paramEIPCResult)
      {
        continue;
      }
      paramEIPCResult = this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent;
      if (paramEIPCResult != null) {
        paramEIPCResult.fail("exceptions!");
      }
      return;
      label172:
      return;
      label173:
      if (j == 0) {
        i = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.GameBuddyPlugin.2
 * JD-Core Version:    0.7.0.1
 */