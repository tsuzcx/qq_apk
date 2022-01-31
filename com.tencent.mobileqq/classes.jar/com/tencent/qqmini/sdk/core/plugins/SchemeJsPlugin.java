package com.tencent.qqmini.sdk.core.plugins;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import bdcz;
import bdfz;
import bdgq;
import bdnw;
import org.json.JSONObject;

public class SchemeJsPlugin
  extends BaseJsPlugin
{
  private static final String TAG = "SchemeJsPlugin";
  
  public void openScheme(bdfz parambdfz)
  {
    Activity localActivity = this.mMiniAppContext.a();
    if (localActivity == null) {
      return;
    }
    try
    {
      Object localObject1 = new JSONObject(parambdfz.b);
      if (((JSONObject)localObject1).has("api_name"))
      {
        Object localObject2 = ((JSONObject)localObject1).optString("api_name");
        JSONObject localJSONObject = ((JSONObject)localObject1).optJSONObject("data");
        localObject1 = null;
        if (localJSONObject != null) {
          localObject1 = bdgq.a(localJSONObject);
        }
        localObject1 = (String)localObject2 + "?" + (String)localObject1;
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("from", "SchemeJsPlugin");
        ((Intent)localObject2).putExtra("scheme", (String)localObject1);
        ((Intent)localObject2).putExtra("result_receiver", new SchemeJsPlugin.1(this, new Handler(Looper.getMainLooper()), parambdfz, (String)localObject1));
        localActivity.startActivity((Intent)localObject2);
        return;
      }
    }
    catch (Exception localException)
    {
      bdnw.d("SchemeJsPlugin", parambdfz.a + " error.", localException);
      return;
    }
    parambdfz.a("params error.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.SchemeJsPlugin
 * JD-Core Version:    0.7.0.1
 */