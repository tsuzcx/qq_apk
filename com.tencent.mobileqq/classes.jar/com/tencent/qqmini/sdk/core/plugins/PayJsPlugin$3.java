package com.tencent.qqmini.sdk.core.plugins;

import android.content.Intent;
import android.os.Bundle;
import bgnk;
import bgnl;
import bgok;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

class PayJsPlugin$3
  implements bgnl
{
  PayJsPlugin$3(PayJsPlugin paramPayJsPlugin, bgok parambgok) {}
  
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
              this.val$req.a(localJSONObject);
              bgnk.a().b(this);
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
      this.val$req.b();
      bgnk.a().b(this);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.PayJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */