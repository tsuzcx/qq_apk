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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("yuki doOnActivityResult requestCode");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" resultCode:");
    ((StringBuilder)localObject).append(paramInt2);
    QMLog.d("PayJsPlugin", ((StringBuilder)localObject).toString());
    if (paramInt1 == 3003)
    {
      localObject = new JSONObject();
      if (paramInt2 == -1)
      {
        paramIntent = paramIntent.getExtras();
        if (paramIntent != null)
        {
          paramInt1 = paramIntent.getInt("errCode");
          paramIntent = paramIntent.getString("errMsg");
          try
          {
            ((JSONObject)localObject).put("resultCode", paramInt1);
            ((JSONObject)localObject).put("resultMsg", paramIntent);
          }
          catch (JSONException paramIntent)
          {
            paramIntent.printStackTrace();
          }
          if (paramInt1 == 0)
          {
            this.val$req.ok((JSONObject)localObject);
            ActivityResultManager.g().removeActivityResultListener(this);
            return true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.PayJsPlugin.6
 * JD-Core Version:    0.7.0.1
 */