package com.tencent.qqmini.minigame.plugins;

import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONException;
import org.json.JSONObject;

public class OrientationJsPlugin$GameOrientationListener
  extends OrientationEventListener
{
  public OrientationJsPlugin$GameOrientationListener(OrientationJsPlugin paramOrientationJsPlugin, Context paramContext, int paramInt)
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
        if ((str == null) || (str.equals(OrientationJsPlugin.access$000(this.this$0)))) {
          continue;
        }
        OrientationJsPlugin.access$002(this.this$0, str);
        localJSONObject = new JSONObject();
      }
      try
      {
        localJSONObject.put("value", str);
        OrientationJsPlugin.access$100(this.this$0, "onDeviceOrientationChange", localJSONObject.toString());
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
          QMLog.e("OrientationJsPlugin", "OrientationChange call back error:" + localJSONException.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.OrientationJsPlugin.GameOrientationListener
 * JD-Core Version:    0.7.0.1
 */