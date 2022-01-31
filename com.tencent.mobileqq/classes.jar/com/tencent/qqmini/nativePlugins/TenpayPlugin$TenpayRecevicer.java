package com.tencent.qqmini.nativePlugins;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import bgkd;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

final class TenpayPlugin$TenpayRecevicer
  extends ResultReceiver
{
  private bgkd req;
  
  TenpayPlugin$TenpayRecevicer(TenpayPlugin paramTenpayPlugin, bgkd parambgkd, Handler paramHandler)
  {
    super(paramHandler);
    this.req = parambgkd;
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    QLog.d("TenpayPlugin", 2, "onReceiveResult resultCode = " + paramInt + " resultData = " + paramBundle);
    if (paramInt != 0)
    {
      this.req.a("error unkown!");
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
        this.req.a(paramBundle);
        return;
      }
    }
    catch (JSONException paramBundle)
    {
      paramBundle.printStackTrace();
      this.req.a("error unkown!");
      return;
    }
    this.req.a(paramBundle, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.TenpayPlugin.TenpayRecevicer
 * JD-Core Version:    0.7.0.1
 */