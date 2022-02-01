package com.tencent.mobileqq.mini.out.nativePlugins;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.mobileqq.mini.out.nativePlugins.foundation.JSContext;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

final class TenpayPlugin$TenpayRecevicer
  extends ResultReceiver
{
  TenpayPlugin$TenpayRecevicer(TenpayPlugin paramTenpayPlugin, Handler paramHandler)
  {
    super(paramHandler);
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
      TenpayPlugin.access$000(this.this$0).evaluateCallback(false, null, "error unkown!");
      return;
    }
    paramBundle = paramBundle.getString("result");
    for (;;)
    {
      try
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("json: ");
        ((StringBuilder)localObject).append(paramBundle);
        QLog.d("TenpayPlugin", 2, ((StringBuilder)localObject).toString());
        paramBundle = new JSONObject(paramBundle);
        paramInt = paramBundle.optInt("resultCode", -1);
        localObject = paramBundle.optString("retmsg");
        JSContext localJSContext = TenpayPlugin.access$000(this.this$0);
        if (paramInt == 0)
        {
          bool = true;
          localJSContext.evaluateCallback(bool, paramBundle, (String)localObject);
          return;
        }
      }
      catch (JSONException paramBundle)
      {
        paramBundle.printStackTrace();
        TenpayPlugin.access$000(this.this$0).evaluateCallback(false, null, "error unkown!");
        return;
      }
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.nativePlugins.TenpayPlugin.TenpayRecevicer
 * JD-Core Version:    0.7.0.1
 */