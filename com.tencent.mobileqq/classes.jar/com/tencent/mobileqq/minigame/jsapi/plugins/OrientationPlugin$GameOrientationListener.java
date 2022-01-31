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
    if (paramInt == -1) {}
    for (;;)
    {
      return;
      String str = null;
      label24:
      JSONObject localJSONObject;
      if ((paramInt > 350) || (paramInt < 10))
      {
        str = "portrait";
        if ((str == null) || (str.equals(OrientationPlugin.access$000(this.this$0)))) {
          continue;
        }
        OrientationPlugin.access$002(this.this$0, str);
        localJSONObject = new JSONObject();
      }
      try
      {
        localJSONObject.put("value", str);
        if ((this.this$0.jsPluginEngine == null) || (this.this$0.jsPluginEngine.getServiceRuntime() == null)) {
          continue;
        }
        this.this$0.jsPluginEngine.getServiceRuntime().evaluateSubcribeJS("onDeviceOrientationChange", localJSONObject.toString(), -1);
        return;
        if ((paramInt > 80) && (paramInt < 100))
        {
          str = "landscapeReverse";
          break label24;
        }
        if ((paramInt > 170) && (paramInt < 190)) {
          break label24;
        }
        if ((paramInt <= 260) || (paramInt >= 280)) {
          continue;
        }
        str = "landscape";
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          QLog.e("[minigame] OrientationPlugin", 1, "OrientationChange call back error:" + localJSONException.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.plugins.OrientationPlugin.GameOrientationListener
 * JD-Core Version:    0.7.0.1
 */