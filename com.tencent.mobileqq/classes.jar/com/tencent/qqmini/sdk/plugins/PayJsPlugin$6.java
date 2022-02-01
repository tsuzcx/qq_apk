package com.tencent.qqmini.sdk.plugins;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.qqmini.sdk.core.manager.ActivityResultManager;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;
import org.json.JSONException;
import org.json.JSONObject;

class PayJsPlugin$6
  implements IActivityResultListener
{
  PayJsPlugin$6(PayJsPlugin paramPayJsPlugin, RequestEvent paramRequestEvent) {}
  
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    QMLog.d("PayJsPlugin", "yuki doOnActivityResult requestCode" + paramInt1 + " resultCode:" + paramInt2);
    if (paramInt1 == 3003)
    {
      JSONObject localJSONObject = new JSONObject();
      if (paramInt2 == -1)
      {
        paramIntent = paramIntent.getExtras();
        if (paramIntent != null)
        {
          paramInt1 = paramIntent.getInt("errCode");
          paramIntent = paramIntent.getString("errMsg");
          try
          {
            localJSONObject.put("resultCode", paramInt1);
            localJSONObject.put("resultMsg", paramIntent);
            if (paramInt1 == 0)
            {
              this.val$req.ok(localJSONObject);
              ActivityResultManager.g().removeActivityResultListener(this);
              return true;
            }
          }
          catch (JSONException paramIntent)
          {
            for (;;)
            {
              paramIntent.printStackTrace();
            }
          }
        }
      }
      this.val$req.fail();
      ActivityResultManager.g().removeActivityResultListener(this);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.PayJsPlugin.6
 * JD-Core Version:    0.7.0.1
 */