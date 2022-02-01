package com.tencent.mobileqq.minigame.jsapi.plugins;

import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class OrientationPlugin$GameOrientationListener
  extends OrientationEventListener
{
  public OrientationPlugin$GameOrientationListener(OrientationPlugin paramOrientationPlugin, Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public void onOrientationChanged(int paramInt)
  {
    Object localObject3 = null;
    if (paramInt == -1) {}
    for (;;)
    {
      return;
      Object localObject1;
      label24:
      JSONObject localJSONObject;
      if ((paramInt > 350) || (paramInt < 10))
      {
        localObject1 = "portrait";
        if ((localObject1 == null) || (((String)localObject1).equals(OrientationPlugin.access$000(this.this$0)))) {
          continue;
        }
        OrientationPlugin.access$002(this.this$0, (String)localObject1);
        localJSONObject = new JSONObject();
      }
      try
      {
        localJSONObject.put("value", localObject1);
        if (OrientationPlugin.access$100(this.this$0))
        {
          localObject1 = OrientationPlugin.access$200(this.this$0);
          if (localObject1 != null) {
            break label227;
          }
          localObject1 = localObject3;
          if (this.this$0.jsPluginEngine != null) {
            localObject1 = this.this$0.jsPluginEngine.getServiceRuntime();
          }
          if (localObject1 == null) {
            continue;
          }
          ((JsRuntime)localObject1).evaluateSubcribeJS("onDeviceOrientationChange", localJSONObject.toString(), -1);
          return;
          if ((paramInt > 80) && (paramInt < 100))
          {
            localObject1 = "landscapeReverse";
            break label24;
          }
          if ((paramInt > 170) && (paramInt < 190))
          {
            localObject1 = null;
            break label24;
          }
          if ((paramInt <= 260) || (paramInt >= 280)) {
            continue;
          }
          localObject1 = "landscape";
        }
      }
      catch (JSONException localJSONException)
      {
        label227:
        for (;;)
        {
          QLog.e("[minigame] OrientationPlugin", 1, "OrientationChange call back error:" + localJSONException.toString());
          continue;
          Object localObject2 = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.plugins.OrientationPlugin.GameOrientationListener
 * JD-Core Version:    0.7.0.1
 */