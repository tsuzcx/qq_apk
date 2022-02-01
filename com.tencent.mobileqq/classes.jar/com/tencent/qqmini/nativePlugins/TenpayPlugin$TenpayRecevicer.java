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
  private RequestEvent b;
  
  TenpayPlugin$TenpayRecevicer(TenpayPlugin paramTenpayPlugin, RequestEvent paramRequestEvent, Handler paramHandler)
  {
    super(paramHandler);
    this.b = paramRequestEvent;
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onReceiveResult resultCode = ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" resultData = ");
    ((StringBuilder)localObject).append(paramBundle);
    QLog.d("TenpayPlugin", 2, ((StringBuilder)localObject).toString());
    if (paramInt != 0)
    {
      this.b.fail("error unkown!");
      return;
    }
    paramBundle = paramBundle.getString("result");
    try
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("json: ");
      ((StringBuilder)localObject).append(paramBundle);
      QLog.d("TenpayPlugin", 2, ((StringBuilder)localObject).toString());
      paramBundle = new JSONObject(paramBundle);
      paramInt = paramBundle.optInt("resultCode", -1);
      localObject = paramBundle.optString("retmsg");
      if (paramInt == 0)
      {
        this.b.ok(paramBundle);
        return;
      }
      this.b.fail(paramBundle, (String)localObject);
      return;
    }
    catch (JSONException paramBundle)
    {
      paramBundle.printStackTrace();
      this.b.fail("error unkown!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.TenpayPlugin.TenpayRecevicer
 * JD-Core Version:    0.7.0.1
 */