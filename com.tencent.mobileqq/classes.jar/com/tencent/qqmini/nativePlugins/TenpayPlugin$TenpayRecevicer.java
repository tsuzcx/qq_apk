package com.tencent.qqmini.nativePlugins;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import org.json.JSONException;
import org.json.JSONObject;

final class TenpayPlugin$TenpayRecevicer
  extends ResultReceiver
{
  private RequestEvent jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent;
  
  TenpayPlugin$TenpayRecevicer(TenpayPlugin paramTenpayPlugin, RequestEvent paramRequestEvent, Handler paramHandler)
  {
    super(paramHandler);
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent = paramRequestEvent;
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    QLog.d("TenpayPlugin", 2, "onReceiveResult resultCode = " + paramInt + " resultData = " + paramBundle);
    if (paramInt != 0)
    {
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent.fail("error unkown!");
      return;
    }
    paramBundle = paramBundle.getString("result");
    String str;
    try
    {
      QLog.d("TenpayPlugin", 2, "json: " + paramBundle);
      paramBundle = new JSONObject(paramBundle);
      paramInt = paramBundle.optInt("resultCode", -1);
      str = paramBundle.optString("retmsg");
      if (paramInt == 0)
      {
        this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent.ok(paramBundle);
        return;
      }
    }
    catch (JSONException paramBundle)
    {
      paramBundle.printStackTrace();
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent.fail("error unkown!");
      return;
    }
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent.fail(paramBundle, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.TenpayPlugin.TenpayRecevicer
 * JD-Core Version:    0.7.0.1
 */